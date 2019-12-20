package com.mx.subastas.impl.bus;

import java.util.List;

import com.mx.subastas.bus.ILoginBUS;
import com.mx.subastas.dao.ILoginDAO;
import com.mx.subastas.dao.IPerfilesDAO;
import com.mx.subastas.vo.LoginVO;
import com.mx.subastas.vo.PerfilesVO;
import com.mx.subastas.vo.RespuestaVO;

public class LoginBUS implements ILoginBUS{

	private ILoginDAO iLoginDAO;
	private IPerfilesDAO iPerfilesDAO;
	
	public ILoginDAO getiLoginDAO() {
		return iLoginDAO;
	}
	public void setiLoginDAO(ILoginDAO iLoginDAO) {
		this.iLoginDAO = iLoginDAO;
	}
	public IPerfilesDAO getiPerfilesDAO() {
		return iPerfilesDAO;
	}
	public void setiPerfilesDAO(IPerfilesDAO iPerfilesDAO) {
		this.iPerfilesDAO = iPerfilesDAO;
	}

	@Override
	public RespuestaVO consultarUserPasword(String usuario, String password) {
		RespuestaVO respuestaVO = new RespuestaVO();
		LoginVO loginVO = iLoginDAO.obtenerUsuario(usuario);

		if (usuario.equals(loginVO.getUsuarioVO().getNombre()) && password.equals(loginVO.getUsuarioVO().getPassword())) {
			List<PerfilesVO> listaPerfilesVO = iPerfilesDAO.obtenerPermisos(loginVO.getUsuarioVO().getId_perfil());
			loginVO.getUsuarioVO().setPermisos(listaPerfilesVO);
			respuestaVO.setLoginVO(loginVO);

		} else {
			respuestaVO.setMensaje("Tu Usuario o contraseña son incorrectos");
			loginVO = null;
		}
		return respuestaVO;
	}
}
