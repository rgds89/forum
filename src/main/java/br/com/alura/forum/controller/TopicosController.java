package br.com.alura.forum.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.forum.controller.dto.RespostaDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Resposta;
import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;

@Controller
public class TopicosController {
	
	@RequestMapping("/topicos")
	@ResponseBody
	public List<TopicoDTO> lista(){
		Usuario usuario = new Usuario(1l, "Roger", "roger@email.com", "senha");
		Curso curso = new Curso(1l, "Spring", "Desenvolvimento BanckEnd");
		List<Resposta> lista = new ArrayList<>();
		
		Topico topico = new Topico(1l, "Dúvida", "Teste Dúvida", LocalDateTime.now(), StatusTopico.SOLUCIONADO, 
				usuario, curso, lista);
		
		List<TopicoDTO> responseDTO = buildTopico(topico);
		
		return responseDTO;
	}

	private List<TopicoDTO> buildTopico(Topico topico) {
		List<TopicoDTO> listaTopicoDTO =  new ArrayList<>();
		TopicoDTO topicoDTO = TopicoDTO.builder()
				.id(topico.getId())
				.titulo(topico.getTitulo())
				.mensagem(topico.getMensagem())
				.dataCriacao(topico.getDataCriacao())
				.build();
		listaTopicoDTO.add(topicoDTO);
		 
		return listaTopicoDTO;		
	}

}
