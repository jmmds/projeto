package br.com.julio.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.julio.projeto.domain.Pagamento;


@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Integer>{



}