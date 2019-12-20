package com.mx.subastas.impl.bus;

import java.util.ArrayList;
import java.util.List;

import com.mx.subastas.bus.IPerfilesBUS;
import com.mx.subastas.dao.IPerfilesDAO;

import com.mx.subastas.vo.PerfilesVO;
import com.mx.subastas.vo.RespuestaVO;


public class PerfilesBUS implements IPerfilesBUS{

	private IPerfilesDAO iPerfilesDAO ;

	
	public IPerfilesDAO getiPerfilesDAO() {
		return iPerfilesDAO;
	}

	public void setiPerfilesDAO(IPerfilesDAO iPerfilesDAO) {
		this.iPerfilesDAO = iPerfilesDAO;
	}

	static List<PerfilesVO> listaPerfiles = new ArrayList<PerfilesVO>();

	@Override
	public RespuestaVO comprobarId(int id) {
		PerfilesVO perfilesVO = iPerfilesDAO.findById(id);
		RespuestaVO respuestaVO = new RespuestaVO();
		int cero = 0;
		respuestaVO.setBanderaGuardar(false);
		if (id == cero) {
			
			respuestaVO.setMensaje("Error \n Estas intentando registrar un ID Cero ");
			respuestaVO.setBanderaGuardar(true);
		} 
	//	if ( id ==  perfilesVO.getId_perfil()) {
			
		
		if (perfilesVO.getId_perfil() != null && new Integer( id).compareTo(perfilesVO.getId_perfil()) == 0) {
			//	logger.error("tu id ya se encuentra registrado");
				respuestaVO.setMensaje("Tu ID ya se encuentra registrado.");
				respuestaVO.setBanderaGuardar(true);
			}

		 else {
			//logger.error("bandera guardar es false ");
			respuestaVO.setBanderaGuardar(false);
		}
		return respuestaVO;
		
		
		
		
		
		
		
		
/*		else if (!listaPerfiles.isEmpty()) {
		
			if (perfilesVO.getId_perfil() == id  ) {
				
				respuestaVO.setMensaje("Tu ID ya se encuentra registrado ");
				respuestaVO.setBanderaGuardar(true);
			}

		} else {
			
			respuestaVO.setBanderaGuardar(false);
		}
		return respuestaVO;*/
	}

	@Override
	public RespuestaVO cregistrarPerfil(PerfilesVO perfilesVO) {
		RespuestaVO respuestaVO;
		respuestaVO = comprobarId(perfilesVO.getId_perfil());
		if (respuestaVO.getBanderaGuardar() == false) {

			if (iPerfilesDAO.registrar(perfilesVO) == true) {
				respuestaVO.setPerfilesVO(perfilesVO);
				respuestaVO.getListaPerfil();
				respuestaVO.setListaPerfil(iPerfilesDAO.obtener());
			}
		}
		return respuestaVO;
	}

	@Override
	public List<PerfilesVO> obtenerCatalogos() {
		listaPerfiles = iPerfilesDAO.obtener();
		return listaPerfiles;
	}

	@Override
	public PerfilesVO consultarId(int id) {
		PerfilesVO perfilesVO = iPerfilesDAO.findById(id);
		return perfilesVO;
	}

	@Override
	public List<PerfilesVO> consultarListaPerfiles() {
		iPerfilesDAO.obtener();
		return iPerfilesDAO.obtener();
	}

	@Override
	public PerfilesVO modificar(PerfilesVO registro) {
		
			PerfilesVO perfileVO = iPerfilesDAO.findById(registro.getId_perfil());
			if (perfileVO.getId_perfil() == registro.getId_perfil()) {
				iPerfilesDAO.eliminar(registro);
			}
			iPerfilesDAO.registrar(registro);
			return registro;
		
	}

	@Override
	public void eliminar(int id) {
		PerfilesVO perfilesVO = iPerfilesDAO.findById(id);
		if (perfilesVO.getId_perfil() == id) {
			iPerfilesDAO.eliminar(perfilesVO);
		}
	
		
	}
}
