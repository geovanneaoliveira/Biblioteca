import classes.DVD;
import classes.Item;
import classes.Livro;
import classes.estante.Estante;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static Estante e = new Estante(5);

    public static void main(String[] args) {
        System.out.println("-------ESTANTE VIRTUAL-------");
        while (true) {
            System.out.println();
            System.out.println("(1) Adicionar item na estante");
            System.out.println("(2) Buscar item na estante");
            System.out.println("(3) Remover item da estante");
            System.out.println("(4) Mostrar itens da estante");
            System.out.println("(0) Sair");
            System.out.print("Escolha: ");
            int escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    buscarItem();
                    break;
                case 3:
                    removerItem();
                    break;
                case 4:
                    mostrarItens();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Escolha inválida!");
            }
            if(escolha==0){
                System.out.print("Obrigado por usar a estante virtual!");
                break;
            }
        }
        /*while (true) {
            System.out.print("Deseja avaliar algum item? Se sim, diga sua posição,\nsenão, digite 0: ");
            int pos = in.nextInt();
            in.nextLine();
            if (pos == 0) {
                break;
            }
            e.getItems()[pos - 1].avaliar();
            System.out.print("Nota média: ");
            System.out.println(e.getItems()[pos - 1].getTotalRating());
        }*/
    }

    public static void adicionarItem() {
        Item item;
        System.out.print("Deseja adicionar um livro ou dvd?: ");
        String add = in.nextLine();
        if (add.equalsIgnoreCase("DVD")) {
            item = new DVD();
            System.out.print("Título: ");
            item.setTitulo(in.nextLine());
            System.out.print("Gênero: ");
            item.setGenero(in.nextLine());
            System.out.print("Valor: R$");
            item.setValor(in.nextDouble());
            in.nextLine();
            System.out.print("Ano de lançamento: ");
            ((DVD) item).setAnoLancamento(in.nextInt());
            in.nextLine();
            System.out.print("Nome do diretor: ");
            ((DVD) item).setDiretor(in.nextLine());
            System.out.print("Duração: ");
            ((DVD) item).setDuracao(in.nextDouble());
            in.nextLine();
            if(!e.adicionarItem(item)){
                System.out.println("O item não foi adicionado!");
            }
        } else if (add.equalsIgnoreCase("Livro")) {
            item = new Livro();
            System.out.print("Título: ");
            item.setTitulo(in.nextLine());
            System.out.print("Gênero: ");
            item.setGenero(in.nextLine());
            System.out.print("Valor: R$");
            item.setValor(in.nextDouble());
            in.nextLine();
            System.out.print("Autor: ");
            ((Livro) item).setAutor(in.nextLine());
            System.out.print("Ano de publicação: ");
            ((Livro) item).setAnoPublicacao(in.nextInt());
            in.nextLine();
            System.out.print("Quantidade de páginas: ");
            ((Livro) item).setQtdePaginas(in.nextInt());
            in.nextLine();
            System.out.print("Edição: ");
            ((Livro) item).setEdicao(in.nextInt());
            in.nextLine();
            if(!e.adicionarItem(item)){
                System.out.println("O item não foi adicionado!");
            }
        }
    }

    public static void buscarItem() {
        System.out.print("Informe o título da obra: ");
        String titulo = in.nextLine();
        int contador = 1;
        for (Item i : e.getItems()) {
            if (i != null && i.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println("------------------------");
                System.out.println("Posição na estante: " +contador);
                System.out.println("Título: " + i.getTitulo());
                System.out.println("Gênero: " + i.getGenero());
                System.out.println("Valor: R$" + i.getValor());
                if (i instanceof DVD) {
                    System.out.print("Ano de lançamento: ");
                    System.out.println(((DVD) i).getAnoLancamento());
                    System.out.print("Diretor: ");
                    System.out.println(((DVD) i).getDiretor());
                    System.out.print("Duração: ");
                    System.out.println(((DVD) i).getDuracao());
                } else if (i instanceof Livro) {
                    System.out.print("Autor: ");
                    System.out.println(((Livro) i).getAutor());
                    System.out.print("Ano de publicação: ");
                    System.out.println(((Livro) i).getAnoPublicacao());
                    System.out.print("Quantidade de Páginas: ");
                    System.out.println(((Livro) i).getQtdePaginas());
                    System.out.print("Edição: ");
                    System.out.println(((Livro) i).getEdicao());
                }
                System.out.println("------------------------");
                System.out.println("(1) Avaliar '" + i.getTitulo() + "'");
                System.out.println("(2) Ver as avaliações de '" + i.getTitulo() + "'");
                System.out.println("(3) Voltar ao menu");
                System.out.print("Escolha: ");
                int escolha = in.nextInt();
                in.nextLine();
                if (escolha == 1) {
                    i.avaliar();
                    break;
                } else if (escolha == 2) {
                    i.getAvaliacoes();
                    break;
                } else {
                    break;
                }
            }
            contador++;
        }
        if(contador==5){
            System.out.println("Item não encontrado!");
        }
    }

    public static void removerItem() {
        System.out.print("Qual o título da obra que deseja remover: ");
        String titulo = in.nextLine();
        for (int i = 0; i < e.getCapMaxima(); i++) {
            if (e.getItems()[i] != null && e.getItems()[i].getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                e.getItems()[i] = null;
                System.out.println("Obra removida!");
                break;
            }
            if (i == 4) {
                System.out.println("A obra não existe na estante!");
            }
        }
    }

    public static void mostrarItens() {
        int contador = 1;
        for (Item i : e.getItems()) {
            if (i != null) {
                System.out.println("------------------------");
                System.out.println("Posição na estante: " + contador);
                System.out.println("Título: " + i.getTitulo());
                System.out.println("Gênero: " + i.getGenero());
                System.out.println("Valor: R$" + i.getValor());
                if (i instanceof DVD) {
                    System.out.print("Ano de lançamento: ");
                    System.out.println(((DVD) i).getAnoLancamento());
                    System.out.print("Diretor: ");
                    System.out.println(((DVD) i).getDiretor());
                    System.out.print("Duração: ");
                    System.out.println(((DVD) i).getDuracao());
                } else if (i instanceof Livro) {
                    System.out.print("Autor: ");
                    System.out.println(((Livro) i).getAutor());
                    System.out.print("Ano de publicação: ");
                    System.out.println(((Livro) i).getAnoPublicacao());
                    System.out.print("Quantidade de Páginas: ");
                    System.out.println(((Livro) i).getQtdePaginas());
                    System.out.print("Edição: ");
                    System.out.println(((Livro) i).getEdicao());
                }
                System.out.println("------------------------");
            }
        }
    }
}
