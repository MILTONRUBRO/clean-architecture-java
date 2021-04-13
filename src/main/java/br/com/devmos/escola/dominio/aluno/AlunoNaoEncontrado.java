package br.com.devmos.escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontrado(CPF cpf) {
		super("Aluno nao encontrado com cpf " + cpf.getNumero());
	}

}
