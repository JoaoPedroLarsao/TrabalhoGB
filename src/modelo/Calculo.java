package modelo;

public class Calculo extends Processo {
    private String expressao;

    public Calculo(int pid, String expressao) { //expressao vem do Main
        super(pid);
        this.expressao = expressao;
    }

    public void executar() {
        System.out.println("Executando a operação: " + expressao + " = " + calcular());
    }

    public double calcular() {
        String[] partes = expressao.trim().split(" ");
        double num1 = Double.parseDouble(partes[0]);
        char operador = partes[1].charAt(0);
        double num2 = Double.parseDouble(partes[2]);

        return switch (operador) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalStateException("Unexpected value: " + operador); // IDE adicionou para caso o operador não seja encontrado
        };
    }
}
