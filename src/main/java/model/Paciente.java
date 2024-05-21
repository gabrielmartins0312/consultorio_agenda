package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String telefone;
    private List<Endereco> enderecos;

    public Paciente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void adicionarEndereco(String cidade, String rua, String numero, String cep) {
        Endereco endereco = new Endereco(cidade, rua, numero, cep);
        enderecos.add(endereco);
    }

    @Override
    public String toString() {
        return nome;
    }
}
