package br.com.devmos.escola.dominio.selo;

import java.util.List;

import br.com.devmos.escola.dominio.aluno.CPF;

public interface RepositorioSelos {
	void adicionar(Selo selo);
	List<Selo> selosDoAlunoDeCPF(CPF cpf);
}
