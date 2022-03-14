package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicoForm {
	
	@NotNull
	@NotEmpty
	private String titulo;
	
	private String mensagem;
	
	@NotNull
	@NotEmpty
	private String nomeCurso;
	
	public Topico converter(Curso curso) {
		return new Topico(titulo, mensagem, curso);
	}

}
