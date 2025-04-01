package br.edu.iff.ccc.bsi.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "device")
public class Device implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
	private String name;
	
	@NotNull
	@Size(min= 8, max = 8, message = "Controle de tamanho do endereço IP enviado")
	private String address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Device(String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Device() {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(address, other.address);
	}
}
