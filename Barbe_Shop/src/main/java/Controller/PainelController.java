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

import BarrbeariaDAO.BarbeiroDAO;
import Model.Barbeiro;


/**
 * Servlet implementation class PainelController
 */
@WebServlet("/PainelController")
public class PainelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BarbeiroDAO barbeiroDAO;
	private static final String MANTER_BARBEIRO = "manterBarbeiro.jsp";
	private static final String LISTAR_BARBEIRO = "listarBarbeirojsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PainelController() {
		super();
		barbeiroDAO = new BarbeiroDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String avancar = "";

		if (acao == null) {
			avancar = LISTAR_BARBEIRO;
		} else if (acao.equalsIgnoreCase("PainelDoBarbeiro")) {
		  

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
