package br.com.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.bo.UserBO;
import br.com.movie.model.dao.UserDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		UserBO userBo = new UserBO();
		UserDAO userDao = new UserDAO();
		
		if (username == "" || password == "") {
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
		if (userBo.login(username, password)) {
			UserBO.idUserLogged = userDao.fetchUsername(username).getId();
			req.getRequestDispatcher("MovieListView.jsp").forward(req, res);
		} else {
			// Erro de login
			req.setAttribute("error", "Usuário ou senha incorretos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}
}