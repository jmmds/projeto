package br.com.julio.projeto.services;

import java.util.Optional;

//import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.julio.projeto.domain.Cliente;
import br.com.julio.projeto.repositories.ClienteRepository;
import br.com.julio.projeto.services.excepctions.ObjectNotFoundException;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository cliente;

    public Cliente find (Integer id){

        Optional<Cliente> obj = cliente.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
          "Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
    }
    
}
