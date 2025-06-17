package modelo;

public class Gravacao extends Processo {

    public Gravacao(int pid) {
        super(pid);
    }

    @Override
    public String toString() {
        return " Processo: Gravação | PID: " + getPid();
    }

    public void executar() {

    }
}
