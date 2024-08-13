/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listatarefas.telas;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jacks
 */
public class SeletorPastaArquivo {

    JFileChooser fileChooser;
    File caminhoPadrao;
    FileNameExtensionFilter filter;

    public SeletorPastaArquivo() {
        fileChooser = new JFileChooser();
        caminhoPadrao = new File("D:\\GitHub\\ListaTerafas\\Arquivos");
        fileChooser.setCurrentDirectory(caminhoPadrao);
        filter = new FileNameExtensionFilter("Arquivos XML", "xml");
        fileChooser.setFileFilter(filter);
    }

    public String caminhoArquivo() {

        fileChooser.setDialogTitle("Selecione o local para salvar o arquivo");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();

            if (!arquivoSelecionado.getName().contains(".")) {
                arquivoSelecionado = new File(arquivoSelecionado.getAbsolutePath() + ".xml");
            }

            return arquivoSelecionado.getAbsolutePath();
        }
        return null;
    }

    public String abrirArquivo() {

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            return null;
        }

    }
}
