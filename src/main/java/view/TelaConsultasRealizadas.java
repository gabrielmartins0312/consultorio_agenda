package view;

import model.Consulta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaConsultasRealizadas extends JFrame {
    public TelaConsultasRealizadas(List<Consulta> consultasRealizadas) {
        setTitle("Consultas Realizadas");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panelConsultasRealizadas = new JPanel();
        panelConsultasRealizadas.setLayout(new BoxLayout(panelConsultasRealizadas, BoxLayout.Y_AXIS));

        for (Consulta consulta : consultasRealizadas) {
            JLabel label = new JLabel("Consulta realizada em " + consulta.getDataConsulta() + ". Nome do Paciente: " + consulta.getPaciente().getNome() + ".");
            panelConsultasRealizadas.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(panelConsultasRealizadas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
