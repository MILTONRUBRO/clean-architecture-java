package br.com.devmos.escola.infra.indicacao;

import br.com.devmos.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.devmos.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		//implementar envio de email com javamail
	}

}
