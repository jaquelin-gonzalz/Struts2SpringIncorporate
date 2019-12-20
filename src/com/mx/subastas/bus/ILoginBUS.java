package com.mx.subastas.bus;

import com.mx.subastas.vo.RespuestaVO;

public interface ILoginBUS {
	
	public RespuestaVO consultarUserPasword(String usuario, String password);

}
