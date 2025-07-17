package com.corp.LunarCorp.entity;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Chamado chamado;

    @ManyToOne
    private UsuarioTecnico usuarioTecnico;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFinal;

    @Transient
    private Duration tempoTotal;

    private String historicoAtendimento;

    public Duration getTempoTotal() {
        if (dataInicio != null && dataFinal != null) {
            return Duration.between(dataInicio, dataFinal);
        }
        return Duration.ZERO;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHistoricoAtendimento() {
        return historicoAtendimento;
    }

    public void setHistoricoAtendimento(String historicoAtendimento) {
        this.historicoAtendimento = historicoAtendimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTempoTotal(Duration tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public UsuarioTecnico getUsuarioTecnico() {
        return usuarioTecnico;
    }

    public void setUsuarioTecnico(UsuarioTecnico usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "chamado=" + chamado +
                ", id=" + id +
                ", usuarioTecnico=" + usuarioTecnico +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", tempoTotal=" + tempoTotal +
                ", historicoAtendimento='" + historicoAtendimento + '\'' +
                '}';
    }

    public void setIdUsuarioTecnico(UsuarioTecnico usuarioTecnico) {
    }
}
