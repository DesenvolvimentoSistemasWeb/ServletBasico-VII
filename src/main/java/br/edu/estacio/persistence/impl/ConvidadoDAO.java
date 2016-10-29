package br.edu.estacio.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.estacio.domain.Pessoa;
import br.edu.estacio.persistence.DBConnection;
import br.edu.estacio.persistence.dao.DAO;

public class ConvidadoDAO implements DAO<Pessoa>{

	private Connection conn = null;
	
	@Override
	public void create(Pessoa t) {
		try {
			conn = DBConnection.Connect();
			PreparedStatement stm = conn.prepareStatement("Insert into convidado(nome) values(?)");
			stm.setString(1, t.getNome());
			boolean ok = stm.execute();
			conn.close();
			if (ok) {
				System.out.println("Convidado inserido com sucesso!!");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados!!");
			e.printStackTrace();
		}		
	}

	@Override
	public Pessoa read(long codigo) {
		Pessoa temp = null;
		try {
			conn = DBConnection.Connect();
			PreparedStatement stm = conn.prepareStatement("select * from convidado where codigo=?");
			stm.setLong(1, codigo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()){
				temp = new Pessoa();
				temp.setCodigo(rs.getLong(1));
				temp.setNome(rs.getString(2));
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados!!");
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public List<Pessoa> readAll() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			conn = DBConnection.Connect();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("select * from convidado");
			while (rs.next()){
				Pessoa temp = new Pessoa();
				temp.setCodigo(rs.getLong(1));
				temp.setNome(rs.getString(2));
				pessoas.add(temp);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados!!");
			e.printStackTrace();
		}
		return pessoas;
	}

	@Override
	public void update(Pessoa t) {
		try {
			conn = DBConnection.Connect();
			PreparedStatement stm = conn.prepareStatement("update convidado set nome=? where codigo=?");
			stm.setString(1, t.getNome());
			stm.setLong(2, t.getCodigo());
			stm.executeQuery();
			conn.close();
			System.out.println("Convidado atualizado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long codigo) {
		try {
			conn = DBConnection.Connect();
			PreparedStatement stm = conn.prepareStatement("delete from convidado where codigo=?");
			stm.setLong(1, codigo);
			stm.executeQuery();
			System.out.println("Convidado apagado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
