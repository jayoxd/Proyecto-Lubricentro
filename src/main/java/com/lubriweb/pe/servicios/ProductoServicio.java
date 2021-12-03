package com.lubriweb.pe.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.repository.ProductoRepository;





@Service
@Transactional
public class ProductoServicio {
	
	
	@Autowired
 public	ProductoRepository repositorioprod;
	
	public ProductoServicio() {
		
	}
	public Producto crear (Producto producto) {
		
		return repositorioprod.save(producto);
	}
	
	public List<Producto> listarTodo(){
		
		return (List<Producto>)repositorioprod.findAll();
		
	}
	

	
	public Producto actualizar(Producto productoActualizar) {
		Producto productoActual = repositorioprod.findById(productoActualizar.getIdProducto()).get();
		
		productoActual.setIdProducto(productoActualizar.getIdProducto());
		productoActual.setNombre(productoActualizar.getNombre());
		productoActual.setDescripcion(productoActualizar.getDescripcion());
		productoActual.setImagen(productoActualizar.getImagen());
		productoActual.setPrecio(productoActualizar.getPrecio());
		productoActual.setCantidad(productoActualizar.getCantidad());
		productoActual.setUsuarios(productoActualizar.getUsuarios());
		productoActual.setMarcas(productoActualizar.getMarcas());
		productoActual.setCategorias(productoActualizar.getCategorias());
		
		Producto productoActualizado = repositorioprod.save(productoActual);
		return productoActualizado;
	}

	
	
	
	public Producto buscarPorID(Integer id) {
		return repositorioprod.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorioprod.deleteById(id);
	}

	
	public void actualizar(int id, Producto producto) {
		
		Producto productoActual = repositorioprod.findById(id).get();
		productoActual.setIdProducto(producto.getIdProducto());
		productoActual.setNombre(producto.getNombre());
		productoActual.setDescripcion(producto.getDescripcion());
		productoActual.setImagen(producto.getImagen());
		productoActual.setPrecio(producto.getPrecio());
		productoActual.setCantidad(producto.getCantidad());
		productoActual.setUsuarios(producto.getUsuarios());
		productoActual.setMarcas(producto.getMarcas());
		productoActual.setCategorias(producto.getCategorias());
		repositorioprod.save(productoActual);

	}

}
