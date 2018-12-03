package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner in = new Scanner(System.in);

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
            System.out.print("[4]  - Editar projeto do laboratório;\n");
            System.out.print("[5]  - Consulta colaborador;\n");
            System.out.print("[6]  - Consulta projeto;\n");
            System.out.print("[7]  - Relatório de produção Acadêmica;\n");
            System.out.print("[8]  - Cadastrar novo administrador.\n");

            option = in.nextInt();

            if(option == 0)
            {
                System.out.print("Opção [0] escolhida - Sair!\n");
                exit = true;
            }
            else if(option == 1)
            {
                System.out.print("Opção [1] escolhida - Adicionar colaborador ao laboratório!\n");
            }
            else if(option == 2)
            {
                System.out.print("Opção [2] escolhida - Adicionar projeto ao laboratório!\n");
            }
            else if(option == 3)
            {
                System.out.print("Opção [3] escolhida - Adicionar projeto ao laboratório!\n");
            }
            else if(option == 4)
            {
                System.out.print("Opção [4] escolhida - Editar projeto do laboratório!\n");
            }
            else if(option == 5)
            {
                System.out.print("Opção [5] escolhida - Consulta colaborador!\n");
            }
            else if(option == 6)
            {
                System.out.print("Opção [6] escolhida - Consulta projeto!\n");
            }
            else if(option == 7)
            {
                System.out.print("Opção [7] escolhida - Relatório de produção Acadêmica!\n");
            }
            else if(option == 8)
            {
                System.out.print("Opção [8] escolhida - Cadastrar novo administrador!\n");
            }
        }
    }


    public static void main(String[] args)
    {
        Laboratorio laboratorio = new Laboratorio();
        ArrayList<Adm> adms = new ArrayList<Adm>();
        Adm adm = new Adm();
        System.out.print("Nenhum administrador criado, crie um usuário de administrador para continuar!\n");
        System.out.print("Nome: ");
        adm.setNome(in.nextLine());
        System.out.print("Usuário: ");
        adm.setUser(in.nextLine());
        System.out.print("Senha: ");
        adm.setSenha(in.nextLine());
        System.out.print("Email: ");
        adm.setEmail(in.nextLine());
        adms.add(adm);
        menu(laboratorio, adms);
    }
}
