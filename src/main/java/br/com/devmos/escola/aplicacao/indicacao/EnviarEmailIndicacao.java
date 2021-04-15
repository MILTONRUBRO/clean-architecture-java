package br.com.devmos.escola.aplicacao.indicacao;

import br.com.devmos.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);

}
