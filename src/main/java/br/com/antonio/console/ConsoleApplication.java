package br.com.antonio.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication {
	/**
	 * @throws InterruptedException
	 * 
	 */
	public static void esperar(int segundos) throws InterruptedException {
		TimeUnit.SECONDS.sleep(segundos);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// limpa as opções
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		Scanner scan = new Scanner(System.in);

		boolean sair = false;
		int opcao = 0;
		List<String> produtos = new ArrayList<>();
		List<String> precoProdutos = new ArrayList<>();
		List<String> pedidos = new ArrayList<>();
		List<String> cleintes = new ArrayList<>();

		String nomeFrunta = null, nomecliente;
		String valorProduto;
		double precoCdProduto = 0;
		int qtdDeFrutasCliente = 0, qtdFrutasCadastro = 0, j = 0;
		double total = 0;

		int ecolhaFruta = 0, i = 0;
		while (!sair) {
			System.out.println("-----------------------");
			System.out.println(
					" 1- Cadastrar produtos" + "\n" +
							"2 - Vender produtos (Criar pedidos, com clientes)" + "\n" +
							"3 - Mostrar relatório dos mesmos" + "\n" +
							"4 - Sair do programa"

			);
			System.out.println("Digite uma opcao");
			opcao = scan.nextInt();

			switch (opcao) {

				case 1:
					System.out.println("Digite primeiro a quantidade de produtos que deseja cadastrar: ");
					qtdFrutasCadastro = scan.nextInt();

					System.out.println("Agora digite o nome de  " + qtdFrutasCadastro + " produtos");
					for (i = 0; i < qtdFrutasCadastro; i++) {

						nomeFrunta = scan.next();
						produtos.add(nomeFrunta);
					}
					System.out.println("Lista de frutas cadastradas: ");
					for (i = 0; i < produtos.size(); i++) {

						System.out.println(produtos.get(i));

					}

					System.out.println("Produtos cadastrado comsucesso! ");
					esperar(2);

					for (i = 0; i < produtos.size(); i++) {

						System.out.println("Digite o valor do(a): " + produtos.get(i));
						precoCdProduto = scan.nextDouble();// floating literal is double by default
						valorProduto = String.valueOf(precoCdProduto);

						precoProdutos.add(valorProduto);

					}

					break;

				case 2:
					System.out.println("Opcao de frutas: ");

					for (i = 0; i < produtos.size(); i++) {

						System.out.println(produtos.get(i) + "------------" + precoProdutos.get(i));

					}

					System.out.println(" Digite o nome do cliente");
					nomecliente = scan.next();
					cleintes.add(nomecliente);

					System.out.println(cleintes.get(j) + " digite a quantidade de produtos");
					qtdDeFrutasCliente = scan.nextInt();

					System.out.println(" Digite o número do pedido de 1 a " + produtos.size());
					for (i = 0; i < qtdDeFrutasCliente; i++) {

						ecolhaFruta = scan.nextInt();
						ecolhaFruta -= 1;
						// valor total do pedido
						valorProduto = precoProdutos.get(ecolhaFruta);
						double valorProdutoFinal = Double.parseDouble(valorProduto);
						total += valorProdutoFinal;
						// lista pedido
						String pedidoCliente = produtos.get(ecolhaFruta);
						pedidos.add(pedidoCliente);
					}

					break;

				case 3:
					System.out.println("============Relatório========== ");
					for (i = 0; i < produtos.size(); i++) {

						System.out.println(produtos.get(i));

					}
					System.out.println("Nome do cliente" + ": " + cleintes.get(j));
					System.out.println("===========Lista de pedido ============ ");
					for (i = 0; i < qtdDeFrutasCliente; i++) {

						System.out.println(pedidos.get(i));

					}
					System.out.println("===========Total a pagar ============ ");
					System.out.println("Total a pagar :" + "R$" + total);

					break;

				case 4:
					System.out.println("Operação finalizada, volte sempre!!! :) ");
					sair = true;

			}

		}
		// SpringApplication.run(ConsoleApplication.class, args);

	}

}
