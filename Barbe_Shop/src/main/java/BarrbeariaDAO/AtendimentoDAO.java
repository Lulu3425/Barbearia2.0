package BarrbeariaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Model.Atendimento;
import Model.Barbeiro;

public class AtendimentoDAO {

	private Connection connection;

	public AtendimentoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
public void add (Atendimento atendimento) {
		
		String sql = "INSERT INTO Atendimento (horario,data,Valor_atendimento,id_atendimento,id_servico,id_cliente,id_barbeiro) VALUES (?,?,?,?,?,?,?)";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,atendimento.getHorario());
			statement.setDate(2,atendimento.getData());
			statement.setString(3,atendimento.getValor_atendimento());
			statement.setInt(3,atendimento.getId());
			
			
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(AtendimentoDAO.class.getName()).log(Level.SEVERE, null,e);
		}
	}

}
