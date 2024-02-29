package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import data.StaticData;
//import data.StaticDataUser;
import model.User;
import model.product;
import service.UserService;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String re_pass = request.getParameter("confirmPassword");
        if (!pass.equals(re_pass)) {
        	 request.getSession().setAttribute("message1", "mat khau ko khop nhau vui long dk lai");
        	 response.sendRedirect("login.jsp");
        }else{
        	
        	User u = UserService.checkAccountExist(user);
        	if (u== null) {
        		//de signup
        		UserService.singUp(user, re_pass);
                response.sendRedirect("homeservlet");
        	}else{
        		//day ve trang login.jsp
        		response. sendRedirect ("login.jsp");
        		 request.getSession().setAttribute("message1", "tai khoan da ton tai vui long dk lai");
        	}
        }
	}

}
