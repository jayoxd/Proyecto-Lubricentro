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
import com.lubriweb.pe.service.CategoriaService;


@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService catsrvc;

	@GetMapping("")
	public String listartodo(Model model) {

		List<Categoria> lstCategorias = catsrvc.findAll();

		model.addAttribute("lstCategorias", lstCategorias);

		return "moduloCategorias/listarCategoria";
	}

	@GetMapping("/create")
	public String nuevaCategoria(Model model) {

		Categoria categoria = new Categoria();

		model.addAttribute("categoria", categoria);

		return "moduloCategorias/nuevaCategoria";
	}

	@PostMapping("/save")
	public String save(Categoria categoria) {

		catsrvc.save(categoria);

		return "redirect:/categorias";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {

		Categoria categoria = catsrvc.getFindById(id);

		model.addAttribute("categoria", categoria);

		return "moduloCategorias/nuevaCategoria";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		catsrvc.delete(id);

		return "redirect:/categorias";

	}

}
