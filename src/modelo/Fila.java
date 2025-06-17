package modelo;

public class Fila {

    private Processo[] filaProcessos = new Processo[100];
    private int inicio = 0;
    private int fim = -1;
    private int tamanho = 0;

    public void adicionarProcesso(Processo processo) {
        if(tamanho == filaProcessos.length) {
            System.out.println("Fila cheia. Não foi possível adicionar processo.");
        } else {
            if(fim == filaProcessos.length - 1) {
                System.out.println("Fila cheia. Execute algum processo para abrir espaço na fila.");
                fim = -1;
            }
            fim++;
            filaProcessos[fim] = processo;
            tamanho++;
        }
    }

    public void excluirProcesso() {
        if(filaVazia()) {
            System.out.println("Fila vazia. Não há processo a ser excluído.");
        } else {
            filaProcessos[inicio] = null;
            for (int i = 0; i < tamanho; i++) {
                inicio++;
                filaProcessos[i] = filaProcessos[inicio];
            }
            inicio = 0;
            System.out.println("Processo excluido com sucesso.");
        }
    }

    public boolean filaVazia() {
        return tamanho == 0;
    }

    public void exibirProcessosFila() {
        int i = 1;
        for (Processo processo : filaProcessos) {

            if(processo == null) {
                break;
            } else {
                System.out.println(i + "-" + processo);
                i++;
            }
        }
    }
}
