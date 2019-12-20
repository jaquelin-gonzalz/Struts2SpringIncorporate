package com.mx.subastas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionBD {

	public static Connection conectar() {
		Connection conexion = null;
		String user = "usrsprin";
		String password = "*spr1n*";
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			//String url3 = "jdbc:sqlserver://localhost:3306/administracion_ventura";
			String url = "jdbc:jtds:sqlserver://192.168.11.4;databaseName=Catalogos_Spring;instance=desarrollo";
			conexion= DriverManager.getConnection(url,user,password);
			//conexion = DriverManager.getConnection(url3, user, password);
			if (conexion != null) {
				System.out.println("Conexión : Conexión a mibase satisfacoria");
			}
		} catch (SQLException | ClassNotFoundException e) {
			//logger.error("Error en la conexión, verifique, su usuario y password o el nombre de la base a la que intenta conectarse",e);
		}
		return conexion;
	}
	
	public static void main(String[] args) {
		conectar();
	}
}


