package com.devsuperior.pedido;

import com.devsuperior.pedido.entities.Pedido;
import com.devsuperior.pedido.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.devsuperior")
public class PedidoApplication implements CommandLineRunner {

	@Autowired
	private PedidoService pedidoService;

	public static void main(String[] args) {

		SpringApplication.run(PedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pedido pedido1 = new Pedido(1034, 150.0, 20.0);
		System.out.println("Pedido código " + pedido1.getCodigo());
		System.out.println("Valor Total: R$ " + pedidoService.totalPedido(pedido1));

		Pedido pedido2 = new Pedido(2282, 800.0, 10.0);
		System.out.println("Pedido código " + pedido2.getCodigo());
		System.out.println("Valor Total: R$ " + pedidoService.totalPedido(pedido2));

		Pedido pedido3 = new Pedido(1309, 95.9, 0.0);
		System.out.println("Pedido código " + pedido3.getCodigo());
		System.out.println("Valor Total: R$ " + pedidoService.totalPedido(pedido3));

	}
}
