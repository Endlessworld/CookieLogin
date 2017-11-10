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
		System.out.println("�˺ţ�" + name + "\t����" + password);
		try {
			if (name.equals("root") && password.equals("root")) {
				// ������ȷ
				System.out.println("Done!");
				Cookie cookie0 = new Cookie("root", user.get("root"));
				cookie0.setMaxAge(5);
				resp.addCookie(cookie0);
				req.getRequestDispatcher("NewFile.jsp").forward(req, resp);
			} else {
				// �������
				req.setAttribute("msg", "�˺Ż������������");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// ���������Ϊ�� ��ָ���쳣
			System.out.println("��Ϊ�գ�");
			try {
				Cookie[] cookie = req.getCookies();
				boolean red = false;
				for (Cookie x : cookie) {
					o.append(x.getName() + x.getValue());
					red = x.getName().equals("root");
					if (red) {
						// ����ҵ�ָ��Cookie
						System.out.println("NewFile.jsp");
						req.getRequestDispatcher("NewFile.jsp").forward(req, resp);
						// resp.sendRedirect("NewFile.jsp");
						break;
					}
				}
				if (red == false) {
					// ����Ҳ���ָ��Cookie
					System.out.println("Login.jsp");
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
					// resp.sendRedirect("Login.jsp");
				}
			} catch (Exception e1) {
				// ���û���κ�Cookie
				System.out.println("cookie" + e1.getMessage());
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
			}
		}
	}
}
