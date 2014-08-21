package br.com.matriz;

public class Result {
	int[][] result;
	int aux = 0;

	public void imprimeResult(MatrizImpl mat1, MatrizImpl mat2) {
		result = new int[mat1.getLinha()][mat2.getColuna()];
		for (int l = 0; l < mat1.getLinha(); l++) {
			for (int c = 0; c < mat2.getColuna(); c++) {
				aux = 0;
				for (int i = 0; i < mat1.getColuna(); i++) {

					aux = aux + (mat1.getMat()[l][i] * mat2.getMat()[i][c]);
				}

				result[l][c] = aux;
				System.out.print(result[l][c] + " ");
			}
			System.out.println("\n");
		}
	}

}