package com.mx.subastas.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.mx.subastas.bus.IPerfilesBUS;
import com.mx.subastas.bus.IUsuarioBUS;
import com.mx.subastas.dao.IUsuarioDAO;
import com.mx.subastas.vo.RespuestaVO;
import com.mx.subastas.vo.UserBean;
import com.mx.subastas.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Dinesh Rajput
 *
 */
public class UsuarioAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	
	private UserBean userBean;
	
	private UsuarioVO usuarioVO;
		
	private IUsuarioBUS iUsuarioBUS;
	private IPerfilesBUS iPerfilesBUS;
		
	private int banderaEnable;
	
	public IUsuarioBUS getiUsuarioBUS() {
		return iUsuarioBUS;
	}

	public void setiUsuarioBUS(IUsuarioBUS iUsuarioBUS) {
		this.iUsuarioBUS = iUsuarioBUS;
	}
	
	public IPerfilesBUS getiPerfilesBUS() {
		return iPerfilesBUS;
	}

	public void setiPerfilesBUS(IPerfilesBUS iPerfilesBUS) {
		this.iPerfilesBUS = iPerfilesBUS;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}

	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}
	
	public int getBanderaEnable() {
		return banderaEnable;
	}

	public void setBanderaEnable(int banderaEnable) {
		this.banderaEnable = banderaEnable;
	}

	public String execute()
	{
		
		System.out.println("" + iUsuarioBUS.nombrar());
		return SUCCESS;
	}
	
	public String addUser()
	{
		
		System.out.println("entro a registrar");
		usuarioVO.setListaPerfiles(iPerfilesBUS.consultarListaPerfiles());
		RespuestaVO respuestaVO = iUsuarioBUS.registrar(usuarioVO);
		if (respuestaVO.getUsuarioVO() == null) {
			usuarioVO.setMensaje(respuestaVO.getMensaje());
			return "cregistrar";
		} else {
			usuarioVO.setListaUsuarios(respuestaVO.getListaUsuario());
			return "cusuario";
		}
	}
	
	public String entrarMenu2() {
		usuarioVO = new UsuarioVO();
		usuarioVO.setListaUsuarios(iUsuarioBUS.consultarListaUsuarios());
		return "ctgUsuario";
	}
	public String cregistrar() {
		usuarioVO = new UsuarioVO();
		usuarioVO.setListaPerfiles(iPerfilesBUS.consultarListaPerfiles());
		return "cregistrar";
	}

	public String registrar() {

		System.out.println("entro a registrar");
		usuarioVO.setListaPerfiles(iPerfilesBUS.consultarListaPerfiles());
		RespuestaVO respuestaVO = iUsuarioBUS.cregistrarUsuario(usuarioVO);
		if (respuestaVO.getUsuarioVO() == null) {
			usuarioVO.setMensaje(respuestaVO.getMensaje());
			return "cregistrar";
		} else {
			usuarioVO.setListaUsuarios(respuestaVO.getListaUsuario());
			return "cusuario";
		}

	}

	public String buscar() {
		usuarioVO = iUsuarioBUS.consultarId(usuarioVO.getId());
		usuarioVO.setListaPerfiles(iPerfilesBUS.consultarListaPerfiles());
		return "resultadoBusc";
	}

	public String modificar() {

		iUsuarioBUS.modificar(usuarioVO);
		usuarioVO.setListaUsuarios(iUsuarioBUS.obtenerCatalogos());
		return "modifica";
	}

	public String eliminar() {
		setBanderaEnable(2);
		iUsuarioBUS.eliminar(usuarioVO.getId());
		usuarioVO.setListaUsuarios(iUsuarioBUS.obtenerCatalogos());
		return "elimina";
	}

	public String regresar() {
		return "menu";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
