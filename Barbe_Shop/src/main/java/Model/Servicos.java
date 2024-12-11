package Model;

public class Servicos {
	private int id;
	private String corte;
	private String barba;
	private String sombrancelha;
    private Barbeiro barbeiro;
    private Cliente cliente;
	
	
	public Barbeiro getBarbeiro() {
		return barbeiro;
	}
	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorte() {
		return corte;
	}
	public void setCorte(String corte) {
		this.corte = corte;
	}
	public String getBarba() {
		return barba;
	}
	public void setBarba(String barba) {
		this.barba = barba;
	}
	
	public String getSombrancelha() {
		return sombrancelha;
	}
	public void setSombrancelha(String sombrancelha) {
		this.sombrancelha = sombrancelha;
	}
}
