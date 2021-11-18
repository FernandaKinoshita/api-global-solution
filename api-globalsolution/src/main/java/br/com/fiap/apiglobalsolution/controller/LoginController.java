package br.com.fiap.apiglobalsolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.apiglobalsolution.model.Empresa;
import br.com.fiap.apiglobalsolution.repository.EmpresaRepository;

@Controller
public class LoginController {

	@Autowired
	EmpresaRepository empresaRepository;

	@RequestMapping("/login/doadora")
	public ResponseEntity<Empresa> login(@RequestBody Empresa login) {

		Empresa empresa = empresaRepository.findByCnpj(login.getCnpj()).get();

		if (empresa.getSenha().equals(login.getSenha())) {
			return ResponseEntity.ok(empresa);
		}

		return ResponseEntity.badRequest().build();
	}

}
