package com.lubriweb.pe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.service.CategoriaService;
import com.lubriweb.pe.service.MarcaService;


@Controller
@RequestMapping("/marcas")
public class MarcaController {

	
	@Autowired
	private MarcaService marcsrvc;
	
	@Autowired
	private CategoriaService catsrvc;
	
	
	@GetMapping("")
	public String listartodo(Model model) {
		
		List<Marca> listaMarcas = marcsrvc.findAll();

		model.addAttribute("listaMarcas",listaMarcas);
		
		return "moduloMarcas/listarMarca";
	}
	
	
	@GetMapping("/create")
	public String nuevaMarca(Model model) {
		
		List<Categoria> lstCategoria = catsrvc.findAll();
		
		model.addAttribute("marca", new Marca());
		model.addAttribute("lstCategoria", lstCategoria);


		return "moduloMarcas/nuevaMarca";
	}
	
	@PostMapping("/save")
	public String save(Marca marca) {

		marcsrvc.save(marca);

		return "redirect:/marcas";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {

		Marca marca = marcsrvc.getFindById(id);

		model.addAttribute("marca", marca);

		List<Categoria> lstCategorias = catsrvc.findAll();

		model.addAttribute("lstCategorias", lstCategorias);

		return "moduloMarcas/nuevaMarca";

	}

	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		marcsrvc.delete(id);

		return "redirect:/marcas";

	}
	
	

}
