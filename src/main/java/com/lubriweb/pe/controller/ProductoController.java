package com.lubriweb.pe.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.service.MarcaService;
import com.lubriweb.pe.service.ProductoService;
import com.lubriweb.pe.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService prodsrvc;

	@Autowired
	private MarcaService marcsrvc;

	@Autowired
	private UploadFileService uploadsrvc;

	@GetMapping("")
	public String listartodo(Model model) {

		List<Producto> lstProductos = prodsrvc.findAll();

		model.addAttribute("lstProductos", lstProductos);

		return "moduloProductos/listarProducto";
	}

	@GetMapping("/create")
	public String nuevoProducto(Model model) {

		List<Marca> lstMarcas = marcsrvc.findAll();

		model.addAttribute("producto", new Producto());
		model.addAttribute("lstMarcas", lstMarcas);

		return "moduloProductos/nuevoProducto";
	}

	@PostMapping("/save")
	public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

		// Imagen
		if (producto.getIdProducto() == null) { // cuando se crea un producto siempre el id viene null

			String nomImagen = uploadsrvc.saveImage(file);

			producto.setImagen(nomImagen);

		} else {

			if (file.isEmpty()) { // Cuando Editamos el producto pero no cambiamos la imagen
				Producto p = new Producto();

				p = prodsrvc.getFindById(producto.getIdProducto());

				producto.setImagen(p.getImagen());

			} else { // Cuando se edita tbn la imagen

				Producto p = new Producto();

				p = prodsrvc.getFindById(producto.getIdProducto());

				// Para eliminar cuando no sea la imagen por defecto
				if (!p.getImagen().equals("default.jpg")) {

					uploadsrvc.deleteImage(p.getImagen());

				}

				String nomImagen = uploadsrvc.saveImage(file);

				producto.setImagen(nomImagen);

			}

		}

		prodsrvc.save(producto);

		return "redirect:/productos";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {

		Producto producto = prodsrvc.getFindById(id);

		model.addAttribute("producto", producto);

		List<Marca> lstMarcas = marcsrvc.findAll();

		model.addAttribute("lstMarcas", lstMarcas);

		return "moduloProductos/nuevoProducto";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {

		Producto p = new Producto();

		p = prodsrvc.getFindById(id);

		// Para eliminar cuando no sea la imagen por defecto
		if (!p.getImagen().equals("default.jpg")) {

			uploadsrvc.deleteImage(p.getImagen());

		}

		prodsrvc.delete(id);

		return "redirect:/productos";

	}

}
