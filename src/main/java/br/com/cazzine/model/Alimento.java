package br.com.cazzine.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimento extends Produto{
    //Atributos
    private LocalDate dataValidade;

    //Construtor
    public Alimento(String nome, double precoCusto, LocalDate dataValidade) {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + "| Data de Validade: " + dataValidade.format(formatter);
    }
}
