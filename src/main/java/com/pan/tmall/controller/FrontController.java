package com.pan.tmall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pan.tmall.comparator.AllComparator;
import com.pan.tmall.comparator.CreateDateComparator;
import com.pan.tmall.comparator.PriceComparator;
import com.pan.tmall.comparator.ReviewComparator;
import com.pan.tmall.comparator.SaleCountComparator;
import com.pan.tmall.pojo.Category;
import com.pan.tmall.pojo.Order;
import com.pan.tmall.pojo.Orderitem;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.Productimage;
import com.pan.tmall.pojo.Propertyvalue;
import com.pan.tmall.pojo.Review;
import com.pan.tmall.pojo.User;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.OrderItemService;
import com.pan.tmall.service.OrderService;
import com.pan.tmall.service.ProductImageService;
import com.pan.tmall.service.ProductService;
import com.pan.tmall.service.PropertyValueService;
import com.pan.tmall.service.ReviewService;
import com.pan.tmall.service.UserService;

@Controller
@RequestMapping("/front")
public class FrontController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private PropertyValueService propertyValueService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private UserService UserService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private OrderService orderService;

	// ��ҳ
	@RequestMapping(value = { "/home" }, method = GET)
	public String home(Model model) {
		long start = System.currentTimeMillis();
		List<Category> categories = categoryService.list();
		categoryService.fillProducts(categories);
		categoryService.fillProductsByRow(categories);
		model.addAttribute("categories", categories);
		long end = System.currentTimeMillis();
		System.out.println("��ҳ���غ�ʱ��"+(end - start));


		return "home";
	}

	// ��ȡ������Ϣ�������������·��ؼ���չʾ
	@RequestMapping(value = { "/getCategory" }, method = GET)
	@ResponseBody
	public String searchKeyWord(HttpSession session) {
		List<Category> categories = categoryService.list();
		session.setAttribute("categories", categories);
		return "success";
	}

	// �����Ʒҳ
	@RequestMapping(value = { "/category" }, method = GET)
	public String category(int id, String sort, Model model) {
		Category category = categoryService.getOne(id);
		List<Product> products = productService.list(id);
		for (Product product : products) {
			productService.setSaleAndReviewCount(product);
		}
		// ����
		if (sort == null) {
			sort = "all";
		}
		if (sort != null) {

			switch (sort) {
			case "all":
				Collections.sort(products, new AllComparator());
				break;
			case "price":
				Collections.sort(products, new PriceComparator());
				break;
			case "reviewCount":
				Collections.sort(products, new ReviewComparator());
				break;
			case "saleCount":
				Collections.sort(products, new SaleCountComparator());
				break;
			case "createDate":
				Collections.sort(products, new CreateDateComparator());
				break;
			}
		}
		category.setProducts(products);
		model.addAttribute("category", category);
		model.addAttribute("sort", sort);
		return "productsOfCategory";
	}

	// ��Ʒ����ҳ
	@RequestMapping(value = { "/product" }, method = GET)
	public String product(int id, Model model) {
		Product product = productService.get(id);
		productService.setFirstProductImage(product);
		productService.setSaleAndReviewCount(product);
		// ��ȡͼƬ
		List<Productimage> simgelImages = productImageService.list(id, productImageService.TYPE_SINGLE);
		List<Productimage> detailImages = productImageService.list(id, productImageService.TYPE_DETAIL);
		product.setProductSingleImages(simgelImages);
		product.setProductDetailImages(detailImages);
		// ��ȡ��Ʒ����
		List<Propertyvalue> propertyValues = propertyValueService.list(id);
		propertyValueService.setProperty(propertyValues);
		// ��ȡ��������
		List<Review> reviews = reviewService.list(id);
		if (reviews != null) {
			reviewService.setUser(reviews);
		}
		model.addAttribute("product", product);
		model.addAttribute("propertyValues", propertyValues);
		model.addAttribute("reviews", reviews);
		return "productInfo";
	}

	// ��Ʒ����ҳ-ģ������
	@RequestMapping(value = { "/search" }, method = GET)
	public String search(String keyWord, Model model) {
		List<Product> products = productService.listByKeyWord(keyWord);
		productService.setFirstProductImage(products);
		productService.setSaleAndReviewCount(products);

		model.addAttribute("products", products);
		return "searchResult";
	}

	// ����¼״̬
	@RequestMapping(value = { "/checkLogin" }, method = GET)
	@ResponseBody
	public String checkLogin(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return "success";
		}
		return "false";
	}

	@RequestMapping(value = { "/registPage" }, method = GET)
	public String registPage() {
		return "regist";
	}

	// ע��
	@RequestMapping(value = { "/regist" }, method = POST)
	public String regist(User user) {
		UserService.add(user);

		return "registSuccessed";
	}

	// Ajax��¼
	@RequestMapping(value = { "/loginAjax" }, method = POST)
	@ResponseBody
	public String loginAjax(User user, HttpSession session) {
		User user1 = UserService.get(user);
		if (user1 != null) {
			session.setAttribute("user", user1);
			return "success";
		}
		return "false";
	}

	@RequestMapping(value = { "/loginPage" }, method = GET)
	public String loginPage() {

		return "login";
	}

	// �����¼
	@RequestMapping(value = { "/login" }, method = POST)
	public String login(User user, HttpSession session, Model model) {
		User user1 = UserService.get(user);
		if (user1 != null) {
			session.setAttribute("user", user1);
			return "redirect:home";
		}
		model.addAttribute("msg", "longin_fail");
		return "login";
	}

	// �˳�--Ajax����
	@RequestMapping(value = { "/logout" }, method = GET)
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();// �ر�session
		return "success";
	}

	// ���ﳵ
	@RequestMapping(value = { "/cart" }, method = GET)
	public String cart(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Orderitem> orderitems = orderItemService.listByUser(user);
		model.addAttribute("orderitems", orderitems);
		return "shoppingCart";
	}

	// ���빺�ﳵ
	@RequestMapping(value = { "/addToCart" }, method = GET)
	@ResponseBody
	public String addToCart(Orderitem orderitem, HttpSession session) {
		// ��鹺�ﳵ�Ƿ��Ѿ����ڴ���Ʒ
		Orderitem orderitem2 = orderItemService.getByProductId(orderitem.getPid());
		if (orderitem2 != null) {
			int number = orderitem2.getNumber() + orderitem.getNumber();
			orderitem2.setNumber(number);
			orderItemService.update(orderitem2);
			return "success";
		} else {
			User user = (User) session.getAttribute("user");
			orderitem.setUid(user.getId());
			orderitem.setOid(-1);
			orderItemService.add(orderitem);
			return "success";
		}
	}

	// ɾ�����ﳵ��Ʒ
	@RequestMapping(value = { "/deleteOrderItem" }, method = POST)
	@ResponseBody
	public String deleteOrderItem(int oiid) {
		orderItemService.delete(oiid);
		return "success";
	}

	// �޸���Ʒ����
	@RequestMapping(value = { "/updateOrderItem" }, method = POST)
	@ResponseBody
	public String updateNumberOfOrderItem(int oiid, int sum) {
		Orderitem orderitem = orderItemService.get(oiid);
		orderitem.setNumber(sum);
		orderItemService.update(orderitem);
		return "success";
	}

	// �������ﳵ����
	@RequestMapping(value = { "/carTotalNumber" }, method = GET)
	@ResponseBody
	public String carTotalNumber(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			List<Orderitem> orderitems = orderItemService.listByUser(user);
			int carTotalNumber = 0;
			if (orderitems != null && !orderitems.isEmpty()) {
				for (Orderitem orderitem : orderitems) {
					carTotalNumber += orderitem.getNumber();
				}
			}
			session.setAttribute("carTotalNumber", carTotalNumber);
			return "success";
		}
		return "false";
	}

	// ����
	@RequestMapping(value = { "/buyNow" }, method = { POST, GET })
	public String buyNow(String oiids, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		String[] ids = oiids.split(",");
		List<Orderitem> orderitems = new ArrayList<>();
		float total = 0f;
		if (ids != null && ids.length > 0) {
			for (String oiid : ids) {
				Orderitem orderitem = orderItemService.get(Integer.parseInt(oiid));
				orderitems.add(orderitem);
				total += orderitem.getNumber() * orderitem.getProduct().getPromoteprice();
			}
		}
		model.addAttribute("total", total);
		session.setAttribute("orderitems", orderitems);// ������Ϸŵ�session��
		return "buy";
	}

	// ��������
	@RequestMapping(value = { "/buy" }, method = { POST, GET })
	public String buy(Orderitem orderitem, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		float total = 0;
		List<Orderitem> orderitems = new ArrayList<>();
		// �鿴���ﳵ�Ƿ��Ѿ��д���Ʒ������У��޸��������й��򣬷�ֹ���ֶ��ͬ��������
		Orderitem i2 = orderItemService.getByProductId(orderitem.getPid());
		if (i2 != null) {
			orderItemService.setProduct(i2);
			i2.setNumber(orderitem.getNumber());
			total = i2.getNumber() * i2.getProduct().getPromoteprice();
			orderitems.add(i2);

		} else {
			// û�У������µĶ�����
			orderitem.setOid(-1);
			orderitem.setUid(user.getId());
			orderItemService.add(orderitem);
			orderItemService.setProduct(orderitem);
			total = orderitem.getNumber() * orderitem.getProduct().getPromoteprice();
			orderitems.add(orderitem);
		}
		model.addAttribute("total", total);
		session.setAttribute("orderitems", orderitems);// ������Ϸŵ�session��
		return "buy";
	}

	// ȷ�϶�����Ϣ����������
	@RequestMapping(value = { "/createOrder" }, method = POST)
	public String createOrder(Order order, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Date date = new Date();
		String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date) + RandomUtils.nextInt(0, 100000);
		order.setOrdercode(orderCode);
		order.setUid(user.getId());
		order.setCreatedate(date);
		order.setStatus(orderService.waitPay);
		List<Orderitem> orderitems = (List<Orderitem>) session.getAttribute("orderitems");

		// �����������Ҹ��Ķ���������
		float total = orderService.add(order, orderitems);

		return "redirect:alipay?oid=" + order.getId() + "&total=" + total;
	}

	// ֧��
	@RequestMapping(value = { "/alipay" }, method = GET)
	public String alipay() {
		return "alipay";
	}

	// ֧���ɹ�
	@RequestMapping(value = { "/payed" }, method = GET)
	public String payed(int oid, Model model) {
		Order order = orderService.get(oid);
		order.setStatus(orderService.waitDelivery);
		order.setPaydate(new Date());
		orderService.update(order);
		model.addAttribute("order", order);
		return "payed";
	}

	// �ҵĶ���
	@RequestMapping(value = { "/myOrder" }, method = GET)
	public String myOrder(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Order> orders = orderService.listByUser(user);
		orderService.setOrderItem(orders);
		// �����ܼ۹���
		orderService.setTotalMoneyAndProductNumber(orders);
		model.addAttribute("orders", orders);
		return "myOrder";
	}

	// ��תȷ���ջ�ҳ�棬��ȡ�����붩������Ϣ
	@RequestMapping(value = { "/confirmPay" }, method = GET)
	public String confirmPay(int oid, Model model, HttpSession session) {
		Order order = orderService.get(oid);
		orderService.setOrderItem(order);
		orderService.setTotalMoneyAndProductNumber(order);
		model.addAttribute("order", order);
		return "reciveConfirm";
	}

	// ȷ���ջ����޸Ķ���״̬
	@RequestMapping(value = { "/confirmed" }, method = GET)
	public String reciveConfirmed(int oid, Model model, HttpSession session) {
		Order order = orderService.get(oid);
		// ����״̬����
		order.setStatus(orderService.waitReview);
		orderService.update(order);

		return "orderConfirmed";
	}

	// ����ҳ��ת
	@RequestMapping(value = { "/review" }, method = GET)
	public String review(int oid, Model model) {
		Order order = orderService.get(oid);
		orderService.setOrderItem(order);
		List<Orderitem> orderitems = order.getOrderItems();
		orderItemService.setRview(orderitems);
		model.addAttribute("order", order);
		return "productReview";
	}

	// �������
	@RequestMapping(value = { "/addReview" }, method = GET)
	@ResponseBody
	public String addReview(Review review, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Date createDate = new Date();
		review.setCreatedate(createDate);
		review.setUid(user.getId());
		reviewService.add(review);
		return "success";
	}

	// ������ۣ��޸Ķ���״̬
	@RequestMapping(value = { "/reviewDone" }, method = GET)
	@ResponseBody
	public String reviewDone(int oid) {
		Order order = orderService.get(oid);
		order.setStatus(orderService.finish);
		orderService.update(order);
		return "success";
	}
	//ɾ������
	// ������ۣ��޸Ķ���״̬
		@RequestMapping(value = { "/deleteOrder" }, method = GET)
		@ResponseBody
		public String deleteOrder(Order order) {
			orderService.delete(order);
			return "success";
		}

}
