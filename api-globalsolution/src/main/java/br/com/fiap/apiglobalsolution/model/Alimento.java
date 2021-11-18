package br.com.fiap.apiglobalsolution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_ALIMENTO")
public class Alimento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private double qtde;

	@Column(nullable = false)
	private String telefone;

	public Alimento() {
	}

	public Alimento(String nome, double qtde, String telefone) {
		this.nome = nome;
		this.qtde = qtde;
		this.telefone = telefone;
	}

}
