package com.company;
import java.util.*;
import java.lang.String;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int sem = 1;
    //static String[] mes = new String[31];
    public class Lista { ArrayList<Funcionario> Lista; }
    public static Stack<Lista> pilhaundo = new Stack<Lista>();
    public static Stack<Lista> pilharedo = new Stack<Lista>();



    static void zerarContabilizar(ArrayList<Funcionario> ListaFuncionarios)
    {
        int i;
        double hor;
        for(i = 0; i < ListaFuncionarios.size(); i++)
        {
            if(ListaFuncionarios.get(i).getTiponum() == 1)
            {
                hor = ListaFuncionarios.get(i).getHj();
                if(hor > 8) hor = hor*1.5;//contabiliza 1.5
                ListaFuncionarios.get(i).setHorw(ListaFuncionarios.get(i).getHorw() + hor);
                ListaFuncionarios.get(i).setHj(0);
            }
            else
            {
                ListaFuncionarios.get(i).setDiaw(ListaFuncionarios.get(i).getDiaw() + (int)ListaFuncionarios.get(i).getHj());
                ListaFuncionarios.get(i).setHj(0);
            }
        }
    }


    /*static void doPayment(Funcionario funcionario)
    {

    }*/


    static boolean findDay(int a[], int dia)
    {
        int i;
        for(i = 0; i < 5; i++) if(dia == a[i]) return true;
        return false;
    }


    static void printFunc(ArrayList<Funcionario> ListaFuncionarios, int id)
    {
        int i = findFunc(ListaFuncionarios, id);
        Funcionario aux = ListaFuncionarios.get(i);
        Salario sal = aux.getSalario();
        System.out.print("Funcionário:\n");
        System.out.printf("%s\n", aux.getNome());
        System.out.printf("ID %d\n", aux.getId());
        System.out.printf("Tipo %d - %s\n", aux.getTiponum(), aux.getTipostr());
        System.out.printf("Dias Trabalhados: %d\nHoras Trabalhadas %.2f\n", aux.getDiaw(), aux.getHorw());
        System.out.print("Salário:\n");
        System.out.printf("Hora %.2f\nMensal %.2f\nComissão %.2f\nVendas %.2f\nTaxas %.2f\nTotal %.2f\n", sal.getSalhor(), sal.getSalmen(), sal.getComis(), sal.getVendas(), sal.getTaxas(), sal.getSaltot());
    }



    static void ListarFuncionarios(ArrayList<Funcionario> ListaFuncionarios) {
        if (ListaFuncionarios.isEmpty()) System.out.print("Não existem Funcionários cadastrados!\n");
        else
        {
            System.out.print("   ID |   Nome do funcionário\n");
            for(int i = 0; i < ListaFuncionarios.size(); i++) System.out.printf("%5d |   %s\n", ListaFuncionarios.get(i).getId(), ListaFuncionarios.get(i).getNome());
        }
    }

    static int findFunc(ArrayList<Funcionario> ListaFuncionarios, int id)
    {
        int i;
        for(i = 0; i < ListaFuncionarios.size(); i++)
        {
            if(ListaFuncionarios.get(i).getId() == id)
            {
                System.out.print("Funcionário encontrado!\n");
                return i;
            }
        }
        System.out.print("Funcionário não encontrado!\n");
        return -1;
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
            System.out.print("O método de pagamento é mensalmente, ao final do mês.\n");
            int a[] = {31, 0, 0, 0, 0};
            novo.setPaymentdays(a);

            //System.out.printf("Tipo %.2s, salario hora %.2f, salario mensal %.2f, comissao %.2f.\n", novo.getTipostr(), novos.getSalhor(), novos.getSalmen(), novos.getComis());//teste
            novo.setSalario(novos);
            ListaFuncionarios.add(novo);
            System.out.print("Funcionário cadastrado com sucesso!\n");

        }
    }

    static Funcionario delFuncionario(ArrayList<Funcionario> ListaFuncionarios)
    {
        ListarFuncionarios(ListaFuncionarios);

        Funcionario aux;
        int id, option, i;
        System.out.print("Digite o ID do funcionário a ser removido: ");
        id = in.nextInt();
        i = findFunc(ListaFuncionarios, id);
        if (i != -1)
        {
            System.out.print("Deseja realmente remover o funcionário? 1 - [S] || 0 - [N].\n");
            option = in.nextInt();
            if(option == 1)
            {
                aux = ListaFuncionarios.remove(i);
                System.out.print("Funcionário removido com sucesso!\n");
                return aux;
            }
        }
        return null;
    }

    static void lancarPonto(ArrayList<Funcionario> ListaFuncionarios)
    {
        System.out.print("Digite o ID do funcionário para ser lançado o ponto: ");
        int id, i, option;
        id = in.nextInt();
        i = findFunc(ListaFuncionarios, id);
        System.out.print("Deseja realmente lançar o ponto? 1 - [S] || 0 - [N].\n");
        printFunc(ListaFuncionarios, id);
        option = in.nextInt();
        if(option == 1)
        {
            if(ListaFuncionarios.get(i).getTiponum() == 1)
            {
                System.out.print("O funcionário é Horista, digite a quantidade de horas trabalhadas: ");
                ListaFuncionarios.get(i).setHj(ListaFuncionarios.get(i).getHj() + in.nextDouble());
                System.out.print("Se excedido 8 horas diárias, cada hora a mais irá custar 50% a mais.\n");
            }
            else if(ListaFuncionarios.get(i).getTiponum() == 2 || ListaFuncionarios.get(i).getTiponum() == 3)
            {
                if(ListaFuncionarios.get(i).getHj() == 1) System.out.print("Ponto já registrado para este funcionário hoje.");
                else
                {
                    System.out.print("O funcionário é Assalariado ou Comissionado, Trabalhou o dia de hoje? [1] para Sim, [0] para Não.\nSe sim um dia de trabalho será incrementado.");
                    option = in.nextInt();
                    if(option == 1) ListaFuncionarios.get(i).setHj(1);
                }
            }
        }

    }


    static void lancarVenda(ArrayList<Funcionario> ListaFuncionarios)
    {
        System.out.print("Digite o ID do funcionário para ser lançada a venda: ");
        int id, i, option;
        id = in.nextInt();
        i = findFunc(ListaFuncionarios, id);
        System.out.print("Deseja realmente lançar a venda? 1 - [S] || 0 - [N].\n");
        printFunc(ListaFuncionarios, id);
        option = in.nextInt();
        if(option == 1)
        {
            if(ListaFuncionarios.get(i).getTiponum() == 3)
            {
                System.out.print("Funcionário comissionado!\nDigite o valor da venda: ");
                Salario aux = ListaFuncionarios.get(i).getSalario();
                aux.setVendas(aux.getVendas() + in.nextDouble());
                ListaFuncionarios.get(i).setSalario(aux);
                printFunc(ListaFuncionarios, id);
            }
            else System.out.print("Funcionário não comissionado!\n");
        }
        //else System.out.print("Funcionário não comissionado!\n");
    }

    static void lancarTaxas(ArrayList<Funcionario> ListaFuncionarios)
    {
        System.out.print("Digite o ID do funcionário para ser lançada a taxa de serviço: ");
        int id, i, option;
        id = in.nextInt();
        i = findFunc(ListaFuncionarios, id);
        System.out.print("Deseja realmente lançar a taxa de serviço? 1 - [S] || 0 - [N].\n");
        printFunc(ListaFuncionarios, id);
        option = in.nextInt();
        if(option == 1)
        {
            System.out.print("Digite o valor da taxa de serviço: ");
            Salario aux = ListaFuncionarios.get(i).getSalario();
            aux.setTaxas(aux.getTaxas() + in.nextDouble());
            ListaFuncionarios.get(i).setSalario(aux);
            printFunc(ListaFuncionarios, id);
        }
        //else System.out.print("Funcionário não comissionado!\n");
    }

    static void editFunc(ArrayList<Funcionario> ListaFuncionarios)
    {
        System.out.print("Digite o ID do funcionário a ser editado: ");
        int id, i, option;
        id = in.nextInt();
        i = findFunc(ListaFuncionarios, id);
        System.out.print("Deseja realmente editar os dados do funcionário? 1 - [S] || 0 - [N].\n");
        printFunc(ListaFuncionarios, id);
        option = in.nextInt();
        if(option == 1)
        {
            System.out.print("Deseja editar o nome do funcionário? 1 - [S] || 0 - [N].\n");
            option = in.nextInt();
            in.nextLine();
            if (option == 1)
            {
                System.out.print("Digite o novo nome:\n");
                ListaFuncionarios.get(i).setNome(in.nextLine());
            }
            System.out.print("Deseja editar o endereço do funcionário? 1 - [S] || 0 - [N].\n");
            option = in.nextInt();
            in.nextLine();
            if (option == 1)
            {
                System.out.print("Digite o novo endereço:\n");
                ListaFuncionarios.get(i).setEndereco(in.nextLine());
            }
            System.out.print("Deseja editar o tipo do funcionário? 1 - [S] || 0 - [N].\n");
            option = in.nextInt();
            //in.nextLine();
            if(option == 1)
            {
                System.out.print("Selecione o tipo de empregado: [1] - Horista || [2] - Assalariado || [3] Comissionado.\n");
                option = in.nextInt();
                if (option == 1)
                {
                    System.out.print("[Horista]\n");
                    ListaFuncionarios.get(i).setTipostr("Horista");
                    ListaFuncionarios.get(i).setTiponum(1);
                    System.out.print("Digite o salário hora: ");
                    Salario aux;
                    aux = ListaFuncionarios.get(i).getSalario();
                    aux.setSalhor(in.nextDouble());
                    ListaFuncionarios.get(i).setSalario(aux);
                }
                else if (option == 2)
                {
                    System.out.print("[Assalariado]\n");
                    ListaFuncionarios.get(i).setTipostr("Assalariado");
                    ListaFuncionarios.get(i).setTiponum(2);
                    System.out.print("Digite o salário mensal: ");
                    Salario aux;
                    aux = ListaFuncionarios.get(i).getSalario();
                    aux.setSalmen(in.nextDouble());
                    ListaFuncionarios.get(i).setSalario(aux);
                }
                else if (option == 3)
                {
                    System.out.print("[Comissionado]\n");
                    ListaFuncionarios.get(i).setTipostr("Comissionado");
                    ListaFuncionarios.get(i).setTiponum(3);
                    System.out.print("Digite o salário mensal: ");
                    Salario aux;
                    aux = ListaFuncionarios.get(i).getSalario();
                    aux.setSalmen(in.nextDouble());
                    System.out.print("Digite a porcentagem de comissão: ");
                    aux.setComis(in.nextDouble());
                    ListaFuncionarios.get(i).setSalario(aux);
                }
            }
        }
    }

    static void rodarFphj(ArrayList<Funcionario> ListaFuncionarios, int dia)
    {
        System.out.print("Rodando a folha de pagamento para hoje...\n");
        int i;
        for(i = 0; i < ListaFuncionarios.size(); i++)
        {
            if(findDay(ListaFuncionarios.get(i).getPaymentdays(), dia))
            {
                System.out.printf("Funcionário a ser pago: %s\nTipo: %s\n", ListaFuncionarios.get(i).getNome(), ListaFuncionarios.get(i).getTipostr());
                System.out.printf("Dias Trabalhados: %d\nSalário Mensal %.2f\n", ListaFuncionarios.get(i).getDiaw(), ListaFuncionarios.get(i).getSalario().getSalmen());
                System.out.printf("Horas Trabalhadas: %.2f\nSalário Hora %.2f\n", ListaFuncionarios.get(i).getHorw(), ListaFuncionarios.get(i).getSalario().getSalhor());
                Salario aux = ListaFuncionarios.get(i).getSalario();
                aux.setSaltot( (ListaFuncionarios.get(i).getHorw() * aux.getSalhor()) +  ( ((double)ListaFuncionarios.get(i).getDiaw()/27) * aux.getSalmen()) + (aux.getVendas() * (aux.getComis()/100)));
                System.out.printf("Salário Bruto = %.2f\n", aux.getSaltot());                                               ///CONSIDERANDO UM MES COM 27 DIAS UTEIS - 4 DOMINGOS.
                System.out.printf("Taxas = %.2f\n", aux.getTaxas());
                System.out.printf("Sindicato(2%%) =  %.2f\n", aux.getSaltot()*0.02);
                aux.setSaltot(aux.getSaltot() - aux.getTaxas() - aux.getSaltot()*0.02);
                System.out.printf("Salário Líquido = %.2f\n", aux.getSaltot());
                aux.setTaxas(0);
                aux.setVendas(0);
                if(ListaFuncionarios.get(i).getTiponum() == 1)//RESETANDO ATRIBUTOS, CASO O FUNCIONARIO TENHA MUDADO DE TIPO
                {
                    ListaFuncionarios.get(i).getSalario().setSalmen(0);
                    ListaFuncionarios.get(i).getSalario().setComis(0);
                }
                else if(ListaFuncionarios.get(i).getTiponum() == 2 || ListaFuncionarios.get(i).getTiponum() == 3)
                {
                    ListaFuncionarios.get(i).getSalario().setSalhor(0);
                    if(ListaFuncionarios.get(i).getTiponum() == 2) ListaFuncionarios.get(i).getSalario().setComis(0);
                }
                ListaFuncionarios.get(i).setSalario(aux);
                ListaFuncionarios.get(i).setHj(0);
                ListaFuncionarios.get(i).setDiaw(0);
                ListaFuncionarios.get(i).setHorw(0);
            }
        }
    }


    //static void undo()
    //static void redo()

    static void agendaPagamento(ArrayList<Funcionario> ListaFuncionarios)
    {
        System.out.print("Digite o ID do funcionário para mudar a agenda de pagamento: ");
        int id, i, option;
        id = in.nextInt();
        i = findFunc(ListaFuncionarios, id);
        System.out.print("Deseja realmente editar a agenda de pagamento do funcionário? 1 - [S] || 0 - [N].\n");
        //printFunc(ListaFuncionarios, id);
        option = in.nextInt();
        //1- semanalmente(1, 8, 15, 22, 29) , 2- bi semanalmente(8, 22), 3- fim do mes(31)
        int p1[] = {1, 8, 15, 22, 29};
        int p2[] = {8, 22, 0, 0, 0};
        int p3[] = {31, 0, 0, 0, 0};
        int aux[];

        aux = ListaFuncionarios.get(i).getPaymentdays();
        int j;
        for(j = 0; j < 5; j++) System.out.printf("%d ", aux[j]);
        System.out.print("\n");

        if(option == 1)
        {
            System.out.print("Qual agenda deseja?\n[1] - Semanalmente as segundas;\n[2] - Bi-semanalmente as segundas;\n[3] - Mensalmente no último dia do mês.\n");
            option = in.nextInt();
            if(option == 1)
            {
                System.out.print("Opção [1]\n");
                ListaFuncionarios.get(i).setPaymentdays(p1);
            }
            else if(option == 2)
            {
                System.out.print("Opção [2]\n");
                ListaFuncionarios.get(i).setPaymentdays(p2);

            }
            else if(option == 3)
            {
                System.out.print("Opção [3]\n");
                ListaFuncionarios.get(i).setPaymentdays(p3);
            }
            aux = ListaFuncionarios.get(i).getPaymentdays();
            for(j = 0; j < 5; j++) System.out.printf("%d ", aux[j]);
            System.out.print("\n");
        }
    }




    private static void menu(int dia, ArrayList<Funcionario> ListaFuncionarios) {
        int option;
        if (dia < 32) {
            System.out.println("Bem vindo(a) de volta, hoje é dia: ");
            int dsem = dia % 7;
            if(dsem == 0) sem++;

            if (dsem == 0)
            {
                System.out.println(sem + " Semana | " + dia + " - Domingo.\n");
                menu(dia + 1, ListaFuncionarios);
            }

            else if (dsem == 1) System.out.println(sem + " Semana | " + dia + " - Segunda.\n");
            else if (dsem == 2) System.out.println(sem + " Semana | " + dia + " - Terça.\n");
            else if (dsem == 3) System.out.println(sem + " Semana | " + dia + " - Quarta.\n");
            else if (dsem == 4) System.out.println(sem + " Semana | " + dia + " - Quinta.\n");
            else if (dsem == 5) System.out.println(sem + " Semana | " + dia + " - Sexta.\n");
            else if (dsem == 6) System.out.println(sem + " Semana | " + dia + " - Sábado.\n");

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
            System.out.print("[11] - Listar um funcionário específico.\n");

            option = in.nextInt();
            //in.nextLine();

            if (option == 0)
            {
                System.out.print("Opção [Sair] selecionada!\n");
                System.exit(0);
            }
            else if (option == 1)
            {
                System.out.print("Opção [Adicionar Empregado] selecionada!\n");
                addFuncionario(ListaFuncionarios);
                ListarFuncionarios(ListaFuncionarios);
            }
            else if (option == 2)
            {
                System.out.print("Opção [Remover Empregado] selecionada!\n");
                delFuncionario(ListaFuncionarios);
            }
            else if (option == 3)
            {
                System.out.print("Opção [Lançar um Cartão de Ponto] selecionada!\n");
                lancarPonto(ListaFuncionarios);
            }
            else if (option == 4)
            {
                System.out.print("Opção [Lançar um Resultado Venda] selecionada!\n");
                lancarVenda(ListaFuncionarios);
            }
            else if (option == 5)
            {
                System.out.print("Opção [Lançar uma taxa de serviço] selecionada!\n");
                lancarTaxas(ListaFuncionarios);
            }
            else if (option == 6)
            {
                System.out.print("Opção [Alterar detalhes de um empregado] selecionada!\n");
                editFunc(ListaFuncionarios);
            }
            else if (option == 7)
            {
                System.out.print("Opção [Rodar a folha de pagamento para hoje] selecionada (finalizar expediente)!\n");
                zerarContabilizar(ListaFuncionarios);
                rodarFphj(ListaFuncionarios, dia);
                menu(dia + 1, ListaFuncionarios);
            }
            else if (option == 8)
            {
                System.out.print("Opção [Undo/Redo] selecionada!\n");

            }
            else if (option == 9)
            {
                System.out.print("Opção [Agenda de Pagamento] selecionada!\n");
                agendaPagamento(ListaFuncionarios);
            }
            else if (option == 10)
            {
                System.out.print("Opção [Criação de Novas Agendas de Pagamento] selecionada!\n");

            }
            /*else if (option == 11)
            {
                System.out.print("Opção [Encerrar Dia de Trabalho] selecionada!\n");
                menu(dia + 1, ListaFuncionarios);

            }*/
            else if(option == 11) printFunc(ListaFuncionarios, in.nextInt());
            else System.out.print("Opção inválida!\n");

            System.out.print("Deseja fazer outra alteração? Se sim, digite [1], se não digite [0](Sair).\n");
            option = in.nextInt();
            //in.nextLine();
            if (option == 1) menu(dia, ListaFuncionarios);
            else System.exit(0);
        }
        else
        {
            System.out.print("Fim do mês!\nDeseja iniciar outro mês? Se sim, digite [1], se não digite [0](Sair).\n");
            option = in.nextInt();
            //in.nextLine();
            if (option == 1) menu(1, ListaFuncionarios);
            else System.exit(0);
        }
    }

    public static void main(String[] args) {
        ArrayList<Funcionario> ListaFuncionarios = new ArrayList<Funcionario>();
        menu(28, ListaFuncionarios);
    }
}