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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name").trim();
		String username = req.getParameter("user").trim();
		String password = req.getParameter("pwd").trim();
		HttpSession session = req.getSession();
		UserBO userBo = new UserBO();
		
		if (!userBo.validateUserInput(name, username, password)) {
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
			return;
		}
		
		if (userBo.createNewUser(username, name, password)) {
			System.out.println("Criado!");
			session.setAttribute("username", username);
			req.getRequestDispatcher("MovieListView.jsp").forward(req, res);
		} else {
			req.setAttribute("error", "Usuário já existe.");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
	}
}
