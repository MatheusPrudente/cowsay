package cowsay.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LerArquivo ler = new LerArquivo();

		try (Scanner s = new Scanner(System.in)) {
			String frase = s.nextLine();
			ler.mostrar(frase);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
