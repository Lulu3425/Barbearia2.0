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
import BarrbeariaDAO.ClienteDAO;
import BarrbeariaDAO.ServicosDAO;
import Model.Barbeiro;
import Model.Cliente;
import Model.Servicos;


/**
 * Servlet implementation class ServicosController
 */
@WebServlet("/ServicosController")
public class ServicosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BarbeiroDAO barbeiroDAO;
	private ClienteDAO clienteDAO;
	private ServicosDAO servicosDAO;
	private static final String MANTER_PAINEL = "Painel.jsp";
	private static final String IR_PARA_SERVICOS = "ManterServicos.jsp";
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServicosController() {
		super();
		barbeiroDAO = new BarbeiroDAO();
		clienteDAO = new ClienteDAO();
		servicosDAO = new ServicosDAO();

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

		if (acao.equalsIgnoreCase("AdiconarCorte")) {
		
			String id_servicos = request.getParameter("id_servicos");
			request.setAttribute("servicos", servicosDAO.findbyId(Integer.parseInt(id_servicos)));
			avancar = IR_PARA_SERVICOS;

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String corte = request.getParameter("corte");
		String barba = request.getParameter("barba");
		String sombrancelha = request.getParameter("sombrancelha");
		String id_servicos = request.getParameter("id_servicos");
		String id_barbeiro = request.getParameter("id_barbeiro");
		String id_cliente = request.getParameter("id_cliente");
		if (id_servicos.isEmpty()) {
			Servicos servicos = new Servicos();
			servicos.setCorte(corte);
			servicos.setBarba(barba);
			servicos.setSombrancelha(sombrancelha);
			
			Barbeiro barbeiro = barbeiroDAO.findbyId(Integer.parseInt(id_barbeiro));
			servicos.setBarbeiro(barbeiro);
			Cliente cliente = clienteDAO.findbyId(Integer.parseInt(id_cliente));
			servicos.setCliente(cliente);
			request.setAttribute("listaServicos", servicosDAO.findbyId(Integer.parseInt(id_servicos)));
			RequestDispatcher pagina = request.getRequestDispatcher(MANTER_PAINEL);
			pagina.forward(request, response);
			doGet(request, response);
		}

	}
}
