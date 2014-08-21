package br.com.matriz;

import javax.swing.JOptionPane;

public class MultiplicaMatriz extends Result {
	public void run() {
		MatrizImpl mat1 = new MatrizImpl("Matriz 1");
		MatrizImpl mat2 = new MatrizImpl("Matriz 2");
		mat1.tamanhoMatriz();
		mat2.tamanhoMatriz();

		while (mat1.getColuna() != mat2.getLinha()) {
			JOptionPane
					.showMessageDialog(
							null,
							"Nãoo é possivel realizar multiplicação destas matrizes.\n -O numero de colunas da 1 matriz deve ser igual ao numero de linhas da 2 matriz");
			mat1.tamanhoMatriz();
			mat2.tamanhoMatriz();

		}

		mat1.valorMatriz();
		mat2.valorMatriz();
		imprimeResult(mat1, mat2);
	}

	public static void main(String[] args) {

		MultiplicaMatriz m = new MultiplicaMatriz();
		m.run();

	}
}
