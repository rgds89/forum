package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TopicoDTO {
	
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

}
