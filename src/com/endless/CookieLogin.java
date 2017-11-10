package com.endless;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLogin
 */
@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter o = resp.getWriter();
		HashMap<String, String> user = new HashMap<>();
		user.put("root", "root");
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("账号：" + name + "\t密码" + password);
		try {
			if (name.equals("root") && password.equals("root")) {
				// 密码正确
				System.out.println("Done!");
				Cookie cookie0 = new Cookie("root", user.get("root"));
				cookie0.setMaxAge(5);
				resp.addCookie(cookie0);
				req.getRequestDispatcher("NewFile.jsp").forward(req, resp);
			} else {
				// 密码错误
				req.setAttribute("msg", "账号或密码密码错误");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// 如果表单数据为空 空指针异常
			System.out.println("表单为空！");
			try {
				Cookie[] cookie = req.getCookies();
				boolean red = false;
				for (Cookie x : cookie) {
					o.append(x.getName() + x.getValue());
					red = x.getName().equals("root");
					if (red) {
						// 如果找到指定Cookie
						System.out.println("NewFile.jsp");
						req.getRequestDispatcher("NewFile.jsp").forward(req, resp);
						// resp.sendRedirect("NewFile.jsp");
						break;
					}
				}
				if (red == false) {
					// 如果找不到指定Cookie
					System.out.println("Login.jsp");
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
					// resp.sendRedirect("Login.jsp");
				}
			} catch (Exception e1) {
				// 如果没有任何Cookie
				System.out.println("cookie" + e1.getMessage());
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}
		}
	}
}
