package br.com.angular.repository;

import java.util.List;

public interface Repository<T> {
	void salvarOrAtualizar(T modelo);

	List<T> consulta();

	void deletar(T modelo);

	T consultaById(int id);
}
