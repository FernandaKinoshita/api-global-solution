package br.com.fiap.apiglobalsolution.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.apiglobalsolution.enumerated.TipoEmpresa;
import br.com.fiap.apiglobalsolution.model.Alimento;


//JpaRepository=> possui metodos prontos para fazer persistencia no BD
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
	
	Optional<Alimento> findByCnpj(String cnpj);	
	
	
	@Query(value = "SELECT b FROM Empresa b WHERE b.tipo = ?1")
	Optional <List<Alimento>> findByTipo(TipoEmpresa tipo);
}



