package com.bancojavar.demo_bancojavar_api.dto;

public class ClienteCreateDTO {

    private String nome;
    private Long telefone;
    private Boolean correntista;
    private float saldo_cc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public float getSaldo_cc() {
        return saldo_cc;
    }

    public void setSaldo_cc(float saldo_cc) {
        this.saldo_cc = saldo_cc;
    }

    public ClienteCreateDTO(String nome, float saldo_cc){
        this.nome = nome;
        this.saldo_cc = saldo_cc;
    }

    public ClienteCreateDTO() {
    }

    public ClienteCreateDTO(String nome, Long telefone, Boolean correntista, float saldo_cc) {
        this.nome = nome;
        this.telefone = telefone;
        this.correntista = correntista;
        this.saldo_cc = saldo_cc;
    }
}
