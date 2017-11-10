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
 * Servlet implementation class ModifyCookie
 */
@WebServlet("/ModifyCookie")
public class ModifyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter o = res.getWriter();
		Cookie[] cookie = req.getCookies();

		if (cookie != null) {
			Arrays.asList(cookie).forEach((x) -> {
				// o.println(x.getName() + x.getValue());
				x.setValue(x.getName().equals("Cookie") ? "Beijing"
						: x.getName().equals("Cookie1") ? "ShangHai"
								: x.getName().equals("Cookie2") ? "XianYou" : "Guangzhou");
				x.setMaxAge(10);
				x.setPath("/Endless");
				res.addCookie(x);
			});
		} else {
			o.println("Ã»ÓÐCookie");
		}
	}
}
