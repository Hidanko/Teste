package writer;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class Escritor {

    private static final Escritor INSTANCE = new Escritor();
    private File arquivo;
    private int versaoArquivo;

    private Escritor() {

    }

    public static Escritor getInstance() {
        return INSTANCE;
    }

    public void adicionarCadastro(String nome, int idade) throws Exception {
        arquivo = new File("cadastros" + versaoArquivo + ".txt");

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(nome + " \t" + idade);

        pw.close();

    }

    public void abrirArquivoTexto() {
        versaoArquivo++;
        try {
            Desktop.getDesktop().open(arquivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
