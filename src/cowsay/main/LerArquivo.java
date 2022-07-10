package cowsay.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {

	private static String cowPath = "../resources/cow/$cow.txt";
	private static String preferenciasPath = "../resources/preferencias.txt";
	private static String constantesPath = "../resources/constantes.txt";

	private List<String> obterPersonagem() {
		String preferencia = obterPreferencia();
		List<String> personagem = this.leitura(cowPath.replace("$cow", preferencia));
		return personagem;
	}

	private String obterPreferencia() {
		List<String> preferencia = this.leitura(preferenciasPath);
		return preferencia.get(0);
	}

	private List<String> leitura(String path) {
		List<String> arrayString = new ArrayList<>(Arrays.asList());

		URL url = getClass().getResource(path);

		File file = new File(url.getPath());
		Scanner sc = null;
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				arrayString.add(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		return arrayString;
	}

	public void mostrar(String frase) {
		List<String> personagem = obterPersonagem();

		List<String> balao = new ArrayList<String>();

		String cima = "";
		String baixo = "-";
		
		for(int i = 0; i <= frase.length(); i++) {
			cima = cima.concat("_");
			baixo = baixo.concat("-");
		}
		
		balao.add(0," " + cima + " ");
		balao.add(1,"< " + frase + " >");
		balao.add(2," " + baixo + " ");
		
		for (String b : balao) {
			System.out.println(b);
		}
		
		for (String p : personagem) {
			p = p.replace("$frase", frase);

			System.out.println(p);
		}

	}
}
