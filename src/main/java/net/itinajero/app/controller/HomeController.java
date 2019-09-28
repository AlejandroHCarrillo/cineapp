package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Pelicula;

@Controller
public class HomeController {
	
/*	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
*/
	@RequestMapping(value="/")
	public String mostrarPrincipal(Model model) {
		model.addAttribute("peliculas", getLista());
		
		return "home";
		
	}

	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {				
		String titulo = "Rapido y Furioso";
		int duracion = 123;
		double precio = 50;
		
		model.addAttribute("titulo", titulo);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precio);
				
		
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
			
			// Agregamos los objetos Pelicula a la lista
				
			peliculas.add(pelicula1);
			peliculas.add(pelicula2);
			peliculas.add(pelicula3);
			peliculas.add(pelicula4);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas;
	}

	
}
