package com.mx.subastas.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.mx.subastas.bus.ILoginBUS;
import com.mx.subastas.vo.LoginVO;
import com.mx.subastas.vo.RespuestaVO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ILoginBUS iLoginBUS;
	private LoginVO loginVO;
	private Map<String, Object> session;
	
	public ILoginBUS getiLoginBUS() {
		return iLoginBUS;
	}
	public void setiLoginBUS(ILoginBUS iLoginBUS) {
		this.iLoginBUS = iLoginBUS;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public String verificar() {

		RespuestaVO respuestaVO = iLoginBUS.consultarUserPasword(loginVO.getUsuarioVO().getNombre(),loginVO.getUsuarioVO().getPassword());
		if (respuestaVO.getLoginVO() == null) {
			loginVO.setMensaje(respuestaVO.getMensaje());
			return "loginn";
		} else {
			session.put("nombre", respuestaVO.getLoginVO().getUsuarioVO());
			return "menu";
		}
	}
	public String salir() {
		session.remove("nombre");
		System.out.println("has salido satisfactoriamente");
		// Map<String, Object> sessionAttributes =
		// actionInvocation.getInvocationContext().getSession();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
}
