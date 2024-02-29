package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.User;
import service.UserService;

@WebServlet("/CheckLoginController")
public class CheckLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User a=UserService.CheckLogin(username, password);
        boolean b=UserService.CheckLoginAdmin(username, password);
    
        
        if (a!=null) {
        	
        	HttpSession session = request.getSession();
    		session.setAttribute("acc",a );
    		session.setMaxInactiveInterval(600000000);
            response.sendRedirect("homeservlet");
        	
        } else {
            request.getSession().setAttribute("message", "Tên đăng nhập và mật khẩu không hợp lệ!");
            response.sendRedirect("login.jsp");
        }
    }
}
