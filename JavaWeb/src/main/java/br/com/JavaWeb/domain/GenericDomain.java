package br.com.JavaWeb.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class GenericDomain implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long codigo;

	public Long getCondigo() {
		return codigo;
	}

	public void setCondigo(Long condigo) {
		this.codigo = codigo;
	}
	
	
	

}
