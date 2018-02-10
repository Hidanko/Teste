/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public final class Escritor {

    private static final Escritor INSTANCE = new Escritor();
    private File arquivo = new File("cadastros.txt");

    private Escritor() {

    }

    public static Escritor getInstance() {
        return INSTANCE;
    }

    public void adicionarCadastro(String nome, int idade) throws Exception {
        PrintWriter writer = new PrintWriter(arquivo, "UTF-8");

        writer.write(nome + " \t" + idade);

        writer.close();

    }

    public void abrirArquivoTexto() {
        try {
            Desktop.getDesktop().open(arquivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
