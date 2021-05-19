package br.com.devmos.escola.dominio.selo;

import br.com.devmos.escola.dominio.aluno.CPF;

public class Selo {
	
	private CPF cpfAluno;
	private String selo;
	
	
	public CPF getCpfAluno() {
		return cpfAluno;
	}


	public void setCpfAluno(CPF cpfAluno) {
		this.cpfAluno = cpfAluno;
	}


	public String getSelo() {
		return selo;
	}


	public void setSelo(String selo) {
		this.selo = selo;
	}


	public Selo(CPF cpfAluno, String selo) {
		this.cpfAluno = cpfAluno;
		this.selo = selo;
	}
	
	

}
