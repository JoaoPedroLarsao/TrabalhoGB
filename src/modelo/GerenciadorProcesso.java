package modelo;

public class GerenciadorProcesso {
    private Processo[] filaProcessos = new Processo[100];
    private int contadorPid = 1;
    private int quantidadeProcessos = 0;

    public void adicionarProcesso(Processo p) {
        if (quantidadeProcessos < filaProcessos.length) {
            filaProcessos[quantidadeProcessos++] = p;
        } else {
            System.out.println("Fila de processos cheia!");
        }
    }

    public void executarProximoProcesso() {
        if (quantidadeProcessos > 0) {
            filaProcessos[0].executar();
            removerProcesso(0);
        } else {
            System.out.println("Nenhum processo na fila para executar.");
        }
    }

    public void removerProcesso(int index) {
        for (int i = index; i < quantidadeProcessos - 1; i++) {
            filaProcessos[i] = filaProcessos[i + 1];
        }
        filaProcessos[--quantidadeProcessos] = null; // Vai limpar a última posição
    }

    public void executarPorPid(int pid) {
        for (int i = 0; i < quantidadeProcessos; i++) {
            if (filaProcessos[i].getPid() == pid) {
                filaProcessos[i].executar();
                removerProcesso(i);
                return;
            }
        }
        System.out.println("PID não encontrado.");
    }

    public void printFila() {
        for (int i = 0; i < quantidadeProcessos; i++) {
            System.out.println("PID: " + filaProcessos[i].getPid() + " - " + filaProcessos[i].getClass().getSimpleName()); // Exibe o tipo de processo sem o pacote
        }
    }
}
