package br.com.devmos.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	private Aluno aluno;
	
	@BeforeEach
	public void beforeEach() {
		this.aluno = new Aluno(new CPF("123.456.789-00"), "Jon Snow", new Email("jonsnow@gmail.com"));
		
	}
	
	@Test
	public void devePermitirAdicionarTelefone() {
		this.aluno.adicionarTelefone(new Telefone("11", "9876555454"));
		assertEquals(1, aluno.getTelefones().size());
	}

}
