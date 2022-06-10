package classes.estante;

import classes.Item;

import java.util.Locale;

public class Estante {
    private int capMaxima;
    private Item[] items;

    public Estante(int capMaxima) {
        setCapMaxima(capMaxima);
        setItems(new Item[capMaxima]);
    }

    public boolean estanteCheia() {
        return this.quantidadeItens() == this.getCapMaxima();
    }

    public int quantidadeItens() {
        int contador = 0;
        for (Item i : this.getItems()) {
            if (i != null) {
                contador++;
            }
        }
        return contador;
    }

    public Item buscarItem(String titulo) {
        for (Item i : this.getItems()) {
            if (i != null && i.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return i;
            }
        }
        return null;
    }

    public boolean adicionarItem(Item item) {
        for (int i = 0; i < this.getItems().length; i++) {
            if (this.getItems()[i] == null) {
                this.getItems()[i] = item;
                return true;
            }
        }
        return false;
    }

    public Item removerItem(int posicao) {
        Item i = this.getItems()[posicao];
        this.getItems()[posicao] = null;
        return i;
    }

    //GETTERS & SETTERS

    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}
