import modelo.Calculo;

import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static int contadorPid = 0;

    public static void main(String[] args) {
        exibirMenuPrincipal();
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
                    System.out.println("Escolha 2");

                    menuPrincipalEmUso = false;
                    break;

                case 3:
                    System.out.println("Escolha 3");

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
                    System.out.println("Escolha 1");

                    menuCriacaoProcessoEmUso = false;
                    break;

                case 2:
                    System.out.println("Escolha 2");

                    menuCriacaoProcessoEmUso = false;
                    break;

                case 3:
                    System.out.println("Escolha 3");

                    menuCriacaoProcessoEmUso = false;
                    break;

                case 4:
                    System.out.println("Escolha 4");
                    System.out.println("Digite o calculo que desejas fazer (ex: 5 + 3): ");
                    String expressao = entrada.nextLine();

                    Calculo calculo = new Calculo(contadorPid, expressao);

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

