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
            System.out.print("Deseja adicionar um livro ou dvd?: ");
            if(in.nextLine().equalsIgnoreCase("DVD")){
                DVD dvd = new DVD();
                System.out.print("Título: ");
                dvd.setTitulo(in.nextLine());
                System.out.print("Gênero: ");
                dvd.setGenero(in.nextLine());
                System.out.print("Valor: R$");
                dvd.setValor(in.nextDouble());
                in.nextLine();
                System.out.print("Ano de lançamento: ");
                dvd.setAnoLancamento(in.nextInt());
                in.nextLine();
                System.out.print("Nome do diretor: ");
                dvd.setDiretor(in.nextLine());
                System.out.print("Duração: ");
                dvd.setDuracao(in.nextDouble());
                in.nextLine();
                e.adicionarItem(dvd);
            } else {
                Livro livro = new Livro();
                System.out.print("Título: ");
                livro.setTitulo(in.nextLine());
                System.out.print("Gênero: ");
                livro.setGenero(in.nextLine());
                System.out.print("Valor: R$");
                livro.setValor(in.nextDouble());
                in.nextLine();
                System.out.print("Autor: ");
                livro.setAutor(in.nextLine());
                System.out.print("Ano de publicação: ");
                livro.setAnoPublicacao(in.nextInt());
                in.nextLine();
                System.out.print("Quantidade de páginas: ");
                livro.setQtdePaginas(in.nextInt());
                in.nextLine();
                System.out.print("Edição: ");
                livro.setEdicao(in.nextInt());
                in.nextLine();
                e.adicionarItem(livro);
            }
        }
        System.out.println("-------ITENS DA ESTANTE--------");
        for (Item i : e.getItems()){
            if(i instanceof Livro){
                System.out.println("        LIVRO");
            } else if (i instanceof DVD) {
                System.out.println("          DVD");
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
            System.out.print("Deseja avaliar algum item? Se sim, diga seu título,\nsenão, digite 0: ");
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
