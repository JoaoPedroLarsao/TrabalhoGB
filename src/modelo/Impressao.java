package modelo;

public class Impressao extends Processo {

    public Impressao(int pid) {
        super(pid);
    }

    @Override
    public String toString() {
        return " Processo: Impressão | PID: " + getPid();
    }

    public void executar() {
        Main.fila.exibirProcessosFila();
    }
}
