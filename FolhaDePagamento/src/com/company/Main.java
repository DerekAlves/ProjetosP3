package com.company;
import java.util.Scanner;
import java.lang.String;

public class Main
{
    private static void menu(int dia)
    {
        Scanner in = new Scanner(System.in);
        int option;
        if(dia < 32)
        {
            System.out.println("Bem vindo(a) de volta, hoje é dia: ");
            int sem = dia % 7;
            if(sem == 0)  System.out.println(" - Domingo.\n");
            else if(sem == 1) System.out.println(dia +" - Segunda.\n");
            else if(sem == 2) System.out.println(dia +" - Terça.\n");
            else if(sem == 3) System.out.println(dia +" - Quarta.\n");
            else if(sem == 4) System.out.println(dia +" - Quinta.\n");
            else if(sem == 5) System.out.println(dia +" - Sexta.\n");
            else if(sem == 6) System.out.println(dia +" - Sábado.\n");

            System.out.print("Digite:\n");
            System.out.print("[0]  - Sair;\n");
            System.out.print("[1]  - Adicionar Empregado;\n");
            System.out.print("[2]  - Remover Empregado;\n");
            System.out.print("[3]  - Lançar um Cartão de Ponto;\n");
            System.out.print("[4]  - Lançar um Resultado Venda;\n");
            System.out.print("[5]  - Lançar uma taxa de serviço;\n");
            System.out.print("[6]  - Alterar detalhes de um empregado;\n");
            System.out.print("[7]  - Rodar a folha de pagamento para hoje;\n");
            System.out.print("[8]  - Undo/Redo;\n");
            System.out.print("[9]  - Agenda de Pagamento;\n");
            System.out.print("[10] - Criação de Novas Agendas de Pagamento;\n");
            System.out.print("[11] - Encerrar Dia de Trabalho;\n");

            option = in.nextInt();

            if(option == 0)
            {
                System.out.print("Opção [Sair] selecionada!\n");
                System.exit(0);
            }

            else if(option == 1)
            {
                System.out.print("Opção [Adicionar Empregado] selecionada!\n");

            }
            else if(option == 2)
            {
                System.out.print("Opção [Remover Empregado] selecionada!\n");

            }
            else if(option == 3)
            {
                System.out.print("Opção [Lançar um Cartão de Ponto] selecionada!\n");

            }
            else if(option == 4)
            {
                System.out.print("Opção [Lançar um Resultado Venda] selecionada!\n");

            }
            else if(option == 5)
            {
                System.out.print("Opção [Lançar uma taxa de serviço] selecionada!\n");

            }
            else if(option == 6)
            {
                System.out.print("Opção [Alterar detalhes de um empregado] selecionada!\n");

            }
            else if(option == 7)
            {
                System.out.print("Opção [Rodar a folha de pagamento para hoje] selecionada!\n");

            }
            else if(option == 8)
            {
                System.out.print("Opção [Undo/Redo] selecionada!\n");

            }
            else if(option == 9)
            {
                System.out.print("Opção [Agenda de Pagamento] selecionada!\n");

            }
            else if(option == 10)
            {
                System.out.print("Opção [Criação de Novas Agendas de Pagamento] selecionada!\n");

            }
            else if(option == 11)
            {
                System.out.print("Opção [Encerrar Dia de Trabalho] selecionada!\n");
                menu(dia + 1);

            }
            else System.out.print("Opção inválida!\n");

            System.out.print("Deseja fazer outra alteração? Se sim, digite [1], se não digite [0](Sair).\n");
            option = in.nextInt();
            if(option == 1) menu(dia);
            else System.exit(0);
        }
        else
        {
            System.out.print("Fim do mês!\nDeseja iniciar outro mês? Se sim, digite [1], se não digite [0](Sair).\n");
            option = in.nextInt();
            if(option == 1) menu(1);
            else System.exit(0);
        }


    }

    public static void main(String[] args) { menu(1); }
}
