package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(Model model, @RequestParam("fecha") String fecha){
		
		List<String> listaFechas = Utileria.getNextDays(7);		
		List<Pelicula> peliculas = getLista();

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		
		System.out.println("Buscando todas las peliculas en exhibicion para la fecha: " + fecha);
		return "home";
	}


	@RequestMapping(value="/")
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(7);
		
		System.out.println(listaFechas);
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", getLista());
		
		return "home";
		
	}

//	@RequestMapping(value="/detail/{id}/{fechaBusqueda}", method=RequestMethod.GET)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
//	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fechaBusqueda") String fechaBusqueda ) {
	public String mostrarDetalle(Model model, 
				@RequestParam("idMovie") int idPelicula,
				@RequestParam("fecha") String fechaBusqueda
				) {
	
		System.out.println("idPelicula:" + idPelicula);
		System.out.println("fechaBusqueda:" + fechaBusqueda);
				
		return "detalle";		
	}
	
	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		List<Pelicula> peliculas = new LinkedList<Pelicula>();
		try {
		
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			// imagen="cinema.png"
			// estatus="Activa"

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula2.setImagen("bella.png"); // Nombre del archivo de imagen

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			pelicula3.setImagen("contratiempo.png"); // Nombre del archivo de imagen

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong La Isla Calavera");
			pelicula4.setDuracion(118);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y Aventura");
			pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
			pelicula4.setImagen("kong.png"); // Nombre del archivo de imagen
			pelicula4.setEstatus("Inactiva"); // Esta pelicula estara inactiva
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
			pelicula5.setImagen("estreno5.png"); // Nombre del archivo de imagen
			pelicula5.setEstatus("Activa"); // Esta pelicula estara inactiva

			// Agregamos los objetos Pelicula a la lista
				
			peliculas.add(pelicula1);
			peliculas.add(pelicula2);
			peliculas.add(pelicula3);
			peliculas.add(pelicula4);
			peliculas.add(pelicula5);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas;
	}

	
}
