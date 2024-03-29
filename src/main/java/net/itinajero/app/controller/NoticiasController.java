package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiaService serviceNoticias;

	@GetMapping(value="/create")
	public String crear(){
//		serviceNoticias.guardar(noticia);
		return "noticias/formNoticia";
	}
	
	@PostMapping(value="/save")
	public String guardar(Noticia noticia){
		// Pendiente: Guardar el objeto noticia en la BD		
//		System.out.println(noticia);
		
		serviceNoticias.guardar(noticia);	
		return "noticias/formNoticia";
	}
}
