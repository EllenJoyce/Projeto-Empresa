package br.com.projeto.projeto.projetoempresa.models;

/**
*
* @author Inmetrics Ellen Joyce
*/

public class SetorEmpresa {
	private int id;
	private String nomesetor;
	private String gerente;
	
	//Construtor da classe, com parametros específicos
	public SetorEmpresa(int id, String nomesetor, String gerente){
	    this.id=id;
	    this.nomesetor=nomesetor;
	    this.gerente=gerente;
	    
	}
	//Funções de Get e Set
	public int getid(){
		return this.id;
	}
	public void setid(int id){
		this.id=id;
	}
	
	public String getnomesetor(){
		return this.nomesetor;
	}
	public void setnomesetor(String nomesetor){
		this.nomesetor=nomesetor;
	}
	
	public String getgerente(){
		return this.gerente;
	}
	public void setgerente(String gerente){
		this.nomesetor=gerente;
	}
	
	

}
