package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner in = new Scanner(System.in);

    private static void printdata(Data data) { System.out.printf("%d / %d / %d\n", data.getDia(), data.getMes(), data.getAno()); }

    private static void listarpa(ArrayList<Publicacao> pub)
    {
        int i;
        System.out.print("Listando publicações...\n");
        for(i = 0; i < pub.size(); i++)
            System.out.printf("Publicação: %s\n", pub.get(i).getTitulo());
    }



    private static int findcollab(ArrayList<Colaborador> collabs, int id)
    {
        int i;
        for(i = 0; i < collabs.size(); i++)
        {
            if(id == collabs.get(i).getId())
            {
                System.out.print("Colaborador encontrado!\n");
                return i;
            }
        }
        System.out.print("Colaborador não encontrado!\n");
        return -1;
    }

    private static void listarcollabs(ArrayList<Colaborador> collabs)
    {
        int i;
        System.out.print("Listando colaboradores...\n");
        for(i = 0; i < collabs.size(); i++)
            System.out.printf("Colaborador: %s - ID %4d - Tipo %s\n", collabs.get(i).getNome(), collabs.get(i).getId(), collabs.get(i).getTipostr());
    }

    private static void criarcollab(Laboratorio lab, int tipo)//tipos: 1 - alunog, 2 - alunom, 3 - alunod, 4 - professores, 5 - pesquisadores.
    {
        if(tipo == 0)
        {
            System.out.print("Digite o tipo do colaborador:\nTipos: 1 - Aluno Graduação | 2 - Aluno Mestrado | 3 - Aluno Doutorado | 4 - Professor | 5 - Pesquisador.\n");
            tipo = in.nextInt();
            in.nextLine();
        }
        Colaborador ncolab = new Colaborador();
        ncolab.setTipo(tipo);
        if(tipo == 1) ncolab.setTipostr("Aluno Graduação");
        else if(tipo == 2) ncolab.setTipostr("Aluno Mestrado");
        else if(tipo == 3) ncolab.setTipostr("Aluno Doutorado");
        else if(tipo == 4) ncolab.setTipostr("Professor");
        else if(tipo == 5) ncolab.setTipostr("Pesquisador");
        System.out.print("Criando novo colaborador...\n");
        System.out.printf("O colaborador é do tipo: %d - %s\n", tipo, ncolab.getTipostr());
        ncolab.setGid(ncolab.getGid() + 1);
        ncolab.setId(ncolab.getGid());
        System.out.printf("Novo ID criado! - ID = %d\n", ncolab.getId());
        System.out.print("Digite o nome do colaborador: ");
        ncolab.setNome(in.nextLine());
        System.out.print("Digite o email do colaborador: ");
        ncolab.setEmail(in.nextLine());
        System.out.print("Novo colaborador criado com sucesso!\n");
        lab.getParticipantes().add(ncolab);
    }


    private static void criarprojeto(Laboratorio lab)
    {
        System.out.print("Criando novo projeto...\n");
        Projeto pjt = new Projeto();
        lab.setPe(lab.getPe() + 1);
        System.out.print("Digite o Título do projeto: ");
        pjt.setTitulo(in.nextLine());
        pjt.setStatus(1);
        System.out.print("Digite a data de início do projeto (DD MM AAAA): ");
        Data ini = new Data();
        ini.setDia(in.nextInt());
        ini.setMes(in.nextInt());
        ini.setAno(in.nextInt());
        System.out.print("Digite a data de termino do projeto (DD MM AAAA): ");
        Data fim = new Data();
        fim.setDia(in.nextInt());
        fim.setMes(in.nextInt());
        fim.setAno(in.nextInt());
        in.nextLine();
        pjt.setTermino(fim);
        pjt.setInicio(ini);
        System.out.print("Digite o nome da agência financiadora: ");
        pjt.setAgfinan(in.nextLine());
        System.out.print("Digite o valor do financiamento: ");
        pjt.setValfinan(in.nextDouble());
        in.nextLine();
        System.out.print("Digite o objetivo do projeto: ");
        pjt.setObjetivo(in.nextLine());
        System.out.print("Digite a descrição do projeto: ");
        pjt.setDescricao(in.nextLine());
        System.out.print("O projeto precisa de um professor, Se o professor já estiver cadastrado no laboratório, Digite [1], Caso queira cadastrar um novo professor Digite [2]: ");
        int op = 0;
        while(op != 1 && op != 2)
        {
            op = in.nextInt();
            in.nextLine();
            if(op == 1)
            {
                boolean flag = false;
                while(!flag)
                {
                    System.out.print("Deseja listar os colaboradores? Sim [1], Não [0].\n");
                    if(in.nextInt() == 1) listarcollabs(lab.getParticipantes());
                    System.out.print("Digite o ID do professor: \n");
                    int id = in.nextInt();
                    System.out.print("Procurando professor...\n");
                    int i = findcollab(lab.getParticipantes(), id);
                    if(lab.getParticipantes().get(i).getTipo() == 4 || i == -1)
                    {
                        pjt.getParticipantes().add(lab.getParticipantes().get(i));
                        flag = true;
                    }
                    else System.out.print("Tente novamente!\n");
                }

            }
            else if(op == 2)
            {
                System.out.print("Criando novo professor...\n");
                criarcollab(lab, 4);
                System.out.print("Digite o id do professor criado: ");
                int i = findcollab(lab.getParticipantes(), in.nextInt());
                pjt.getParticipantes().add(lab.getParticipantes().get(i));
            }
            else System.out.print("Opção Inválida, digite novamente: ");
        }
        System.out.print("Novo projeto criado com sucesso!\n");
        lab.getProjetos().add(pjt);
    }

    private static void editprojeto(Laboratorio lab)
    {
        System.out.print("Deseja listar todos os projetos? [1] -  Sim | [2] - Não: ");
        if(in.nextInt() == 1) listarpjts(lab.getProjetos());
        in.nextLine();
        //STATUS//1 - elaboração, 2 - em andamento, 3 - concluido.
        System.out.print("Digite o título do projeto a ser editado: ");
        int i = findpjts(lab.getProjetos(), in.nextLine());
        if(i != -1)
        {
            System.out.print("O que deseja editar no projeto?\n");
            System.out.print("[1] Para alocar participantes;\n");
            System.out.print("[2] Para alterar status;\n");
            System.out.print("[3] Adicionar publicação;\n");
            System.out.print("[4] Adicionar orientação;\n");

            int option =  in.nextInt();
            in.nextLine();
            if(option == 1)
            {
                System.out.print("Opção - [1] Para alocar participantes;\n");
                if(lab.getProjetos().get(i).getStatus() != 2)
                {
                    System.out.print("Mude o status do projeto para adicionar colaboradores!\n");
                    System.out.print("Deseja mudar agora? [1] -  Sim | [2] - Não: ");
                    if(in.nextInt() == 1)
                    {
                        in.nextLine();
                        lab.getProjetos().get(i).setStatus(2);
                        System.out.print("Status setado para 2 - Em andamento!\n");
                        lab.setPe(lab.getPe() - 1);
                        lab.setPa(lab.getPa() + 1);
                    }
                }
                if(lab.getProjetos().get(i).getStatus() == 2)
                {
                    System.out.print("Deseja listar os colaboradores? [1] - Sim | [2] - Não: ");
                    if(in.nextInt() == 1) listarcollabs(lab.getParticipantes());
                    System.out.print("Digite o ID do colaborador a ser alocado; ");
                    int j = findcollab(lab.getParticipantes(), in.nextInt());
                    if(lab.getParticipantes().get(j).isPartdeprojeto() && lab.getParticipantes().get(j).getTipo() != 4) System.out.print("Colaborador já está em um projeto! Ele não será adicionado!\n");
                    else
                    {
                        lab.getProjetos().get(i).getParticipantes().add(lab.getParticipantes().get(j));///TESTAR
                        System.out.print("Colaborador adicionado com sucesso! ");
                        lab.getParticipantes().get(j).setPartdeprojeto(true);
                    }
                }

            }
            else if(option == 2)
            {
                System.out.print("Opção - [2] Para alterar status;\n");
                if(lab.getProjetos().get(i).getStatus() == 1)
                {
                    System.out.print("Status Elaboração! Deseja mudar para Em andamento? [1] - Sim | [2] - Não: ");
                    if(in.nextInt() == 1)
                    {
                        lab.getProjetos().get(i).setStatus(2);
                        System.out.print("Status alterado com sucesso!\n");
                        lab.setPe(lab.getPe() - 1);
                        lab.setPa(lab.getPa() + 1);
                    }
                    else System.out.print("Status não alterado!\n");
                }
                if(lab.getProjetos().get(i).getStatus() == 2)
                {
                    System.out.print("Status Em andamento! Deseja mudar para Concluído? [1] - Sim | [2] - Não: ");
                    if(in.nextInt() == 1)
                    {
                        lab.getProjetos().get(i).setStatus(3);
                        for (Colaborador collab : lab.getParticipantes()) collab.setPartdeprojeto(false);
                        System.out.print("Status alterado com sucesso!\n");
                        lab.setPa(lab.getPa() - 1);
                        lab.setPc(lab.getPc() + 1);
                    }
                    else System.out.print("Status não alterado!\n");
                }
            }
            else if(option == 3)
            {
                System.out.print("Opção - [3] Adicionar publicação;\n");
                if(lab.getProjetos().get(i).getStatus() != 2) System.out.print("Mude o status para em andamento para adicionar uma publicação!\n");
                else
                {
                    Publicacao pub = new Publicacao();
                    System.out.print("Digite o título da publicação: ");
                    pub.setTitulo(in.nextLine());
                    System.out.print("Digite o nome da conferência: ");
                    pub.setNomeconf(in.nextLine());
                    System.out.print("Digite a data da publicação (DD MM AAAA): ");
                    Data aux = new Data();
                    aux.setDia(in.nextInt());
                    aux.setMes(in.nextInt());
                    aux.setAno(in.nextInt());
                    pub.setPublicacao(aux);
                    in.nextLine();
                    System.out.printf("Projeto de pesquisa associado: %s\n", lab.getProjetos().get(i).getTitulo());
                    pub.setPpassociado(lab.getProjetos().get(i).getTitulo());
                    lab.getProjetos().get(i).getPublicacoes().add(pub);
                    lab.setPap(lab.getPap() + 1);
                    System.out.print("Publicação adicionada com sucesso!\n");
                }

            }
            else if(option == 4)
            {
                System.out.print("Opção - [4] Adicionar orientação;\n");
                System.out.print("Falta finalizar, nenhuma alteração foi feita!\n");
            }
        }
        else System.out.print("Tente novamente!\n");
    }

    private static void consultacollab(Laboratorio lab)
    {
        System.out.print("Deseja listar todos os colaboradores? [1] - Sim | [2] -  Não: ");
        if(in.nextInt() == 1) listarcollabs(lab.getParticipantes());
        in.nextLine();
        System.out.print("Digite o ID do colaborador a ser consultado: ");
        int i = findcollab(lab.getParticipantes(), in.nextInt());
        System.out.printf("Colaborador: %s - ID %4d - Tipo %s\n", lab.getParticipantes().get(i).getNome(), lab.getParticipantes().get(i).getId(), lab.getParticipantes().get(i).getTipostr());
        System.out.printf("Email: %s\n", lab.getParticipantes().get(i).getEmail());
        System.out.printf("Tipo - %d - %s\n", lab.getParticipantes().get(i).getTipo(), lab.getParticipantes().get(i).getTipostr());


        //LISTAR PJTS


    }

    private static void consultapjt(Laboratorio lab)
    {
        System.out.print("Deseja listar todos os projetos? [1] - Sim | [2] -  Não: ");
        if(in.nextInt() == 1) listarpjts(lab.getProjetos());
        in.nextLine();
        System.out.print("Digite o nome do projeto a ser consultado: ");
        int i = findpjts(lab.getProjetos(), in.nextLine());
        System.out.printf("Projeto: %s\n", lab.getProjetos().get(i).getTitulo());
        if(lab.getProjetos().get(i).getStatus() == 1) System.out.print("Status: Em elaboração!\n");
        else if(lab.getProjetos().get(i).getStatus() == 2) System.out.print("Status: Em andamento!\n");
        else if(lab.getProjetos().get(i).getStatus() == 3) System.out.print("Status: Concluído!\n");
        System.out.print("Data de Inicio: ");
        printdata(lab.getProjetos().get(i).getInicio());
        System.out.print("Data de Termino: ");
        printdata(lab.getProjetos().get(i).getTermino());
        System.out.printf("Agencia financiadora: %s | Valor financiado %.2f\n", lab.getProjetos().get(i).getAgfinan(), lab.getProjetos().get(i).getValfinan());
        System.out.printf("Objetivo: %s\nDescrição: %s\n", lab.getProjetos().get(i).getObjetivo(), lab.getProjetos().get(i).getDescricao());
        //System.out.print("Listando colaboradores...\n");
        listarcollabs(lab.getProjetos().get(i).getParticipantes());
        listarpa(lab.getProjetos().get(i).getPublicacoes());

        //LISTAR PA ORD D DATA
    }


    private static void listarpjts(ArrayList<Projeto> pjts)
    {
        int i;
        System.out.print("Listando projetos...\n");
        for(i = 0; i < pjts.size(); i++)
            System.out.printf("%s\n", pjts.get(i).getTitulo());
    }

    private static int findpjts(ArrayList<Projeto> pjts, String titulo)
    {
        int i;
        //System.out.print("Listando administradores...\n");
        for(i = 0; i < pjts.size(); i++)
            if(titulo.equals(pjts.get(i).getTitulo()))
            {
                System.out.print("Projeto encontrado!\n");
                return i;
            }
        System.out.print("Projeto não encontrado!\n");
        return -1;//nao achou.!!
    }


    private static void criaradm(ArrayList<Adm> adms)
    {
        System.out.print("Criando novo Administrador...\n");
        Adm adm =  new Adm();
        System.out.print("Nome: ");
        adm.setNome(in.nextLine());
        System.out.print("Usuário: ");
        adm.setUser(in.nextLine());
        System.out.print("Senha: ");
        adm.setSenha(in.nextLine());
        System.out.print("Email: ");
        adm.setEmail(in.nextLine());
        adms.add(adm);
        System.out.print("Novo administrador criado com sucesso!\n");
    }


    private static void listaradms(ArrayList<Adm> adms)
    {
        int i;
        System.out.print("Listando administradores...\n");
        for(i = 0; i < adms.size(); i++)
            System.out.printf("%s\n", adms.get(i).getUser());
    }

    private static int findadm(ArrayList<Adm> adms, String user)
    {
        int i;
        //System.out.print("Listando administradores...\n");
        for(i = 0; i < adms.size(); i++)
            if(user.equals(adms.get(i).getUser()))
            {
                System.out.print("Usuário encontrado!\n");
                return i;
            }
        System.out.print("Usuário não encontrado!\n");
        return -1;//nao achou.!!
    }

    private static void relatorio(Laboratorio lab)
    {
        //a. Número de colaboradores
        //b. Número de projetos em elaboração
        //c. Número de projetos em andamento
        //d. Número de projetos concluídos
        //e. Número total de projetos
        //f. Número de produção acadêmica por tipo de produção

        System.out.print("Gerando Relatório...\n");
        System.out.printf("Número de colaboradores          = %4d\n", lab.getParticipantes().size());
        System.out.printf("Número de projetos em elaboração = %4d\n", lab.getPe());
        System.out.printf("Número de projetos em andamento  = %4d\n", lab.getPa());
        System.out.printf("Número de projetos concluídos    = %4d\n", lab.getPc());
        System.out.printf("Número total de projetos         = %4d\n", lab.getProjetos().size());
        System.out.printf("Publicações                      = %4d\n", lab.getPap());
        System.out.printf("Orientações                      = %4d\n", lab.getPao());
    }




    private static void menu(Laboratorio laboratorio, ArrayList<Adm> adms)
    {
        boolean islogged =  false;
        boolean exit = false;
        int option;
        while(!exit)
        {
            if(islogged)
            {
                System.out.print("Deseja deslogar? 1 - S | 2 - N.\n");
                if(in.nextInt() == 1)
                {
                    islogged = false;
                    System.out.print("Usuário deslogado.\n");
                }
                else System.out.print("Usuário continua logado.\n");
                in.nextLine();
            }

            while(!islogged)
            {
                System.out.print("Usuário de administrador não logado!\nLogue para fazer alterações\n");
                listaradms(adms);
                System.out.print("Digite o nome de usuário para logar: ");
                int i = findadm(adms, in.nextLine());
                if( i>= 0)
                {
                    System.out.print("Digite a senha: ");
                    if(in.nextLine().equals(adms.get(i).getSenha()))
                    {
                        System.out.print("Senha correta! Usuário logado!\n");
                        islogged = true;
                    }
                    else System.out.print("Senha inválida! Tente novamente\n");
                }
            }
            //menu(laboratorio, adms, islogged);

            System.out.print("Digite:\n");
            System.out.print("[0]  - Sair;\n");
            System.out.print("[1]  - Adicionar colaborador ao laboratório;\n");
            System.out.print("[2]  - Adicionar projeto ao laboratório;\n");
            System.out.print("[3]  - Editar projeto do laboratório;\n");
            System.out.print("[4]  - Consulta colaborador;\n");
            System.out.print("[5]  - Consulta projeto;\n");
            System.out.print("[6]  - Relatório de produção Acadêmica;\n");
            System.out.print("[7]  - Cadastrar novo administrador.\n");

            option = in.nextInt();
            in.nextLine();

            if(option == 0)
            {
                System.out.print("Opção [0] escolhida - Sair!\n");//v
                exit = true;
            }
            else if(option == 1)
            {
                System.out.print("Opção [1] escolhida - Adicionar colaborador ao laboratório!\n");//v
                criarcollab(laboratorio, 0);
            }
            else if(option == 2)
            {
                System.out.print("Opção [2] escolhida - Adicionar projeto ao laboratório!\n");//v
                criarprojeto(laboratorio);
            }
            else if(option == 3)
            {
                System.out.print("Opção [3] escolhida - Editar projeto do laboratório!\n");//
                editprojeto(laboratorio);
            }
            else if(option == 4)
            {
                System.out.print("Opção [4] escolhida - Consulta colaborador!\n");//
                consultacollab(laboratorio);
            }
            else if(option == 5)
            {
                System.out.print("Opção [5] escolhida - Consulta projeto!\n");//
                consultapjt(laboratorio);
            }
            else if(option == 6)
            {
                System.out.print("Opção [6] escolhida - Relatório de produção Acadêmica!\n");//
                relatorio(laboratorio);
            }
            else if(option == 7)
            {
                System.out.print("Opção [7] escolhida - Cadastrar novo administrador!\n");//v
                criaradm(adms);
            }
        }
    }


    public static void main(String[] args)
    {
        Laboratorio laboratorio = new Laboratorio();
        ArrayList<Adm> adms = new ArrayList<Adm>();
        System.out.print("Nenhum administrador criado, crie um usuário de administrador para continuar!\n");
        criaradm(adms);
        menu(laboratorio, adms);
    }
}
