package com.lubriweb.pe.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dist")
public class indexpruecontroller {


@GetMapping("/index")
public String index() {
	
	
	return "dist/index";
}
}
