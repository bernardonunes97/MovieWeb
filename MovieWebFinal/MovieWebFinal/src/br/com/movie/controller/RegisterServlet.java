package br.com.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.bo.UserBO;
import br.com.movie.model.dao.UserDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		UserBO userBo = new UserBO();
		
		if (name == "" || username == "" || password == "") {
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		
		UserDAO userDao = new UserDAO();
		List<UserBean> users = userDao.fetchAll();
		for (UserBean user : users) {
			System.out.println("Username: " + user.getUsername());
			System.out.println("Password: " + user.getPassword());
		}
		
		if (userBo.createNewUser(username, name, password)) {
			System.out.println("Criado!");
			req.getRequestDispatcher("MovieListView.jsp").forward(req, res);
		} else {
			req.setAttribute("error", "Usuário já existe.");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
	}
}
