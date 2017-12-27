package br.com.projeto.projeto.projetoempresa.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.projeto.projetoempresa.dao.TesteConection;
import br.com.projeto.projeto.projetoempresa.models.FuncionarioEmpresa;

public class ControllerFuncionario {
    //função para adicionar funcionário na base de dados
	public static void adicionaFuncionario(String cpf, String nome, String cargo, String dtnasc)
			throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Funcionario_empresa";
		sql = "INSERT INTO " + table + "(cpf, nome, cargo, dt_nasc) values (?,?,?,?)";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, cpf);
		pstm.setString(2, nome);
		pstm.setString(3, cargo);
		pstm.setString(4, dtnasc);
		pstm.executeUpdate();
		conn.close();

	}
	
	//função para alterar funcionário na base de dados
	public static void alterarFuncionario(FuncionarioEmpresa f)
			throws SQLException, InstantiationException {

		String sql;
		String table = "PROJETO_EMPRESA.dbo.Funcionario_empresa";
		sql = "UPDATE " + table + " SET Nome=?, Cargo=?, Dt_nasc=?, id_setor=? WHERE CPF=?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, f.getNome());
		pstm.setString(2, f.getCargo());
		pstm.setString(3, f.getDt_nasc());
		pstm.setInt(4, f.getid_setor());
		pstm.setString(5, f.getCPF());
		pstm.executeUpdate();
		conn.close();

	}
	//função para deletar funcionário na base de dados
	public static void deleteFunc(String CPF)
			throws SQLException, InstantiationException {
			
			String sql;
			String table = "PROJETO_EMPRESA.dbo.Funcionario_empresa";
			sql = "DELETE FROM " + table + " WHERE CPF=?";
			//Chamada de funcao para remover relacao projeto -> funcionario (Por id de Func)
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, CPF);
			pstm.executeUpdate();
			conn.close();
			
	}
	//função para consultar funcionário na base de dados
	public static FuncionarioEmpresa consultaFunc(String cpf)
			throws SQLException, InstantiationException {
		String sql;
		String table = "PROJETO_EMPRESA.dbo.Funcionario_empresa";
		sql = "SELECT * FROM " + table + "  WHERE CPF = ?";
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, cpf);
		ResultSet resultado = (pstm.executeQuery());

		FuncionarioEmpresa f = null;
		
		if (resultado.next()) {
			String resCPF = resultado.getString("CPF");
			String resNome = resultado.getString("Nome");
			String resCargo = resultado.getString("Cargo");
			String resDtNasc = resultado.getDate("Dt_nasc").toString();
			int resSetor = resultado.getInt("id_setor");
			
			f = new FuncionarioEmpresa(resCPF, resNome, resCargo, resDtNasc, resSetor);
		}

		return f;
	}
	//Função para listar todos os funcionários
	/*public static ArrayList<FuncionarioEmpresa> consultaFuncs()
			throws SQLException, InstantiationException {
		String sql;
		String table = "PROJETO_EMPRESA.dbo.Funcionario_empresa";
		sql = "SELECT * FROM " + table;
		Connection conn = TesteConection.connect();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet resultado = (pstm.executeQuery());

		ArrayList<FuncionarioEmpresa> f = new ArrayList<FuncionarioEmpresa>();
		
		while (resultado.next()) {
			String resCPF = resultado.getString("CPF");
			String resNome = resultado.getString("Nome");
			String resCargo = resultado.getString("Cargo");
			String resDtNasc = resultado.getDate("Dt_nasc").toString();
			int resSetor = resultado.getInt("id_setor");
			
			f.add(new FuncionarioEmpresa(resCPF, resNome, resCargo, resDtNasc, resSetor));
		}

		return f;
	}*/
	
	

}
