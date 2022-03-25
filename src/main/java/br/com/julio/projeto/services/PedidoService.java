package br.com.julio.projeto.services;

import java.util.Optional;

//import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.julio.projeto.domain.Pedido;
import br.com.julio.projeto.repositories.PedidoRepository;
import br.com.julio.projeto.services.excepctions.ObjectNotFoundException;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedido;

    public Pedido find (Integer id){

        Optional<Pedido> obj = pedido.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
          "Objeto não encontrado! ID: " + id + ", Tipo: " + Pedido.class.getName()));
    }
    
}
