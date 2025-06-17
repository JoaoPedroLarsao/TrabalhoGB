package modelo;

public abstract class Processo {
    protected int pid;

    public Processo(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    @Override
    public abstract String toString();

    public abstract void executar();
}
