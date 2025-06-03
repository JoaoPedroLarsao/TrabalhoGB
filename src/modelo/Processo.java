package modelo;

public abstract class Processo {

    protected int pid;

    public Processo(int pid) {
        this.pid = pid;
    }

    public abstract void executar();
}
