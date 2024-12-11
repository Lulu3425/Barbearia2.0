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
import Model.Barbeiro;
import Model.Cliente;
import Model.Servicos;

public class ServicosDAO {
	private Connection connection;

	public ServicosDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// criacao de metados
	public void add(Servicos servicos) {
		String sql = "INSERT INTO Servicos(corte,barba,sombrancelha,id_barbeiro,id_cliente) VALUES (?,?,?,?,?)";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, servicos.getCorte());
			statement.setString(2,servicos.getBarba());
			statement.setString(3, servicos.getSombrancelha());
			statement.setInt(4, servicos.getBarbeiro().getId());
            statement.setInt(5,servicos.getCliente().getId());
		} catch (SQLException e) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
		}
	}
		public Servicos findbyId(int id){
			String sql = "SELECT * FROM Servicos WHERE id_servico = ?";
			Servicos servicos = new Servicos();
			ClienteDAO clienteDAO = new ClienteDAO();
			BarbeiroDAO barbeiroDAO = new BarbeiroDAO();
			
			try(PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setInt(1,id);
				 
				ResultSet rs = statement.executeQuery();
				rs.next();
				servicos = new Servicos();
				servicos.setId(rs.getInt("id_servico"));
				servicos.setCorte(rs.getString("corte"));
				servicos.setSombrancelha(rs.getString("sombrancelha"));
				servicos.setBarba(rs.getString("barba"));
				int id_barbeiro = rs.getInt("id_barbeiro");
				Barbeiro barbeiro = barbeiroDAO.findbyId(id_barbeiro);
				servicos.setBarbeiro(barbeiro);
				int id_cliente = rs.getInt("id_cliente");
				Cliente cliente = clienteDAO.findbyId(id_cliente);
				servicos.setCliente(cliente);
			
			}catch (SQLException e) {
				Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE,null,e);
			}
			return servicos;
		}
		
		public void updateServicosById(Servicos servicos) {
			String sql = "UPDATE Servicos SET corte = ?, sombrancelha = ?,barba=? WHERE id_servico = ?";
			
			try (PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setString(1,servicos.getCorte());
				statement.setString(2,servicos.getSombrancelha());
				statement.setString(3, servicos.getBarba());
				statement.setInt(4,servicos.getId());
				statement.execute();
			}catch (SQLException e) {
				Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE,null,e);
			}
		}
		
		public void deleteById(Servicos servicos) {
			String sql = "DELETE FROM Servicos WHERE id_servico = ?";
			
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,servicos.getId());
			statement.execute();
		}catch (SQLException e) {
			Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE,null,e);
		}
		
	}
		
		public List<Servicos> findAll(){
			String sql = "SELECT * FROM Servicos";
			List<Servicos> list = new ArrayList<>();
			ClienteDAO clienteDAO = new ClienteDAO();
			BarbeiroDAO barbeiroDAO = new BarbeiroDAO();
			try(PreparedStatement statement = connection.prepareStatement(sql)){
				statement.execute();
				ResultSet rs = statement.getResultSet();
				Servicos servicos = null;
				
				while (rs.next()) {
					servicos = new Servicos();
					servicos.setId(rs.getInt("id_servico"));
					servicos.setCorte(rs.getString("corte"));
					servicos.setBarba(rs.getNString("barba"));
					servicos.setSombrancelha(rs.getString("sombrancelha"));
					int id_barbeiro = rs.getInt("id_barbeiro");
					Barbeiro barbeiro = barbeiroDAO.findbyId(id_barbeiro);
					servicos.setBarbeiro(barbeiro);
					int id_cliente = rs.getInt("id_cliente");
					Cliente cliente = clienteDAO.findbyId(id_cliente);
					servicos.setCliente(cliente);
					
					list.add(servicos);
				}
			}catch (SQLException e) {
				Logger.getLogger(ServicosDAO.class.getName()).log(Level.SEVERE,null,e);
			}
			return list;
		}
		
		
	}

