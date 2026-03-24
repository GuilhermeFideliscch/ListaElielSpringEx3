package com.example.Pedido.services;

import com.example.Pedido.models.PedidoModel;
import com.example.Pedido.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criarPedido(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> findById(Long id){
        return pedidoRepository.findById(id);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

}
