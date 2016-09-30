package br.edu.estacio.interfaces;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.estacio.domain.Pessoa;
import br.edu.estacio.domain.Pessoas;

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
		
		Integer cod = Integer.parseInt(codigo);
		
		Pessoas pessoas = (Pessoas) request.getSession().getAttribute("pessoas");
		Pessoa pessoa = null;
		if (!pessoas.getPessoas().isEmpty()) {
			pessoa = pessoas.findByCodigo(cod);
		}
		if (pessoa != null) {
			request.getSession().setAttribute("pessoa", pessoa);	
			response.sendRedirect("/ServletBasico-VI/edicao.jsp");		
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String codigo = request.getPathInfo().substring(1);

		Integer cod = Integer.parseInt(codigo);
		
		Pessoas pessoas = (Pessoas) request.getSession().getAttribute("pessoas");
		pessoas.removeByCodigo(cod);
		
		String nome = request.getParameter("nome");
		Pessoa temp = new Pessoa();
		temp.setCodigo(cod);
		temp.setNome(nome);
		pessoas.add(cod, temp);
		
		response.sendRedirect("/ServletBasico-VI/listagem.jsp");
		
		
	}

}
