package com.foo.rest;

public class VentaEnProcesoRQ {

	private String empresa;
	private String centro;
	private String terminal;
	private String transaccion;
	private String fecha;
	private String hora;
	private String tipoPeticion;

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getTipoPeticion() {
		return tipoPeticion;
	}
	public void setTipoPeticion(String tipoPeticion) {
		this.tipoPeticion = tipoPeticion;
	}

	@Override
	public String toString() {
		return "VentaEnProcesoRQ [empresa=" + empresa + ", centro=" + centro
				+ ", terminal=" + terminal + ", transaccion=" + transaccion
				+ ", fecha=" + fecha + ", hora=" + hora + ", tipoPeticion="
				+ tipoPeticion + "]";
	}

}
