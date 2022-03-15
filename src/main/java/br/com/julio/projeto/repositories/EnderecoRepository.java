package br.com.julio.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.julio.projeto.domain.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer>{



}