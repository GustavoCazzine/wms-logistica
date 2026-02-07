package br.com.cazzine.model;

abstract class Produto {
    //Atributos
    protected String nome;
    protected double precoCusto;

    //Construtor
    public Produto(String nome, double precoCusto) {
        this.nome = nome;
        this.precoCusto = precoCusto;
    }

    //Metodos Especiais
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    //toString
    @Override
    public String toString() {
        return "Produto: " +
                "Nome: '" + nome + '\'' +
                " | Preço de custo: R$=" + precoCusto;
    }

    //Metodos
    public void calcularPrecoVenda(){}
}
