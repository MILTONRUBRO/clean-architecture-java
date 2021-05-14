package br.com.devmos.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.devmos.escola.dominio.Evento;

public class PublicadorEvento {
	
	private List<Ouvinte> ouvintes = new ArrayList<>();
	
	public void adicionar(Ouvinte ouvinte) {
		this.ouvintes.add(ouvinte);
	}
	
	public void publicar(Evento evento) {
		this.ouvintes.forEach(o -> {
			o.processa(evento);
		});
	}

}
