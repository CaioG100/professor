package externo;

public class professor{
	private long id;
	private double valorhora;
	private String nome;
	private String telefone;
	private String materia;
	
	public long getid(){
		return id;
	}
	public double getvalorhora(){
		return valorhora;
	}
	public String getnome(){
		return nome;
	}
	public String gettelefone(){
		return telefone;
	}
	public String getmateria(){
		return materia;
	}
	public void setid(long id){
		this.id = id;
	}
	public void setvalorhora(double valorhora){
		this.valorhora = valorhora;
	}
	public void setnome(String nome){
		this.nome = nome;
	}
	public void settelefone(String telefone){
		this.telefone = telefone;
	}
	public void setmateria(String materia){
		this.materia = materia;
	}
}
