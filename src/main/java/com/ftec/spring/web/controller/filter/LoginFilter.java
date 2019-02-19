package com.ftec.spring.web.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftec.spring.web.controller.session.UserSession;

@Component
public class LoginFilter implements Filter {

	private static final String[] STATIC_CONTENT = new String[] {"/api/","/login","/register", "/uploads", "/show_news","/css/","/img/","/bower_components/","/icon_fonts_assets/","/js/"};

	@Autowired
	private UserSession userSession;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			String uri = httpRequest.getRequestURI();

			if (userSession.isLogged()) {
				if ("/login".equals(uri)) {
					httpResponse.sendRedirect("/");
					return;
				}
			} else {
				
				boolean found = false;
				
				for(String staticContent : STATIC_CONTENT) {
					if(uri.startsWith(staticContent)) {
						found = true;
						break;
					}
				}
				
				if (uri.equals("/"))
					found = true;
				
				if(!found) {
					httpResponse.sendRedirect("/login");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
