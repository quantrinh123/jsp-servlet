<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng nhập</title>
	<link href="login.css" rel="stylesheet" type="text/css">
	<link href="./font/fontawesome-free-6.5.1/css/all.min.css" rel="stylesheet">
</head>
<body>


	<div class="container" id="container">
        <div class="form-container sign-up">
            <form action="RegisterController" method="post">
                <h1>Create Account</h1>
                 
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="password" name="confirmPassword" placeholder="Confirm password" required>
                <button>Sign up</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="CheckLoginController" method="post">
                <h1>Sign in</h1>
				  <%
				if (session.getAttribute("message") != null) {
				%>
				<p style='color: red'><%=session.getAttribute("message")%></p>
				<%
				session.setAttribute("message", null);
				}
				%>
				
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" name = "submit" value="Log In">
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>Enter your personal details to use all of site features</p>
                    <button class="hidden" id="register">Sign in</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello, Friend!</h1>
 <%
				if (session.getAttribute("message1") != null) {
				%>
				<p style='color: red'><%=session.getAttribute("message1")%></p>
				<%
				session.setAttribute("message1", null);
				}
				%>
                    <button class="hidden" id="login">Sign up</button>
                </div>
            </div>
        </div>
    </div>
    <script > const container = document.getElementById('container');
    const registerBtn = document.getElementById('register');
    const loginBtn = document.getElementById('login');

    registerBtn.addEventListener('click', () => {
        container.classList.remove("active");
    });

    loginBtn.addEventListener('click', () => {
        container.classList.add("active");
    });</script>
</body>
</html>
