import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    private Controle controle = new Controle();
    public void menu() {
        int opcao;
        String aux = "1 - Inserir Empregado\n2 - Pesquisar Empregado\n3 - Listar Empregados\n4 - Fechar";

        while (true) {
            opcao = parseInt(showInputDialog(aux));

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void listar() {
        showMessageDialog(null, controle.listar());
    }

    private void pesquisar() {
        long matricula = parseLong(showInputDialog("Matricula: "));
        Empregado empregado = controle.pesquisar(matricula);
        if (empregado==null) {
            showMessageDialog(null,"Empregado não encontrado");
        } else {
            showMessageDialog(null, empregado);
        }
    }

    public void cadastrar() {
        Empregado empregado;
        long matricula;
        String nome;
        int totalDeHorasTrabalhadas;
        double valorDaHora;
        double totalDeVendas, comissao;

        String aux = "1 - Horista\n2 - Comissionado\n 3 - Sair";
        int opcao;

        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao==3) {
                return;
            }
            if (opcao==1|| opcao ==2) {
                matricula = parseLong(showInputDialog("Matrícula: "));
                nome = showInputDialog("Nome: ");
                if(opcao==1) {
                    valorDaHora = parseDouble(showInputDialog("Valor da hora: "));
                    totalDeHorasTrabalhadas = parseInt(showInputDialog("Total de horas trabalhadas: "));
                    empregado = new EmpregadoHorista(matricula, nome, totalDeHorasTrabalhadas, valorDaHora);
                    controle.inserir(empregado);
                }
                else if (opcao==2) {
                    comissao = parseDouble(showInputDialog("Comissão: "));
                    totalDeVendas = parseDouble(showInputDialog("Total de vendas: "));
                    empregado = new EmpregadoComissionado(matricula, nome, totalDeVendas, comissao);
                    controle.inserir(empregado);
                }
            }
            else {
                showMessageDialog(null,"Opção Invalida");
            }

        }
    }


}
