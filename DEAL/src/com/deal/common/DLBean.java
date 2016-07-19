package com.deal.common;

import java.lang.reflect.Field;

import net.sf.json.JSONObject;

/**
 * 
 * @author Gabriel Manzano Mérida
 *
 */
abstract public class DLBean {

	private String chg;

	public DLBean() {
		setChg("");
	}

	public void copyTo(DLBean Destino) {
		Destino.copyFrom(this);
	}

	public void copyFrom(DLBean Origen) {
		// Busca cada campo del Origen aqui, en el Destino, y lo "intenta"
		// copiar.
		for (Field fldOrigen : Origen.getClass().getDeclaredFields()) {
			try {
				Field fldDestino = this.getClass().getField(fldOrigen.getName());
				if (fldDestino != null) {
					fldDestino.set(this, fldDestino.get(Origen));
				}
			} catch (SecurityException e) {
				// e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
			} catch (IllegalAccessException e) {
				// e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// e.printStackTrace();
			}
		}
	}

	public String getChg() {
		return chg;
	}

	public void setChg(String chg) {
		this.chg = chg;
	}

	public String toString() {
		JSONObject obj = new JSONObject();
		Object valor_N = null;
		Object valor_V = null;
		for (Field f : this.getClass().getFields()) {
			try {
				valor_N = f.getName();
				valor_V = f.get(this);
			} catch (SecurityException e) {
				// e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
			} catch (IllegalAccessException e) {
				// e.printStackTrace();
			}
			if (valor_N != null && valor_V != null) {
				obj.put(valor_N.toString(), valor_V.toString());
			}
		}
		return obj.toString();
	}

}
