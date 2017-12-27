package br.com.projeto.projeto.projetoempresa.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projeto.projeto.projetoempresa.dao.TesteConection;
import br.com.projeto.projeto.projetoempresa.models.Projeto;
import br.com.projeto.projeto.projetoempresa.models.SetorEmpresa;

public class ControllerSetor {

		public static void adicionaSetor(String nomeSetor, String nomeGerente)
				throws SQLException, InstantiationException {

			String sql;
			String table = "PROJETO_EMPRESA.dbo.Setor_empresa";
			sql = "INSERT INTO " + table + "(Nome_do_setor, Gerente) values (?,?)";
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nomeSetor);
			pstm.setString(2, nomeGerente);
			pstm.executeUpdate();
			conn.close();

		}
		
		public static void alterarSetor(SetorEmpresa s)
				throws SQLException, InstantiationException {

			String sql;
			String table = "PROJETO_EMPRESA.dbo.Setor_empresa";
			sql = "UPDATE " + table + " SET Nome_do_setor=?, Gerente=? WHERE id=?";
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getnomesetor());
			pstm.setString(2, s.getgerente());
			pstm.setInt(3, s.getid());
			pstm.executeUpdate();
			conn.close();
 
		}
		
		public static void deleteSetor(int id)
				throws SQLException, InstantiationException {
				
				String sql;
				String table = "PROJETO_EMPRESA.dbo.Setor_empresa";
				sql = "DELETE FROM " + table + " WHERE id=?";
				Connection conn = TesteConection.connect();
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.executeUpdate();
				conn.close();
				
		}	
		
		
		public static SetorEmpresa consultaSetorEmp(int id)
				throws SQLException, InstantiationException {
			String sql;
			String table = "PROJETO_EMPRESA.dbo.Setor_empresa";
			sql = "SELECT * FROM " + table + "  WHERE id = ?";
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet resultado = (pstm.executeQuery());

			SetorEmpresa s = null;
			
			if (resultado.next()) {
				int resId = resultado.getInt("id");
				String resNomeSetor = resultado.getString("Nome_do_setor");
				String resGerente = resultado.getString("Gerente");
				
				s = new SetorEmpresa(resId, resNomeSetor, resGerente);
			}

			return s;
		}
		
		public static ArrayList<SetorEmpresa> consultaSetores()
				throws SQLException, InstantiationException {
			String sql;
			String table = "PROJETO_EMPRESA.dbo.Setor_empresa";
			sql = "SELECT * FROM " + table;
			Connection conn = TesteConection.connect();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet resultado = (pstm.executeQuery());

			ArrayList<SetorEmpresa> p = new ArrayList<SetorEmpresa>();
			
			while (resultado.next()) {
				int resId = resultado.getInt("id");
				String resNomeSetor = resultado.getString("Nome_do_setor");
				String resGerente = resultado.getString("Gerente");
				
				p.add(new SetorEmpresa(resId, resNomeSetor, resGerente));
				
			}

			return p;
		}
		

		
		

}
