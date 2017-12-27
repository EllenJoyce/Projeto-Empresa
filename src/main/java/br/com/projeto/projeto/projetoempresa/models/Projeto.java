package br.com.projeto.projeto.projetoempresa.models;

/**
*
* @author Inmetrics Ellen Joyce
*/

public class Projeto {
	private int id;
	private String Cliente;
	private String Nome_projeto;
	private String Gestor;
	private int id_setor;
	
	//Construtor da classe, com parametros específicos
	public Projeto(int idP, String cliente, String nome_projeto,String gestor, int idsetor){
		this.id=idP;
	    this.Cliente=cliente;
	    this.Nome_projeto=nome_projeto;
	    this.Gestor=gestor;
	    this.id_setor=idsetor;
	}
	//Funções de Get e Set
	public int getid(){
		return this.id;
	}
	public void setid(int id){
		this.id=id;
	}
	
	public String getCliente(){
		return this.Cliente;
	}
	public void setCliente(String cliente){
		this.Cliente=cliente;
	}
	
	public String getNome_projeto(){
		return this.Nome_projeto;
	}
	public void setNome_projeto(String nome_projeto){
		this.Nome_projeto=nome_projeto;
	}
	
	public String getGestor(){
		return this.Gestor;
	}
	public void setGestor(String gestor){
		this.Gestor=gestor;
	}	
	
	public int getid_setor(){
		return this.id_setor;
	}
	public void setid_setor(int id_setor){
		this.id_setor=id_setor;
	}

}
