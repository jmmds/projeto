package br.com.julio.projeto.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.julio.projeto.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

     //@RequestMapping(method = RequestMethod.GET)    
    @GetMapping
     public List<Categoria> lista(){
        
        Categoria cat1 = new Categoria(1, "informatica");
        Categoria cat2 = new Categoria(2,"Escritorio");

        
        List <Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
    
}
