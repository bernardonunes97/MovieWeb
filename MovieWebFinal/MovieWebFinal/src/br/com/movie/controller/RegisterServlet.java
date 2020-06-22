package br.com.movie.controller;

import java.io.IOException;
import java.util.List;

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
		
		if (name == "" || username == "" || password == "") {
			System.out.println("Entrou aki");
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		
//		System.out.println("Name: " + name + " Username: " + username + " Password: " + password);
		
//		UserDAO userDao = new UserDAO();
//		UserBean user = userDao.fetchUsername(username);
//		
//		List<UserBean> users = userDao.fetchAll();
//		for (UserBean u : users) {
//			System.out.println("Name: " + u.getName() + " Username: " + u.getUsername());
//		}
//		
//		if (user != null) {
//			System.out.println("Usuário existente");
//			// Usuário já existente
//		} else {
//			System.out.println("Usuário não existente");
//			// Registrar usuário
//			user = new UserBean(username, name, password);
//			System.out.println("User: " + user.getName());
//			if (userDao.create(user)) {
//				System.out.println("Sucesso ao cadastrar");
//				// Sucesso cadastrado
//			} else {
//				// Erro ao cadastrar
//				System.out.println("Erro ao cadastrar");
//			}
//		}
	}
}
