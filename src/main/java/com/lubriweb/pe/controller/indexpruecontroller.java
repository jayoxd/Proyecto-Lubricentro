package com.lubriweb.pe.controller;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dist")
public class indexpruecontroller {
private final Logger LOGGER = LoggerFactory.getLogger(indexpruecontroller.class);


@GetMapping("/index")
public String index() {
	
	
	return "dist/index";
}
}
