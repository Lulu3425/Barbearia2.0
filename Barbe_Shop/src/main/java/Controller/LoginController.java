package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthCheckBoxMenuItemUI;

import BarrbeariaDAO.BarbeiroDAO;
import Model.Barbeiro;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BarbeiroDAO barbeiroDAO;

	private static final String LOGIN = "ListarBarbeiro.jsp";
	private static final String PAINEL = "Painel.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		barbeiroDAO = new BarbeiroDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String avancar = "";

		if (acao.equalsIgnoreCase("LOGAR")) {
			String nome = request.getParameter("nome");
			int senha = Integer.parseInt(request.getParameter("senha"));

			Barbeiro barbeiro = barbeiroDAO.LoginBarbeiro(nome, senha);
			if (barbeiro.getNome()!=nome && barbeiro.getSenha()!=senha) {
				   avancar= LOGIN;
			   }
			else if (barbeiro.getNome().equalsIgnoreCase(nome) && barbeiro.getSenha() == senha) {
				
				List<Barbeiro> Babr = new ArrayList<>();
			    Babr.add(barbeiro);
				request.setAttribute("listaBarbeiro", Babr);
				avancar = PAINEL;
				
		   } 
		   
			
		
		}

		RequestDispatcher pagina = request.getRequestDispatcher(avancar);
		pagina.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
