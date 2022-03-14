package br.com.julio.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.julio.projeto.domain.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository <Produto , Integer>{



}