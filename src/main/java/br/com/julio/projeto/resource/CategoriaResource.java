package br.com.julio.projeto.resource;




import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.julio.projeto.domain.Categoria;
import br.com.julio.projeto.services.CategoriaService;
import ch.qos.logback.core.status.Status;


@RestController
@RequestMapping(value = "/categorias")

public class CategoriaResource {

     
     
     @Autowired(required=true)
     private CategoriaService service;
     
   @GetMapping(value = "/{id}")
  //  @RequestMapping( value = "/{id}", method = RequestMethod.GET) // Tem a mesma funcionalidade do @GetMapping - porém pode implementar os métodos de get. put. post
     public ResponseEntity<?> find(@PathVariable Integer id){
       
      
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
       
    }

    @RequestMapping(method = RequestMethod.POST)   
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
      obj = service.insert(obj);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

      return ResponseEntity.created(uri).build();
       



    }
    
}
