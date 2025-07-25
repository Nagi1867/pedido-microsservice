package com.api.pedido_api.model;

import com.api.pedido_api.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Double preco;
    private Integer status;

    public Pedido() {
    }

    public Pedido(UUID id, String nome, Double preco, Status status) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        setStatus(status);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(nome, pedido.nome) && Objects.equals(preco, pedido.preco) && Objects.equals(status, pedido.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, status);
    }
}
