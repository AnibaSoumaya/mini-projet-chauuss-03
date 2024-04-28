package com.soumaya.chaussures.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
public class Chaussure {
	public Chaussure(String nomChaussure, Double prixChaussure) {
		super();
		this.nomChaussure = nomChaussure;
		this.prixChaussure = prixChaussure;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChaussure;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomChaussure;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixChaussure;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Lieu lieu;
	
	public Chaussure() {
	super();
	}
	public Chaussure(String nomChaussure, Double prixChaussure, Date dateCreation) {
	super();
	this.nomChaussure = nomChaussure;
	this.prixChaussure = prixChaussure;
	this.dateCreation = dateCreation;
	}
	public Long getIdChaussure() {
		return idChaussure;
	}
	public void setIdChaussure(Long idChaussure) {
		this.idChaussure = idChaussure;
	}
	public String getNomChaussure() {
		return nomChaussure;
	}
	public void setNomChaussure(String nomChaussure) {
		this.nomChaussure = nomChaussure;
	}
	public Double getPrixChaussure() {
		return prixChaussure;
	}
	public void setPrixChaussure(Double prixChaussure) {
		this.prixChaussure = prixChaussure;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	@Override
	public String toString() {
		return "Chaussure [idChaussure=" + idChaussure + ", nomChaussure=" + nomChaussure + ", prixChaussure="
				+ prixChaussure + ", dateCreation=" + dateCreation + "]";
	}



}
