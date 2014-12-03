package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.MappingChange.Map;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if (usuario == null) {
			PrintWriter writer = resp.getWriter();
	        writer.println("<html>");
	        writer.println("<body>");
	        writer.println("Usuario e/ou senha inválidos");
	        writer.println("</body>");
	        writer.println("</html>");
		} else {
			
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);
			
			//Cookie cookie = new Cookie("usuario.logado", email);
			//cookie.setMaxAge(10*60);
			//resp.addCookie(cookie);
			
			PrintWriter writer = resp.getWriter();
	        writer.println("<html>");
	        writer.println("<body>");
	        writer.println("Usuario Logado" + usuario.getEmail());
	        writer.println("</body>");
	        writer.println("</html>");
		}
	}
	
}
