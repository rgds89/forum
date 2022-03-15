package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AtualizacaoTopicoForm {
	@NotNull
	@NotEmpty
	private String titulo;
	
	private String mensagem;

}
