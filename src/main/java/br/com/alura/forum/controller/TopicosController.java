package br.com.alura.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositories.TopicoRepository;

@Controller
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	@ResponseBody
	public List<TopicoDTO> lista() {
		List<Topico> topicos = topicoRepository.findAll();

		List<TopicoDTO> responseDTO = buildTopico(topicos);

		return responseDTO;
	}
	
	@RequestMapping("/topicos-titulo")
	@ResponseBody
	public TopicoDTO topicoTitulo(@RequestParam String titulo) {
		return topicoRepository.findByTitulo(titulo);
	}
	
	
	@RequestMapping("/topicos-curso")
	@ResponseBody
	public TopicoDTO topicoCursoNome(@RequestParam String nome) {
		return topicoRepository.findByCursoNome(nome);
	}

	private List<TopicoDTO> buildTopico(List<Topico> topicos) {
		List<TopicoDTO> listaTopicoDTO = new ArrayList<>();

		topicos.forEach(x -> {
			TopicoDTO topicoDTO = TopicoDTO.builder().id(x.getId()).titulo(x.getTitulo()).mensagem(x.getMensagem())
					.dataCriacao(x.getDataCriacao()).build();
			listaTopicoDTO.add(topicoDTO);
		});

		return listaTopicoDTO;
	}

}
