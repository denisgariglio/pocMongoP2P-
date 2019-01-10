package com.poc.mongo.service;

import java.util.List;
import java.util.Optional;

import com.poc.mongo.bean.Pessoa;

public interface PessoaService {
	
	public void salvarNovaPessoa(Pessoa pessoa);
	public List<Pessoa> retornaListaDePessoas();
	public Optional<Pessoa> retornaPessoaPeloId(String id);
	public Pessoa alterarDadosDaPessoa(Pessoa pessoa, String id);
	public void excluiPessoaPeloId(String id);

}
