/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listatarefas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlRootElement
public class GerenciarListaTarefas {

    private List<Tarefa> listaDeTarefas;

    public GerenciarListaTarefas() {
        this.listaDeTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaDeTarefas.add(tarefa);
    }

    public void removerTarefa(String id) {
        listaDeTarefas.removeIf(tarefa -> tarefa.getId().equals(id));
    }

    public List<Tarefa> listarTarefas() {
        return listaDeTarefas;
    }

    public Tarefa buscarTarefaPorId(String id) {
        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }
        return null;
    }

    public void imprimirTarefas() {
        for (Tarefa tarefa : listaDeTarefas) {
            System.out.println(tarefa);
        }
    }

    @XmlElementWrapper(name = "tarefas")
    @XmlElement(name = "tarefa")
    public List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }

    public void setListaDeTarefas(List<Tarefa> listaDeTarefas) {
        this.listaDeTarefas = listaDeTarefas;
    }
}
