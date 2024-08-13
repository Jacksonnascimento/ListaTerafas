/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listatarefas;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jacks
 */
public class GerenciarArquivoXML {

    public void salvarEmXML(GerenciarListaTarefas tarefas, String caminhoArquivo) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(GerenciarListaTarefas.class, Tarefa.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(tarefas, new File(caminhoArquivo));
    }

    public GerenciarListaTarefas lerXML(String caminhoArquivo) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(GerenciarListaTarefas.class, Tarefa.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (GerenciarListaTarefas) unmarshaller.unmarshal(new File(caminhoArquivo));
    }

}
