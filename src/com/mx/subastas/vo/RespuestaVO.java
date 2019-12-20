package com.mx.subastas.vo;

import java.util.List;

public class RespuestaVO {
	
	private List<UsuarioVO> listaUsuario;
	private UsuarioVO usuarioVO;
	private LoginVO loginVO;
	private Boolean banderaGuardar;
	private String mensaje;
	private PerfilesVO perfilesVO;
	private List<PerfilesVO> listaPerfil;
	

	public List<UsuarioVO> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<UsuarioVO> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}

	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getBanderaGuardar() {
		return banderaGuardar;
	}

	public void setBanderaGuardar(Boolean banderaGuardar) {
		this.banderaGuardar = banderaGuardar;
	}

	public List<PerfilesVO> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<PerfilesVO> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	public PerfilesVO getPerfilesVO() {
		return perfilesVO;
	}

	public void setPerfilesVO(PerfilesVO perfilesVO) {
		this.perfilesVO = perfilesVO;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
}
