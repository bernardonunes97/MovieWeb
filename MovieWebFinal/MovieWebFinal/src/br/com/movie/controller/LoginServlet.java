package br.com.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.client.RestTemplate;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.dao.UserDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("user");
		String password = req.getParameter("pwd");
		
		if (name == "" || password == "") {
			System.out.println("Entrou aki");
			req.setAttribute("error", "Preencha todos os campos!");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
		
//		UserDAO userDao = new UserDAO();
//		UserBean user = userDao.fetchUsername(name);
//		System.out.println("Username: " + user.getUsername());
//		System.out.println("Senha: " + user.getPassword());
//		System.out.println("Password entered: " + password);
//		
//		System.out.println("Name: " + "'" + name + "'");
//		
//		
//		
//		if (user == null || !user.getPassword().equals(password)) {
//			System.out.println("Usuário ou senha incorretos");
//			// Usuário ou senha incorretos
//		} else {
//			System.out.println("Username: " + user.getUsername() + "Id: " + user.getId());
//			// Passar id para tela de favoritos
////			req.setAttribute("userId", user.getId());
////			req.getRequestDispatcher("Favoritos.jsp").forward(req, res);
//		}
	}
}