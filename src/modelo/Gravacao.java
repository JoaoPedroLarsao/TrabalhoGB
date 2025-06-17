package modelo;

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

    }
}
