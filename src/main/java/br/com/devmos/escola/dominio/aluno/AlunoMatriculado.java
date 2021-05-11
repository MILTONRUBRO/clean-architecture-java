package br.com.devmos.escola.dominio.aluno;

import java.time.LocalDateTime;

import br.com.devmos.escola.dominio.Evento;

public class AlunoMatriculado implements Evento{
	
	private final CPF cpfAluno;
	private final LocalDateTime momento;
	
	public AlunoMatriculado(CPF cpfAluno) {
		this.cpfAluno = cpfAluno;
		this.momento = LocalDateTime.now();
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

	public CPF getCpfAluno() {
		return cpfAluno;
	}

	public LocalDateTime getMomento() {
		return momento;
	}
	
}
