package br.com.devmos.escola.aplicacao.aluno.matricular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.AlunoMatriculado;
import br.com.devmos.escola.dominio.aluno.LogDeAlunoMatriculado;
import br.com.devmos.escola.dominio.aluno.PublicadorEvento;
import br.com.devmos.escola.dominio.aluno.RepositorioAlunos;

public class MatricularAluno {
	private static final Logger logger = LoggerFactory.getLogger(MatricularAluno.class);

	private final RepositorioAlunos repositorioAlunos;
	private final PublicadorEvento publicador;
	
	public MatricularAluno(RepositorioAlunos repositorioAlunos, PublicadorEvento publicador ) {
		this.repositorioAlunos = repositorioAlunos;
		this.publicador = publicador;
	}
	
	public void matricular(MatriculaAlunoDTO dados) {
		Aluno aluno = dados.criarAluno(); 
		repositorioAlunos.matricular(aluno);
		
		logger.info("Aluno " + aluno.getNome() + " matriculado");
		
		AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
		publicador.publicar(evento);
	}

}
