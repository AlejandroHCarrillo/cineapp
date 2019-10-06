package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.util.Utileria;
//import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannersController {
	@Autowired
	private IBannersService serviceBanners;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		System.out.println("Banners: home - index");
		List<Banner> lista = serviceBanners.buscarTodos();
		
		model.addAttribute("banners", lista);
		return "banners/listBanners";
	}
	
	@GetMapping("/create")
	public String crear() {		
		System.out.println("Crear un banner");
		return "banners/frmBanner";
	}
	
	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes,
						  @RequestParam("archivoImagen") MultipartFile multiPart,
						  HttpServletRequest request
						) {
		System.out.println("Guardando el banner");
		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Errores: "+ error.getDefaultMessage());				
			}
			return "banners/frmBanner";
		}
		
		if(!multiPart.isEmpty()) {
			System.out.println("El multiPart NO está vacio, Si mandaron una imagen");
			String nombreImagen = Utileria.guardarImagen(multiPart, request);			
			banner.setArchivo(nombreImagen);
		}
		
		serviceBanners.insertar(banner);
		
		System.out.println("Guardando el banner: "+ banner);		
		attributes.addFlashAttribute("mensaje", "El banner fue guardado con éxito.");		
		System.out.println("El banner fue guardado con éxito.");		
		
		return "redirect:/banners/index";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}