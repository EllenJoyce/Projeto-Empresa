package br.com.projeto.projeto.projetoempresa.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projeto.projeto.projetoempresa.dao.TesteConection;
import br.com.projeto.projeto.projetoempresa.models.FuncionarioEmpresa;
import br.com.projeto.projeto.projetoempresa.models.Projeto;

public class ControllerProjeto {
	public static void adicionaProjeto(String cliente, String nome_projeto, String gestor, int id_setor)
			throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.projeto";
		sql = "INSERT INTO " + table + "(Cliente, Nome_projeto, Gestor, id_setor) values (?,?,?,?)";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, cliente);
		pstm.setString(2, nome_projeto);
		pstm.setString(3, gestor);
		pstm.setInt(4, id_setor);
		pstm.executeUpdate();
		conn.close();

	}
	
	
	public static void alterarProjeto(Projeto p)
			throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Projeto";
		sql = "UPDATE " + table + " SET Cliente=?, Nome_projeto=?, Gestor=?, id_setor=? WHERE id=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, p.getCliente());
		pstm.setString(2, p.getNome_projeto());
		pstm.setString(3, p.getGestor());
		pstm.setInt(4, p.getid_setor());
		pstm.setInt(5, p.getid());
		pstm.executeUpdate();
		conn.close();

	}
	

	public static void deleteProjeto(int id)
			throws SQLException, InstantiationException {
			
			String sql;
			String table = "PROJETO_EMPRESA.dbo.Projeto";
			sql = "DELETE FROM " + table + " WHERE id=?";
			//Chamada de funcao para remover relacao projeto -> funcionario (Por id de Projeto)
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			conn.close();
			
	}	
	

	public static void deleteProjetoSetor(int idsetor)
			throws SQLException, InstantiationException {
			
			String sql;
			String table = "PROJETO_EMPRESA.dbo.Projeto";
			sql = "DELETE FROM " + table + " WHERE id_setor=?";
			//Chamada de funcao para remover relacao projeto -> funcionario (Por id de Projeto)
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idsetor);
			pstm.executeUpdate();
			conn.close();
			
	}	
	public static Projeto consultaProj(String nomeProjeto)
			throws SQLException, InstantiationException {
		String sql;
		String table = "PROJETO_EMPRESA.dbo.Projeto";
		sql = "SELECT * FROM " + table + "  WHERE Nome_projeto=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, nomeProjeto);
		ResultSet resultado = (pstm.executeQuery());

		Projeto p = null;
		
		if (resultado.next()) {
			int resId = resultado.getInt("id");
			String resCliente = resultado.getString("Cliente");
			String resNomeProj = resultado.getString("Nome_projeto");
			String resGestor = resultado.getString("Gestor");
			int resSetor = resultado.getInt("id_setor");
			
			p = new Projeto(resId, resCliente, resNomeProj, resGestor, resSetor);
		}

		return p;
	}
	
	
	public static ArrayList<Projeto> consultaProjts()
			throws SQLException, InstantiationException {
		String sql;
		String table = "PROJETO_EMPRESA.dbo.Projeto";
		sql = "SELECT * FROM " + table;
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet resultado = (pstm.executeQuery());

		ArrayList<Projeto> p = new ArrayList<Projeto>();
		
		while (resultado.next()) {
			int resId = resultado.getInt("id");
			String resCliente = resultado.getString("Cliente");
			String resNomeProj = resultado.getString("Nome_projeto");
			String resGestor = resultado.getString("Gestor");
			int resSetor = resultado.getInt("id_setor");
			
			p.add(new Projeto(resId, resCliente, resNomeProj, resGestor, resSetor));
		}

		return p;
	}
	
	public static ArrayList<Integer> ConsultaProjSetor(int idSetor)
			throws SQLException, InstantiationException {
		String sql;
		String table = "PROJETO_EMPRESA.dbo.Projeto";
		sql = "SELECT * FROM " + table + "  WHERE id_setor = ?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idSetor);
		ResultSet resultado = (pstm.executeQuery());

		ArrayList<Integer> p = new ArrayList<Integer>();
		
		while (resultado.next()) {
		      int resSetor = resultado.getInt("id_setor");
			
			p.add(resSetor);
		}

		return p;
	}
	


}
