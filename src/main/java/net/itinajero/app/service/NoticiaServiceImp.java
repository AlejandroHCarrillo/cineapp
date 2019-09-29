package net.itinajero.app.service;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

@Service
public class NoticiaServiceImp implements INoticiaService {

	public void guardar(Noticia noticia) {
		System.out.println("Guardando Noticia");		
		System.out.println(noticia);		
	}
	
}
