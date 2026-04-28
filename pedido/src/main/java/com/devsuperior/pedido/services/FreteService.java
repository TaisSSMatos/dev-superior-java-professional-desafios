package com.devsuperior.pedido.services;

import org.springframework.stereotype.Service;

@Service
public class FreteService {

    public double frete(double valor) {
        if (valor < 100.0) {
            return 20.0;
        } else if (valor >= 100.0 && valor < 200.0) {
            return 12.0;
        }
        else {
            return 0.0;
        }
    }
}
