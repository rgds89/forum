package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.alura.forum.modelo.StatusTopico;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalhesDoTopicoDTO {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;

}
