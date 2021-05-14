package br.com.devmos.escola.dominio.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devmos.escola.dominio.Evento;

public class LogDeAlunoMatriculado extends Ouvinte{
	private static final Logger logger = LoggerFactory.getLogger(LogDeAlunoMatriculado.class);

	@Override
	public void reageAo(Evento evento) {
		logger.info("Aluno com CPF " + ((AlunoMatriculado) evento).getCpfAluno().getNumero() + " se matriculou em " + ((AlunoMatriculado) evento).getMomento());
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}

}
