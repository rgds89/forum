package br.com.alura.forum.config.validation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErroDeFormularioDTO {
	
	private String campo;
	private String erro;

}
