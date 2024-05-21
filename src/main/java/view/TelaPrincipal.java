package view;

import model.Consulta;
import controller.ConsultaController;
import controller.PacienteController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private DefaultListModel<Consulta> consultasModel;
    private ConsultaController consultaController;
    private PacienteController pacienteController;
    private List<Consulta> consultasRealizadas;
    private JPanel panelConsultas;

    public TelaPrincipal() {
        setTitle("Agenda de Consultas Médicas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        consultasModel = new DefaultListModel<>();
        consultasRealizadas = new ArrayList<>();
        consultaController = new ConsultaController(consultasModel);
        pacienteController = new PacienteController(new DefaultListModel<>());

        panelConsultas = new JPanel();
        panelConsultas.setLayout(new BoxLayout(panelConsultas, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelConsultas);

        JButton btnAdicionarConsulta = new JButton("Adicionar Consulta");
        btnAdicionarConsulta.addActionListener(e -> {
            new FormularioConsulta(consultaController, pacienteController, this).setVisible(true);
        });

        JButton btnConsultasRealizadas = new JButton("Consultas Realizadas");
        btnConsultasRealizadas.addActionListener(e -> new TelaConsultasRealizadas(consultasRealizadas).setVisible(true));

        JButton btnListarPacientes = new JButton("Listar Pacientes");
        btnListarPacientes.addActionListener(e -> new TelaPacientes(pacienteController).setVisible(true));

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnAdicionarConsulta);
        panelBotoes.add(btnConsultasRealizadas);
        panelBotoes.add(btnListarPacientes);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBotoes, BorderLayout.SOUTH);

        atualizarListaConsultas();
    }

    private JPanel criarPanelConsulta(Consulta consulta) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel( "Consulta agendada no dia " + consulta.getDataConsulta() + " no nome de " + consulta.getPaciente().getNome() + ".");

        JButton btnRealizada = new JButton("Realizada");
        btnRealizada.setEnabled(!consulta.isRealizada() && !consulta.isCancelada());
        btnRealizada.addActionListener(e -> {
            consulta.setRealizada(true);
            consulta.setCancelada(false);
            consultasRealizadas.add(consulta);
            consultasModel.removeElement(consulta);
            atualizarListaConsultas();
        });

        JButton btnCancelada = new JButton("Cancelada");
        btnCancelada.setEnabled(!consulta.isCancelada() && !consulta.isRealizada());
        btnCancelada.addActionListener(e -> {
            consulta.setCancelada(true);
            consulta.setRealizada(false);
            consultasModel.removeElement(consulta);
            atualizarListaConsultas();
        });

        panel.add(label);
        panel.add(btnRealizada);
        panel.add(btnCancelada);
        return panel;
    }

    public void atualizarListaConsultas() {
        panelConsultas.removeAll();
        for (int i = 0; i < consultasModel.size(); i++) {
            Consulta consulta = consultasModel.getElementAt(i);
            JPanel panelConsulta = criarPanelConsulta(consulta);
            panelConsultas.add(panelConsulta);
        }
        panelConsultas.revalidate();
        panelConsultas.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
