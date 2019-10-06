package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
//import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
//	@Autowired
//	private IBannersService serviceBanners;
	@Autowired
	private IPeliculasService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha") String fecha){
		
		List<String> listaFechas = Utileria.getNextDays(7);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
//		model.addAttribute("banners", serviceBanners.buscarTodos());
		
		System.out.println("Buscando todas las peliculas en exhibicion para la fecha: " + fecha);
		return "home";
	}


	@RequestMapping(value="/")
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(7);
		
		System.out.println(listaFechas);
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", servicePeliculas.buscarTodas());
		
		return "home";
		
	}

//	@RequestMapping(value="/detail/{id}/{fechaBusqueda}", method=RequestMethod.GET)
//	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fechaBusqueda") String fechaBusqueda ) {
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, 
				@RequestParam("idMovie") int idPelicula,
				@RequestParam("fecha") String fechaBusqueda
				) {
	
		System.out.println("idPelicula:" + idPelicula);
		System.out.println("fechaBusqueda:" + fechaBusqueda);
		
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		System.out.println(pelicula);
		model.addAttribute("pelicula", pelicula);
				
		return "detalle";		
	}
	
//	private List<Pelicula> getLista(){		
//		return peliculas;
//	}

	
}
