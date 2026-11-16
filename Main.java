import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String livro = "Introdução à Ciência da Computação";
        String membro = "";
        
        int exemplares = 2;
        int emprestimos = 0;
        int opcao;

        do {

            System.out.println("\n=== BIBLIOTECA UNIVERSITARIA ===");
            System.out.println("1 - Cadastrar membro");
            System.out.println("2 - Consultar livro");
            System.out.println("3 - Realizar emprestimo");
            System.out.println("4 - Realizar devolucao");
            System.out.println("5 - Reservar livro");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do membro: ");
                    membro = scanner.nextLine();

                    System.out.println("Membro cadastrado!");
                    break;

                case 2:
                    System.out.println("Livro: " + livro);
                    System.out.println("Exemplares disponiveis: " + exemplares);
                    break;

                case 3:
                    if (membro.isEmpty()) {
                        System.out.println("Cadastre um membro primeiro.");

                    } else if (emprestimos >= 3) {
                        System.out.println("Limite de emprestimos atingido.");

                    } else if (exemplares > 0) {

                        emprestimos = emprestimos + 1;
                        exemplares = exemplares - 1;

                        System.out.println("Emprestimo realizado!");
                        System.out.println("Data de retirada: " + LocalDate.now());
                        System.out.println("Devolucao: " + LocalDate.now().plusDays(14));

                    } else {
                        System.out.println("Livro indisponivel.");
                    }
                    break;

                case 4:
                    if (emprestimos > 0) {

                        emprestimos = emprestimos - 1;
                        exemplares = exemplares + 1;

                        System.out.println("Devolucao realizada!");
                    } else {
                        System.out.println("Nenhum emprestimo ativo.");
                    }
                    break;

                case 5:
                    if (exemplares == 0) {
                        System.out.println("Reserva realizada!");
                    } else {
                        System.out.println("Existem livros disponiveis.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}