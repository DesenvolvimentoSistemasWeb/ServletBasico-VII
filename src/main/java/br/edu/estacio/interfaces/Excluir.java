package br.edu.estacio.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.estacio.domain.Pessoa;
import br.edu.estacio.domain.Pessoas;
import br.edu.estacio.persistence.impl.ConvidadoDAO;

/**
 * Servlet implementation class Excluir
 */
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getPathInfo().substring(1);
		
		Integer cod = Integer.parseInt(codigo);
		
		ConvidadoDAO convidadoDAO = new ConvidadoDAO();
		
		convidadoDAO.delete(cod);
		Pessoas pessoas = new Pessoas();
		for (Pessoa pessoa : convidadoDAO.readAll()) {
			pessoas.add(pessoa.getCodigo(), pessoa);
		}
		
		request.getSession().setAttribute("pessoas", pessoas);
		response.sendRedirect("/ServletBasico-VII/listagem.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
