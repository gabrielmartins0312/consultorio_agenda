package view;

import model.Paciente;
import model.Endereco;

import javax.swing.*;
import java.awt.*;

public class TelaDetalhesPaciente extends JFrame {
    public TelaDetalhesPaciente(Paciente paciente) {
        setTitle("Detalhes do Paciente");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea txtDetalhes = new JTextArea();
        txtDetalhes.setEditable(false);
        txtDetalhes.append("Nome: " + paciente.getNome() + "\n");
        txtDetalhes.append("Email: " + paciente.getEmail() + "\n");
        txtDetalhes.append("Telefone: " + paciente.getTelefone() + "\n");
        txtDetalhes.append("Endereços:\n");
        for (Endereco endereco : paciente.getEnderecos()) {
            txtDetalhes.append("  - " + endereco + "\n");
        }

        getContentPane().add(new JScrollPane(txtDetalhes), BorderLayout.CENTER);
    }
}
