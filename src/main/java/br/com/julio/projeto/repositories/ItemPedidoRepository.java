package br.com.julio.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.julio.projeto.domain.ItemPedido;


@Repository
public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Integer>{



}