package br.com.julio.projeto.resource;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.julio.projeto.domain.Pedido;
import br.com.julio.projeto.services.PedidoService;


@RestController
@RequestMapping(value = "/pedidos")

public class PedidoResource {

     
     
     @Autowired(required=true)
     private PedidoService service;
     
   @GetMapping(value = "/{id}")
  //  @RequestMapping( value = "/{id}", method = RequestMethod.GET) // Tem a mesma funcionalidade do @GetMapping - porém pode implementar os métodos de get. put. post
     public ResponseEntity<?> find(@PathVariable Integer id){
       
      
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
       
    }
    
}
