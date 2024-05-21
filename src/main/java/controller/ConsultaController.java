package controller;

import model.Consulta;
import model.Paciente;
import javax.swing.DefaultListModel;
import java.time.LocalDate;

public class ConsultaController {
    private DefaultListModel<Consulta> consultasModel;

    public ConsultaController(DefaultListModel<Consulta> consultasModel) {
        this.consultasModel = consultasModel;
    }

    public void adicionarConsulta(Paciente paciente, LocalDate dataConsulta, LocalDate dataSolicitacao) {
        Consulta consulta = new Consulta(paciente, dataConsulta, dataSolicitacao);
        consultasModel.addElement(consulta);
    }

    public void marcarConsultaComoRealizada(Consulta consulta) {
        consulta.setRealizada(true);
    }

    public DefaultListModel<Consulta> getConsultasModel() {
        return consultasModel;
    }
}
