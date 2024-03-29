package net.itinajero.app.model;

import java.util.Date;

public class Pelicula {
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png";
	private Date fechaEstreno;
	private String Estatus = "Activa";
	
	private String actores = "No especificados";
	private String director = "Desconocido";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return Estatus;
	}
	public void setEstatus(String estatus) {
		Estatus = estatus;
	}
	
	public String getActores() {
		return actores;
	}
	public void setActores(String actores) {
		this.actores = actores;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	@Override
	public String toString() {
		return "Pelicula [ id=" + id + ", titulo=" + titulo + ", " + 
						  "duracion=" + duracion + ", clasificacion=" + clasificacion + ", " + 
						  "genero=" + genero + ", imagen=" + imagen + ", " +
						  "fechaEstreno=" + fechaEstreno  + ", Estatus=" + Estatus + ", " + 
						  "actores=" + actores + ", director=" + director + "]";
	}

}
