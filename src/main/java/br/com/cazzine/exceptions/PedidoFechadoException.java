package br.com.cazzine.exceptions;

public class PedidoFechadoException extends RuntimeException{
    public PedidoFechadoException(String mensagem){
        super(mensagem);
    }
}
