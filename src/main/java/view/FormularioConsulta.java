package view;

import controller.ConsultaController;
import controller.PacienteController;
import model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FormularioConsulta extends JFrame {
    private ConsultaController consultaController;
    private PacienteController pacienteController;
    private TelaPrincipal telaPrincipal;

    public FormularioConsulta(ConsultaController consultaController, PacienteController pacienteController, TelaPrincipal telaPrincipal) {
        setTitle("Adicionar Consulta");
        setSize(400, 300);
        setLocationRelativeTo(null);

        this.consultaController = consultaController;
        this.pacienteController = pacienteController;
        this.telaPrincipal = telaPrincipal;

        JTextField txtNomePaciente = new JTextField(20);
        JTextField txtDataConsulta = new JTextField(10);
        JTextField txtDataSolicitacao = new JTextField(10);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            Paciente paciente = new Paciente(txtNomePaciente.getText(), "", "");
            pacienteController.adicionarPaciente(paciente);
            LocalDate dataConsulta = LocalDate.parse(txtDataConsulta.getText());
            LocalDate dataSolicitacao = LocalDate.parse(txtDataSolicitacao.getText());
            consultaController.adicionarConsulta(paciente, dataConsulta, dataSolicitacao);
            telaPrincipal.atualizarListaConsultas();
            dispose();

        });

        setLayout(new GridLayout(4, 2));
        add(new JLabel("Nome do Paciente:"));
        add(txtNomePaciente);
        add(new JLabel("Data da Consulta (AAAA-MM-DD):"));
        add(txtDataConsulta);
        add(new JLabel("Data de Solicitação (AAAA-MM-DD):"));
        add(txtDataSolicitacao);
        add(btnSalvar);
    }

}
