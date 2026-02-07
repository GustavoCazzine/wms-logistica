package br.com.cazzine.model;

public class Alimento extends Produto{
    //Atributos
    private String dataValidade;

    //Construtor
    public Alimento(String nome, double precoCusto, String dataValidade) {
        super(nome, precoCusto);
        this.dataValidade = dataValidade;
    }

    //Metodo abstrato
    @Override
    public double calcularPrecoVenda() {
        return this.precoCusto * 1.1; //Retorna preço com 10% de lucro sobre o custo.
    }

    @Override
    public String toString() {
        return super.toString() + "| Data de Validade: " + dataValidade;
    }
}
