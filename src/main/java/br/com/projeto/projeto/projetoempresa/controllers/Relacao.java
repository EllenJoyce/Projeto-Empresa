package br.com.projeto.projeto.projetoempresa.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.projeto.projetoempresa.dao.TesteConection;
import br.com.projeto.projeto.projetoempresa.models.RelacaoProjetoFuncionario;
import br.com.projeto.projeto.projetoempresa.models.SetorEmpresa;

public class Relacao {
	//função para adicionar relacionamento na base de dados
	public static void adicionaRelacao(int idProjeto, String idFunc) throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Relacao_projeto_func";
		sql = "INSERT INTO " + table + "(id_projeto, id_func) values (?,?)";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idProjeto);
		pstm.setString(2, idFunc);
		pstm.executeUpdate();
		conn.close();

	}
	//função para alterar relacionamento na base de dados
	public static void alterarRelacao(RelacaoProjetoFuncionario r) throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Relacao_projeto_func";
		sql = "UPDATE " + table + " SET id_projeto=?, id_func=?, WHERE id=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, r.getid_projeto());
		pstm.setString(2, r.getid_func());
		pstm.executeUpdate();
		conn.close();

	}
	//função para deletar relacionamento na base de dados
	public static void deleteRelacao(int id) throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Relacao_projeto_func";
		sql = "DELETE FROM " + table + " WHERE id=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
		conn.close();

	}
	//função para deletar relacionamento com funcionário na base de dados
	public static void deleteRelacaoFunc(String CPF) throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Relacao_projeto_func";
		sql = "DELETE FROM " + table + " WHERE id_func=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, CPF);
		pstm.executeUpdate();
		conn.close();
	}
	//função para deletar relacionamento com projeto na base de dados
	public static void deleteRelacaoProj(int idprojeto) throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Relacao_projeto_func";
		sql = "DELETE FROM " + table + " WHERE id_projeto=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idprojeto);
		pstm.executeUpdate();
		conn.close();

	}

}
