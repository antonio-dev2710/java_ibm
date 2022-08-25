package br.com.antonio.console.models;

import java.util.List;

public class Pedido {

    private Cliente cliente;
    private double valorProdutoFinal;
    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // metodos

    // calcular valor total do pedido
    
    public double valorTotalPed(String valor) {
         valorProdutoFinal = Double.parseDouble(valor);
        this.total += valorProdutoFinal;
        return this.total;
    }

}
