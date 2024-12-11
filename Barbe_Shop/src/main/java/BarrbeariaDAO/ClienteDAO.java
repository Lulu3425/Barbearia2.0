package BarrbeariaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Model.Cliente;






public class ClienteDAO {

	private Connection connection;

	public ClienteDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add (Cliente cliente) {
		
		String sql = "INSERT INTO Cliente (nome,numero) VALUES (?,?)";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,cliente.getNome());
			statement.setString(2,cliente.getNumero());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null,e);
		}
	}
		
	public Cliente findbyId(int id){
		String sql = "SELECT * FROM Cliente WHERE id = ?";
		Cliente cliente = new Cliente ();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,id);
			 
			ResultSet rs = statement.executeQuery();
			rs.next();
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setNumero(rs.getString("numero"));
		}catch (SQLException e) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return cliente;
	}
	
	public void updateClienteById(Cliente cliente) {
		String sql = "UPDATE Cliente SET nome = ?, numero = ? WHERE id = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,cliente.getNome());
			statement.setString(2,cliente.getNumero());
			statement.setInt(3,cliente.getId());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void deleteById(Cliente cliente) {
		String sql = "DELETE FROM Cliente WHERE id = ?";
		
	try(PreparedStatement statement = connection.prepareStatement(sql)){
		statement.setInt(1,cliente.getId());
		statement.execute();
	}catch (SQLException e) {
		Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,e);
	}
	
}
	
	public List<Cliente> findAll(){
		String sql = "SELECT * FROM Cliente";
		List<Cliente> list = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Cliente cliente = null;
			
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setNumero(rs.getString("numero"));
				
				list.add(cliente);
			}
		}catch (SQLException e) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		return list;
	}
	
}


