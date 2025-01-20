package com.bancojavar.demo_bancojavar_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Username não pode ser nulo")
    @Column(name = "username", length = 250)
    private String username;

    @NotNull(message = "Telefone não pode ser nulo")
    @Column(name = "telefone", length = 250)
    private Long telefone;

    @NotNull(message = "Correntista não pode ser nulo")
    @Column(name = "correntista")
    private Boolean correntista;

    @Column(name = "saldo_cc", length = 250)
    private Float saldo_cc;

    @Column(name = "score_credito", length = 250)
    private Float score_credito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Boolean getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Boolean correntista) {
        this.correntista = correntista;
    }

    public Float getSaldo_cc() {
        return saldo_cc;
    }

    public void setSaldo_cc(Float saldo_cc) {
        this.saldo_cc = saldo_cc;
    }

    public Float getScore_credito() {
        return saldo_cc * 0.1f;
    }

    public void setScore_credito(Float score_credito) {
        this.score_credito = score_credito;
    }
}
