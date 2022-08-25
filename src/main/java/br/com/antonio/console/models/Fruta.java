package br.com.antonio.console.models;

import java.util.List;
import java.util.Scanner;

public class Fruta {
    Scanner scan = new Scanner(System.in);

    private String nome;
    private String precoCdFruta;
    
   

    
    

    public String getPrecoCdFruta() {
        return precoCdFruta;
    }

    public void setPrecoCdFruta(String precoCdFruta) {
        this.precoCdFruta = precoCdFruta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   


}
