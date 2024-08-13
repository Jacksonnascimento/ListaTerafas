/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listatarefas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tarefa {

    private String id;
    private String descricao;
    private String dataCriacao;
    private String dataConclusao;
    private String status;
    private String prioridade;
    private String categoria;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tarefa() {
    }

    public Tarefa(String descricao, String status, String prioridade, String categoria) {
        this.id = UUID.randomUUID().toString(); // Gera um ID único
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now().format(FORMATTER);
        this.status = status;
        this.prioridade = prioridade;
        this.categoria = categoria;
        atualizarDataConclusao();
    }

    public void AlterarTarefa(String descricao, String status, String prioridade, String categoria) {
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.categoria = categoria;
        atualizarDataConclusao();
    }

    public void atualizarDataConclusao() {

        if ("Concluído".equals(status) && this.dataConclusao == null) {
            this.dataConclusao = LocalDateTime.now().format(FORMATTER);
        } else if ("Pendente".equals(status)) {
            this.dataConclusao = null;
        }

    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlElement
    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @XmlElement
    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @XmlElement
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement
    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @XmlElement
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Tarefa{"
                + "id='" + id + '\''
                + ", descricao='" + descricao + '\''
                + ", dataCriacao='" + dataCriacao + '\''
                + ", dataConclusao='" + dataConclusao + '\''
                + ", status='" + status + '\''
                + ", prioridade='" + prioridade + '\''
                + ", categoria='" + categoria + '\''
                + '}';
    }
}
