package br.com.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.dao.UserDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		UserDAO userDao = new UserDAO();
		String name = req.getParameter("user");
		String password = req.getParameter("pwd");
		UserBean user = userDao.fetchUsername(name);
		
		if (user == null || user.getPassword() != password) {
			// Usuário ou senha incorretos
		} else {
			// Passar id para tela de favoritos
//			req.setAttribute("userId", user.getId());
//			req.getRequestDispatcher("Favoritos.jsp").forward(req, res);
		}
	}
}