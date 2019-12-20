package com.mx.subastas.impl.bus;

import java.util.ArrayList;
import java.util.List;

import com.mx.subastas.bus.IUsuarioBUS;
import com.mx.subastas.dao.IPerfilesDAO;
import com.mx.subastas.dao.IUsuarioDAO;
import com.mx.subastas.util.ConeccionBD;
import com.mx.subastas.vo.RespuestaVO;
import com.mx.subastas.vo.UsuarioVO;

public class UsuarioBUS  implements IUsuarioBUS{

	ConeccionBD coneccionDB = new ConeccionBD();
	RespuestaVO respuestaVO;
	
	static List<UsuarioVO> listaUsuario = new ArrayList<UsuarioVO>();
	
    IUsuarioBUS iUsuarioBUS ;
    IPerfilesDAO iPerfilesDAO;
    IUsuarioDAO iUsuarioDAO;
    
	public IUsuarioBUS getiUsuarioBUS() {
		return iUsuarioBUS;
	}

	public void setiUsuarioBUS(IUsuarioBUS iUsuarioBUS) {
		this.iUsuarioBUS = iUsuarioBUS;
	}
	
	public IPerfilesDAO getiPerfilesDAO() {
		return iPerfilesDAO;
	}

	public void setiPerfilesDAO(IPerfilesDAO iPerfilesDAO) {
		this.iPerfilesDAO = iPerfilesDAO;
	}
	
	public IUsuarioDAO getiUsuarioDAO() {
		return iUsuarioDAO;
	}

	public void setiUsuarioDAO(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}

	@Override
	public String nombrar() {
		
		return "entro nombrar";
	}

	@Override
	public RespuestaVO registrar(UsuarioVO usuarioVO) {
			RespuestaVO respuestaVO;
			respuestaVO = comprobarId(usuarioVO.getId());
			if (respuestaVO.getBanderaGuardar() == false) {
				//usuarioDao.registrar(usuarioVO);
				
				if (iUsuarioDAO.registrar(usuarioVO) == true) {
					respuestaVO.setUsuarioVO(usuarioVO);
					respuestaVO.getListaUsuario();
					respuestaVO.setListaUsuario(iUsuarioDAO.obtener());
				}
			}
			return respuestaVO;
		
	}

	@Override
	public List<UsuarioVO> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaVO comprobarId(int id) {
		UsuarioVO usuarVO = iUsuarioDAO.findById(id);
		//obtenerCatalogos();
		RespuestaVO respuestaVO = new RespuestaVO();
		int cero = 0;
		respuestaVO.setBanderaGuardar(false);
		if (id == cero) {
			//logger.error("tu id ya se encuentra registrado");
			respuestaVO.setMensaje("Error \n Estas intentando registrar un ID Cero ");
			respuestaVO.setBanderaGuardar(true);
		//} else if (!listaUsuario.isEmpty()) {
		}
		
	   if (usuarVO.getId() != null && new Integer( id).compareTo(usuarVO.getId()) == 0) {
			//	logger.error("tu id ya se encuentra registrado");
				respuestaVO.setMensaje("Tu ID ya se encuentra registrado.");
				respuestaVO.setBanderaGuardar(true);
			}

		 else {
			//logger.error("bandera guardar es false ");
			respuestaVO.setBanderaGuardar(false);
		}
		return respuestaVO;
	}

	@Override
	public List<UsuarioVO> obtenerCatalogos() {
		
			listaUsuario = iUsuarioDAO.obtener();
			return listaUsuario;
	}

	@Override
	public List<UsuarioVO> consultarListaUsuarios() {
			return iUsuarioDAO.obtener();
	}

	@Override
	public RespuestaVO cregistrarUsuario(UsuarioVO usuarioVO) {
			
			RespuestaVO respuestaVO;
			respuestaVO = comprobarId(usuarioVO.getId());
			if (respuestaVO.getBanderaGuardar() == false) {
				//usuarioDao.registrar(usuarioVO);
				
				if (iUsuarioDAO.registrar(usuarioVO) == true) {
					respuestaVO.setUsuarioVO(usuarioVO);
					respuestaVO.getListaUsuario();
					respuestaVO.setListaUsuario(iUsuarioDAO.obtener());
				}
			}
			return respuestaVO;
		}

	@Override
	public UsuarioVO consultarId(int id) {
			UsuarioVO usuarVO = iUsuarioDAO.findById(id);
				return usuarVO;
	}

	@Override
	public UsuarioVO modificar(UsuarioVO registro) {
		
			UsuarioVO usuarioVO = iUsuarioDAO.findById(registro.getId());
			if (usuarioVO.getId() == registro.getId()) {
				iUsuarioDAO.eliminar(registro);
			}
			iUsuarioDAO.registrar(registro);
			return registro;
	}

	@Override
	public void eliminar(int id) {

			UsuarioVO usuarioVO = iUsuarioDAO.findById(id);
			if (usuarioVO.getId() == id) {
				iUsuarioDAO.eliminar(usuarioVO);
			
		}
	}
	
}
