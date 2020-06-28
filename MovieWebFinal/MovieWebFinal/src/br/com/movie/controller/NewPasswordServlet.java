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

@WebServlet("/NewPasswordServlet")
public class NewPasswordServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UserBO userBo = new UserBO();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		String repeatPassword = req.getParameter("pwd2");
		String error = errorMessage(name, username, password, repeatPassword);
		
		if (error != null) {
			req.setAttribute("error", error);
			req.getRequestDispatcher("TrocarSenha.jsp").forward(req, res);
		}
		
		if(userBo.changePassword(name, repeatPassword)) {
			// Sucesso
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		} else {
			req.setAttribute("error", "Erro ao alterar senha");
			req.getRequestDispatcher("TrocarSenha.jsp").forward(req, res);
		}
	}
	
	
	private String errorMessage(String name, String username, String password, String repeatPassword) {
		return userBo.validadeNewPasswordEntries(name, username, password, repeatPassword);
	}
}
