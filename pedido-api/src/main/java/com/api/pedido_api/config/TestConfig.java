package com.api.pedido_api.config;

import com.api.pedido_api.enums.Status;
import com.api.pedido_api.model.Pedido;
import com.api.pedido_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PedidoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Pedido pedido = new Pedido(null, "Computador", 1990.20, Status.PAGO);
    }
}
