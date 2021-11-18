
package br.com.fiap.apiglobalsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.apiglobalsolution.model.Alimento;
import br.com.fiap.apiglobalsolution.repository.AlimentoRepository;

//anotação informando que é uma aplicação Rest
//essa classe receberá as requisições HTTP
@RestController
@RequestMapping("/api/beneficiarias") // uri padrao para nossa api
public class AlimentoController {

	// @ Autowired fornece controle sobre onde e como a ligação entre os beans deve
	// ser realizada
	@Autowired
	AlimentoRepository alimentoRepository;

	// Lista a empresa beneficiaria no banco de dados
	@GetMapping
	public List<Alimento> lista() {
		return alimentoRepository.findAll();
	}

	// Salva uma empresa beneficiaria no banco de dados
	@PostMapping
	@ResponseBody
	public Alimento novo(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}

	// Exclui uma empresa beneficiaria
	@DeleteMapping
	public void deletaAlimento(@RequestBody Alimento alimento) {
		alimentoRepository.delete(alimento);
	}

	// Atualiza uma empresa beneficiaria
	@PutMapping
	public Alimento atualizaAlimento(@RequestBody Alimento alimento) {
		return alimentoRepository.save(alimento);
	}

}
