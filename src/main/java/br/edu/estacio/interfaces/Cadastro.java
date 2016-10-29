package br.edu.estacio.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.estacio.domain.Pessoa;
import br.edu.estacio.domain.Pessoas;
import br.edu.estacio.persistence.impl.ConvidadoDAO;

/**
 * Servlet implementation class Cadastro
 */
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/cadastro.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nome = request.getParameter("nome");
		ConvidadoDAO convidadoDAO = new ConvidadoDAO();
		Pessoas pessoas = new Pessoas();
		if (nome != null && !"".equals(nome)){
			Pessoa temp = new Pessoa();
			temp.setNome(nome);
			convidadoDAO.create(temp);
			for (Pessoa pessoa : convidadoDAO.readAll()) {
				pessoas.add(pessoa.getCodigo(), pessoa);
			}
		}
		request.getSession().setAttribute("pessoas",pessoas);
		RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
		rd.forward(request, response);
	}

}
