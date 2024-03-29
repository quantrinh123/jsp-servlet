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

/**
 * Servlet implementation class detail
 */
@WebServlet("/detail")
public class detailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("ID"));
		
		 request.setAttribute("pro", ProductService.findById(id));
		RequestDispatcher dispatcher=request.getRequestDispatcher("detail.jsp");
		dispatcher.forward(request, response);
	}

	

}
