package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> listaSaida = new ArrayList<>();
		
		System.out.print("Digite o caminho até o arquivo .cvs: ");
		String path = sc.nextLine();
		
		File caminho = new File(path);
		String caminhoStr = caminho.getParent();
		
		boolean novaPasta = new File(caminhoStr+"/out/").mkdirs();
		String arquivoDeEscrita = caminhoStr+"/out/sumarry.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String item = br.readLine();
			
			while(item != null) {
				
				String[] dados = item.split(",");
				String produto = dados[0];
				double preco = Double.parseDouble(dados[1]);
				int quantidade = Integer.parseInt(dados[2]);
				
				
				listaSaida.add(new Product(produto, quantidade, preco));
				item = br.readLine();
			}
			
			try(BufferedWriter bf = new BufferedWriter(new FileWriter(arquivoDeEscrita))){
				
				for(Product itemSaida: listaSaida) {
					bf.write(itemSaida.getProduto());
					bf.write(",");
					bf.write(String.format("%.2f", itemSaida.total()));
					bf.newLine();
				}
			}
			catch (IOException erroEscrita) {
				System.err.println("Erro de escrita: " +erroEscrita.getMessage());
			}
		}
		catch(IOException errorLeitura) {
			System.err.println("Erro de leitura: " +errorLeitura.getMessage());	
		}
		sc.close();
	}

}
