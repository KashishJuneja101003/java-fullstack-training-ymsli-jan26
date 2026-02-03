package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class F1Filter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("🧱 F1Filter START :: " + req.getRequestURI());
		chain.doFilter(request, response);
		System.out.println("🧱 F1Filter END :: " + req.getRequestURI());
	}
}