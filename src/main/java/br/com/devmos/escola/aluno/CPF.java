package br.com.devmos.escola.aluno;

public class CPF {
	
	private String numero;

	public CPF(String numero) {
		if(numero == null || !numero.matches("^([0-9]{3}\\.?){3}-?[0-9]{2}$")) {
			throw new IllegalArgumentException("CPF invalido");
		}
		
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	
}
