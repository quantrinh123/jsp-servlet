package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import data.StaticData;
import model.product;
import service.ProductService;


@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str=request.getParameter("key");
		 ArrayList<product> products=ProductService.search(str);
	      
	       
	       request.setAttribute("keys", str);
	       request.setAttribute("products", products);
		   RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
		   dispatcher.forward(request, response);   	
	}

}
