package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//import data.StaticData;
import model.product;
import service.ProductService;


@WebServlet("/managerEditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("ID"));
		
	       request.setAttribute("product", ProductService.findById(id));
		 RequestDispatcher dispatcher=request.getRequestDispatcher("edit.jsp");
		   dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String Name=request.getParameter("name");
		double Price=Double.valueOf(request.getParameter("price"));
		String Dcri=request.getParameter("description");
		String Img=request.getParameter("image");
		int id=Integer.valueOf(request.getParameter("ID"));
		ProductService.update(Name, Price, Dcri,id,Img);
		response.sendRedirect("manager");	

	}
	
	}


