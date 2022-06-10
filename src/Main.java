import classes.DVD;
import classes.Item;
import classes.Livro;
import classes.estante.Estante;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("---CRIE UMA ESTANTE VIRTUAL---");
        System.out.print("Deseja informar quantos itens?: ");
        int numItens = in.nextInt();
        in.nextLine();
        Estante e = new Estante(numItens);
        for(int i = 0; i<numItens;i++){
            Item item;
            System.out.print("Deseja adicionar um livro ou dvd?: ");
            String add = in.nextLine();
            if(add.equalsIgnoreCase("DVD")){
                item = new DVD();
                System.out.print("Título: ");
                item.setTitulo(in.nextLine());
                System.out.print("Gênero: ");
                item.setGenero(in.nextLine());
                System.out.print("Valor: R$");
                item.setValor(in.nextDouble());
                in.nextLine();
                System.out.print("Ano de lançamento: ");
                ((DVD)item).setAnoLancamento(in.nextInt());
                in.nextLine();
                System.out.print("Nome do diretor: ");
                ((DVD) item).setDiretor(in.nextLine());
                System.out.print("Duração: ");
                ((DVD) item).setDuracao(in.nextDouble());
                in.nextLine();
                e.adicionarItem(item);
                System.out.print("Deseja avaliar a obra '"+item.getTitulo()+"' agora? (S/N): ");
                if(in.nextLine().equalsIgnoreCase("s")){
                    item.avaliar();
                }
            } else if(add.equalsIgnoreCase("Livro")){
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
                e.adicionarItem(item);
                System.out.print("Deseja avaliar a obra '"+item.getTitulo()+"' agora? (S/N): ");
                if(in.nextLine().equalsIgnoreCase("s")){
                    item.avaliar();
                }
            }
        }
        System.out.println("-------ITENS DA ESTANTE--------");
        for (Item i : e.getItems()){
            if(i instanceof Livro){
                System.out.println("            LIVRO");
            } else if (i instanceof DVD) {
                System.out.println("             DVD");
            }
            System.out.print("Título: ");
            System.out.println(i.getTitulo());
            System.out.print("Gênero: ");
            System.out.println(i.getGenero());
            System.out.print("Valor: R$");
            System.out.println(i.getValor());
            if(i instanceof Livro){
                System.out.print("Autor: ");
                System.out.println(((Livro) i).getAutor());
                System.out.print("Ano de publicação: ");
                System.out.println(((Livro) i).getAnoPublicacao());
                System.out.print("Quantidade de Páginas: ");
                System.out.println(((Livro) i).getQtdePaginas());
                System.out.print("Edição: ");
                System.out.println(((Livro) i).getEdicao());
            }
            if(i instanceof DVD){
                System.out.print("Ano de lançamento: ");
                System.out.println(((DVD) i).getAnoLancamento());
                System.out.print("Diretor: ");
                System.out.println(((DVD) i).getDiretor());
                System.out.print("Duração: ");
                System.out.println(((DVD) i).getDuracao());
            }
            System.out.println("-------------------------------");
        }
        while (true){
            System.out.print("Deseja avaliar algum item? Se sim, diga sua posição,\nsenão, digite 0: ");
            int pos = in.nextInt();
            in.nextLine();
            if(pos==0){
                break;
            }
            e.getItems()[pos-1].avaliar();
            System.out.print("Nota média: ");
            System.out.println(e.getItems()[pos-1].getTotalRating());
        }
    }
}
