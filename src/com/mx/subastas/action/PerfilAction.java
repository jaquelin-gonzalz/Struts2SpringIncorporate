package com.mx.subastas.action;

import com.mx.subastas.bus.IPerfilesBUS;
import com.mx.subastas.impl.bus.PerfilesBUS;
import com.mx.subastas.vo.PerfilesVO;
import com.mx.subastas.vo.RespuestaVO;
import com.opensymphony.xwork2.ActionSupport;


public class PerfilAction  extends ActionSupport {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private RespuestaVO repuestaVO = new RespuestaVO();
		private IPerfilesBUS iPerfilesBUS;

		private PerfilesVO perfilVO;
		
		private int banderaEnable;
		
		public int getBanderaEnable() {
			return banderaEnable;
		}

		public void setBanderaEnable(int banderaEnable) {
			this.banderaEnable = banderaEnable;
		}

		public PerfilesVO getPerfilVO() {
			return perfilVO;
		}

		public void setPerfilVO(PerfilesVO perfilVO) {
			this.perfilVO = perfilVO;
		}
		
		public IPerfilesBUS getiPerfilesBUS() {
			return iPerfilesBUS;
		}

		public void setiPerfilesBUS(IPerfilesBUS iPerfilesBUS) {
			this.iPerfilesBUS = iPerfilesBUS;
		}

		public String registrar() {

			System.out.println("entro a registrar");
			RespuestaVO respuestaVO = iPerfilesBUS.cregistrarPerfil(perfilVO);
			if (respuestaVO.getPerfilesVO() == null) {
				perfilVO.setMensaje(respuestaVO.getMensaje());
				return "cregistrar";
			} else {
				perfilVO.setListaPerfiles(respuestaVO.getListaPerfil());
				return "cperfiles";
			}

		}

		public String entrarMenu() {
			perfilVO = new PerfilesVO();
			perfilVO.setListaPerfiles(iPerfilesBUS.consultarListaPerfiles());
			return "cperfiles";
		}

		public String buscar() {

			perfilVO = iPerfilesBUS.consultarId(perfilVO.getId_perfil());
			return "resultadoBusc";
		}

		public String modificar() {
			iPerfilesBUS.modificar(perfilVO);
			perfilVO.setListaPerfiles(iPerfilesBUS.obtenerCatalogos());
			return "modifica";
		}

		public String eliminar() {
			iPerfilesBUS.eliminar(perfilVO.getId_perfil());
			perfilVO.setListaPerfiles(iPerfilesBUS.obtenerCatalogos());
			return "elimina";
		}

	}