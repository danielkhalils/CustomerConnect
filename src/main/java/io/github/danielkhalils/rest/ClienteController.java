package io.github.danielkhalils.rest;

import io.github.danielkhalils.model.entity.Cliente;
import io.github.danielkhalils.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    //método para salvar cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    //buscar cliente por id
    @GetMapping("{id}")
    public Cliente findbyId(@PathVariable Integer id){
        //retorna o id, senão uma mensagem de não encontrado
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
