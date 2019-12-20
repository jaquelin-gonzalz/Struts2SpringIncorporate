package com.mx.subastas.bus;

import java.util.List;

import com.mx.subastas.vo.PerfilesVO;
import com.mx.subastas.vo.RespuestaVO;

public interface IPerfilesBUS {

	public RespuestaVO cregistrarPerfil(PerfilesVO perfilesVO);
	public RespuestaVO comprobarId(int id) ;
	public List<PerfilesVO> consultarListaPerfiles();
	public PerfilesVO consultarId(int id);
	public List<PerfilesVO> obtenerCatalogos();
	public PerfilesVO modificar(PerfilesVO registro) ;
	public void eliminar(int id) ;
}
