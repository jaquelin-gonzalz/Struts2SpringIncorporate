package com.mx.subastas.impl.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mx.subastas.dao.IUsuarioDAO;
import com.mx.subastas.util.ConeccionBD;
import com.mx.subastas.vo.UsuarioVO;



public class UsuarioDAO implements IUsuarioDAO{

    ConeccionBD coneccionDB = new ConeccionBD();
 
    
	Statement stm = null;
	PreparedStatement pstmt = null;
	Connection con = null;

	ResultSet rs = null;

	boolean registrar = false;
	boolean actualizar = false;
	boolean eliminar = false;

	@Override
	public boolean registrar(UsuarioVO usuarioVO) {
		String query = " INSERT into sprinusu (Id, UsuarioId, Telefono, Correo, Contrasena ,id_perfil)" + " values (?, ?,?,?,?,?)";

		try {
			con = ConeccionBD.conectar();
			

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, usuarioVO.getId());
			preparedStmt.setString(2, usuarioVO.getNombre());
			preparedStmt.setString(3, usuarioVO.getTelefono());
			preparedStmt.setString(4, usuarioVO.getCorreo());
			preparedStmt.setString(5, usuarioVO.getPassword());
			preparedStmt.setInt(6, usuarioVO.getId_perfil());
			
			
			preparedStmt.executeUpdate();
			registrar = true;
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase UsuarioDao, método registrar", e);
		}
		
		return registrar;
	}

	@Override
	public List<UsuarioVO> obtener() {
		ArrayList<UsuarioVO> listaObtenidaUsuario = new ArrayList<UsuarioVO>();
		
		String sql =" SELECT A.Id,A.UsuarioId,A.telefono, A.correo,A.contrasena, B.perfil FROM sprinusu A INNER JOIN sprinper B ON A.id_perfil = B.id_perfil";
		try {
			con = ConeccionBD.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(rs.getInt("Id"));
				usuarioVO.setNombre(rs.getString("UsuarioId"));
				usuarioVO.setTelefono(rs.getString("telefono"));
				usuarioVO.setCorreo(rs.getString("correo"));
				usuarioVO.setPassword(rs.getString("contrasena"));
				usuarioVO.setPerfil(rs.getString("perfil"));
				listaObtenidaUsuario.add(usuarioVO);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase EstadoDao, método obtener", e);
		}
		return listaObtenidaUsuario;
	}

	@Override
	public UsuarioVO findById(int id) {
		String sql = "SELECT Id,UsuarioId,Telefono, Correo,Contrasena,id_perfil FROM sprinusu  WHERE Id='" + id + "'";
		UsuarioVO usuarioVO = new UsuarioVO();
		try {
			con = ConeccionBD.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			if (rs.next()) {

				usuarioVO.setId(rs.getInt("Id"));
				usuarioVO.setNombre(rs.getString("UsuarioId"));
				usuarioVO.setTelefono(rs.getString("Telefono"));
				usuarioVO.setCorreo(rs.getString("Correo"));
				usuarioVO.setPassword(rs.getString("Contrasena"));
				usuarioVO.setId_perfil(rs.getInt("id_perfil"));
							
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase EstadoDao, método obtener", e);
		}
		return usuarioVO;
	}
	public boolean eliminar(UsuarioVO usuarioVO) {

		String sql = "	delete from sprinusu where Id ='" + usuarioVO.getId() + "'";
		try { 	 	 	 
			con = ConeccionBD.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
		} catch (SQLException e) {
			//logger.error("Error: Clase EstadoDao, método eliminar", e);
		}
		return eliminar;
	}
	
	
 
}
