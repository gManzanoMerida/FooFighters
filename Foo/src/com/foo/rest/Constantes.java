package com.foo.rest;

public class Constantes {
	
	/**
	 * Fichero de configuración
	 */
	public static final String NOMBRE_PROPERTIES = "sksm0016";
	
	
	public static final String VEP_ORDERNO_FORMAT = "EEECCCCTTTTRRRRFFFFFFFFHHHHHH";
	/**
	 * CODIGOS
	 */
	public static final String CODIGO_EFECTIVO = "01";
	public static final String CODIGO_TARJETA_COMPRA = "02";
	public static final String CODIGO_TARJETA_ECI = "03";
	public static final String CODIGO_TARJETA_ECI_PT = "05";
	public static final String CODIGO_CUENTA_OC = "06";
	public static final String CODIGO_BANCOS = "07";
	public static final String CODIGO_FPP = "08";
	public static final String CODIGO_DIVISION_COM = "09";
	public static final String CODIGO_AGNC_VIAJES = "10";
	public static final String CODIGO_DATAFONO = "11";
	public static final String CODIGO_PPP = "18";
	public static final String CODIGO_IMPORTE_A_COBRAR = "99";
	/**
	 * TIPOS
	 */
	public static final String TIPO_MP_OV = "0";
	public static final String TIPO_MP_COBRADO = "2";
	public static final String TIPO_MP_DEVUELTO = "1";
	/**
	 * ORIGENES
	 */
	public static final String ORIGEN_FRONT = "0";
	public static final String ORIGEN_SAC = "1";
	public static final String ORIGEN_PENDIENTE = "2";
	public static final String ORIGEN_VEP = "3";
	/**
	 * SUBTIPOS
	 */
	public static final String SUBTIPO_SOLRED_BANCOS = "001";
	public static final String SUBTIPO_SOLRED_CONTING = "002";
	public static final String SUBTIPO_CHEQUE_COMBUST = "003";
	public static final String SUBTIPO_SOLRED_DESCUENTOS = "004";
	public static final String SUBTIPO_FUGAS= "005";
	public static final String SUBTIPO_CONSUMO_INTERNO = "006";
	public static final String SUBTIPO_VALES_REPSOL = "007";
	public static final String SUBTIPO_TRJT_REGALO_ES = "011";
	public static final String SUBTIPO_TRJT_REGALO_PT = "012";
	public static final String SUBTIPO_TRJT_ABONO_ES = "021";
	public static final String SUBTIPO_TRJT_ABONO_PT = "022";
	public static final String SUBTIPO_TRJT_REGALO_2_ES = "031";
	public static final String SUBTIPO_TRJT_REGALO_2_PT = "032";
	public static final String SUBTIPO_TRJT_PROMO_ES = "041";
	public static final String SUBTIPO_TRJT_PROMO_PT = "042";
	public static final String SUBTIPO_TRJT_FIDELIZACION = "061";
	
	/**
	 * TYPE
	 */
	public static final String TIPO_OV = "01";
	public static final String TIPO_SUBOPERACION = "02";
	
	/**
	 * TIPO_VENTA
	 */
	public static final String TIPOVENTA_RESCISION = "05";
	public static final String TIPOVENTA_CUMPLIMENTACION = "06";
	public static final String TIPOVENTA_RECOGIDA = "07";
	public static final String TIPOVENTA_ENTREGA_CXI = "08";
	public static final String TIPOVENTA_RECOGIDA_CXI = "09";
	public static final String TIPOVENTA_ENTREGA_PARCIAL = "10";
	
	/**
	 * MONEDA
	 */
	public static final String MONEDA_001 = "001";
	public static final String MONEDA_002 = "002";
	public static final String MONEDA_003 = "003";
	public static final String MONEDA_004 = "004";
	public static final String MONEDA_005 = "005";
	public static final String MONEDA_006 = "006";
	public static final String MONEDA_007 = "007";
	public static final String MONEDA_008 = "008";
	public static final String MONEDA_009 = "009";
	public static final String MONEDA_010 = "010";
	public static final String MONEDA_011 = "011";
	public static final String MONEDA_149 = "149";
	public static final String MONEDA_150 = "150";
	public static final String MONEDA_151 = "151";
	public static final String MONEDA_152 = "152";
	public static final String MONEDA_153 = "153";
	public static final String MONEDA_154 = "154";
	public static final String MONEDA_155 = "155";
	public static final String MONEDA_156 = "156";
	public static final String MONEDA_157 = "157";
	public static final String MONEDA_158 = "158";
	public static final String MONEDA_159 = "159";
	public static final String MONEDA_999 = "999";  
	
	
	/**
	 * Datos del servicio web
	 */
	public static final String NAMESPACE_SERVICIO = "http://es.eci.servicios.sksm0016";
	public static final String NOMBRE_SERVICIO = "sksm0016ws";
	public static final String NOMBRE_EXCEPCION = "Sksm0016Exception";
	
	public static final String PARAM_OPERTATION_RQ = "RQ";
	public static final String PARAM_OPERTATION_RS = "RS";
	public static final String STR_ERROR = "ERROR";
	
	/**
	 * Parámetros de entrada y salida interfaz SOAP
	 */   
    public static final String PARAM_GET_BASKET_TOTALS_INFORMATION_RS = "getBasketTotalsInformationRS";    
    public static final String PARAM_GET_BASKET_TOTALS_INFORMATION_RQ = "getBasketTotalsInformationRQ";
    
    public static final String PARAM_GET_SALEOP_TOTALS_INFORMATION_RS = "getSaleOpTotalsInformationRS";    
    public static final String PARAM_GET_SALEOP_TOTALS_INFORMATION_RQ = "getSaleOpTotalsInformationRQ";
    
	
    /**
     * Respuestas del servicio
     */
    public static final String RESPONSE_OK = "OK";
    public static final String RESPONSE_MESSAGE_OK = "Campos de totalizacion recuperados correctamente.";
    public static final String RESPONSE_KO = "KO";
    public static final String RESPONSE_MESSAGE_KO = "No se han recuperados campos de totalizacion.";
    
    
    public static final String RESPONSE_VEP_KO = "VEP_KO";
    public static final String RESPONSE_MESSAGE_VEP_KO = "No se han recuperados todos los campos de Venta en Proceso.";
    
    /**
     * Servicio Rest VeP
     */
    public static final String APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String POST = "POST";
    public static final String TIME_OUT = "10000";

//    ## Servicio Rest VeP - DES
//    servicioRestVeP=http://serviciosvep.des.eci.geci/serviciosvep/rest/2_0/mediosPagoOper//
//    ## Servicio Rest VeP - PRE
//    #servicioRestVeP=http://serviciosvep.pre.eci.geci/serviciosvep/rest/2_0/mediosPagoOper
    public static final String URL_SERVICIO_REST_VEP = PropertiesReader.get("servicioRestVeP");
	
    /**
	 * Parámetros de entrada interfaz REST
	 */   
    public static final String PARAM_LIST_ECI_CUSTOMER_ORDER_NO_RQ = "eciCustomerOrderNo";
    public static final String PARAM_LIST_TOTALS_INFO_JSON_RQ = "totalsInfoJSON";
    public static final String PARAM_LIST_ECI_ORDER_HEADER_KEY_RQ = "eciOrderHeaderKey";
	
	/**
	 * Campos de BBDD
	 */
    public static final int NUM_CONEXIONES_TOTALES = Integer.valueOf(PropertiesReader.getInt("numConexionesTotal"));
	public static final String DS_NOMBRE = PropertiesReader.get("dsnombre");

//	public static final String FIELD_LINE_KEY ="LINE_KEY"; 
//	public static final String FIELD_HEADER_KEY = "HEADER_KEY";

	/**
	 * Nombres de parámetros de cabecera
	 */
	public static final String HEADER_PARAM_APP_ID = "appId";
	public static final String HEADER_PARAM_TXN_ID = "txnId";
	
    /**
	 * Constantes auxiliares
	 */
	public static final String FORMATO_FECHA_ORACLE="YYYY-MM-DD HH:mm:ss.SSS";
	public static final String FORMATO_FECHA_LOG_KEY="YYYYMMDDHHmmssSSS";
	public static final String STR_VACIA = "";
	public static final String LITERAL_0 = "0";
	public static final String LITERAL_1 = "1";
//	public static final String VALOR_0 = "0.0";
	public static final double VALOR_0 = 0.0;
	public static final String BARRAN = "\n";
	public static final String BARRAT = "\t";
	public static final String BARRANT = "\n\t";
	public static final String BARRANGUION = "\n - ";
	public static final String STR_ESPACIO_ABREPARENTESIS = " (";
	public static final String STR_COMA_ESPACIO = ", ";
	public static final String STR_CIERRAPARENTESIS_ESPACIO_DOSPUNTOS_ESPACIO = ") : ";
	public static final String STR_ARRAY_DEFINE = "[L";
	public static final String STR_ARRAY_VIEW = "[ ] ";
	public static final String STR_PUNTOYCOMA = ";";
	public static final String STR_ESPACIO_DOSPUNTOS_ESPACIO = " : ";
	public static final String STR_ESPACIO = " ";
	
	/**
	 * Constantes de estado del pedido.
	 */
	public static final String REJECTED_STL_STATUS_ID = "3700.800";
	public static final String COMPLETED_STL_STATUS_ID = "3700.100";
	
	public static final String DOC_TYPE_STL_ENTREGA = "0001";
	public static final String DOC_TYPE_STL_DEVOLUCION = "0003";
	
	public static final String EMP_ES = "001";
	public static final String EMP_PT = "004";
	
	
	public static final String ECI_PAY_STATUS_NOT_CHARGED = "NOT CHARGED";

	public static final String SI = "S";
	public static final String YES = "Y";
	public static final String NO = "N";
	
	public static final String CREDIT_CARD = "004";
	public static final String PAY_PAL = "154";
	public static final String CONTRAREEMBOLSO = "003";
	public static final String CODIGO_300 = "300";
	public static final String COBRO_DIFERIDO = "004-dif";
	

	public static final String CHARGED = "CHARGED";

	/**
	 * LINE_TYPE
	 */
	public static final String LINE_TYPE_ISPU = "ISPU";
	public static final String LINE_TYPE_CLICKNSEND = "CLICKNSEND";


	/**
	 * Error Codes
	 */
	public static final String ERROR_CODE_201 = "201";
	public static final String ERROR_CODE_205 = "205";
	public static final String ERROR_CODE_205_DESCRIPTION = "No se ha podido insertar la informaci�n de totales para la cesta.";
	
	public static final String PARAM_OPERTATION_RQEE = "RQSE";
	public static final String CONSULTA_VEP = "Consulta VeP";
	public static final String PARAM_OPERTATION_RSEE = "RSSE";
	public static final String RESPUESTA_VEP = "Respuesta VeP";


}
