package Main;

import BarrbeariaDAO.BarbeiroDAO;
import Model.Barbeiro;

public class MainBarbeiro {
public static void main(String[] args) {
	BarbeiroDAO barbeiro = new BarbeiroDAO();
	Barbeiro baa = barbeiro.LoginBarbeiro("Ricardo",123456);
	System.out.println(baa.getNumero());
	
	
}
}
