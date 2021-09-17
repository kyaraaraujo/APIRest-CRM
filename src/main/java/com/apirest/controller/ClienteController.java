package com.apirest.controller;

import com.apirest.model.Cliente;
import com.apirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Cliente enccontrarClientePeloIdOuRetornarErro(@PathVariable Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // ao invés do OK 200, retornará 201
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public void removerCliente(@PathVariable Long id){
        clienteRepository.delete(enccontrarClientePeloIdOuRetornarErro(id));
    }

    @PutMapping
    public void atualizarCliente(@RequestBody Cliente cliente){
        Cliente clienteAlterado = enccontrarClientePeloIdOuRetornarErro(cliente.getId());

        clienteAlterado.setId(cliente.getId());
        clienteAlterado.setNome(cliente.getNome());

        clienteRepository.save(clienteAlterado);

    }
}
