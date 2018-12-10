package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static Scanner in = new Scanner(System.in);

    private static int finduser(ArrayList<Usuario> users, String user)
    {
        System.out.printf("Procurando usuário: %s...\n", user);
        int i;
        for(i = 0; i < users.size(); i++)
        {
            if(user.equals(users.get(i).getUser()))
            {
                System.out.print("Usuário encontrado!\n");
                return i;
            }
            else if (user.equals(users.get(i).getLogin()))
            {
                System.out.print("Login encontrado!\n");
                return i;
            }
        }
        return -1;//nao encontrado
    }

    private static void listuser(ArrayList<Usuario> users)
    {
        System.out.print("Listando usuários...\n");
        int i;
        for(i = 0; i < users.size(); i++)
            System.out.printf("Usuário: %s | Login: %s\n", users.get(i).getUser(), users.get(i).getLogin());
    }

    private static void criarconta(Rede iface)
    {
        in.nextLine();
        System.out.print("Criando nova conta...\n");
        Usuario novo = new Usuario();
        System.out.print("Digite o seu login: ");
        novo.setLogin(in.nextLine());
        System.out.print("Digite a sua senha: ");
        novo.setPassword(in.nextLine());
        System.out.print("Digite o seu nome de Usuário (como você será conhecido na rede): ");
        novo.setUser(in.nextLine());
        iface.getUsers().add(novo);
        System.out.print("Usuário adicionado com sucesso!\n");
    }

    private static void editconta(Usuario user)
    {
        System.out.printf("Editando a conta de: %s...\n", user.getUser());
        System.out.print("Deseja mesmo editar? [1] - Sim | [2] - Não: ");
        if(in.nextInt() == 1)
        {
            System.out.print("Deseja editar seu login? [1] - Sim | [2] - Não: ");
            if(in.nextInt() == 1)
            {
                in.nextLine();
                System.out.print("Digite o novo login: ");
                user.setLogin(in.nextLine());
            }
            else System.out.print("Não editado\n");
            System.out.print("Deseja editar sua senha? [1] - Sim | [2] - Não: ");
            if(in.nextInt() == 1)
            {
                in.nextLine();
                System.out.print("Digite a nova senha: ");
                user.setPassword(in.nextLine());
            }
            else System.out.print("Não editado\n");
            System.out.print("Deseja editar seu nome de Usuário? [1] - Sim | [2] - Não: ");
            if(in.nextInt() == 1)
            {
                in.nextLine();
                System.out.print("Digite o novo nome de Usuário: ");
                user.setUser(in.nextLine());
            }
            else System.out.print("Não editado\n");
        }
        else System.out.print("Edição cancelada!\n");
        System.out.print("Fim da edição!\n");
    }

    private static void envmsg(Usuario rem, Usuario dest)
    {
        System.out.printf("Você está enviando uma mensagem para: %s.\n", dest.getUser());
        System.out.print("Deseja mesmo enviar a mensagem? [1] - Sim | [2] - Não: ");
        if(in.nextInt() == 1)
        {
            in.nextLine();
            System.out.print("Digite a mensagem a ser enviada:\n");
            Mensagem nova = new Mensagem();
            nova.setMsg(in.nextLine());
            nova.setUser(rem.getUser());
            dest.getMsg().add(nova);
            System.out.print("Mensagem enviada com sucesso!\n");
        }
        else System.out.print("Mensagem não enviada!\n");
    }

    private static void criarcomunidade(Rede iface, Usuario adm)
    {
        System.out.print("Criando nova comunidade...\n");
        Comunidade nova = new Comunidade();
        System.out.print("Digite o nome da comunidade: ");
        nova.setNome(in.nextLine());
        System.out.print("Digite a descrição da comunidade: ");
        nova.setDescricao(in.nextLine());
        nova.getMembros().add(adm);
        nova.setAdm(adm.getUser());
        System.out.print("Comunidade criada com sucesso!\n");
        iface.getComunidades().add(nova);
    }

    private static int findcomm(ArrayList<Comunidade> comunidades, String comunidade)
    {
        System.out.printf("Procurando comunidade: %s...\n", comunidade);
        int i;
        for(i = 0; i < comunidades.size(); i++)
        {
            if(comunidade.equals(comunidades.get(i).getNome()))
            {
                System.out.print("Comunidade encontrada!\n");
                return i;
            }
        }
        return -1;//nao encontrado
    }


    private static void addusertocomm(Rede iface, String adm)
    {
        System.out.print("Digite o nome da comunidade que irá receber o novo membro: ");
        int i = findcomm(iface.getComunidades(), in.nextLine());
        int j;
        if(adm.equals(iface.comunidades.get(i).getAdm()))
        {
            System.out.print("Digite o nome do usuário a ser adicionado: ");
            j = finduser(iface.getUsers(), in.nextLine());
            iface.getComunidades().get(i).getMembros().add(iface.getUsers().get(j));
            System.out.print("Usuário adicionado a comunidade com sucesso!\n");
        }
        else System.out.print("Você não é o administrador da comunidade, só administradores podem adicionar novos membros!\n");
    }

    private static void listcomm(ArrayList<String> comunidades)
    {
        System.out.print("Listando comunidades...\n");
        int i;
        for(i = 0; i < comunidades.size(); i++)
            System.out.printf("%s\n", comunidades.get(i));
    }

    private static void listamz(ArrayList<String> users)
    {
        System.out.print("Listando amigos...\n");
        int i;
        for(i = 0; i < users.size(); i++)
            System.out.printf("%s\n", users.get(i));
    }

    private static int msgread(ArrayList<Mensagem> msgs)
    {
        int i = 0;
        for(Mensagem msg: msgs) if(msg.isRead()) i++;
        return i;
    }


    private static void recuperarinfo(ArrayList<Usuario> users, Usuario atual)
    {
        int i;
        System.out.print("Deseja recuperar suas informações [1], ou informações de outro usuário [2]? : ");
        int option = in.nextInt();
        in.nextLine();
        if(option == 1)
        {
            System.out.print("Recuperando suas informações...\n");
            System.out.printf("Nome: %s\nLogin: %s\nSenha: %s\n", atual.getUser(), atual.getLogin(), atual.getPassword());
            listamz(atual.getAmigos());
            listcomm(atual.getComunidades());
            System.out.printf("Você tem um total de %d mensagens, lidas %d, não lidas %d.\n", atual.getMsg().size(), msgread(atual.getMsg()), atual.getMsg().size() - msgread(atual.getMsg()));
            System.out.printf("Você tem %d solicitações de amizade!\n", atual.getSolicitacoes().size());
            System.out.print("Fim!\n");
        }
        else if(option == 2)
        {
            System.out.print("Digite o nome do usuário procurado: ");
            i = finduser(users, in.nextLine());
            System.out.printf("Nome: %s\n", users.get(i).getUser());
            listamz(users.get(i).getAmigos());
            listcomm(users.get(i).getComunidades());
            System.out.print("Fim!\n");
        }
    }

    private static void addamz(Usuario rem, Usuario dest)
    {
        System.out.printf("Deseja realmente enviar um pedido de amizade a: %s? [1] - Sim | [2] - Não: ", dest.getUser());
        if(in.nextInt() == 1) dest.getSolicitacoes().add(rem.getUser());
        else System.out.print("Operação cancelada!\n");
    }

    private static void readmsgs(ArrayList<Mensagem> msgs)
    {
        System.out.print("Deseja ver todas as mensagens? [1]\nOu ver apenas as não lidas? [2]: ");
        int option = in.nextInt();
        if(option == 1)
        {
            System.out.print("Todas as mensagens!\n");
            passmsgs(msgs, true);
        }
        else if(option == 2)
        {
            System.out.print("Apenas mensagens não lidas!\n");
            passmsgs(msgs, false);
        }
    }

    private static void passmsgs(ArrayList<Mensagem> msgs, boolean todas)
    {
        for(Mensagem msg: msgs)
        {
            if(todas)
            {
                System.out.printf("%s\nEnviada por: %s\n\n", msg.getMsg(), msg.getUser());
                if(msg.isRead())
                {
                    System.out.print("Deseja marcar como não lida? [1] - Sim | 2 - Não: ");
                    if(in.nextInt() == 1) msg.setRead(false);
                }
                else
                {
                    System.out.print("Deseja marcar como lida? [1] - Sim | 2 - Não: ");
                    if(in.nextInt() == 1) msg.setRead(true);
                }
            }
            else
            {
                System.out.printf("%s\nEnviada por: %s\n\n", msg.getMsg(), msg.getUser());
                System.out.print("Deseja marcar como lida? [1] - Sim | 2 - Não: ");
                if(in.nextInt() == 1) msg.setRead(true);
            }
        }
    }


    private static void accsamz(ArrayList<Usuario> users, Usuario dest)
    {
        int i, j;
        for (j = 0; j < dest.getSolicitacoes().size(); j++)
        {
            System.out.printf("Solicitação de amizade enviada por: %s. Aceitar - [1] | Rejeitar - [2]: ", dest.getSolicitacoes().get(j));
            if(in.nextInt() == 1)
            {
                System.out.print("Aceita!\n");
                i = finduser(users, dest.getSolicitacoes().get(j));
                dest.getAmigos().add(dest.getSolicitacoes().get(j));
                users.get(i).getAmigos().add(dest.getUser());
            }
            else
            {
                System.out.print("Rejeitado!\n");
            }
            dest.getSolicitacoes().remove(dest.getSolicitacoes().get(j));
        }
    }


    private static void menu(Rede iface)
    {
        int option, i = 0;
        boolean exit = false;
        Usuario logado = null;
        int j;

        while(!exit)
        {
            if(logado == null)
            {
                System.out.print("Nenhum usuário logado! Logue ou crie uma conta!\n");
                System.out.print("Digite:\n");
                System.out.print("[0]  - Sair;\n");
                System.out.print("[1]  - Criar conta;\n");
                System.out.print("[2]  - Logar;\n");

                option = in.nextInt();
                if(option == 0)
                {
                    System.out.print("Saindo!\n");
                    exit = true;
                }
                else if(option == 1)
                {
                    System.out.print("[1]  - Criar conta selecionada!\n");
                    criarconta(iface);
                }
                else if(option == 2)
                {
                    System.out.print("[2]  - Logar selecionada!\n");
                    System.out.print("Deseja listar usuários? [1] - Sim | [2] - Não: ");
                    if(in.nextInt() == 1) listuser(iface.getUsers());
                    in.nextLine();
                    System.out.print("Digite seu login: ");
                    i = finduser(iface.getUsers(), in.nextLine());
                    if(i >= 0)
                    {
                        System.out.print("Digite sua senha: ");
                        if(in.nextLine().equals(iface.getUsers().get(i).getPassword())) logado = iface.getUsers().get(i);
                        else System.out.print("Senha Inválida! Operação cancelada!\n");
                    }
                    else System.out.print("Tentativa de logar falhou (Login inválido), tente novamente!\n");
                }
            }
            else
            {
                System.out.printf("Você está logado como: %s\n", iface.getUsers().get(i).getLogin());
                System.out.print("Gostaria de deslogar? [1] - Sim | [2] - Não: ");
                if(in.nextInt() == 1)
                {
                    System.out.print("Usuário deslogado com sucesso!\n");
                    logado = null;
                }
                else
                {
                    System.out.printf("Você tem um total de %d mensagens, lidas %d, não lidas %d.\n",
                            iface.getUsers().get(i).getMsg().size(), msgread(iface.getUsers().get(i).getMsg()),
                            iface.getUsers().get(i).getMsg().size() - msgread(iface.getUsers().get(i).getMsg()));
                    System.out.print("Gostaria de ler as mensagens? [1] - Sim | [2] - Não: ");
                    if(in.nextInt() == 1) readmsgs(iface.getUsers().get(i).getMsg());

                    System.out.printf("Você tem um total de %d solicitações de amizade.\n", iface.getUsers().get(i).getSolicitacoes().size());
                    System.out.print("Gostaria de ver as solicitações? [1] - Sim | [2] - Não: ");
                    if(in.nextInt() == 1) accsamz(iface.getUsers(), iface.getUsers().get(i));

                    System.out.print("Digite:\n");
                    System.out.print("[0]  - Sair;\n");
                    System.out.print("[2]  - Editar Conta;\n");
                    System.out.print("[3]  - Adição de Amigos;\n");
                    System.out.print("[4]  - Envio de Mensagens;\n");
                    System.out.print("[5]  - Criação de Comunidades;\n");
                    System.out.print("[6]  - Adição de membros a uma comunidade;\n");
                    System.out.print("[7]  - Recuperar Informações sobre um determinado Usuário;\n");
                    System.out.print("[8]  - Remoção de Conta;\n");

                    option = in.nextInt();
                    in.nextLine();
                    if(option == 0)
                    {
                        System.out.print("Saindo\n");
                        exit = true;
                    }
                    else if (option == 2)
                    {
                        System.out.print("[2]  - Editar Conta selecionada!\n");
                        System.out.printf("Editando conta do Usuário logado!\nLogin: %s\nSe deseja editar outro Usuário, por favor logue com uma nova conta!\n", iface.getUsers().get(i).getLogin());
                        editconta(iface.getUsers().get(i));
                        logado = iface.getUsers().get(i);
                    }
                    else if (option == 3)
                    {
                        System.out.print("[3]  - Adição de Amigos selecionada!\n");
                        System.out.print("Digite o nome do usuário que deseja adicionar: ");
                        j = finduser(iface.getUsers(), in.nextLine());
                        if(j >= 0) addamz(iface.getUsers().get(i), iface.getUsers().get(j));
                        else System.out.print("Tente novamente, Usuário não encontrado!\n");

                    }
                    else if (option == 4)
                    {
                        System.out.print("[4]  - Envio de Mensagens selecionada!\n");
                        System.out.print("Digite o nome do destinatário da mensagem: ");
                        j = finduser(iface.getUsers(), in.nextLine());
                        if(j >= 0) envmsg(iface.getUsers().get(i), iface.getUsers().get(j));
                        else System.out.print("Tente novamente, Usuário não encontrado!\n");
                    }
                    else if (option == 5)
                    {
                        System.out.print("[5]  - Criação de Comunidades selecionada!\n");
                        criarcomunidade(iface, iface.getUsers().get(i));
                    }
                    else if (option == 6)
                    {
                        System.out.print("[6]  - Adição de membros a uma comunidade selecionada!\n");
                        addusertocomm(iface, iface.getUsers().get(i).getUser());
                    }
                    else if (option == 7)
                    {
                        System.out.print("[7]  - Recuperar Informações sobre um determinado Usuário selecionada!\n");
                        recuperarinfo(iface.getUsers(), iface.getUsers().get(i));
                    }
                    else if (option == 8)
                    {
                        System.out.print("[8]  - Remoção de Conta selecionada!\n");
                    }
                }
            }
        }
    }


    public static void main(String[] args)
    {
        Rede iface = new Rede();
        menu(iface);
    }
}
