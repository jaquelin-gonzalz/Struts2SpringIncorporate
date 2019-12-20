package com.mx.subastas.dao;

import java.util.List;

import com.mx.subastas.vo.PerfilesVO;

public interface IPerfilesDAO {

	public List<PerfilesVO> obtener();
	public boolean registrar(PerfilesVO perfilesVo);
	public PerfilesVO findById(int id);
	public List<PerfilesVO> obtenerPermisos(int id_perfil);
	public boolean eliminar(PerfilesVO perfilesVO) ;
}
