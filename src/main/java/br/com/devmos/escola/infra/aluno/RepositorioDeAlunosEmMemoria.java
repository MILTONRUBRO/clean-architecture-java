package br.com.devmos.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.dominio.aluno.RepositorioAlunos;

public class RepositorioDeAlunosEmMemoria implements RepositorioAlunos{
	
	private List<Aluno> matriculados = new ArrayList<Aluno>();
	
	@Override
	public void matricular(Aluno aluno) {
		matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados
				.stream()
				.filter(aluno -> aluno.getCpf().equals(cpf.getNumero()))
				.findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> listarTodosAlunos() {
		return this.matriculados;
	}

}
