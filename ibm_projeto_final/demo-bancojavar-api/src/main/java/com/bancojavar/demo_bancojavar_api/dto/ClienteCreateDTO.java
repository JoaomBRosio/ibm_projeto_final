package com.bancojavar.demo_bancojavar_api.dto;

public class ClienteCreateDTO {
    private String username;
    private Long telefone;
    private Boolean correntista;
    private Float saldo_cc;

    // Getters and setters...
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
}
