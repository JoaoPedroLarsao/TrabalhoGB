package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Leitura extends Processo {

    public Leitura(int pid) {
        super(pid);
    }

    @Override
    public String toString() {
        return " Processo: Leitura | PID: " + getPid();
    }

    public void executar() {
        try (BufferedReader br = new BufferedReader(new FileReader("gravacao.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Calculo c = new Calculo(Main.contadorPid, linha);
                Main.fila.adicionarProcesso(c);
                Main.incrementoPid();
            }
            new PrintWriter("gravacao.txt").close(); // limpa o arquivo
            System.out.println("Arquivo lido e processos adicionados à fila.");
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo.");
        }
    }
}
