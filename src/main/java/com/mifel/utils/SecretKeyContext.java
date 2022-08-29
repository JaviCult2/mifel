package com.mifel.utils;

public class SecretKeyContext {

	private String clave;
	private String dato;
	
	public SecretKeyContext() {
		
	}
	
	public SecretKeyContext(String clave, String dato) {
		super();
		this.clave = clave;
		this.dato = dato;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
	
	
}
