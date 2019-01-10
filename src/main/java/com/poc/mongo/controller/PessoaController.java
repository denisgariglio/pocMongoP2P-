package com.poc.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.poc.mongo.bean.Pessoa;
import com.poc.mongo.service.PessoaService;

@RestController
@RequestMapping(value = { "/pessoa" })
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable("id") String id) {
		Optional<Pessoa> pessoa = pessoaService.retornaPessoaPeloId(id);
		return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
	}

	@PostMapping(value = "/salvarNovaPessoa", headers = "Accept=application/json")
	public ResponseEntity<Void> salvarNovaPessoa(@RequestBody Pessoa pessoa, UriComponentsBuilder ucBuilder) {
		pessoaService.salvarNovaPessoa(pessoa);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping(value = "/retornarListaDePessoas", headers = "Accept=application/json")
	public List<Pessoa> retornaListaDePessoas() {
		return pessoaService.retornaListaDePessoas();
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Pessoa> excluirPessoaPorId(@PathVariable("id") String id) {
		Optional<Pessoa> pessoa = pessoaService.retornaPessoaPeloId(id);
		if (pessoa.get() == null) {
			return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}
		pessoaService.excluiPessoaPeloId(id);
		return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/alterarDadosDaPessoa", headers = "Accept=application/json")
	public ResponseEntity<String> alterarDadosDaPessoa(@RequestBody Pessoa dadosAtuaisPessoa) {

		Optional<Pessoa> pessoa = pessoaService.retornaPessoaPeloId(dadosAtuaisPessoa.getId());
		if (pessoa.get() == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		pessoaService.alterarDadosDaPessoa(dadosAtuaisPessoa, dadosAtuaisPessoa.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
