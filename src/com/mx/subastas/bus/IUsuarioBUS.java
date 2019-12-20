package com.mx.subastas.bus;

import java.util.List;

import com.mx.subastas.vo.RespuestaVO;
import com.mx.subastas.vo.UsuarioVO;

public interface IUsuarioBUS {

	public String nombrar() ;
	public RespuestaVO registrar(UsuarioVO usuarioVO) ;
	public List<UsuarioVO> obtener();
	public RespuestaVO comprobarId(int id);
	public List<UsuarioVO> obtenerCatalogos();
    public List<UsuarioVO> consultarListaUsuarios();
    public RespuestaVO cregistrarUsuario(UsuarioVO usuarioVO);
    public UsuarioVO consultarId(int id);
    public UsuarioVO modificar(UsuarioVO registro);
	public void eliminar(int id) ;

}
