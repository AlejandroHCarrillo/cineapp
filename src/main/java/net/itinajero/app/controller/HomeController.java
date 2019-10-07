package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	@Autowired
	private IBannersService serviceBanners;
	@Autowired
	private IPeliculasService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome(Model model) {
		model.addAttribute("fechas", Utileria.getNextDays(7));
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", servicePeliculas.buscarTodas());
		model.addAttribute("banners", serviceBanners.buscarTodos());

		return "home";
	}

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha") String fecha){				
		model.addAttribute("fechas", Utileria.getNextDays(7));
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", servicePeliculas.buscarTodas());
		model.addAttribute("banners", serviceBanners.buscarTodos());
		
		return "home";
	}


	@RequestMapping(value="/")
	public String mostrarPrincipal(Model model) {
		model.addAttribute("fechas", Utileria.getNextDays(7));
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", servicePeliculas.buscarTodas());
		model.addAttribute("banners", serviceBanners.buscarTodos());
		
		return "home";
	}

	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, 
				@RequestParam("idMovie") int idPelicula,
				@RequestParam("fecha") String fechaBusqueda
				) {
			
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		model.addAttribute("pelicula", pelicula);
				
		return "detalle";		
	}
	
}
