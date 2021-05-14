package br.com.devmos.escola.aplicacao.aluno.matricular;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.AlunoMatriculado;
import br.com.devmos.escola.dominio.aluno.PublicadorEvento;
import br.com.devmos.escola.dominio.aluno.RepositorioAlunos;

public class MatricularAluno {
	
	private final RepositorioAlunos repositorioAlunos;
	private final PublicadorEvento publicador;
	
	public MatricularAluno(RepositorioAlunos repositorioAlunos, PublicadorEvento publicador ) {
		this.repositorioAlunos = repositorioAlunos;
		this.publicador = publicador;
	}
	
	public void matricular(MatriculaAlunoDTO dados) {
		Aluno aluno = dados.criarAluno(); 
		repositorioAlunos.matricular(aluno);
		
		AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
		publicador.publicar(evento);
	}

}
