package com.gmm.fooWebProject2.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VerSession")
public class VerSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		Producto miproducto = (Producto) misession.getAttribute("producto");

		PrintWriter pw = response.getWriter();
		pw.println("<html><body>" + miproducto.getId() + "," + miproducto.getConcepto() + "," + miproducto.getImporte());
		pw.close();
	}
}