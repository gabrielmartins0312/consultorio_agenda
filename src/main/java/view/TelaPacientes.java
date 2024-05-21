package view;

import model.Paciente;
import controller.PacienteController;

import javax.swing.*;
import java.awt.*;

public class TelaPacientes extends JFrame {
    private PacienteController pacienteController;

    public TelaPacientes(PacienteController pacienteController) {
        setTitle("Listar Pacientes");
        setSize(600, 400);
        setLocationRelativeTo(null);

        this.pacienteController = pacienteController;

        DefaultListModel<Paciente> pacientesModel = pacienteController.getPacientesModel();
        JList<Paciente> pacientesList = new JList<>(pacientesModel);
        pacientesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton btnAdicionarPaciente = new JButton("Adicionar Paciente");
        btnAdicionarPaciente.addActionListener(e -> new FormularioPaciente(pacienteController).setVisible(true));

        pacientesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Paciente pacienteSelecionado = pacientesList.getSelectedValue();
                if (pacienteSelecionado != null) {
                    new TelaDetalhesPaciente(pacienteSelecionado).setVisible(true);
                }
            }
        });

        getContentPane().add(new JScrollPane(pacientesList), BorderLayout.CENTER);
        getContentPane().add(btnAdicionarPaciente, BorderLayout.SOUTH);
    }
}
