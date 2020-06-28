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
		
		// Parâmetros da .jsp
		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		// BO e DAO
		UserBO userBo = new UserBO();
		UserDAO userDao = new UserDAO();
		
		// Testando input do usuário
		if (username == "" || password == "") {
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
		
		// Testando se usuário existe no banco
		if (userBo.login(username, password)) {
			// Usuário e senha corretos.
			UserBO.idUserLogged = userDao.fetchUsername(username).getId();
			req.getRequestDispatcher("MovieListView.jsp").forward(req, res);
		} else {
			// Usuário ou senha incorretos.
			req.setAttribute("error", "Usuário ou senha incorretos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}
}