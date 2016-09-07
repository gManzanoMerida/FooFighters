package com.foo.rest;

import java.util.List;

public class VentaEnProcesoRS {

	private String fecha;
	private String empresa;
	private String centro;
	private String terminal;
	private String transaccion;
	private String hora;
	private String tipoPeticion;
	private String codigo;
	private String resultado;
	private String tipoVenta;
	private String abono;
	private String resultCode;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getTipoVenta() {
		return tipoVenta;
	}
	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}
	public String getAbono() {
		return abono;
	}
	public void setAbono(String abono) {
		this.abono = abono;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	@Override
	public String toString() {
		return "VentaEnProcesoRS [fecha=" + fecha + ", empresa=" + empresa + ", centro=" + centro + ", terminal=" + terminal + ", transaccion="
				+ transaccion + ", hora=" + hora + ", tipoPeticion=" + tipoPeticion + ", codigo=" + codigo + ", resultado=" + resultado
				+ ", tipoVenta=" + tipoVenta + ", abono=" + abono + ", resultCode=" + resultCode + "]";
	}



}
