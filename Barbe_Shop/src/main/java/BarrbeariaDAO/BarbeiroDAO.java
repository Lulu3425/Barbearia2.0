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

public class BarbeiroDAO {

	private Connection connection;

	public BarbeiroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Barbeiro barbeiro) {

		String sql = "INSERT INTO Barbeiro (nome,numero,senha) VALUES (?,?,?)";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, barbeiro.getNome());
			statement.setString(2, barbeiro.getNumero());
			statement.setInt(3, barbeiro.getSenha());
			statement.execute();
		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public Barbeiro LoginBarbeiro(String nome, int senha) {

		String sql = "SELECT * FROM Barbeiro WHERE nome = ? and senha = ?";
		Barbeiro barbeiro = new Barbeiro();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, nome);
			statement.setInt(2, senha);
			ResultSet rs = statement.executeQuery();
			rs.next();
			barbeiro = new Barbeiro();
			barbeiro.setNome(rs.getString("nome"));
			barbeiro.setSenha(rs.getInt("senha"));
			barbeiro.setNumero(rs.getString("numero"));

		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}

		return barbeiro;
	}

	public Barbeiro findbyId(int id) {
		String sql = "SELECT * FROM Barbeiro WHERE id = ?";
		Barbeiro barbeiro = new Barbeiro();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();
			rs.next();
			barbeiro = new Barbeiro();
			barbeiro.setId(rs.getInt("id"));
			barbeiro.setNome(rs.getString("nome"));
			barbeiro.setNumero(rs.getString("numero"));
		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return barbeiro;
	}
	public Barbeiro findbyName(String nome) {
		String sql = "SELECT * FROM Barbeiro WHERE nome = ?";
		Barbeiro barbeiro = new Barbeiro();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, nome);

			ResultSet rs = statement.executeQuery();
			rs.next();
			barbeiro = new Barbeiro();
			barbeiro.setId(rs.getInt("id"));
			barbeiro.setNome(rs.getString("nome"));
			barbeiro.setNumero(rs.getString("numero"));
		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return barbeiro;
	}

	public void updateBarbeiroById(Barbeiro barbeiro) {
		String sql = "UPDATE Barbeiro SET nome = ?, numero = ? WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, barbeiro.getNome());
			statement.setString(2, barbeiro.getNumero());
			statement.setInt(3, barbeiro.getId());
			statement.execute();
		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void deleteById(Barbeiro barbeiro) {
		String sql = "DELETE FROM Barbeiro WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, barbeiro.getId());
			statement.execute();
		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public List<Barbeiro> findAll() {
		String sql = "SELECT * FROM Barbeiro";
		List<Barbeiro> list = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Barbeiro barbeiro = null;

			while (rs.next()) {
				barbeiro = new Barbeiro();
				barbeiro.setId(rs.getInt("id"));
				barbeiro.setNome(rs.getString("nome"));
				barbeiro.setNumero(rs.getString("numero"));

				list.add(barbeiro);
			}
		} catch (SQLException e) {
			Logger.getLogger(BarbeiroDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return list;
	}

}
