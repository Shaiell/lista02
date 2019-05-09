package lista03;

/**
 * Classe criada para resolução da lista 03 de exercicios.
 * 
 * @author jean.ribeiro
 *
 */
public class Principal {

	/**
	 * Função para inicialização dos exercicios.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String[] exercicio = { "Mostrar Vetor", "Maior Elemento", "Elementos Repitidos" };

		boolean repitir = true;

		do {
			int menu = Console.mostrarMenu(exercicio, "lista02", null);
			switch (menu) {

			case 1:
				int[] lista = criarVetor();
				mostrarVetor(lista);
				break;

			case 2:
				int[] lista1 = criarVetor();
				int maior = Exercicio.maiorElemento(lista1);
				System.out.println("O valor maior é: " + maior);
				break;

			case 3:
				elementosRepitidos();

				break;

			case -1:
				System.out.println("Saindo...");
				repitir = false;
				break;
			}
		} while (repitir == true);

	}

	/**
	 * Cria um vetor de inteiros
	 * 
	 * @return um vetor inteiro
	 */
	public static int[] criarVetor() {
		int quantidade = Console.recuperaInteiro("Informe a quantidade de posições: ");
		int[] vetor = new int[quantidade];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = Console.recuperaInteiro("Informe o valor " + (i + 1) + ":");
		}
		return vetor;
	}

	/**
	 * Imprime um vetor primitivo de inteiros na tela
	 * 
	 * @param vetor de inteiros a ser impresso.
	 */
	public static void mostrarVetor(int[] vetor) {
		if (vetor.length == 0) {
			System.out.println("[]");
		} else if (vetor.length == 1) {
			System.out.println("[" + vetor[0] + "]");
		} else {
			System.out.print("[");
			for (int i = 0; i < vetor.length - 1; i++) {
				System.out.print(vetor[i] + ",");
			}
			System.out.println(vetor[vetor.length - 1] + "]");
		}
	}

	/**
	 * Verifica valores repitidos em um vetor
	 */
	public static void elementosRepitidos() {

		int[] vetor = criarVetor();
		int[][] repetidos = Exercicio.verificarRepitidos(vetor);
		System.out.print("[");
		for (int i = 0; i < repetidos.length; i++) {
			int[] repetido = repetidos[i];
			System.out.print("\t");
			mostrarVetor(repetido);
		}
		System.out.println("]");
	}

}
