package com.deal.common;

import java.io.File;

/**
 * @author Gabriel Manzano Mérida 2015
 *
 */
public class _K {
	
	public static final String MARCA_SINCRO_PENDIENTE = "P";
	
	public static final String unidadIntercambio = "c:";
	
	public static final String caminoInterfaz    = unidadIntercambio +File.separator+"datos"+File.separator+"SisExt"+File.separator;
	public static final String caminoSalida      = caminoInterfaz + "llamadas" + File.separator;
	public static final String caminoEntrada     = caminoInterfaz + "retornos" + File.separator;
	public static final String caminoExecExterno = caminoInterfaz + "exec"     + File.separator;
	
	public static final String ORIGINAL = "";
	public static final String REPLACEMENT = "AaEeIiOoUuNnUu";
	
	public static final String ejecutableExterno = "SE.bat";
	
	public static final String extFicParm = ".txt";
	
	public static final String sepFld = "\t";
	public static final String sepReg = "\r\n";
	public static final String sepReg_0x0D = "\r";
	public static final String sepReg_0x0A = "\n";
	
	//PATHS
	public static final String PATH_DOWNLOAD = "path_download";
	public static final String PATH_UPLOAD = "path_upload";//"C:\\datos\\deal";//
	public static final String PATH_UPLOAD_MAIL = "path_upload_mail";
	
	//Cliente / Proveedor
	public static final String SI = "S"; 
	public static final String NO = "N"; 
	//Si/No
	public static final String Si = "Si"; 
	public static final String No = "No"; 
		
	//Cliente / Proveedor
	public static final String CLIENTE = "C"; 
	public static final String PROVEEDOR = "P"; 
	
	//BD, Tablas y campos
	public static final String SUPRIMIDO = "Suprimido";
	
	public static final String DEAL = "\"DEAL\"";
	public static final String SINCRO = "Sincro";

	public static final String US_USUARIOS = "US_Usuarios";
	public static final String US_USUARIO = "Usuario"; 
	public static final String CUENTA_DE_SISTEMA = "SYS";

	public static final String VALOR_NS = "Valor no significativo";

	public static final String NO_APLICA = "No aplica.";

	public static final String CT_SUPRIMIDAS = "Cuentas Suprimidas";
	
}
