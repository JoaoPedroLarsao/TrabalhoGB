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
            tamanho--;
            System.out.println("Processo excluido com sucesso.");
        }
    }

    public void excluirProcesso(int posicaoProcesso) {
            if (posicaoProcesso == 100) {
                return;
            }

            filaProcessos[posicaoProcesso] = null;
            inicio = posicaoProcesso;
            for (int i = posicaoProcesso; i < tamanho; i++) {
                inicio++;
                filaProcessos[i] = filaProcessos[inicio];
            }
            inicio = 0;
            tamanho--;
            System.out.println("Processo excluido com sucesso.");
    }

    public int buscarPosicaoProcessoViaPid(int pid) {
        int posicaoProcesso = -1;
        for (int i = 0; i < tamanho; i++) {
            if (filaProcessos[i].getPid() == pid) {
                posicaoProcesso = i;
                break;
            }
        }

        if(posicaoProcesso == -1) {
            System.out.println("Pid não encontrado. Insira um Pid válido.");
            posicaoProcesso = 100;
        }

        return posicaoProcesso;
    }

    public Processo buscarProcessoViaPid(int pid) {
        Processo processo = null;
        for (int i = 0; i < tamanho; i++) {
            if (filaProcessos[i].getPid() == pid) {
                processo = filaProcessos[i];
                break;
            }
        }

        if(processo == null) {
            System.out.println("Processo não encontrado. Insira um Pid válido.");
        }

        return processo;
    }

    public Processo primeiroProcesso() {
        return filaProcessos[0];
    }

    public int getTamanho() {
        return tamanho;
    }

    public Processo getProcesso(int posicao) {
        return filaProcessos[posicao];
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

    public boolean filaVazia() {
        return tamanho == 0;
    }
}
