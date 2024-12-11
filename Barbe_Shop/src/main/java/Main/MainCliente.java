package Main;

import java.util.List;

import BarrbeariaDAO.ClienteDAO;
import BarrbeariaDAO.ServicosDAO;
import Model.Cliente;
import Model.Servicos;


public class MainCliente {

	public static void main (String [] args) { 
		

		Servicos serv = new Servicos();
		ServicosDAO servDAO = new ServicosDAO();
		
		
	   
	  List<Servicos> list = servDAO.findAll();
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i).getId()+"\n"+list.get(i).getCorte());
		}
	    System.out.println("Hello word");
		
		/*Servicos serv3 = servDAO.findbyId(2);
		S
		System.out.println(serv3.getCorte());
		/*
		serv.setBarba("Tiras as Pontas");
		serv.setCorte("desgraçe");
		serv.setSombrancelha("sla");
		servDAO.add(serv);
		/*adicionar um cliente*/
//		Cliente cliente = new Cliente();
//		cliente.setNome("Luiz");
//		cliente.setNumero("064 999712512");
//		ClienteDAO pDAO = new ClienteDAO();
//    	pDAO.add(cliente);
		
		/*atualizar os dados do cliente*/
//		Cliente cliente = new Cliente();
//		ClienteDAO pDAO = new ClienteDAO();
//		Cliente pc = pDAO.findbyId(1);
//		pc.setNome("Otavio");
//		pc.setNumero("064 999712512");
//		pDAO.updateClienteById(pc);
		
		/*apagar o cliente pelo nome*/
//		Cliente cliente = new Cliente();
//		cliente.setNome("Luiz");
//		ClienteDAO pDAO = new ClienteDAO();
//    	pDAO.deleteByName(cliente);
		
		/*Listar todos*/
//		ClienteDAO pDAO = new ClienteDAO();
//		List<Cliente> list = pDAO.findAll();	
//		for (int i = 0; i < list.size(); i++) {
//		System.out.println(list.get(i).getNome());
//		System.out.println(list.get(i).getId());
//		System.out.println(list.get(i).getNumero());
//		}

		
}
}
