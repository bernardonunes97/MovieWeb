package br.com.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.bo.UserBO;
import br.com.movie.model.dao.UserDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		UserBO userBo = new UserBO();
		
		if (username == "" || password == "") {
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
		
		if (userBo.login(username, password)) {
			req.setAttribute("error", "Usuário ou senha incorretos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		} else {
			// Passar id para tela de favoritos
//			req.setAttribute("userId", user.getId());
//			req.getRequestDispatcher("Favoritos.jsp").forward(req, res);
		}
	}
}