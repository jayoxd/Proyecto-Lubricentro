package com.lubriweb.pe.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lubriweb.pe.model.Carrito;
import com.lubriweb.pe.model.Orden;
import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.model.Rol;
import com.lubriweb.pe.model.Usuario;
import com.lubriweb.pe.service.CarritoService;
import com.lubriweb.pe.service.OrdenService;
import com.lubriweb.pe.service.ProductoService;
import com.lubriweb.pe.service.RoleService;
import com.lubriweb.pe.service.UsuarioService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	private RoleService rolesrvc;

	@Autowired
	private UsuarioService usersrvc;

	@Autowired
	private ProductoService prodsrvc;

	@Autowired
	private OrdenService ordnsrvc;

	@Autowired
	private CarritoService cartsrvc;

	// Para almacenar los detalles del carrito - En un carrito hay uno o varios
	// productos
	List<Carrito> detallescart = new ArrayList<Carrito>();

	// Datos de la orden
	Orden orden = new Orden();

	// @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	@GetMapping(value = { "/", "/index" })
	public String Inicio() {

		return "index";

	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {

		return "login";

	}

	@GetMapping("/Nosotros")
	public String Nosotros() {

		return "Nosotros";

	}

	@GetMapping("/register")
	public String showFormRegister(Model model) {

		Usuario usuario = new Usuario();
		Collection<Rol> itemsRol = rolesrvc.findAll();

		model.addAttribute("usuario", usuario); // Usuario vacio
		model.addAttribute("roles", itemsRol);

		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Registration(Usuario usuario) { // Usuario Cargado

		usersrvc.insert(usuario);

		return "registration_success";
	}

//---------------------------------------------------------------------------------------------

	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	// Metodo que carga listado de productos del moduloUsuarios
	@GetMapping("/user")
	public String user(Model model) {

		List<Producto> lstprodcargados = prodsrvc.findAll();

		model.addAttribute("lstprodcargados", lstprodcargados);

		return "/moduloUsuario/user";

	}
	

	// @RequestMapping(value = "/admin", method = RequestMethod.GET)
	@GetMapping("/admin")
	public String admin() {

		return "/moduloAdmin/admin";

	}

	@PostMapping("/Search")
	public String searchProducto(@RequestParam String buscar, Model model) {

		List<Producto> productos = prodsrvc.findAll().stream().filter(p -> p.getNombre().contains(buscar))
				.collect(Collectors.toList());

		model.addAttribute("lstprodcargados", productos);

		return "/moduloUsuario/user";

	}

	@GetMapping("/detalleprod/{id}")
	public String detalleProducto(@PathVariable("id") Integer id, Model model) {

		Producto detproducto = prodsrvc.getFindById(id);

		model.addAttribute("detproducto", detproducto);

		return "/moduloUsuario/detalleProducto";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {

		Carrito cart = new Carrito();
		Producto producto = prodsrvc.getFindById(id);
		double sumaTotal = 0;

		cart.setCantidad(cantidad);
		cart.setPrecio(producto.getPrecio());
		cart.setNombre(producto.getNombre());
		cart.setTotal(producto.getPrecio() * cantidad);
		cart.setProducto(producto);

		// Validar que el producto no se añada dos veces
		Integer idProd = producto.getIdProducto();

		boolean ingresado = detallescart.stream().anyMatch(p -> p.getProducto().getIdProducto() == idProd);

		if (!ingresado) {

			detallescart.add(cart);

		}

		sumaTotal = detallescart.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);

		model.addAttribute("cart", detallescart);
		model.addAttribute("orden", orden);

		return "/moduloUsuario/carrito";
	}

	// Quitar un producto del carrito
	@GetMapping("/delete/cart/{id}")
	public String deleteProductCart(@PathVariable("id") Integer id, Model model) {

		// Lista nueva de productos
		List<Carrito> cartnuevo = new ArrayList<Carrito>();

		for (Carrito detallecart : detallescart) {

			if (detallecart.getProducto().getIdProducto() != id) {

				cartnuevo.add(detallecart);

			}

		}

		// Poner la nueva lista con los productos restantes
		detallescart = cartnuevo;

		double sumaTotal = 0;

		sumaTotal = detallescart.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);

		model.addAttribute("cart", detallescart);
		model.addAttribute("orden", orden);

		return "/moduloUsuario/carrito";

	}

	@GetMapping("/order")
	public String order(Model model) {

		Usuario usuario = usersrvc.findById(2);

		model.addAttribute("cart", detallescart);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);

		return "/moduloUsuario/resumenOrden";

	}

	// Guardar la orden
	@GetMapping("/saveOrder")
	public String saveOrder() {
		Date fechaCreacion = new Date();

		orden.setFechaCreacion(fechaCreacion);
		orden.setFechaRecibida(fechaCreacion);
		orden.setNumero(ordnsrvc.generarNumeroOrden());

		// MetodoPago mtpago = metpagosrvc.findbyid
		// Usuario
		Usuario usuario = usersrvc.findById(2);

		orden.setOrdenUsuarios(usuario);

		ordnsrvc.save(orden);

		// Guardar detalles al carrito
		for (Carrito dcart : detallescart) {

			dcart.setOrden(orden);
			cartsrvc.save(dcart);

		}

		// Limpiar listacart y orden
		orden = new Orden();

		detallescart.clear();

		return "redirect:/user";
	}


	// @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	@GetMapping("/access_denied")
	public String access_denied() {

		return "access_denied";

	}

	// --------------------------------------------------------------------------------------

	// @RequestMapping(value = "/logout", method = RequestMethod.GET)
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		// Llamar al usuario aunthenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// si existe el usuario authenticado
		if (auth != null)

			new SecurityContextLogoutHandler().logout(request, response, auth);// cerrar sesion

		// redireccionar a login
		return "redirect:login?logout";

	}

}
