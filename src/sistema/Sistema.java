package sistema;

import classes.Desenvolvedor;
import classes.Estagiario;
import classes.Funcionario;
import classes.Gerente;

public class Sistema {
    private static void exibirMenu() {

        System.out.println("\nFUNCIONARIO SYSTEM");
        System.out.println("1) Cadastrar Gerente");
        System.out.println("2) Cadastrar Desenvolvedor");
        System.out.println("3) Cadastrar Estagiario");
        System.out.println("4) Procurar Funcionario");
        System.out.println("5) Listar Todos");
        System.out.println("6) Excluir um Funcionario");
        System.out.println("7) Excluir todos os Funcionarios");
        System.out.println("0) Sair");
        System.out.print("Informe uma opcao: ");

    }
     private static void cadastrarGerente() {

        System.out.println("\nNovo Gerente:");
        
        System.out.print("Nome: ");
        String nome = Console.lerString();

        System.out.print("Matricula: ");
        int matricula = Console.lerInt();

        System.out.println("Horas trabalhadas: ");
        int horasdeTrabalho = Console.lerInt();

        System.out.print("Bonus Anual:");
        float bonusAnual = Console.lerFloat();

        System.out.print("Nome da equipe:");
        String equipe = Console.lerString();

        Gerente g = new Gerente(nome, matricula, horasdeTrabalho, bonusAnual, equipe);

        System.out.println(g.toString());
        System.out.println("\nSalario com o bonus: " + g.calcularSalario()  + " Reais");
       
        Cadastro.cadastrar(g);

        System.out.println("\nGerente cadastrado com sucesso!");

    }

    private static void cadastrarDesenvolvedor() {

        System.out.println("\nNovo Desenvolvedor:");
        System.out.print("Matricula: ");
        int matricula = Console.lerInt();

        System.out.print("Nome: ");
        String nome = Console.lerString();

        System.out.println("Horas trabalhadas: ");
        int horasdeTrabalho = Console.lerInt();

        System.out.print("Tecnologia que domina:");
        String tecnologia = Console.lerString();

        Desenvolvedor d = new Desenvolvedor(nome, matricula, horasdeTrabalho, tecnologia);
 
        System.out.println(d.toString());
        System.out.println("Salario: " + d.calcularSalario() + " Reais");
        Cadastro.cadastrar(d);

        System.out.println("\nDesenvolvedor cadastrado com sucesso!");

    }

    private static void cadastrarEstagiario() {

        System.out.println("\nNovo Estagiario:");
        System.out.print("Matricula: ");
        int matricula = Console.lerInt();

        System.out.print("Nome: ");
        String nome = Console.lerString();

        System.out.print("Horas de trabalho:");
        int horasdeTrabalho = Console.lerInt();

        System.out.println("Supervisor: ");
        String supervisor = Console.lerString();

        Estagiario e = new Estagiario(nome, matricula, horasdeTrabalho, supervisor);

        
        Cadastro.cadastrar(e);
        
        System.out.println(e.toString());
        System.out.println("Salario : " + e.calcularSalario() + "Reais");
        System.out.println("\nEstagiario cadastrado com sucesso!");

    }

     private static void procurarFuncionario() {

        System.out.println("\nProcurar Funciomario:");

        System.out.print("Matricula: ");
        int matricula = Console.lerInt();

       
        Funcionario f = Cadastro.buscar(matricula);

        if (f != null) {

            System.out.println("\nFuncionário Localizado:");
            System.out.println(f.toString());
            System.out.println(f.toString());
            System.out.println("Salario : " + f.calcularSalario() + "Reais");
            return;

        }

        System.out.println("\nFuncionario " + matricula + " não foi encontrado");

    }

    private static void listarFuncionarios() {

        System.out.println("\nTodos os funcionarios cadastrados:");

        if (Cadastro.getListaFuncionarios().size() == 0) {

            System.out.println("\nNao ha fucionários cadastrados...");
            return; 

        }

        for (Funcionario temp : Cadastro.getListaFuncionarios()) {

            System.out.println(temp.toString());

        }
    }

    private static void excluirFuncionario() {

        System.out.print("\nInforme a matricula do func. que deseja excluir: ");
        int matricula = Console.lerInt();

        Funcionario f2 = Cadastro.buscar(matricula);

        if (f2 == null) {
            System.out.println("\nFuncionario " + matricula + " nao foi encontrado");
            return;
        }

        Cadastro.excluir(f2);

        System.out.println("\nFuncionario excluido com sucesso!");

    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:

            cadastrarGerente();

                break;

            case 2:

            cadastrarDesenvolvedor();
                break;

            case 3:
            cadastrarEstagiario();
            
            break;
            
            case 4:
            
            procurarFuncionario();
            break;
            
            case 5:
            
             listarFuncionarios();
            
            break;
            
            case 6:
            
             excluirFuncionario();
                break;

            case 7:
            if (Cadastro.getListaFuncionarios().size() == 0) {
                System.out.println("Nao ha funcionarios para excluir");
                return;
            }

            Cadastro.getListaFuncionarios().clear();
            System.out.println("Todos os funcionarios foram excluidos com sucesso");
            
            break;
            case 0:

                System.out.println("\nO programa foi finalizado...");
                break;

            default:

                System.out.println("\nOpcao invalida. Digite novamente.");
                break;
        }

    }

    public static void executar() {

        int op;
        do {

            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while (op != 0);

    }
}
