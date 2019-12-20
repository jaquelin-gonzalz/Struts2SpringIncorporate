package com.mx.subastas.impl.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mx.subastas.dao.ILoginDAO;
import com.mx.subastas.util.ConeccionBD;
import com.mx.subastas.vo.LoginVO;

public class LoginDAO implements ILoginDAO{
	
	private Statement stm = null;
	private Connection con = null;
	private ResultSet rs = null;

	@Override
	public LoginVO obtenerUsuario(String usuario) {
		String sql = "select UsuarioId,Contrasena,id_perfil from  sprinusu where UsuarioId = ?";
		LoginVO loginVO = new LoginVO();
		try {
			con = ConeccionBD.conectar();
			PreparedStatement ps = con.prepareStatement(sql);
			// ps = con.createStatement();
			ps.setString(1, usuario);

			rs = ps.executeQuery();
			while (rs.next()) {
				
				loginVO.getUsuarioVO().setNombre(rs.getString("UsuarioId"));
				loginVO.getUsuarioVO().setPassword(rs.getString("Contrasena"));
				loginVO.getUsuarioVO().setId_perfil(rs.getInt("id_perfil"));
			
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase EstadoDao, método obtener", e);
		}
		return loginVO;
	}

	@Override
	public List<LoginVO> obtenerUsus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
