package br.com.julio.projeto.services;

import java.util.Optional;

//import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.julio.projeto.domain.Categoria;
import br.com.julio.projeto.repositories.CategoriaRepository;
import br.com.julio.projeto.services.excepctions.ObjectNotFoundException;

@Service
public class CategoriaService {

  
  @Autowired  
  private CategoriaRepository repo;

    public Categoria find(Integer id){

     Optional<Categoria> obj = repo.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));


    }
}
