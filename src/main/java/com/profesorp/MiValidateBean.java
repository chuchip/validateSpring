package com.profesorp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MiValidateBean {
	private int codigo;
	
	@Size(min=2, message="Campo 'valor' deberia tener al menos 2 caracteres")
	@NotNull(message="Campo 'valor' no puede ser nulo")
	private String valor;
	
	public MiValidateBean()
	{
		
	}
	
	public MiValidateBean(int codigo, String valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
