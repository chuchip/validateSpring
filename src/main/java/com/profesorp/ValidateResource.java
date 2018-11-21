package com.profesorp;

import java.net.URI;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.profesorp.exception.BeanNotFoundException;



@RestController
public class ValidateResource {

	@Autowired
	MiBeanService service;
	
	@GetMapping("{id}")
	public MiValidateBean getBean(@PathVariable int id) {
		MiValidateBean bean = null;
		try 
		{
			 bean = service.getBean(id);
		} catch (NoSuchElementException k)
		{
			throw new BeanNotFoundException("Bean con id: "+id+ " no encontrado" );
		}
		return bean;
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addBean(@Valid  @RequestBody MiValidateBean bean) {
		MiValidateBean miBeanSaved=service.addBean(bean);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(miBeanSaved.getCodigo()).toUri();

		return ResponseEntity.created(location).build();
	}
}
