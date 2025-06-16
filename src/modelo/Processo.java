package modelo;

public abstract class Processo {
    protected int pid;

    public Processo(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public abstract void executar();
}
