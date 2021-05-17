package br.com.devmos.escola.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.dominio.selo.RepositorioSelos;
import br.com.devmos.escola.dominio.selo.Selo;

public class RepositorioDeSeloEmMemoria implements RepositorioSelos{
	
	private List<Selo> selos = new ArrayList<>();

	@Override
	public void adicionar(Selo selo) {
		selos.add(selo);
	}

	@Override
	public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
		return selos.stream()
				.filter(s -> s.getCpfAluno() == cpf)
				.collect(Collectors.toList());
	}

}
