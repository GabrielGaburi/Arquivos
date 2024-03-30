package Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Produto;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);

		List<Produto> lista = new ArrayList<>();

		System.out.println("Entre com o caminho do arquivo: ");
		String procurarArquivoStr = leia.nextLine();

		File procurarArquivo = new File(procurarArquivoStr);
		String procurarPastaStr = procurarArquivo.getParent();

		boolean sucesso = new File(procurarPastaStr + "\\out").mkdir();

		String caminhoArquivoStr = procurarPastaStr + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(procurarArquivoStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] campos = itemCsv.split(" , ");
				String nome = campos[0];
				Double preco = Double.parseDouble(campos[1]);
				Integer quant = Integer.parseInt(campos[2]);

				lista.add(new Produto(nome, preco, quant));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivoStr))) {

				for (Produto item : lista) {
					bw.write(item.getNome() + ", " + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(caminhoArquivoStr + "criado");

			} catch (IOException e) {
				System.out.println("Errona criação do arquivo" + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo" + e.getMessage());
		}

		leia.close();

	}

}
