package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class F2Filter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("🧱 F2 Filter START :: " + req.getRequestURI());
		chain.doFilter(request, response);
		System.out.println("🧱 F2 Filter END :: " + req.getRequestURI());
	}
}