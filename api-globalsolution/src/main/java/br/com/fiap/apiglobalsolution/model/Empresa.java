package br.com.fiap.apiglobalsolution.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.fiap.apiglobalsolution.enumerated.TipoEmpresa;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMPRESA")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CNPJ
	@Column(nullable = false, length = 14, unique = true)
	private String cnpj;

	@Column(nullable = false, length = 50)
	private String razaoSocial;

	@Column(nullable = false, length = 50)
	private String endereco;

	@Email
	@Column(nullable = false, length = 40, unique = true)
	private String email;

	@Column(nullable = false, length = 4)
	private String senha;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEmpresa tipo;

	// Construtor
	public Empresa() {
	}

	public Empresa(@CNPJ String cnpj, String razaoSocial, String endereco, @Email String email, String senha,
			TipoEmpresa tipo) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
}