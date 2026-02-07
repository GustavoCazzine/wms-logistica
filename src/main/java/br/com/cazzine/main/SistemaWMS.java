package br.com.cazzine.main;

import br.com.cazzine.interfaces.Tributavel;
import br.com.cazzine.model.Alimento;
import br.com.cazzine.model.Eletronico;
import br.com.cazzine.model.Pedido;
import br.com.cazzine.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class SistemaWMS {
    public static void main(String [] args){
        Eletronico p1 = new Eletronico("Notebook Dell", 3000.0);
        Alimento p2 = new Alimento("Arroz tio João", 20.0, "10/2026");

        Pedido pedido1001 = new Pedido(1001);

        pedido1001.adicionarProduto(p1);
        pedido1001.adicionarProduto(p2);
        pedido1001.avancarStatus();
        pedido1001.avancarStatus();

        pedido1001.exibirNotaFiscal();


        List<Tributavel> auditoria = new ArrayList<>();

        auditoria.add(p1);

        for (Tributavel tr: auditoria){
            System.out.printf("Imposto: R$%.2f %n", tr.calcularImposto());
        }


    }

}
