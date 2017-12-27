package br.com.projeto.projeto.projetoempresa.models;


/**
*
* @author Inmetrics Ellen Joyce
*/

public class FuncionarioEmpresa {
	private String CPF;
	private String Nome;
	private String Cargo;
	private String DtNasc;
	private int id_setor;
	
	//Construtor da classe, com parametros específicos
	public FuncionarioEmpresa(String cpf, String nome, String cargo, String DtNasc, int idsetor){
		this.CPF=cpf;
		this.Nome=nome;
		this.Cargo=cargo;
		this.DtNasc=DtNasc;
		this.id_setor=idsetor;
	}
	
	//Funções de Get e Set
	public String getCPF(){
		return this.CPF;
	}
	public void setCPF(String cpf){
		this.CPF=cpf;
	}
	
	public String getNome(){
		return this.Nome;
	}
	public void setNome(String nome){
		this.Nome=nome;
	}
	
	public String getCargo(){
		return this.Cargo;
	}
	public void setCargo(String cargo){
		this.Cargo=cargo;
	}
	
	public String getDt_nasc(){
		return this.DtNasc;
	}
	public void setDt_nasc(String dt_nasc){
		this.DtNasc=dt_nasc;
	}
	
	public int getid_setor(){
		return this.id_setor;
	}
	public void setid_setor(int idsetor){
		this.id_setor=idsetor;
	}
	
}
