package controller;

import java.io.IOException;
import java.util.ArrayList;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import data.StaticData;
import model.product;
import service.ProductService;


@WebServlet("/manager")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<product> products=ProductService.findAll();
	       request.setAttribute("products", products);
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("name");
		double Price=Double.valueOf(request.getParameter("price"));
		String Dcri=request.getParameter("description");
		String Img=request.getParameter("image");
//		product pro=new product(
//				StaticData.products.get(StaticData.products.size()-1).getID()+1,
//				request.getParameter("name"),
//				Double.valueOf(request.getParameter("price")),
//				request.getParameter("description")
//				);
//		StaticData.products.add(pro);
		LocalDateTime currentTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentTime);
		ProductService.add(Name, Price, Dcri,Img,timestamp);
		response.sendRedirect("manager");	
	}

}
