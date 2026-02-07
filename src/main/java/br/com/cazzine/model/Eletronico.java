package br.com.cazzine.model;

import br.com.cazzine.interfaces.Tributavel;

public class Eletronico extends Produto implements Tributavel {
    //Construtor
    public Eletronico(String nome, double precoCusto) {
        super(nome, precoCusto);


    }
    //Metodo abstrato
    @Override
    public double calcularPrecoVenda() {
        return this.precoCusto * 1.5; //Retorna preço com 50% de lucro sobre o custo.
    }

    //Metodo interface
    @Override
    public double calcularImposto() {
        return this.calcularPrecoVenda() * 0.20; //Retorna o preço com 20% de imposto sobre o preço de custo.
    }
}
