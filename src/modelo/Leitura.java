package modelo;

public class Leitura extends Processo {

    public Leitura(int pid) {
        super(pid);
    }

    @Override
    public String toString() {
        return " Processo: Leitura | PID: " + getPid();
    }

    public void executar() {

    }
}
