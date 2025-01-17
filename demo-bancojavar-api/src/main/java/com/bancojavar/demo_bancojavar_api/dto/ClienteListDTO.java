package com.bancojavar.demo_bancojavar_api.dto;


public class ClienteListDTO {

    private Long id;
    private String nome;
    private Long telefone;
    private Boolean correntista;
    private float score_credito;
    private float saldo_cc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public float getScore_credito() {
        return score_credito;
    }

    public void setScore_credito(float score_credito) {
        this.score_credito = score_credito;
    }

    public float getSaldo_cc() {
        return saldo_cc;
    }

    public void setSaldo_cc(float saldo_cc) {
        this.saldo_cc = saldo_cc;
    }

    public ClienteListDTO() {
    }

    public ClienteListDTO(Long id, String nome, Long telefone, Boolean correntista, float score_credito, float saldo_cc) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.correntista = correntista;
        this.score_credito = score_credito;
        this.saldo_cc = saldo_cc;
    }

    public ClienteListDTO(long id, String nome, float saldo_cc) {
        this.id = id;
        this.nome = nome;
        this.saldo_cc = saldo_cc;
    }
}
