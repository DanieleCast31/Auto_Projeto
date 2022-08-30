package br.edu.ifrn.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	//Medoto para abrir a url inicial
	@GetMapping("/menu")
	public String inicio(){
		return "menu";
	}
	
}