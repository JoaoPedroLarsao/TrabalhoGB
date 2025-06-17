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
            for (int i = 0; i < filaProcessos.length - 1; i++) {
                for (int j = 1; j < filaProcessos.length -1; j++) {
                    if(filaProcessos[j] == null) {
                        break;
                    } else {
                        filaProcessos[i] = filaProcessos[j];
                    }
                }
            }
            System.out.println("Processo excluido com sucesso.");
        }
    }

    public boolean filaVazia() {
        return tamanho == 0;
    }
}
