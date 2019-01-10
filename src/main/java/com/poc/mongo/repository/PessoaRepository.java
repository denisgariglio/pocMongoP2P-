package com.poc.mongo.repository;

import org.springframework.data.repository.CrudRepository;

import com.poc.mongo.bean.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, String> {

}
