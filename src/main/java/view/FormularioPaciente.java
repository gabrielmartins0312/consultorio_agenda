package view;

import model.Paciente;
import controller.PacienteController;
import service.ViaCepService;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FormularioPaciente extends JFrame {
    private PacienteController pacienteController;

    public FormularioPaciente(PacienteController pacienteController) {
        setTitle("Adicionar Paciente");
        setSize(400, 300);
        setLocationRelativeTo(null);

        this.pacienteController = pacienteController;

        JTextField txtNome = new JTextField(20);
        JTextField txtEmail = new JTextField(20);
        JTextField txtTelefone = new JTextField(15);
        JTextField txtCEP = new JTextField(8);
        JTextField txtCidade = new JTextField(20);
        JTextField txtRua = new JTextField(20);
        JTextField txtNumero = new JTextField(5);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();
            String cep = txtCEP.getText();
            String cidade = txtCidade.getText();
            String rua = txtRua.getText();
            String numero = txtNumero.getText();

            Paciente paciente = new Paciente(nome, email, telefone);
            paciente.adicionarEndereco(cidade, rua, numero, cep);
            pacienteController.adicionarPaciente(paciente);

            dispose();
        });

        txtCEP.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String cep = txtCEP.getText().trim();
                if (!cep.isEmpty()) {
                    JSONObject enderecoJson = ViaCepService.getEndereco(cep);
                    if (enderecoJson != null) {
                        txtCidade.setText(enderecoJson.getString("localidade"));
                        txtRua.setText(enderecoJson.getString("logradouro"));
                    } else {
                        JOptionPane.showMessageDialog(FormularioPaciente.this, "CEP inválido!");
                    }
                }
            }
        });

        setLayout(new GridLayout(8, 2));
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Telefone:"));
        add(txtTelefone);
        add(new JLabel("CEP:"));
        add(txtCEP);
        add(new JLabel("Cidade:"));
        add(txtCidade);
        add(new JLabel("Rua:"));
        add(txtRua);
        add(new JLabel("Número:"));
        add(txtNumero);
        add(btnSalvar);
    }
}
