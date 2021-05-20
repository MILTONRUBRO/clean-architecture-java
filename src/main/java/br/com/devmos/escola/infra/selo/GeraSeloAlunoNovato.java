package br.com.devmos.escola.infra.selo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devmos.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.devmos.escola.dominio.Evento;
import br.com.devmos.escola.dominio.aluno.AlunoMatriculado;
import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.dominio.aluno.Ouvinte;
import br.com.devmos.escola.dominio.selo.RepositorioSelos;
import br.com.devmos.escola.dominio.selo.Selo;

public class GeraSeloAlunoNovato extends Ouvinte{
	
	private static final Logger logger = LoggerFactory.getLogger(GeraSeloAlunoNovato.class);
	
	private final RepositorioSelos repositorioSelos;

	public GeraSeloAlunoNovato(RepositorioSelos repositorioSelos) {
		this.repositorioSelos = repositorioSelos;
	}

	@Override
	protected void reageAo(Evento evento) {
		
		CPF cpfAluno = ((AlunoMatriculado) evento).getCpfAluno();
		Selo novato = new Selo(cpfAluno, "Novato");
		repositorioSelos.adicionar(novato);
		logger.info("Selo do aluno " + cpfAluno + " criado com sucesso");
		
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}

}
