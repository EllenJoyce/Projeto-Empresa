package br.com.projeto.projeto.projetoempresa.models;

/**
*
* @author Inmetrics Ellen Joyce
*/

public class RelacaoProjetoFuncionario {
	private int id;
	private int idprojeto;
	private String idfunc;
	
	public RelacaoProjetoFuncionario(int id, int idprojeto, String idfunc){
		this.id=id;
		this.idprojeto=idprojeto;
		this.idfunc=idfunc;
	}
	
	public int getid(){
		return this.id;
	}
	public void setid(int id){
		this.id=id;
	}
	
	public int getid_projeto(){
		return this.idprojeto;
	}
	public void setid_projeto(int idprojeto){
		this.idprojeto=idprojeto;
	}
	
	public String getid_func(){
		return this.idfunc;
	}
	public void setid_func(String idfunc){
		this.idfunc=idfunc;
	}

}
