package com.pan.tmall.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pan.tmall.pojo.User;

public class AuthorityInterceptor implements HandlerInterceptor {
	/**
	 * preHandle�����ǽ��д����������õģ�����˼�壬�÷�������Controller����֮ǰ���е��ã�SpringMVC�е�
	 * Interceptor����������ʽ�ģ�����ͬʱ���� ���Interceptor��Ȼ��SpringMVC�����������ǰ��˳��һ����һ����ִ�У�
	 * �������е�Interceptor�е�preHandle���������� Controller��������֮ǰ���á�SpringMVC������Interceptor��ʽ
	 * �ṹҲ�ǿ��Խ����жϵģ������жϷ�ʽ����preHandle�ķ� ��ֵΪfalse����preHandle�ķ���ֵΪfalse��ʱ����������ͽ����ˡ�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String contextPath = session.getServletContext().getContextPath();
		String[] imAuthorityRequest = new String[] { "/home", "/product", "/category", "/regist", "/registPage",
				"/login", "/checkLogin", "/loginPage", "/search", "/loginAjax","/getCategory","/carTotalNumber" };
		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath);
		if (uri.startsWith("/front")) {
			uri=StringUtils.substringAfterLast(uri, "/front");
			if (!Arrays.asList(imAuthorityRequest).contains(uri)) {
				User user = (User) session.getAttribute("user");
				if (user == null) {
					response.sendRedirect("loginPage");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * �������ֻ���ڵ�ǰ���Interceptor��preHandle��������ֵΪtrue��ʱ��Ż�ִ�С�postHandle�ǽ��д����������õģ�
	 * ����ִ��ʱ�����ڴ��������д���֮��Ҳ������Controller�ķ�������֮��ִ�У�����������DispatcherServlet������ͼ����Ⱦ֮ǰִ�У�
	 * Ҳ����˵���������������Զ�ModelAndView���в����������������ʽ�ṹ���������ʵķ������෴�ģ�Ҳ����˵��������Interceptor������
	 * �÷�������������.
	 * ���Struts2�������������ִ�й����е���ֻ��Struts2�����intercept������Ҫ�ֶ��ĵ���ActionInvocation��
	 * invoke������Struts2�е���ActionInvocation��invoke�������ǵ�����һ��Interceptor�����ǵ���action��Ȼ��Ҫ��Interceptor
	 * ֮ǰ���õ����ݶ�д�ڵ���invoke֮ǰ��Ҫ��Interceptor֮����õ����ݶ�д�ڵ���invoke����֮��
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * �÷���Ҳ����Ҫ��ǰ��Ӧ��Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С��÷������������������֮��
	 * Ҳ����DispatcherServlet��Ⱦ����ͼִ�У� �����������Ҫ����������������Դ�ģ���Ȼ�������Ҳֻ���ڵ�ǰ���
	 * Interceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С�
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}