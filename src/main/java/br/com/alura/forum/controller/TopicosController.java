package br.com.alura.forum.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;


	@GetMapping
	public List<TopicoDTO> lista() {
		List<Topico> topicos = topicoRepository.findAll();

		List<TopicoDTO> responseDTO = listBuildTopicoDTO(topicos);

		return responseDTO;
	}
	
	@RequestMapping("/titulo")
	@GetMapping
	public TopicoDTO topicoTitulo(@RequestParam String titulo) {
		return topicoRepository.findByTitulo(titulo);
	}
	
	
	@RequestMapping("/curso")
	@GetMapping
	public TopicoDTO topicoCursoNome(@RequestParam String nome) {
		return topicoRepository.findByCursoNome(nome);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> casdastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(buscaCurso(form.getNomeCurso()));
		topicoRepository.saveAndFlush(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(buildTopicoDTO(topico));
		
	}

	private Curso buscaCurso(String nome) {
		return cursoRepository.findByNome(nome);
	}

	private List<TopicoDTO> listBuildTopicoDTO(List<Topico> topicos) {
		List<TopicoDTO> listaTopicoDTO = new ArrayList<>();

		topicos.forEach(x -> {
			TopicoDTO topicoDTO = TopicoDTO.builder().id(x.getId()).titulo(x.getTitulo()).mensagem(x.getMensagem())
					.dataCriacao(x.getDataCriacao()).build();
			listaTopicoDTO.add(topicoDTO);
		});

		return listaTopicoDTO;
	}
	
	private TopicoDTO buildTopicoDTO(Topico topico) {
		TopicoDTO topicoDTO = TopicoDTO.builder().id(topico.getId()).titulo(topico.getTitulo()).mensagem(topico.getMensagem())
				.dataCriacao(topico.getDataCriacao()).build();
		return topicoDTO;
	}

}
