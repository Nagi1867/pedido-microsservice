package com.api.pedido_api.resource;

import com.api.pedido_api.model.Pedido;
import com.api.pedido_api.services.PedidoService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService service;

    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}/{currency}")
    public ResponseEntity<Pedido> findbyId(@PathVariable("id") UUID id, @PathVariable("currency") String currency) {
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pedido> insert(@RequestBody Pedido obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pedido> update(@PathVariable UUID id, @RequestBody Pedido obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
