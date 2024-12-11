package Model;

import java.sql.Date;

public class Atendimento {
	private int id;
	private float preco;
	private String horario;
	private String Valor_atendimento;
	private Servicos id_servico;
	private Barbeiro id_barbeiro;
	private Cliente id_cliente;
	private Atendimento id_atendimento;

	public Atendimento getId_atendimento() {
		return id_atendimento;
	}

	public void setId_atendimento(Atendimento id_atendimento) {
		this.id_atendimento = id_atendimento;
	}

	private Date data;

	public String getValor_atendimento() {
		return Valor_atendimento;
	}

	public void setValor_atendimento(String valor_atendimento) {
		Valor_atendimento = valor_atendimento;
	}

	public Servicos getId_servico() {
		return id_servico;
	}

	public void setId_servico(Servicos id_servico) {
		this.id_servico = id_servico;
	}

	public Barbeiro getId_barbeiro() {
		return id_barbeiro;
	}

	public void setId_barbeiro(Barbeiro id_barbeiro) {
		this.id_barbeiro = id_barbeiro;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
//