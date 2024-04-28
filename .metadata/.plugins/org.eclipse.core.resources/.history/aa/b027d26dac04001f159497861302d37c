package com.soumaya.chaussures.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.entities.Lieu;

@RepositoryRestResource(path = "rest")
public interface ChaussureRepository extends JpaRepository<Chaussure, Long> {
	
	List<Chaussure> findByNomChaussure(String nom);
	List<Chaussure> findByNomChaussureContains(String nom);
	
	@Query("select c from Chaussure c where c.nomChaussure like %?1 and c.prixChaussure > ?2")
	List<Chaussure> findByNomPrix (String nom, Double prix);
	
	@Query("select c from Chaussure c where c.lieu = ?1")
	List<Chaussure> findByLieu (Lieu lieu);
	
	List<Chaussure> findByLieuIdLieu(Long id);
	
	List<Chaussure> findByOrderByNomChaussureAsc();
	
	@Query("select c from Chaussure c order by c.nomChaussure ASC, c.prixChaussure DESC")
	List<Chaussure> trierChaussuresNomsPrix ();
	
}
