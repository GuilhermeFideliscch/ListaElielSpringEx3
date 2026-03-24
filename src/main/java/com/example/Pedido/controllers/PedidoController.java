package com.example.Pedido.controllers;

import com.example.Pedido.models.PedidoModel;
import com.example.Pedido.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoServices;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> pedidoModels = pedidoServices.findAll();
        return ResponseEntity.ok().body(pedidoModels);
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel novoPedido = pedidoServices.criarPedido(pedidoModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoPedido.getId()).toUri();

        return ResponseEntity.created(uri).body(novoPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidoModel>> buscarPorId(@PathVariable Long id){
        Optional<PedidoModel> pedidoModelOptional = pedidoServices.findById(id);

        return ResponseEntity.ok().body(pedidoModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        pedidoServices.deletarPedido(id);

        return ResponseEntity.noContent().build();
    }

}