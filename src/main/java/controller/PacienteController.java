package controller;

import model.Paciente;
import model.Endereco;
import javax.swing.DefaultListModel;

public class PacienteController {
    private DefaultListModel<Paciente> pacientesModel;

    public PacienteController(DefaultListModel<Paciente> pacientesModel) {
        this.pacientesModel = pacientesModel;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientesModel.addElement(paciente);
    }

    public void adicionarEnderecoAoPaciente(Paciente paciente, Endereco endereco) {
        paciente.adicionarEndereco(endereco.getCidade(), endereco.getRua(), endereco.getNumero(), endereco.getCep());
    }
    
    public DefaultListModel<Paciente> getPacientesModel() {
        return pacientesModel;
    }
}
