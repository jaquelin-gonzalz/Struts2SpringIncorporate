package com.mx.subastas.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mx.subastas.dao.IPerfilesDAO;
import com.mx.subastas.util.ConeccionBD;
import com.mx.subastas.vo.PerfilesVO;

public class PerfilesDAO implements IPerfilesDAO {

	ConeccionBD db = new ConeccionBD();
	PreparedStatement pstmt = null;
	Connection con = null;
	Statement stm = null;

	ResultSet rs = null;
	
	boolean registrar = false;
	boolean actualizar = false;
	boolean eliminar = false;
	
	@Override
	public List<PerfilesVO> obtener() {
		ArrayList<PerfilesVO> listaObtenidaPerfil = new ArrayList<PerfilesVO>();
		String sql = "SELECT Id_Perfil , Perfil FROM sprinper ";

		try {
			con = ConeccionBD.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				PerfilesVO perflesVO = new PerfilesVO();
				perflesVO.setId_perfil(rs.getInt("Id_Perfil"));
				perflesVO.setPerfil(rs.getString("Perfil"));
				
				listaObtenidaPerfil.add(perflesVO);
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase EstadoDao, método obtener", e);
		}
		return listaObtenidaPerfil;
	}


	@Override
	public PerfilesVO findById(int id) {
		String sql = "SELECT Id_Perfil , Perfil FROM sprinper WHERE Id_Perfil='" + id + "'";
		PerfilesVO perfilesVO = new PerfilesVO();
		try {
			con = ConeccionBD.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				perfilesVO.setId_perfil(rs.getInt("Id_Perfil"));
				perfilesVO.setPerfil(rs.getString("Perfil"));
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase EstadoDao, método obtener", e);
		}
		return perfilesVO;
	}


	@Override
	public boolean registrar(PerfilesVO perfilesVo) {

		String query = "  insert into sprinper(Id_Perfil, Perfil)" + " values (?, ?)";

		try {
			con = ConeccionBD.conectar();
			//PropertyConfigurator.configure("log4j.properties");
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, perfilesVo.getId_perfil());
			preparedStmt.setString(2, perfilesVo.getPerfil());
			preparedStmt.executeUpdate();
			registrar = true;
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase UsuarioDao, método registrar", e);
		}
		//logger.info("finnnn");
		return registrar;
	}


	@Override
	public List<PerfilesVO> obtenerPermisos(int id_perfil) {
		ArrayList<PerfilesVO> listaPermisos = new ArrayList<PerfilesVO>();
		String sql = " SELECT A.id_perfil, B.id_path ,B.path FROM sprinppa A INNER JOIN sprinpat B ON A.id_path = B.id_path WHERE id_perfil = ?";

		
		try {
			con = ConeccionBD.conectar();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id_perfil);
			rs = ps.executeQuery();
			while (rs.next()) {
				PerfilesVO perfilesVO = new PerfilesVO();
				perfilesVO.setId_perfil(rs.getInt("id_perfil"));
				perfilesVO.setId_path(rs.getInt("id_path"));
				perfilesVO.setPath(rs.getString("path"));
				listaPermisos.add(perfilesVO);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			//logger.error("Error: Clase PerfilesDAO, método obtenerPermisos", e);
		}
		return listaPermisos;
	}


	@Override
	public boolean eliminar(PerfilesVO perfilesVO) {

		String sql = "DELETE FROM sprinper WHERE Id_Perfil='" + perfilesVO.getId_perfil() + "'";
		try {
			con = ConeccionBD.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
		} catch (SQLException e) {
			// logger.error("Error: Clase EstadoDao, método eliminar", e);
		}
		return eliminar;
	}

}
