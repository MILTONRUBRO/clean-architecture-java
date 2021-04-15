package br.com.devmos.escola.aplicacao.aluno.matricular;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.dominio.aluno.Email;

public class MatriculaAlunoDTO {
	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	
	public MatriculaAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}

	public Aluno criarAluno() {
		return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
	}
	

}
