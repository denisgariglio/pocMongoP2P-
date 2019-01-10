package com.poc.mongo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.mongo.bean.Pessoa;
import com.poc.mongo.repository.PessoaRepository;
import com.poc.mongo.service.PessoaService;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@Override
	public void salvarNovaPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public List<Pessoa> retornaListaDePessoas() {		
		return (List<Pessoa>) pessoaRepository.findAll();
	}

	@Override
	public Optional<Pessoa> retornaPessoaPeloId(String id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public Pessoa alterarDadosDaPessoa(Pessoa pessoa, String id) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void excluiPessoaPeloId(String id) {
		pessoaRepository.deleteById(id);
		
	}		

}
