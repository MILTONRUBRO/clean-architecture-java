package br.com.devmos.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCaseAluno = new MatricularAluno(repositorio);
		
		MatriculaAlunoDTO alunoDTO = new MatriculaAlunoDTO("Fulano", "123.456.789-00", "fulano@email.com");
		
		useCaseAluno.matricular(alunoDTO);
		
		Aluno aluno = repositorio.buscarPorCPF(new CPF("123.456.789-00"));
		
		assertEquals("Fulano", aluno.getNome());
		assertEquals("123.456.789-00", aluno.getCpf().getNumero());
		assertEquals("fulano@email.com", aluno.getEmail().getEndereco());
	
	}

}
