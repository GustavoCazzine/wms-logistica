package br.com.cazzine.main;

import br.com.cazzine.exceptions.PedidoFechadoException;
import br.com.cazzine.exceptions.PedidoVazioException;
import br.com.cazzine.interfaces.Tributavel;
import br.com.cazzine.model.Alimento;
import br.com.cazzine.model.Eletronico;
import br.com.cazzine.model.Pedido;
import br.com.cazzine.model.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaWMS {
    public static void main(String [] args){
        //Lista de pedidos
        List<Pedido> pedidos = new ArrayList<>();
        //Criando Produtos
        Eletronico notebook = new Eletronico("Notebook Samsung", 3500.00);
        Eletronico mouse = new Eletronico("Mouse Gamer", 120.00);
        Alimento feijao = new Alimento("Feijão Carioca", 8.50, LocalDate.of(2026, 12, 1));
        Alimento leite = new Alimento("Leite Integral", 5.00, LocalDate.of(2026, 2, 20));
        //Cenário 1
        Pedido p1 = new Pedido(1001);
        p1.adicionarProduto(notebook);
        p1.adicionarProduto(mouse);
        pedidos.add(p1);
        //Cenario 2
        Pedido p2 = new Pedido(1002);
        pedidos.add(p2);
        //Cenario 3
        Pedido p3 = new Pedido(1003);
        p3.adicionarProduto(feijao);
        p3.avancarStatus(); // Vira EM_SEPARACAO
        p3.avancarStatus(); // Vira EXPEDIDO
        p3.avancarStatus(); // Vira ENTREGUE
        pedidos.add(p3);
        //Cenario 4
        Pedido p4 = new Pedido(1004);
        p4.adicionarProduto(feijao);
        p4.adicionarProduto(leite);
        pedidos.add(p4);

        for (Pedido ped : pedidos){
            try{
                ped.avancarStatus();
            } catch (PedidoVazioException e){
                System.err.println("Erro mudar status: " + e.getMessage());
            }
        }
    }

}
