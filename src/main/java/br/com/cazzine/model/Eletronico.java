package br.com.cazzine.model;

public class Eletronico extends Produto{
    //Construtor
    public Eletronico(String nome, double precoCusto) {
        super(nome, precoCusto);


    }
    //Metodo abstrato
    @Override
    public double calcularPrecoVenda() {
        return this.precoCusto * 1.5; //Retorna preço com 50% de lucro sobre o custo.
    }
}
