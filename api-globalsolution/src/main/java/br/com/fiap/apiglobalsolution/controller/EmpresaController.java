
package br.com.fiap.apiglobalsolution.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apiglobalsolution.enumerated.TipoEmpresa;
import br.com.fiap.apiglobalsolution.model.Empresa;
import br.com.fiap.apiglobalsolution.repository.EmpresaRepository;

//anotação informando que é uma aplicação Rest
//essa classe receberá as requisições HTTP
@RestController
@RequestMapping("/api/beneficiarias") // uri padrao para nossa api
public class EmpresaController {

	// @ Autowired fornece controle sobre onde e como a ligação entre os beans deve
	// ser realizada
	@Autowired
	EmpresaRepository empresaRepository;

	// Lista a empresa beneficiaria no banco de dados
	@GetMapping
	public List<Empresa> lista() {
		return empresaRepository.findAll();
	}
	
	
	@GetMapping("/lista/doadoras")
	public List<Empresa> listaDoadoras(@PathVariable TipoEmpresa empresa) {
		return empresaRepository.findByTipo(empresa).get();
	}
	
	
	// Salva uma empresa beneficiaria no banco de dados
	@PostMapping
	@ResponseBody
	public Empresa novo(@RequestBody Empresa beneficiaria) {
		return empresaRepository.save(beneficiaria);
	}

	// Exclui uma empresa beneficiaria
	@DeleteMapping
	public void deletaBeneficiaria(@RequestBody Empresa beneficiaria) {
		empresaRepository.delete(beneficiaria);
	}

	// Atualiza uma empresa beneficiaria
	@PutMapping
	public Empresa atualizaPaciente(@RequestBody Empresa beneficiaria) {
		return empresaRepository.save(beneficiaria);
	}

}
