package com.mx.subastas.vo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioVO {

	private Integer id,id_perfil;

	private String nombre, correo, perfil, mensaje, telefono,password;

	private List<UsuarioVO> listaUsuarios ;
	private List<PerfilesVO> listaPerfiles;
	private List<PerfilesVO> permisos = new ArrayList<PerfilesVO>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<UsuarioVO> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<UsuarioVO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public List<PerfilesVO> getListaPerfiles() {
		return listaPerfiles;
	}
	public void setListaPerfiles(List<PerfilesVO> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
	public List<PerfilesVO> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<PerfilesVO> permisos) {
		this.permisos = permisos;
	}
		
}
