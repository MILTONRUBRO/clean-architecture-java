package br.com.devmos.escola.dominio.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDeAlunoMatriculado {
	private static final Logger logger = LoggerFactory.getLogger(LogDeAlunoMatriculado.class);

	public void reageAo(AlunoMatriculado evento) {
		logger.info("Aluno com CPF " + evento.getCpfAluno().getNumero() + " em " + evento.getMomento());
	}

}
