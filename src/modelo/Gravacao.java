package modelo;

import java.io.FileWriter;
import java.io.IOException;

public class Gravacao extends Processo {
    private String expressao;

    public Gravacao(int pid, String expressao) {
        super(pid);
        this.expressao = expressao;
    }

    @Override
    public String toString() {
        return " Processo: Gravação | PID: " + getPid();
    }

    public String getExpressao() {
        return expressao;
    }

    public void executar() {
        try (FileWriter gravar = new FileWriter("fila/gravacao.txt", true)) {
            gravar.write(expressao + "\n");
            System.out.println("Expressão gravada no arquivo: " + expressao);
        } catch (IOException e) {
            System.out.println("Erro na gravação do arquivo.");
        }
    }
}