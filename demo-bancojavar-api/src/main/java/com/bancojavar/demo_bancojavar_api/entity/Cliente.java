package com.bancojavar.demo_bancojavar_api.entity;

import com.bancojavar.demo_bancojavar_api.Enum.Role;
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

    @NotNull
    @Column(name = "username",length = 250)
    private String username;

    @NotNull
    @Column(name = "telefone",length = 250)
    private Long telefone;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "correntista",length = 250)
    private Role correntista;

    @NotNull
    @Column(name = "score_credito",length = 250)
    private Float score_credito;

    @Column(name = "saldo_cc",length = 250)
    private Float saldo_cc;

    public Float getSaldo_cc() {
        return saldo_cc;
    }

    public void setSaldo_cc(Float saldo_cc) {
        this.saldo_cc = saldo_cc;
    }

    public Float getScore_credito() {
        return saldo_cc* 0.1f;
    }

    public void setScore_credito(Float saldo_cc) {
        this.score_credito = saldo_cc* 0.1f;
    }

    public Role getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Role correntista) {
        this.correntista = correntista;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}