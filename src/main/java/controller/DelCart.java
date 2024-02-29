package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.cart;
import service.CartService;

/**
 * Servlet implementation class DelCart
 */
@WebServlet("/DelCart")
public class DelCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("ID"));
		HttpSession session = request.getSession();
		User a=(User) session.getAttribute("acc");
		int idUser=a.getId();
		CartService.DelCart(id,idUser);
		response.sendRedirect("cartcontroller");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
