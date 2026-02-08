package br.com.cazzine.model;

import br.com.cazzine.enums.StatusPedido;
import br.com.cazzine.exceptions.PedidoFechadoException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    //Atributos
    private int codigo;
    private StatusPedido status;
    private List<Produto> itens = new ArrayList<>();
    private LocalDateTime dataCriacao;

    //Construtor
    public Pedido(int codigo) {
        this.codigo = codigo;
        this.status = StatusPedido.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
    }

    //Metodos
    public boolean adicionarProduto(Produto produto){
        if(this.status != StatusPedido.PENDENTE){
            throw new PedidoFechadoException("Não é possível adicionar produtos. O pedido está " + this.status);
        }

        return itens.add(produto);
    }

    public void avancarStatus(){
        switch (this.status){
            case PENDENTE:
                this.status = StatusPedido.EM_SEPARACAO;
                break;
            case EM_SEPARACAO:
                this.status = StatusPedido.EXPEDIDO;
                break;
            case EXPEDIDO:
                this.status = StatusPedido.ENTREGUE;
                break;
        }
    }

    public void exibirNotaFiscal(){
        double total = 0.0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("--- Nota Fiscal (Pedido " + this.codigo + ") ---");
        System.out.println("Status: " + this.status);
        System.out.println("Data: " + this.dataCriacao.format(formatter));

        for (Produto prod : itens) {
            total += prod.calcularPrecoVenda();
            System.out.println("- " + prod.getNome() + ": R$ " + prod.calcularPrecoVenda());
        }

        System.out.printf("Valor Total do Pedido: R$ %.2f %n", total);
        System.out.println("----------------------------------");

    }
}
