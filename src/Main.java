public class Main {
    public static void main(String[] args) {

        Empregado[] empregado = new Empregado[3];
        empregado[0] = new EmpregadoComissionado(1, "Pedro", 130, 950);
        empregado[1] = new EmpregadoHorista(2, "João", 200, 11);
        empregado[2] = new EmpregadoHorista(3, "Lucas", 205, 8);

        for(Empregado e : empregado) {
            System.out.println(e);
            System.out.println(e.calcularSalario());
            System.out.println();
        }

    }
}
