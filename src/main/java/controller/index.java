package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setAttribute("key","hello");
//		request.setAttribute("key1","milk");
//		request.setAttribute("key2","cafe");
//		request.setAttribute("key3","cake");
		ArrayList<String> array =new ArrayList<String>();
		array.add("list1");
		array.add("list2");
		array.add("list3");
		request.setAttribute("key", array);
		RequestDispatcher dispatcher=request.getRequestDispatcher("default.jsp");
		dispatcher.forward(request, response);
	}
}
