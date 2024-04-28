package com.soumaya.chaussures.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idLieu;
	private String nomLieu;
	@JsonIgnore
	@OneToMany(mappedBy = "lieu")
	private List<Chaussure> chaussures;
	
	
	public Long getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(Long idLieu) {
		this.idLieu = idLieu;
	}
	public String getNomLieu() {
		return nomLieu;
	}
	public void setNomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}
	public List<Chaussure> getChaussures() {
		return chaussures;
	}
	public void setChaussures(List<Chaussure> chaussures) {
		this.chaussures = chaussures;
	}
}
