package model;

import java.io.Serializable;

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cidade;
    private String rua;
    private String numero;
    private String cep;

    public Endereco(String cidade, String rua, String numero, String cep) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    // Getters e Setters
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + cidade + " (" + cep + ")";
    }
}
