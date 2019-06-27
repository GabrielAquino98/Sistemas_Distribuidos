package br.com.viagem.gerenciador.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="local")
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "preco_diaria", nullable = false)
	private float preco_diaria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco_diaria() {
		return preco_diaria;
	}

	public void setPreco_diaria(float preco_diaria) {
		this.preco_diaria = preco_diaria;
	}

	public Local(int id, String descricao, float preco_diaria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco_diaria = preco_diaria;
	}

	public Local() {
		super();
	}
	
}
