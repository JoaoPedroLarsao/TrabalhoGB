package modelo;

import java.util.Scanner;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static int contadorPid = 0;
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

        while(menuPrincipalEmUso) {

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
                    menuPrincipalEmUso = false;

                    exibirMenuCriacaoProcesso();
                    break;
                case 2:
                    fila.primeiroProcesso().executar();
                    fila.excluirProcesso();
                    menuPrincipalEmUso = false;
                    break;

                case 3:
                    System.out.println("Digite o PID do processo que deseja executar: ");
                    int pid = entrada.nextInt();

                    fila.buscarProcessoViaPid(pid).executar();
                    fila.excluirProcesso(fila.buscarPosicaoProcessoViaPid(pid));

                    menuPrincipalEmUso = false;
                    break;

                case 4:
                    System.out.println("Escolha 4");

                    menuPrincipalEmUso = false;
                    break;

                case 5:
                    System.out.println("Escolha 5");

                    menuPrincipalEmUso = false;
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
    public static void incrementoPid() {
        contadorPid++;
    }
}

