package com.mx.subastas.dao;

import java.util.List;

import com.mx.subastas.vo.LoginVO;

public interface ILoginDAO {
	
	public LoginVO obtenerUsuario(String usuario);
	public List<LoginVO> obtenerUsus() ;
}
