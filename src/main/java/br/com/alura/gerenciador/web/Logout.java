package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().removeAttribute("usuario.logado");
		//req.getSession().invalidate();        Usado quando quer eliminar toda a sessão
		
		/*
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		if(cookie == null){
			writer.println("<html><body>Usuario nao estava logado!</body></html>");
			return;
		}
		cookie.setMaxAge(0);
		resp.addCookie(cookie);*/
		/*PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Deslogado com sucesso</body></html>");*/
		
		//redirecionamento no cliente
		//resp.sendRedirect("logout.html");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
	}
}
