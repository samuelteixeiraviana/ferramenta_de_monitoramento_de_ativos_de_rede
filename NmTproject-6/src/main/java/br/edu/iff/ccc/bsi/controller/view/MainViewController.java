package br.edu.iff.ccc.bsi.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "home") //URL DELE
public class MainViewController {
	
	@GetMapping("/")  //Era pra ser o GET http://localhost:8080/home/ mas está retornando 404 n sei pq
	public String getHome()  
	{
		return "home.html"; 
	}
	
	@GetMapping("login") //GET pra tela de login
	public  String getLogin()
	{
		return "login.html";
	}
}