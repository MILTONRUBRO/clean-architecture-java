package br.com.devmos.escola.aplicacao.aluno.matricular;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.RepositorioAlunos;

public class MatricularAluno {
	
	private final RepositorioAlunos repositorioAlunos;

	public MatricularAluno(RepositorioAlunos repositorioAlunos) {
		this.repositorioAlunos = repositorioAlunos;
	}
	
	public void matricular(MatriculaAlunoDTO dados) {
		Aluno aluno = dados.criarAluno(); 
		repositorioAlunos.matricular(aluno);
	}

}
