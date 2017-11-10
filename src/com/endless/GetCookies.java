package com.endless;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter o = resp.getWriter();

		String city = URLEncoder.encode("µÈ´ý", "utf-8");
		Cookie c1 = new Cookie("cookie7", city);
		resp.addCookie(c1);
		Arrays.asList(req.getCookies()).forEach((x) -> {
			String val = x.getValue();
			try {
				o.println(URLDecoder.decode(val, "utf-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		o.println("Done!");
	}
}
