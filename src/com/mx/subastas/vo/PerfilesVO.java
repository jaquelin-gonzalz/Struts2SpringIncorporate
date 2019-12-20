package com.mx.subastas.vo;

import java.util.List;

public class PerfilesVO {

	private Integer id_perfil , id_path;
	private String perfil, path, mensaje;

	private List<PerfilesVO> listaPerfiles ;
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}

	public void setId_path(Integer id_path) {
		this.id_path = id_path;
	}

	public int getId_path() {
		return id_path;
	}

	public void setId_path(int id_path) {
		this.id_path = id_path;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<PerfilesVO> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<PerfilesVO> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
}
