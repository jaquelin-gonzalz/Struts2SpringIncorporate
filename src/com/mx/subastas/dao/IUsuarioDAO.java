package com.mx.subastas.dao;

import java.util.List;

import com.mx.subastas.vo.UsuarioVO;

public interface IUsuarioDAO {
	
	public boolean registrar(UsuarioVO usuarioVo) ;
	public List<UsuarioVO> obtener();
	public UsuarioVO findById(int id) ;
	public boolean eliminar(UsuarioVO usuarioVO);

}
