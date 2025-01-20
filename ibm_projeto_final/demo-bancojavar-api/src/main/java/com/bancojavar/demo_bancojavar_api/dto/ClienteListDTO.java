package com.bancojavar.demo_bancojavar_api.dto;

public class ClienteListDTO {

    private Long id;
    private String username;
    private Long telefone;
    private Boolean correntista;
    private Float saldo_cc;
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
        return score_credito;
    }

    public void setScore_credito(Float score_credito) {
        this.score_credito = score_credito;
    }
}
