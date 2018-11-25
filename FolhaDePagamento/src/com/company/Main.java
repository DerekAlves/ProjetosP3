package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Main {
    static Scanner in = new Scanner(System.in);

    static void ListarFuncionarios(ArrayList<Funcionario> ListaFuncionarios) {
        if (ListaFuncionarios.isEmpty()) System.out.printf("Não existem Funcionários cadastrados!\n");
        else
        {
            for(int i = 0; i < ListaFuncionarios.size(); i++)
            {
                System.out.printf("ID = %d | Nome = %s\n", ListaFuncionarios.get(i).getId(), ListaFuncionarios.get(i).getNome());
            }
        }
    }

    static void addFuncionario(ArrayList<Funcionario> ListaFuncionarios) {
        int option;
        System.out.println("Deseja Continuar? [1] Para sim, [0] para não.\n");
        option = in.nextInt();
        in.nextLine();
        if (option != 1) return;
        else {
            Funcionario novo = new Funcionario();
            Salario novos = new Salario();
            novo.setGid(novo.getGid() + 1);
            novo.setId(novo.getGid());
            System.out.println("Novo ID Criado\nO ID é: " + novo.getGid());
            System.out.print("Digite o nome do funcionário.\n");
            novo.setNome(in.nextLine());
            //System.out.printf("NOME %s\n", novo.getNome());//teste
            System.out.print("Digite o endereço do funcionário.\n");
            novo.setEndereco(in.nextLine());
            //System.out.printf("ENDEREÇO %s\n", novo.getEndereco());//teste
            System.out.print("Selecione o tipo de empregado: [1] - Horista || [2] - Assalariado || [3] Comissionado.\n");
            option = in.nextInt();
            novo.setTiponum(option);

            if (option == 1) {
                System.out.print("[Horista]\n");
                novo.setTipostr("Horista");
                System.out.print("Digite o salário hora: ");
                novos.setSalhor(in.nextDouble());
                //System.out.print("\n");
            } else if (option == 2) {
                System.out.print("[Assalariado]\n");
                novo.setTipostr("Assalariado");
                System.out.print("Digite o salário mensal: ");
                novos.setSalmen(in.nextDouble());
                //System.out.print("\n");
            } else if (option == 3) {
                System.out.print("[Comissionado]\n");
                novo.setTipostr("Comissionado");
                System.out.print("Digite o salário mensal: ");
                novos.setSalmen(in.nextDouble());
                //System.out.print("\n");
                System.out.print("Digite a porcentagem de comissão: ");
                novos.setComis(in.nextDouble());
                //System.out.print("\n");
            }

            //System.out.printf("Tipo %.2s, salario hora %.2f, salario mensal %.2f, comissao %.2f.\n", novo.getTipostr(), novos.getSalhor(), novos.getSalmen(), novos.getComis());//teste
            novo.setSalario(novos);
            ListaFuncionarios.add(novo);
            System.out.print("Funcionário cadastrado com sucesso!\n");

        }
    }

    static void delFuncionario(ArrayList<Funcionario> ListaFuncionarios)
    {
        ListarFuncionarios(ListaFuncionarios);
        int id, option, i;
        System.out.print("Digite o ID do funcionário a ser removido: ");
        id = in.nextInt();
        System.out.print("Deseja realmente remover o funcionário? 1 - [S] || 0 - [N].\n");
        option = in.nextInt();
        for (i = 0; (option == 1) && i < ListaFuncionarios.size(); i++)
        {
            //System.out.printf("I %d, ID %d, nome %s, size %d\n", i, ListaFuncionarios.get(i).getId(), ListaFuncionarios.get(i).getNome(), ListaFuncionarios.size());
            if (ListaFuncionarios.get(i).getId() == id)
            {
                ListaFuncionarios.remove(i);
                break;
            }
        }
        ListarFuncionarios(ListaFuncionarios);
    }


    private static void menu(int dia, ArrayList<Funcionario> ListaFuncionarios) {
        int option;
        if (dia < 32) {
            System.out.println("Bem vindo(a) de volta, hoje é dia: ");
            int sem = dia % 7;
            if (sem == 0) System.out.println(" - Domingo.\n");
            else if (sem == 1) System.out.println(dia + " - Segunda.\n");
            else if (sem == 2) System.out.println(dia + " - Terça.\n");
            else if (sem == 3) System.out.println(dia + " - Quarta.\n");
            else if (sem == 4) System.out.println(dia + " - Quinta.\n");
            else if (sem == 5) System.out.println(dia + " - Sexta.\n");
            else if (sem == 6) System.out.println(dia + " - Sábado.\n");

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
            //in.nextLine();

            if (option == 0) {
                System.out.print("Opção [Sair] selecionada!\n");
                System.exit(0);
            } else if (option == 1) {
                System.out.print("Opção [Adicionar Empregado] selecionada!\n");
                addFuncionario(ListaFuncionarios);
                ListarFuncionarios(ListaFuncionarios);

            } else if (option == 2) {
                System.out.print("Opção [Remover Empregado] selecionada!\n");
                delFuncionario(ListaFuncionarios);

            } else if (option == 3) {
                System.out.print("Opção [Lançar um Cartão de Ponto] selecionada!\n");

            } else if (option == 4) {
                System.out.print("Opção [Lançar um Resultado Venda] selecionada!\n");

            } else if (option == 5) {
                System.out.print("Opção [Lançar uma taxa de serviço] selecionada!\n");

            } else if (option == 6) {
                System.out.print("Opção [Alterar detalhes de um empregado] selecionada!\n");

            } else if (option == 7) {
                System.out.print("Opção [Rodar a folha de pagamento para hoje] selecionada!\n");

            } else if (option == 8) {
                System.out.print("Opção [Undo/Redo] selecionada!\n");

            } else if (option == 9) {
                System.out.print("Opção [Agenda de Pagamento] selecionada!\n");

            } else if (option == 10) {
                System.out.print("Opção [Criação de Novas Agendas de Pagamento] selecionada!\n");

            } else if (option == 11) {
                System.out.print("Opção [Encerrar Dia de Trabalho] selecionada!\n");
                menu(dia + 1, ListaFuncionarios);

            } else System.out.print("Opção inválida!\n");

            System.out.print("Deseja fazer outra alteração? Se sim, digite [1], se não digite [0](Sair).\n");
            option = in.nextInt();
            //in.nextLine();
            if (option == 1) menu(dia, ListaFuncionarios);
            else System.exit(0);
        } else {
            System.out.print("Fim do mês!\nDeseja iniciar outro mês? Se sim, digite [1], se não digite [0](Sair).\n");
            option = in.nextInt();
            //in.nextLine();
            if (option == 1) menu(1, ListaFuncionarios);
            else System.exit(0);
        }


    }

    public static void main(String[] args) {
        ArrayList<Funcionario> ListaFuncionarios = new ArrayList<Funcionario>();
        menu(1, ListaFuncionarios);
    }
}