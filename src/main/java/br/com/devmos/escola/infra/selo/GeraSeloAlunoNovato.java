package br.com.devmos.escola.infra.selo;

import br.com.devmos.escola.dominio.Evento;
import br.com.devmos.escola.dominio.aluno.AlunoMatriculado;
import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.dominio.aluno.Ouvinte;
import br.com.devmos.escola.dominio.selo.RepositorioSelos;
import br.com.devmos.escola.dominio.selo.Selo;

public class GeraSeloAlunoNovato extends Ouvinte{
	
	private final RepositorioSelos repositorioSelos;

	public GeraSeloAlunoNovato(RepositorioSelos repositorioSelos) {
		this.repositorioSelos = repositorioSelos;
	}

	@Override
	protected void reageAo(Evento evento) {
		
		CPF cpfAluno = ((AlunoMatriculado) evento).getCpfAluno();
		Selo novato = new Selo(cpfAluno, "Novato");
		repositorioSelos.adicionar(novato);
		
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}

}
