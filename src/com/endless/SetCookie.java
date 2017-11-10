package com.endless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie coo1 = new Cookie("Cookie", "Hello Cookie");
		Cookie coo2 = new Cookie("Cookie1", "Hello Cookie");
		Cookie coo3 = new Cookie("Cookie2", "Hello Cookie");
		Cookie coo4 = new Cookie("Cookie3", "Hello Cookie");
		Cookie coo5 = new Cookie("Cookie4", "Hello Cookie");
		PrintWriter o = res.getWriter();

		res.addCookie(coo1);
		res.addCookie(coo2);
		res.addCookie(coo3);
		res.addCookie(coo4);
		res.addCookie(coo5);
		o.println("SetCookie Done!");
	}

}
