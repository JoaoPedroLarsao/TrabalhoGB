package modelo;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static int contadorPid = 1;
    public static Fila fila = new Fila();


    public static void main(String[] args) {
        exibirMenuPrincipal();

        /*Testes
        Calculo p1 = new Calculo(1, "1 + 1");
        Gravacao p2 = new Gravacao(2, "2 + 2");
        Leitura p3 = new Leitura(3);
        Impressao p4 = new Impressao(4);

        fila.adicionarProcesso(p1);
        fila.adicionarProcesso(p2);
        fila.adicionarProcesso(p3);
        fila.adicionarProcesso(p4);

        fila.exibirProcessosFila();

        fila.excluirProcesso();
        fila.excluirProcesso(fila.buscarPosicaoProcessoViaPid(5));

        fila.exibirProcessosFila();
                                    */
    }

    private static void exibirMenuPrincipal() {

        boolean menuPrincipalEmUso = true;

        while(true) {

            System.out.println("-------------------------------------");
            System.out.println("Menu principal");
            System.out.println("-------------------------------------");
            System.out.println("1- Criar processo");
            System.out.println("2- Executar próximo");
            System.out.println("3- Executar processo específico");
            System.out.println("4- Salvar a fila de processos");
            System.out.println("5- Carregar fila de processo");
            System.out.println("6- Sair");
            System.out.println("-------------------------------------");

            String escolhaMenuPrincipal = entrada.nextLine();

            if (!escolhaMenuPrincipal.matches("\\d+")) {
                System.out.println("A escolha deve ser um valor númerico!");
                continue;
            }

            int opcaoEscolhidaMenuPrincipal = Integer.parseInt(escolhaMenuPrincipal);

            switch (opcaoEscolhidaMenuPrincipal) {
                case 1:
                    exibirMenuCriacaoProcesso();
                    break;
                case 2:
                    fila.primeiroProcesso().executar();
                    fila.excluirProcesso();

                    break;

                case 3:
                    System.out.println("Digite o PID do processo que deseja executar: ");
                    int pid = entrada.nextInt();
                    entrada.nextLine();

                    fila.buscarProcessoViaPid(pid).executar();
                    fila.excluirProcesso(fila.buscarPosicaoProcessoViaPid(pid));

                    break;

                case 4:
                    salvarFila();
                    break;

                case 5:
                   carregarFila();

                    break;

                case 6:
                    System.out.println("Encerrando sistema!");
                    entrada.close();
                    System.exit(0);

                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }
    }

    private static void exibirMenuCriacaoProcesso() {

        boolean menuCriacaoProcessoEmUso = true;

        while(menuCriacaoProcessoEmUso) {
            System.out.println("-------------------------------------");
            System.out.println("Menu criação de novo processo");
            System.out.println("-------------------------------------");
            System.out.println("1- Criar processo de gravação");
            System.out.println("2- Criar processo de leitura");
            System.out.println("3- Criar processo de impressão");
            System.out.println("4- Criar processo de cálculo");
            System.out.println("-------------------------------------");

            String escolhaMenuCriacaoProcesso = entrada.nextLine();

            if (!escolhaMenuCriacaoProcesso.matches("\\d+")) {
                System.out.println("A escolha deve ser um valor númerico!");
                continue;
            }

            int opcaoEscolhidaMenuCriacaoProcesso = Integer.parseInt(escolhaMenuCriacaoProcesso);

            switch (opcaoEscolhidaMenuCriacaoProcesso) {
                case 1:
                    System.out.println("Digite a expressão que deseja gravar (Ex: 5 + 3): ");
                    String expressaoGravacao = entrada.nextLine();

                    Gravacao gravacao = new Gravacao(contadorPid, expressaoGravacao);

                    fila.adicionarProcesso(gravacao);
                    incrementoPid();

                    menuCriacaoProcessoEmUso = false;
                    break;

                case 2:
                    Leitura leitura = new Leitura(contadorPid);
                    fila.adicionarProcesso(leitura);
                    incrementoPid();
                    menuCriacaoProcessoEmUso = false;
                    break;

                case 3:
                    Impressao impressao = new Impressao(contadorPid);
                    fila.adicionarProcesso(impressao);
                    incrementoPid();
                    menuCriacaoProcessoEmUso = false;
                    break;

                case 4:
                    System.out.println("Digite o calculo que deseja criar (Ex: 5 + 3): ");
                    String expressaoCalculo = entrada.nextLine();

                    Calculo calculo = new Calculo(contadorPid, expressaoCalculo);

                    fila.adicionarProcesso(calculo);
                    incrementoPid();
                    menuCriacaoProcessoEmUso = false;
                    break;

                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }
    }

    public static void carregarFila() {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("fila/processos.txt"));
            String linha;
            while((linha = leitor.readLine()) != null) {
                String[] partes = linha.split("/");
                String tipoProcesso = partes[0];
                int pid = Integer.parseInt(partes[1]);

                switch (tipoProcesso) {
                    case "Calculo":
                        String expressaoCalculo = partes[2];
                        fila.adicionarProcesso(new Calculo(pid, expressaoCalculo));
                        break;

                    case "Gravacao":
                        String expressaoGravacao = partes[2];
                        fila.adicionarProcesso(new Gravacao(pid, expressaoGravacao));
                        break;

                    case "Impressao":
                        fila.adicionarProcesso(new Impressao(pid));
                        break;

                    case "Leitura":
                        fila.adicionarProcesso(new Leitura(pid));
                        break;
                }

            }
            System.out.println("Fila carregada com sucesso.");
            leitor.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void salvarFila() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("fila/processos.txt"));
            for (int i = 0; i < fila.getTamanho(); i++) {
                Processo processo = fila.getProcesso(i);

                if(processo instanceof Calculo) {
                    escritor.write("Calculo/" + processo.getPid() + "/" + ((Calculo) processo).getExpressao() + "\n");
                } else if(processo instanceof Gravacao) {
                    escritor.write("Gravacao/" + processo.getPid() + "/" + ((Gravacao) processo).getExpressao()  + "\n");
                } else if(processo instanceof Leitura) {
                    escritor.write("Leitura/" + processo.getPid() + "\n");
                } else if(processo instanceof Impressao) {
                    escritor.write("Impressao/" + processo.getPid() + "\n");
                }
            }
            escritor.close();
            System.out.println("Fila salva com sucesso.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void incrementoPid() {
        contadorPid++;
    }
}

