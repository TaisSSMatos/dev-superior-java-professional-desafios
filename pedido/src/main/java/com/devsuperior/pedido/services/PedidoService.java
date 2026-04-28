package com.devsuperior.pedido.services;

import com.devsuperior.pedido.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private FreteService freteService;

    public double totalPedido(Pedido pedido) {
        return this.valorComDesconto(pedido.getValorBasico(), pedido.getPorcentagemDesconto())
                + freteService.frete(pedido.getValorBasico());
    }

    private double valorComDesconto( double valor, double porcentagemDesconto) {
        double valorDesconto = (valor * porcentagemDesconto) / 100;
        return valor - valorDesconto;
    }
}
