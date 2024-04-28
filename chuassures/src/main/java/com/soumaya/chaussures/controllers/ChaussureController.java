package com.soumaya.chaussures.controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.entities.Lieu;
import com.soumaya.chaussures.service.ChaussureService;

import jakarta.validation.Valid;

@Controller
public class ChaussureController {

	@Autowired
	ChaussureService chaussureService;
	@RequestMapping("/ListeChaussures")
	public String listeChaussures(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Chaussure> chausss = chaussureService.getAllChaussuresParPage(page, size);
	modelMap.addAttribute("chaussures", chausss);
	modelMap.addAttribute("pages", new int[chausss.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeChaussures";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	return "index";
	}
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("chaussure", new Chaussure());
		List<Lieu> ls = chaussureService.getAllLieu();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("lieux", ls);
		return "formChaussure";
	}
	@RequestMapping("/saveChaussure")
	public String saveChaussure(@Valid Chaussure chaussure,BindingResult bindingResult,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size",defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formChaussure";
		if (chaussure.getIdChaussure()==null) //ajout
		isNew=true;
		chaussureService.saveChaussure(chaussure);
		if (isNew) //ajout
		{
		Page<Chaussure> chausss = chaussureService.getAllChaussuresParPage(page, size);
		currentPage = chausss.getTotalPages()-1;
		}
		else //modif
		currentPage=page;
		//return "formProduit";
		return ("redirect:/ListeChaussures?page="+currentPage+"&size="+size);
	}
	
	@RequestMapping("/supprimerChaussure")
	public String supprimerChaussure(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	
	{
		chaussureService.deleteChaussureById(id);
		Page<Chaussure> chausss = chaussureService.getAllChaussuresParPage(page, size); 
		modelMap.addAttribute("chaussures", chausss);
		modelMap.addAttribute("pages", new int[chausss.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeChaussures";
	}
	@RequestMapping("/modifierChaussure")
	public String editerChaussure(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		
		Chaussure c= chaussureService.getChaussure(id);
		List<Lieu> ls = chaussureService.getAllLieu();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("chaussure", c);
		modelMap.addAttribute("lieux", ls);
		modelMap.addAttribute("Page", page);
		modelMap.addAttribute("size", size);
		
		return "formChaussure";
	}
	@RequestMapping("/updateChaussure")
	public String updateChaussure(@ModelAttribute("chaussure") Chaussure
	chaussure, @RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	chaussure.setDateCreation(dateCreation);
	chaussureService.updateChaussure(chaussure);
	List<Chaussure> chausss = chaussureService.getAllChaussures();
	modelMap.addAttribute("chaussures", chausss);
	return "listeChaussures";
	}
	

}
