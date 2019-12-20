package com.mx.subastas.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.mx.subastas.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AutentificacionInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("entro interceptor");

		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();

		System.out.println("entro interceptor");

		UsuarioVO loginVO = (UsuarioVO) sessionAttributes.get("nombre");

		HttpServletRequest request = ServletActionContext.getRequest();

		request.getServletPath();
		if (request.getServletPath().equals("/principal/login.action") || request.getServletPath().equals("/principal/logout.action")) {
			return actionInvocation.invoke();
		}
		request.getServletPath();

		if (sessionAttributes != null && loginVO != null) {
			for (int i = 0; i < loginVO.getPermisos().size(); i++) {
				if (loginVO.getPermisos().get(i).getPath().equals(request.getServletPath())) {
					return actionInvocation.invoke();
				}
			}

			return "sinPermisos";
		}
		return "loginn";

	}

}
