package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.cart;
import model.product;
import service.CartService;

/**
 * Servlet implementation class cartcontroller
 */
@WebServlet("/cartcontroller")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User a=(User) session.getAttribute("acc");
		
		if(a !=null) {
		int idUser=a.getId();
		ArrayList<product> products=CartService.getAllCart(idUser);
	    request.setAttribute("product",products);
		RequestDispatcher dispatcher=request.getRequestDispatcher("cart.jsp");
		dispatcher.forward(request, response);
		}
		else {
			 response.sendRedirect("login.jsp");
		}
	}

	
	

}
