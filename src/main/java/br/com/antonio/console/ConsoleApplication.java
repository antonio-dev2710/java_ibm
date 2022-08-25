package br.com.antonio.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.antonio.console.models.Cliente;
import br.com.antonio.console.models.Fruta;
import br.com.antonio.console.models.Pedido;

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
		List<Fruta> produtos = new ArrayList<>();
		List<Fruta> precoProdutos = new ArrayList<>();
		List<Cliente> cleintes = new ArrayList<>();
		List<String> auxPedido = new ArrayList<>();
		String nomeFrunta = null, valorProdBruto = null, nomeCl;

		double total = 0;
		int qtdDeFrutasCliente = 0, qtdFrutasCadastro = 0,
				j = 0, ecolhaFruta = 0;

		// instcacia do objeto
		Pedido pedido = new Pedido();
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

					for (int i = 0; i < qtdFrutasCadastro; i++) {
						Fruta cadastrofruta = new Fruta();

						System.out.println("Agora digite o nome do  " + " produto "+ i);
						nomeFrunta = scan.next();
						cadastrofruta.setNome(nomeFrunta);
						produtos.add(cadastrofruta);

						System.out.println("Produtos cadastrado comsucesso! ");
						esperar(2);

						System.out.println("Digite o valor do(a): " + produtos.get(i).getNome());
						// floating literal is double by default
						do{
							System.out.println("Se for numero decimal coloque o '.' ");
							valorProdBruto = scan.next();
						   
						   
					   	}while(valorProdBruto .contains(".")==false);

						
						cadastrofruta.setPrecoCdFruta(valorProdBruto);
						// método
						precoProdutos.add(cadastrofruta);

					}

					break;

				case 2:
					System.out.println("Opcao de frutas: ");

					for (int i = 0; i < produtos.size(); i++) {

						System.out.println(produtos.get(i).getNome() + "----------------" +
								precoProdutos.get(i).getPrecoCdFruta());

					}

					System.out.println(" Digite o nome do cliente");
					Cliente nomeCliente = new Cliente();
					nomeCl = scan.next();
					nomeCliente.setNomeCliente(nomeCl);

					cleintes.add(nomeCliente);

					System.out.println(cleintes.get(j).getNomeCliente() + " digite a quantidade de produtos");
					qtdDeFrutasCliente = scan.nextInt();

					
					pedido.setCliente(nomeCliente);
					

					System.out.println(" Digite o número do pedido de 1 a " + produtos.size());
					for (int i = 0; i < qtdDeFrutasCliente; i++) {

						ecolhaFruta = scan.nextInt();
						ecolhaFruta -= 1;
						// valor total do pedido
						String valorCdPedido = precoProdutos.get(ecolhaFruta).getPrecoCdFruta();
							System.out.println(valorCdPedido );
							//converter de String para numero

						total = pedido.valorTotalPed(valorCdPedido);

						// lista pedido
						String produtoDoCliente = produtos.get(ecolhaFruta).getNome();
						auxPedido.add(produtoDoCliente);

					}

					break;

				case 3:
					System.out.println("============Relatório========== ");
					for (int i = 0; i < produtos.size(); i++) {

						System.out.println(produtos.get(i).getNome());

					}
					System.out.println("Nome do cliente" + ": " + pedido.getCliente().getNomeCliente());
					System.out.println("===========Lista de pedido ============ ");
					for (int i = 0; i < auxPedido.size(); i++) {

						System.out.println(auxPedido.get(i));

					}
					System.out.println("===========Total a pagar ============ ");
					System.out.println("Total a pagar :" + "R$" + total);

					break;
				case 4:
					System.out.println("Vc finalizou a operação :)! ");
					sair = true;

				break;

			}

		}
		// SpringApplication.run(ConsoleApplication.class, args);
	}
}
