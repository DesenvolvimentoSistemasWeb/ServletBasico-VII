package br.edu.estacio.interfaces;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.estacio.domain.Pessoa;
import br.edu.estacio.domain.Pessoas;
import br.edu.estacio.persistence.impl.ConvidadoDAO;

/**
 * Servlet implementation class Editar
 */
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String codigo = request.getPathInfo().substring(1);
		
		ConvidadoDAO convidadoDAO = new ConvidadoDAO();
		
		Integer cod = Integer.parseInt(codigo);
		
		//Pessoas pessoas = (Pessoas) request.getSession().getAttribute("pessoas");
		Pessoa pessoa = null;
		pessoa = convidadoDAO.read(cod);
		request.getSession().setAttribute("pessoa", pessoa);	
		response.sendRedirect("/ServletBasico-VII/edicao.jsp");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String codigo = request.getPathInfo().substring(1);

		Integer cod = Integer.parseInt(codigo);
		
		ConvidadoDAO convidadoDAO = new ConvidadoDAO();
		
		//Pessoas pessoas = (Pessoas) request.getSession().getAttribute("pessoas");
		//pessoas.removeByCodigo(cod);
		
		String nome = request.getParameter("nome");
		Pessoa temp = new Pessoa();
		temp.setCodigo(cod);
		temp.setNome(nome);
		convidadoDAO.update(temp);
				
		Pessoas pessoas = new Pessoas();
		for (Pessoa pessoa : convidadoDAO.readAll()) {
			pessoas.add(pessoa.getCodigo(), pessoa);
		}	
		
		request.getSession().setAttribute("pessoas",pessoas);		
		//response.sendRedirect("/ServletBasico-VII/listagem.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/listagem.jsp");
		rd.forward(request,response);		
		
	}

}
