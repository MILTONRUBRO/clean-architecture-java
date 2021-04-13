package br.com.devmos.escola.dominio.aluno;

import java.util.List;

public interface RepositorioAlunos {
	
	void matricular(Aluno aluno);
	Aluno buscarPorCPF(CPF cpf);
	List<Aluno> listarTodosAlunos();
	

}
