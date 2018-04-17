package br.usjt.arqsw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
@Entity
public class Fila {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_fila")
	private int id;
	
	@NotNull
	@Size(max=45)
	@Column(name="nm_fila")
	private String nome;
	
	@Null
	@Size(max=45)
	@Column(name="nm_figura")
	private String figura;
	
	@Size(max=256)
	@Column(name="caminho_figura")
	private String caminho_figura;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_rh")
	private int id_rh;
	
	@NotNull
	@Size(max=45)
	@Column(name="nome_cliente")
	private String nomecliente;
	
	@NotNull
	@Size(max=45)
	@Column(name="sobrenome_cliente")
	private String sobrenomecliente;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFigura() {
		return figura;
	}
	public void setFigura(String figura) {
		this.figura = figura;
	}
	
	public String getCaminho_figura() {
		return caminho_figura;
	}
	public void setCaminho_figura(String caminho_figura) {
		this.caminho_figura = caminho_figura;
	}
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + ", figura=" + figura + ", caminho_figura=" + caminho_figura + "]";
	}
	public void add(int numero) {
		// TODO Auto-generated method stub
		
	}
}
