package lista03;

/**
 * Classe para executar os calculos dos exercicios da lista 01.
 * 
 * @author jean ribeiro
 *
 */
public class Exercicio {

	/**
	 * Identifica o maior elemento do vetor.
	 * 
	 * @param vetor informado para analise do maior elemento
	 * @return o maior elemento do vetor.
	 */
	public static int maiorElemento(int[] vetor) {

		int maior = vetor[0];

		for (int i = 0; i < vetor.length; i++) {
			if (maior < vetor[i]) {
				maior = vetor[i];
			}
		}

		return maior;
	}

	/**
	 * Identifica os elementos repitidos e retorno os dois valores, a saber: no
	 * indice 0 � a quantidade de ocorrencias, no indice 1 � o elemento avaliado.
	 * 
	 * @param valores para serem avaliados quanto a repeti��o.
	 * @return Vetor com os valores e quantidade de repitidos.
	 */
	public static int[][] verificarRepitidos(int[] valores) {
		int[][] repetidos = new int[0][2];
		int[] avaliados = new int[0];

		for (int i = 0; i < valores.length; i++) {
			// seria bem legal...
			int avaliado = valores[i];
			if (precisaAvaliar(avaliado, avaliados)) {
				avaliados = adcionarAvaliados(avaliado, avaliados);
				int ocorrencias = contarOcorrencias(avaliado, valores);
				if (ocorrencias > 1) {
					// houve repeti��es.
					int[] numerosRepetem = { ocorrencias, avaliado };
					repetidos = adicionarRepetidos(numerosRepetem, repetidos);

				}
			}
		}

		return repetidos;
	}

	/**
	 * Fun��o que verifica se � preciso avaliar um valor de repeti��o
	 * 
	 * @param avaliado  Valor a ser testado
	 * @param avaliados vetor dos valores ja avaliados.
	 * @return true para precisar avaliar, false para n�o avaliar
	 */
	public static boolean precisaAvaliar(int avaliado, int[] avaliados) {
		for (int i = 0; i < avaliados.length; i++) {

			if (avaliado == avaliados[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * adiciona o valor do avaliado no vetor de avaliados
	 * 
	 * @param avaliado   O valor a ser inserido.
	 * @param avaliadosO vetor com os valores ja avaliados.
	 * @return o novo arrey de avaliados.
	 */
	public static int[] adcionarAvaliados(int avaliado, int[] avaliados) {

		int[] aux = new int[avaliados.length + 1];
		// for para a copia
		for (int i = 0; i < avaliados.length; i++) {
			aux[i] = avaliados[i];
		}
		// adiciona o avaliado
		aux[aux.length - 1] = avaliado;

		return aux;
	}

	/**
	 * Conta quantas vezes o avaliado ocorre dentro do array de valores
	 * 
	 * @param avaliado O Valor a ser verificado quento a repeti��es.
	 * @param valores  Lista de valores para contabilizar repitidos
	 * @return A quantidade de ocorrencias do valor avaliado.
	 */
	public static int contarOcorrencias(int avaliado, int[] valores) {
		int ocorrencias = 0;
		for (int i = 0; i < valores.length; i++) {
			if (avaliado == valores[i]) {
				ocorrencias++;
			}
		}
		return ocorrencias;
	}

	/**
	 * Fun��o para adcionar um bloco de repeti��es na lista de repetidos.
	 * 
	 * @param numerosRepetem Bloco de contagem de repeti��o.
	 * @param repetidos      Lista de blocos repitidos
	 * @return Uma nova lista com o bloco adcionado.
	 */
	public static int[][] adicionarRepetidos(int[] numerosRepetem, int[][] repetidos) {

		int[][] aux = new int[repetidos.length + 1][2];
		
		for (int i = 0; i < repetidos.length; i++) {
			aux[i]=repetidos[i];
		}
		aux[aux.length-1]= numerosRepetem;
		return aux;
	}
}
