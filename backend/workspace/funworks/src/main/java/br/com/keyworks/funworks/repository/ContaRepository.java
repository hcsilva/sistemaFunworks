package br.com.keyworks.funworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.keyworks.funworks.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
