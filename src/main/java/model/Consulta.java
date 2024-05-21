package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    private Paciente paciente;
    private LocalDate dataConsulta;
    private LocalDate dataSolicitacao;
    private boolean realizada;
    private boolean cancelada;

    public Consulta(Paciente paciente, LocalDate dataConsulta, LocalDate dataSolicitacao) {
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.dataSolicitacao = dataSolicitacao;
        this.realizada = false;
        this.cancelada = false;
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    @Override
    public String toString() {
        return "Consulta com " + paciente.getNome() + " em " + dataConsulta + " (Solicitada em " + dataSolicitacao + ")";
    }
}
