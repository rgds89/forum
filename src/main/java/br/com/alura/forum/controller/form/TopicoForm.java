package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicoForm {
	
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	public Topico converter(Curso curso) {
		return new Topico(titulo, mensagem, curso);
	}

}
