package br.com.cazzine.model;

import br.com.cazzine.enums.StatusPedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //Atributos
    private int codigo;
    private StatusPedido status;
    private List<Produto> itens = new ArrayList<>();

    //Construtor
    public Pedido(int codigo) {
        this.codigo = codigo;
        this.status = StatusPedido.PENDENTE;
    }

    //Metodos
    public boolean adicionarProduto(Produto produto){
        return itens.add(produto);
    }

    public void avancarStatus(){
        switch (this.status){
            case PENDENTE:
                this.status = StatusPedido.EM_SEPARACAO;
            case EM_SEPARACAO:
                this.status = StatusPedido.EXPEDIDO;
        }
    }

    public void exibirNotaFiscal(){
        for (Produto prod : itens){
            System.out.printf("Codigo do Pedido: %d | Status Atual: %s | Valor Total: R$%.2f", this.codigo, this.status, prod.calcularPrecoVenda());
        }

    }
}
