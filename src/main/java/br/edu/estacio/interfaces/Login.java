package br.edu.estacio.interfaces;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Usuário e senha do web.xml
		String usuario = request.getServletContext().getInitParameter("Usuario");
		String senha = request.getServletContext().getInitParameter("Senha");
		
		//Usuário e senha do login da aplicação
		String usuarioLogin = request.getParameter("usuario");
		String senhaLogin = request.getParameter("senha");
		
		RequestDispatcher rd;
		request.getSession().invalidate();
		if (usuarioLogin.equals(usuario) && senhaLogin.equals(senha)){
			rd = request.getRequestDispatcher("/index.jsp");
		} else {
			rd = request.getRequestDispatcher("/");		
		}
		rd.forward(request, response);
		
	}

}
