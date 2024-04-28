package com.soumaya.chaussures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.entities.Lieu;

public interface ChaussureService {

	Chaussure saveChaussure(Chaussure c);
	Chaussure updateChaussure(Chaussure c);
	void deleteChaussure(Chaussure c);
	void deleteChaussureById(Long id);
	Chaussure getChaussure(Long id);
	List<Chaussure> getAllChaussures();
	List<Chaussure> findByNomChaussure(String nom);
	List<Chaussure> findByNomChaussureContains(String nom);
	//List<Chaussure> findByNomPrix(String nom, Double prix);
	List<Chaussure> findByLieu(Lieu lieu);
	List<Chaussure> findByLieuIdL(Long id);
	List<Chaussure> findByOrderByNomChaussureAsc();
	List<Chaussure> trierChaussuresNomsPrix();
	

	Page<Chaussure> getAllChaussuresParPage(int page, int size);
}
