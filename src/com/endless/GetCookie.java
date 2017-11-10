package com.endless;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookie
 */
@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter o = resp.getWriter();
		Cookie[] cookie = req.getCookies();
		if (cookie != null) {
			Arrays.asList(cookie).forEach((x) -> o.println(x.getName() + "<       >" + x.getValue() + "<br/>"));
		} else {
			o.println("Ã»ÓÐCookie");
		}
	}
}
