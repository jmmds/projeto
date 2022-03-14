package br.com.julio.projeto.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.julio.projeto.domain.Estado;


@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer>{



}