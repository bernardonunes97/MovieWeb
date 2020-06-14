package br.com.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.dao.UserDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		
		UserDAO userDao = new UserDAO();
		UserBean user = userDao.fetchUsername(username);
		
		if (user != null) {
			// Usuário já existente
		} else {
			// Registrar usuário
			user = new UserBean(username, name, password);
			if (userDao.create(user)) {
				// Sucesso cadastrado
			} else {
				// Erro ao cadastrar
			}
		}
	}
}
