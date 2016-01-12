package com.gmm.fooWebProject2.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CrearSession")
public class CrearSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession misession = request.getSession(true);
		Producto miproducto = new Producto(1, "telefono", 300);
		misession.setAttribute("producto", miproducto);
		PrintWriter pw = response.getWriter();
		String verSesion="<a href=\"http://localhost:8080/FooWebProject/VerSession\">VerSession</a>";
		pw.println("<html><body>Producto en session<br><br>"+verSesion+"<br><br></body></html>");
		pw.close();

	}
}