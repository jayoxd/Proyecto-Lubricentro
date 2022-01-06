package com.lubriweb.pe.controller;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.service.ProductoService;



@Controller
@RequestMapping("/moduloProductos")
public class productosController {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(productosController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String listartodo(Model model) {
		model.addAttribute("listaproductos", productoService.findAll());
		return "moduloProductos/listartodo";
	}

	@GetMapping("/nuevoProducto")
	public String nuevoProducto() {
		
		
		return "moduloProductos/nuevoProducto";
	}
	
	
	
	@PostMapping("/save")
	public String  save(Producto producto) {
		LOGGER.info("este  es el objeto producto {}",producto);
		
		Categoria c=new Categoria(1, "","");
		
		Marca m =new  Marca(1, " ", "",c);
		producto.setMarcas(m);
		productoService.save(producto);

		return "redirect:/moduloProductos";
	}
}
