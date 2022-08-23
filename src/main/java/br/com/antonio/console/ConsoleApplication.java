package br.com.antonio.console;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean sair = false;
		int opcao = 0;
		String[] listaDeFrutas = new String[5];
		String[] listaDePedidos = new String[5];
		String nomeDoCliente = null;
		String nomeFrunta;
		int qtdDeFrutas = 0, total = 0, preco = 0;

		int ecolhaFrunta = 0, j = 0;
		while (!sair) {
			System.out.println("-----------------------");
			System.out.println(
					" 1- Cadastrar produtos" + "\n" +
							"2 - Vender produtos (Criar pedidos, com clientes)" + "\n" +
							"3 - Mostrar relatório dos mesmos"

			);
			System.out.println("Digite uma opcao");
			opcao = scan.nextInt();

			switch (opcao) {

				case 1:
					System.out.println("Digite os produtos que de seja: ");
					for (int i = 0; i < listaDeFrutas.length; i++) {
						listaDeFrutas[i] = scan.next();
					}
					// bloco de código que será ex.ecutado

					break;

				case 2:
					System.out.println("Opcao de frutas: ");

					for (int i = 0; i < listaDeFrutas.length; i++) {
						System.out.println(listaDeFrutas[i]);
					}

					System.out.println("Digite o nome do cliente: ");
					nomeDoCliente = scan.next();

					System.out.println(nomeDoCliente + "Escolha a quantida de de frutas: ");
					qtdDeFrutas = scan.nextInt();
					// lsita de pedido
					// numero de frutas e um cliente
					listaDePedidos = new String[qtdDeFrutas];

					for (int i = 0; i < listaDePedidos.length; i++) {

						System.out.println(
								nomeDoCliente + "Escolha as opções de frutas digitando um número de um até cinco: ");
						ecolhaFrunta = scan.nextInt();
						if (ecolhaFrunta == 1) {
							preco = 5;

						} else if (ecolhaFrunta == 1) {
							preco = 1;
						} else if (ecolhaFrunta == 2) {
							preco = 2;
						} else if (ecolhaFrunta == 3) {
							preco = 6;
						} else if (ecolhaFrunta == 4) {
							preco = 8;
						} else {
							preco = 3;
						}
						total += preco;

						ecolhaFrunta -= 1;
						nomeFrunta = listaDeFrutas[ecolhaFrunta];
						listaDePedidos[i] = nomeFrunta;
					}

					break;

				case 3:
					System.out.println("============Relatório======= ");
					for (String lista : listaDeFrutas) {
						System.out.println(lista);
					}
					System.out.println("Nome do cliente" + ": " + nomeDoCliente);
					System.out.println("===========Lista de pedido ============ ");
					for (int i = 0; i < listaDePedidos.length; i++) {

						System.out.println(listaDePedidos[i]);

					}
					System.out.println("Total a pagar :"+"R$"+total);
					sair = true;

			}
		}
		// SpringApplication.run(ConsoleApplication.class, args);

	}

}
