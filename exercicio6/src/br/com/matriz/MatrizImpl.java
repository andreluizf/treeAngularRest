package br.com.matriz;

import javax.swing.JOptionPane;

public class MatrizImpl implements Matriz {
	private int[][] mat;

	private int linha;
	private int coluna;
	private int l = 0;
	private int c = 0;

	private String nome;

	public MatrizImpl(String nome) {
		this.nome = nome;
	}

	public MatrizImpl() {
		super();

	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int[][] getMat() {
		return mat;
	}

	public void setMat(int[][] mat) {
		this.mat = mat;
	}

	@Override
	public void valorMatriz() {

		try {
			if (l < linha) {
				if (c < coluna) {

					mat[l][c++] = Integer.parseInt(JOptionPane
							.showInputDialog(new StringBuffer()
									.append("Informe o valor da  ")
									.append(nome).append(" para linha ")
									.append(l).append(" coluna ").append(c)
									.append(" :")));
					valorMatriz();

				}
				c = 0;
				l++;
				valorMatriz();
			}
		} catch (Exception e) {
			--c;
			JOptionPane.showMessageDialog(null, "Valor invalido");
			valorMatriz();
		}


	}


	@Override
	public void tamanhoMatriz() {

		linhaMatriz();
		colunaMatriz();

		mat = new int[linha][coluna];

	}

	public void linhaMatriz() {
		try {
			linha = Integer.parseInt(JOptionPane
					.showInputDialog(new StringBuffer()
							.append("Informe o a quantidade de linhas da  ")
							.append(nome).append(" :")));
			if (linha == 0) {
				JOptionPane.showMessageDialog(null, "Tamanho linha invalido");
				linhaMatriz();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho linha invalido");
			linhaMatriz();
		}

	}

	public void colunaMatriz() {
		try {
			coluna = Integer.parseInt(JOptionPane
					.showInputDialog(new StringBuffer()
							.append("Informe o a quantidade de colunas da   ")
							.append(nome).append(" :")));
			if (coluna == 0) {
				JOptionPane.showMessageDialog(null, "Tamanho linha invalido");
				colunaMatriz();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho coluna invalido");
			colunaMatriz();
		}
	}

}
