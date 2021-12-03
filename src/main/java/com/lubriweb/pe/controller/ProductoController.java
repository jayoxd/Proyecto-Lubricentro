package com.lubriweb.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.servicios.CategoriaServicio;
import com.lubriweb.pe.servicios.MarcaServicio;
import com.lubriweb.pe.servicios.ProductoServicio;





@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoServicio servicioprod;
	
	private CategoriaServicio categoriaservicio;
	
	private MarcaServicio marcaservicio;
	
	@RequestMapping("/listarTodo")
	public String listarProductos(Model model) {
		
		List<Producto> listaProductos = servicioprod.listarTodo();
		
		model.addAttribute("listaProductos", listaProductos);
		
		return "/moduloProductos/listartodo";
		
	}
	
	@RequestMapping("/nuevo")
	public String nuevaProducto(Model model) {
		
		Producto producto  = new Producto();
		List<Categoria>listadoCategorias=categoriaservicio.buscarTodo();
		List<Marca>listadoMarcas=marcaservicio.buscarTodo();
		model.addAttribute("producto", producto);
		model.addAttribute("categorias",listadoCategorias);
		model.addAttribute("marcas",listadoMarcas);
		
		
		return "/moduloProductos/nuevoProducto";
		
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearProducto(@ModelAttribute("producto") Producto producto) {
		
		servicioprod.crear(producto);
		return "redirect:/productos/listarTodo";
		
	}
	
	@RequestMapping(value= "/actualizar/{id}")
	public ModelAndView editarProducto(@PathVariable(name = "id") int id,Model model) {
		
		ModelAndView mav = new ModelAndView("/moduloProductos/editarProductos");
		
		Producto producto  = servicioprod.buscarPorID(id);
		
		 List<Categoria> listadoCategorias = categoriaservicio.buscarTodo();
		List<Marca> listadoMarcas = marcaservicio.buscarTodo();
		model.addAttribute("categorias",listadoCategorias);
		model.addAttribute("marcas",listadoMarcas);
		mav.addObject("producto", producto);
		
		return mav;
		
		
	}
	
	@RequestMapping(value= "/eliminar/{id}")
	public String eliminarProductos(@PathVariable(name = "id") int id) {
		
		servicioprod.borrarPorID(id);
		
		return "redirect:/productos/listarTodo";
		
		
	}	

}
