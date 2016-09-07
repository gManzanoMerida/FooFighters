package com.foo.threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class StringsManagerThread extends Thread{
	
	private static final String LOGNAME = "es.eci.servicios.sksm0016.util.StringManager";
	private static final String ERROR_200_DESCRIPTION = null;
	private static final String ERROR_213_DESCRIPTION = null;
	private static final String ERROR_211_DESCRIPTION = null;
//	protected static Logging logging = null;	
	private static String loggin_operation = "StringManager";
//	static {
//		logging = LoggingFactory.getLogging(Constantes.NOMBRE_PROPERTIES);
//	}
	
	private String saleOpInput = null;
	private List<String> listStrings = null;
	
	private String error = "";
	
	private boolean fin = false;
	
	
	public StringsManagerThread(String saleOpInput){
		this.saleOpInput = saleOpInput;
		
	}
	
	@Override
	public void run() {
		List<String> l = getStrings(saleOpInput);
		setListStrings(l);
		fin = true;
		
		//synchronized (this) {
		//	this.notify();	
		//}
	}

	/**
	 * Calcula la lista de operaciones devueltas por VEP asociadas a una operación de entrada. Incluye calculo VeP.
	 * 
	 * @param saleOpInput
	 * @return
	 */
	private List<String> getStrings(String saleOpInput) {
		
//		if (logging.isTrazaEnabled(LOGNAME)) {
//		      logging.traza(LOGNAME, "::StringsManager::Calculo de totales para una operacion de venta ");
//		}
		
		//VALIDADCION DATOS DE LA OPERACIÓN DE ENTRADA///////////////////////////////////////////////////////////////
		//
		String orderNo = saleOpInput;
		String eciCustomerOrderNo = saleOpInput;
		String eciISPUNo = saleOpInput;
		String enterpriseCode = saleOpInput;
		String documentType = saleOpInput;
		String eciExchangeOrderNo = saleOpInput;
		//String eciShippingMethod = saleOpInput.getEciShippingMethod();
		String currency = saleOpInput;
		String sentJSONts = saleOpInput;
		String lineType = null;
		
		
		String errorInputJson=checkInputOVInfo(orderNo, eciCustomerOrderNo, eciISPUNo,
				enterpriseCode, documentType, currency);
		//
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//LLAMADA A VENTA EN PROCESO//////////////////////////////////////////////////////////////////////////////////
		//
//		VentaEnProcesoRQ ventaEnProcesoRQ = null;
//		VentaEnProcesoRS ventaEnProcesoRS = null;
		
		if (errorInputJson.equals(ERROR_200_DESCRIPTION)){
//			ventaEnProcesoRQ = getVentaEnProcesoRQ(orderNo, eciISPUNo, documentType, eciExchangeOrderNo, lineType);
			
//			if (ventaEnProcesoRQ!=null){
//				ventaEnProcesoRS = llamadaVEP(ventaEnProcesoRQ);
//			} else {
//				if (logging.isTrazaEnabled(LOGNAME)) {
//				      logging.traza(LOGNAME, "::StringsManager:: badRequest: "+ventaEnProcesoRQ);
//				}
//				
//				error = "ventaEnProcesoRQ="+ventaEnProcesoRQ.toString();
//			}
			
		} else {
//			if (logging.isTrazaEnabled(LOGNAME)) {
//			      logging.traza(LOGNAME, "::StringsManager:: falló la validación de datos del JSON.");
//			}
//			error = "validInputJson="+errorInputJson;
		}
		//
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//CREAR LA LISTA DE OPERATIONS DE LA RESPUESTA////////////////////////////////////////////////////////////////
		//
		String operation = null;
		List<String> listStrings = new ArrayList<String>();
//		if (null!=ventaEnProcesoRS){
//			operation = createString(ventaEnProcesoRS.getFecha(), ventaEnProcesoRS.getEmpresa(), ventaEnProcesoRS.getCentro(), 
//										ventaEnProcesoRS.getTerminal(), ventaEnProcesoRS.getTransaccion(), ventaEnProcesoRS.getHora(), 
//										ventaEnProcesoRS.getTipoPeticion(), ventaEnProcesoRS.getCodigo(), ventaEnProcesoRS.getResultado(),
//										ventaEnProcesoRS.getTipoVenta(), ventaEnProcesoRS.getAbono(), ventaEnProcesoRS.getMediosPago(),
//										ventaEnProcesoRS.getOperaciones(),Constantes.TIPO_OV);
//			listStrings.add(operation);
//			List<Suboperacion> suboperaciones = ventaEnProcesoRS.getSuboperaciones();
//			if (null!=suboperaciones){
//				for (Suboperacion currentSuboperacion:suboperaciones){
//					operation = createString(currentSuboperacion.getFecha(), currentSuboperacion.getEmpresa(), currentSuboperacion.getCentro(), 
//												currentSuboperacion.getTerminal(), currentSuboperacion.getTransaccion(), currentSuboperacion.getHora(), 
//												Constantes.STR_VACIA,Constantes.STR_VACIA,Constantes.STR_VACIA,
//												currentSuboperacion.getTipoVenta(), currentSuboperacion.getAbono(), currentSuboperacion.getMediosPago(),
//												currentSuboperacion.getOperaciones(),Constantes.TIPO_SUBOPERACION);
//					listStrings.add(operation);
//				}
//			}
//			error = "OK";
//		} else {
//			error = "ventaEnProcesoRS=null";
//			operation = new String();
//			operation.setResultCode(ERROR_400);
//			operation.setResultDescription(errorInputJson);
//			listStrings.add(operation);
//		}
		//
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		if (logging.isTrazaEnabled(LOGNAME)) {
//		      logging.traza(LOGNAME, "::StringsManager:: Se devuelven la lista de operaciones: "+listStrings.toString());
//		}
		return listStrings;
	}

	private String checkInputOVInfo(String orderNo, String eciCustomerOrderNo,
			String eciISPUNo, String enterpriseCode, String documentType,
			String lineType) {
		String validInputJson = ERROR_200_DESCRIPTION;
		//Comprueba la estructura
		if (orderNo==null){
			validInputJson=ERROR_213_DESCRIPTION;
		}else if (eciCustomerOrderNo==null){
			validInputJson=ERROR_211_DESCRIPTION; 
		}else{
//			for (SaleOpLineInput currentOpLine:saleOpLineList){
//				if (currentOpLine.getItemID()==null){
//					validInputJson=ERROR_212_DESCRIPTION;
//				}else if (currentOpLine.getLineType()==null){
//					validInputJson=ERROR_212_DESCRIPTION;
//				}else if (currentOpLine.getIsShippingCost()==null){
//					validInputJson=ERROR_212_DESCRIPTION;
//				}else if (currentOpLine.getEciShippingMethod()==null){
//					validInputJson=ERROR_212_DESCRIPTION;
//				}
//			}
		}
		if (eciISPUNo==null && lineType!=null){
//			if (lineType.equals(Constantes.LINE_TYPE_ISPU)||lineType.equals(Constantes.LINE_TYPE_CLICKNSEND)){
//				validInputJson=ERROR_213_DESCRIPTION;
//			}
		}
		//Comprueba valores nulos o incorrectos
		if (validInputJson.equals(ERROR_200_DESCRIPTION)){
//			if (orderNo.trim().equals(Constantes.STR_VACIA)){
//				validInputJson=ERROR_213_DESCRIPTION;
//			}else if (orderNo.length()!=Constantes.VEP_ORDERNO_FORMAT.length()){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (eciCustomerOrderNo.trim().equals(Constantes.STR_VACIA)){
//				validInputJson=ERROR_211_DESCRIPTION;		
//			}else if (enterpriseCode.trim().equals(Constantes.STR_VACIA)){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (!enterpriseCode.trim().equals(Constantes.EMP_ES)&&!enterpriseCode.trim().equals(Constantes.EMP_PT)){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (documentType.trim().equals(Constantes.STR_VACIA)){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (!documentType.trim().equals(Constantes.DOC_TYPE_STL_ENTREGA)&&!documentType.trim().equals(Constantes.DOC_TYPE_STL_DEVOLUCION)){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (currency.trim().equals(Constantes.STR_VACIA)){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (paymentMethods.isEmpty()){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (sentJSONts.trim().equals(Constantes.STR_VACIA)){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else if (saleOpLineList.isEmpty()){
//				validInputJson=ERROR_212_DESCRIPTION;
//			}else{
//				for (SaleOpLineInput currentOpLine:saleOpLineList){
//					if (currentOpLine.getItemID().trim().equals(Constantes.STR_VACIA)){
//						validInputJson=ERROR_212_DESCRIPTION;
//					}else if (currentOpLine.getLineType().trim().equals(Constantes.STR_VACIA)){
//						validInputJson=ERROR_212_DESCRIPTION;
//					}else if (currentOpLine.getIsShippingCost().trim().equals(Constantes.STR_VACIA)){
//						validInputJson=ERROR_212_DESCRIPTION;
//					}else if (currentOpLine.getEciShippingMethod().trim().equals(Constantes.STR_VACIA)){
//						validInputJson=ERROR_212_DESCRIPTION;
//					}
//				}
//			}
//			if (lineType!=null&&!lineType.equals(Constantes.STR_VACIA)){
//				if (lineType.equals(Constantes.LINE_TYPE_ISPU)||lineType.equals(Constantes.LINE_TYPE_CLICKNSEND)){
//					if (eciISPUNo.trim().equals(Constantes.STR_VACIA)){
//						validInputJson=ERROR_213_DESCRIPTION;
//					}else if (eciISPUNo.length()!=Constantes.VEP_ORDERNO_FORMAT.length()){
//						validInputJson=ERROR_212_DESCRIPTION;
//					}
//				}
//			}
		}
		return validInputJson;
	}
	
	/**
	 * Genera el request a VEP para una operación de venta de entrada al totalizador.
	 * Si orderNo o eciISPUNo no tienen la longitud exacta, no se creará la petición vep
	 * 
	 * @params orderNo,eciISPUNo,documentType,eciExchangeOrderNo,lineType
	 * @return ventaEnProcesoRQ
	 */
//	private static VentaEnProcesoRQ getVentaEnProcesoRQ(String orderNo, String eciISPUNo,String documentType, String eciExchangeOrderNo, String lineType) {
//		VentaEnProcesoRQ ventaEnProcesoRQ = null;
//		if (documentType.equals(Constantes.DOC_TYPE_STL_ENTREGA)&&(eciExchangeOrderNo==null||eciExchangeOrderNo.trim().equals(Constantes.STR_VACIA))){
//			if (lineType!=null&&!lineType.equals(Constantes.STR_VACIA)){
//				if (lineType.equals(Constantes.LINE_TYPE_ISPU)||lineType.equals(Constantes.LINE_TYPE_CLICKNSEND)){
//					ventaEnProcesoRQ = Utils.obtenerInfoEntradaVeP(eciISPUNo.trim());
//					if (logging.isTrazaEnabled(LOGNAME)) {
//						if (null!=ventaEnProcesoRQ){
//							logging.traza(LOGNAME, "::StringsManager::getVentaEnProcesoRQ::Se genera una petción a VEP para la Operación:(eciISPUNo):" + eciISPUNo + " --> " + ventaEnProcesoRQ.toString());
//						} else {
//							logging.traza(LOGNAME, "::StringsManager::getVentaEnProcesoRQ::No se pudo generar la petción a VEP para la Operación:(eciISPUNo):" + eciISPUNo + " --> ");
//						}
//					}
//				}else{
//					ventaEnProcesoRQ = Utils.obtenerInfoEntradaVeP(orderNo.trim());
//					if (logging.isTrazaEnabled(LOGNAME)) {
//						if (null!=ventaEnProcesoRQ){
//							logging.traza(LOGNAME, "::StringsManager::getVentaEnProcesoRQ::Se genera una petción a VEP para la Operación:(orderNo): " + orderNo + " --> " + ventaEnProcesoRQ.toString());
//						} else {
//							logging.traza(LOGNAME, "::StringsManager::getVentaEnProcesoRQ::No se pudo generar la petción a VEP para la Operación:(orderNo):" + orderNo + " --> ");
//						}
//					}
//				}
//			}
//		}
//		if (logging.isCustodiaEnabled(LOGNAME)){
//			logging.custodia(LOGNAME, new StringBuffer(128).append(Constantes.CONSULTA_VEP).append(JSONUtil.getJSONFromVentaEnProcesoRQ(ventaEnProcesoRQ)).toString(),loggin_operation, Constantes.PARAM_OPERTATION_RQEE);
//		}
//		return ventaEnProcesoRQ;
//		return null;
//	}

	/**
	 * Se hace la petición a VEP de las OP y MP de una operación de entrada
	 * 
	 * @params ventaEnProcesoRQ
	 * @return ventaEnProcesoRS
	 */
//	private VentaEnProcesoRS llamadaVEP(VentaEnProcesoRQ ventaEnProcesoRQ) {
//		VentaEnProcesoRS ventaEnProcesoRS = new VentaEnProcesoRS();
//		if (ventaEnProcesoRQ!=null){
//			OperacionVentaEnProceso proceso = new OperacionVentaEnProceso(ventaEnProcesoRQ);
//			String errorProceso = Constantes.STR_VACIA;
//			proceso.start();
//			try {
//				synchronized (proceso) {
//					proceso.wait();
//				}
//				if (proceso.getVentaEnProcesoRS()!=null ){
//					ventaEnProcesoRS = proceso.getVentaEnProcesoRS();
//				}  
//				if (null!=proceso.getError()){
//					if (logging.isTrazaEnabled(LOGNAME)) {
//					      logging.traza(LOGNAME, "::StringsManager::llamadaVEP::Error al invocar el servicio REST: "+proceso.getError());
//					}
//				}  
//			} catch (InterruptedException e) {
//				if (logging.isTrazaEnabled(LOGNAME)) {
//				      logging.traza(LOGNAME, "::StringsManager::llamadaVEP::Error al invocar el servicio REST: "+e);
//				}
//			}
//			errorProceso = proceso.getError();
//			if (ventaEnProcesoRS==null && null!=errorProceso){
//				if (logging.isTrazaEnabled(LOGNAME)) {
//				      logging.traza(LOGNAME, "::StringsManager::llamadaVEP::No hubo respuesta de VeP");
//				}
//			} else {
//				ventaEnProcesoRS.setResultCode(errorProceso);
//			}
//		}else{
//			if (logging.isTrazaEnabled(LOGNAME)) {
//				logging.traza(LOGNAME, "::StringsManager::llamadaVEP::RQ a VEP nulo");
//			}
//		}
//		if (logging.isCustodiaEnabled(LOGNAME)){
//			if (null!=ventaEnProcesoRS){
//				logging.custodia(LOGNAME, new StringBuffer(128).append(Constantes.RESPUESTA_VEP).append(JSONUtil.getJSONFromVentaEnProcesoRS(ventaEnProcesoRS)).toString(),loggin_operation, Constantes.PARAM_OPERTATION_RSEE);
//			}else{
//				logging.custodia(LOGNAME, new StringBuffer(128).append(Constantes.RESPUESTA_VEP).append("No hubo respuesta de VeP.").toString(),loggin_operation, Constantes.PARAM_OPERTATION_RSEE);
//			}
//		}
//		return ventaEnProcesoRS;
//	}

	/**
	 * Crea operacion
	 * 
	 * @params orderNo,eciISPUNo,documentType,eciExchangeOrderNo,lineType 
	 * @return ventaEnProcesoRQ
	 */
//	private static String createString(String fecha, String empresa, String centro, 
//			String terminal, String transaccion, String hora, String tipoPeticion, 
//			String codigo, String resultado, String tipoVenta, String abono, 
//			List<MedioPago> mediosPago, List<Operacion> operaciones, String type) {
//		
//		String operation = new String();
//		if (type.equals(Constantes.TIPO_OV)){
//			operation.setType(Constantes.TIPO_OV);
//		}else if (type.equals(Constantes.TIPO_SUBOPERACION)){
//			operation.setType(Constantes.TIPO_SUBOPERACION);
//		}
//		if (tipoVenta!=null){
//			operation.setSubOrderType(tipoVenta);
//		}else{
//			operation.setSubOrderType(Constantes.STR_VACIA);}	
//		if (fecha!=null&&empresa!=null&&centro!=null&&terminal!=null&&transaccion!=null&&hora!=null){
//			operation.setStringNo(empresa+centro+terminal+transaccion+fecha+hora);
//		}else{
//			operation.setSubOrderType(Constantes.STR_VACIA);
//		}
//		if (abono!=null){
//			operation.setCC(abono);
//		}else{
//			operation.setCC(Constantes.STR_VACIA);
//		}
//
//		ArrayList<Payment> listPayments = null;
//		if (codigo==null){
//			operation.setResultCode(String.valueOf(String.valueOf(HTTP_INTERNAL_SERVER_ERROR)));
//			operation.setResultDescription("Fallo en VEP");
//		}else if (codigo!=null&&codigo.equals(ERROR_00)){
//			listPayments = createOperarionListPayments(mediosPago, operaciones);
//			operation.setListPayments(listPayments);	
//			if (null!=listPayments){
//				ArrayList<PaymentTotals> listPaymentTotals = createStringListPaymentTotals(listPayments);
//				//listPaymentTotals (nivel operacion)
//				operation.setListPaymentTotals(listPaymentTotals);
//				//Totals (nivel operacion)
//				setStringTotals(operation, listPaymentTotals);
//				
//				operation.setResultCode(String.valueOf(codigo));
//				operation.setResultDescription(resultado);
//			}
//		}else if (codigo!=null&&codigo.equals(ERROR_01)){
//			operation.setResultCode(String.valueOf(codigo));
//			operation.setResultDescription(resultado);
//		}else if (codigo!=null&&codigo.equals(ERROR_02)){
//			operation.setResultCode(String.valueOf(codigo));
//			operation.setResultDescription(resultado);
//		}
//		
//		return operation;
//	}
//	
//	private static ArrayList<Payment> createOperarionListPayments(List<MedioPago> mediosPago, List<Operacion> operaciones) {
//		
//		ArrayList<Payment> listPayments = new ArrayList<Payment>();
//		if (mediosPago!=null && !mediosPago.isEmpty() ){
//			for (MedioPago currentMedioPago:mediosPago){
//				if (logging.isTrazaEnabled(LOGNAME)) {
//				      logging.traza(LOGNAME, "::StringsManager::createOperarionListPayments:: Medio de Pago OV/SOV: " + currentMedioPago.toString());
//				}
//				Payment payment = createPaymentFromMedioPago(null,currentMedioPago);
//				listPayments.add(payment);
//			}
//		}
//		if (operaciones!=null && !operaciones.isEmpty() ){
//			for (Operacion operacionDeOperacion:operaciones ){
//				List<MedioPago> mediosPagoOperacion = operacionDeOperacion.getMediosPago();
//				for (MedioPago currentMedioPago:mediosPagoOperacion){
//					if (logging.isTrazaEnabled(LOGNAME)) {
//					      logging.traza(LOGNAME, "::StringsManager::createOperarionListPayments:: Medio de Pago OP asociada a OV/SOV: " + currentMedioPago.toString());
//					}
//					Payment payment = createPaymentFromMedioPago(operacionDeOperacion,currentMedioPago);
//					listPayments.add(payment);
//				}
//				if ((operacionDeOperacion.getMediosPago()==null||operacionDeOperacion.getMediosPago().isEmpty())
//						&&operacionDeOperacion.getTipoVenta().equals(Constantes.TIPOVENTA_CUMPLIMENTACION)){
//					Payment payment = new Payment();
//					payment.setPaymentVEPOpType(operacionDeOperacion.getTipoVenta());
//					payment.setPaymentVEPOpNo(operacionDeOperacion.getEmpresa()+operacionDeOperacion.getCentro()+operacionDeOperacion.getTerminal()
//											 +operacionDeOperacion.getTransaccion()+operacionDeOperacion.getFecha()+operacionDeOperacion.getHora());
//				}
//			}
//		}
//		return listPayments;
//	}
//	
//	private static Payment createPaymentFromMedioPago(Operacion operacionDeOperacion,MedioPago currentMedioPago) {
//		
//		Payment payment = new Payment();
//		String paymentVEPCode = Constantes.STR_VACIA;
//		String paymentPGPCode = Constantes.STR_VACIA;
//		String paymentMaskedCard = Constantes.STR_VACIA;
//		String paymentVEPDate = Constantes.STR_VACIA;
//		String paymentVEPTime = Constantes.STR_VACIA;
//		String paymentVEPSubType = Constantes.STR_VACIA;
//		String paymentVEPSeller = Constantes.STR_VACIA;
//		String paymentVEPAuthorizationCode = Constantes.STR_VACIA;
//		String paymentVEPType = Constantes.STR_VACIA;
//		String paymentVEPOrigin = Constantes.STR_VACIA;
//		String paymentTotalAmount = Constantes.STR_VACIA;
//		String paymentChargedAmount = Constantes.STR_VACIA;
//		String paymentPendingAmount = Constantes.STR_VACIA;
//		String paymentReturnAmount = Constantes.STR_VACIA;
//		String paymentVEPOpType = Constantes.STR_VACIA;
//		String paymentVEPOpNo = Constantes.STR_VACIA;
//		String paymentVEPOpCC = Constantes.STR_VACIA;
//
//		if (currentMedioPago.getMoneda()!=null){
//			paymentVEPCode = currentMedioPago.getMoneda();
//		}
//		if (currentMedioPago.getCodigo()!=null&&currentMedioPago.getMoneda()!=null){
//			if (PropertiesReader.get(currentMedioPago.getCodigo()+currentMedioPago.getMoneda())!=null){
//				paymentPGPCode = PropertiesReader.get(currentMedioPago.getCodigo()+currentMedioPago.getMoneda());
//			}	
//		}
//		if (currentMedioPago.getDocumento()!=null){
//			paymentMaskedCard = currentMedioPago.getDocumento().toString().replaceAll("\\s+","");
//			if (paymentMaskedCard.length()>=4){
//				paymentMaskedCard = paymentMaskedCard.substring(0,4)+paymentMaskedCard.replaceAll("\\w(?=\\w{4})","*").substring(4);
//			}
//		}
//		if (currentMedioPago.getFecha()!=null){
//			paymentVEPDate = currentMedioPago.getFecha();
//		}
//		if ( currentMedioPago.getHora()!=null){
//			paymentVEPTime = currentMedioPago.getHora();
//		}
//		if (currentMedioPago.getSubtipo()!=null){
//			paymentVEPSubType = currentMedioPago.getSubtipo();
//		}
//		if (currentMedioPago.getVendedor()!=null){
//			paymentVEPSeller = currentMedioPago.getVendedor();
//		}
//		if (currentMedioPago.getAutorizacion()!=null){
//			paymentVEPAuthorizationCode = currentMedioPago.getAutorizacion();
//		}
//		if (currentMedioPago.getTipo()!=null){
//			paymentVEPType = currentMedioPago.getTipo();
//		}
//		if (currentMedioPago.getOrigen()!=null){
//			paymentVEPOrigin = currentMedioPago.getOrigen();
//		}
//		if (currentMedioPago.getTipo()!=null&&currentMedioPago.getOrigen()!=null&&currentMedioPago.getImporte()!=null){
//			if ((currentMedioPago.getTipo().equals(Constantes.TIPO_MP_OV)||currentMedioPago.getTipo().equals(Constantes.TIPO_MP_DEVUELTO))
//					&&!currentMedioPago.getOrigen().equals(Constantes.ORIGEN_PENDIENTE)){
//				paymentChargedAmount = String.valueOf(Math.abs((Double.parseDouble(currentMedioPago.getImporte()))/100));
//				paymentPendingAmount = Constantes.LITERAL_0;
//				paymentReturnAmount = Constantes.LITERAL_0;
//			}else if (currentMedioPago.getTipo().equals(Constantes.TIPO_MP_OV)&&currentMedioPago.getOrigen().equals(Constantes.TIPO_MP_COBRADO)){
//				paymentChargedAmount = Constantes.LITERAL_0;
//				paymentPendingAmount = String.valueOf(Math.abs((Double.parseDouble(currentMedioPago.getImporte()))/100));
//				paymentReturnAmount = Constantes.LITERAL_0;
//			}else if (currentMedioPago.getTipo().equals(Constantes.TIPO_MP_COBRADO)){
//				paymentChargedAmount = Constantes.LITERAL_0;
//				paymentPendingAmount = Constantes.LITERAL_0;
//				paymentReturnAmount = String.valueOf(Math.abs((Double.parseDouble(currentMedioPago.getImporte()))/100));
//			}else{
//				paymentChargedAmount = Constantes.LITERAL_0;
//				paymentPendingAmount = Constantes.LITERAL_0;
//				paymentReturnAmount = Constantes.LITERAL_0;
//			}
//			paymentTotalAmount = String.valueOf(Double.parseDouble(paymentChargedAmount)+Double.parseDouble(paymentPendingAmount)-Double.parseDouble(paymentReturnAmount));
//		}
//		if (operacionDeOperacion!=null){
//			if (operacionDeOperacion.getTipoVenta()!=null){
//				paymentVEPOpType = operacionDeOperacion.getTipoVenta() ;
//			}
//			if (operacionDeOperacion.getFecha()!=null&&operacionDeOperacion.getEmpresa()!=null&&operacionDeOperacion.getCentro()!=null
//					&&operacionDeOperacion.getTerminal()!=null&&operacionDeOperacion.getTransaccion()!=null&&operacionDeOperacion.getHora()!=null){
//				paymentVEPOpNo = operacionDeOperacion.getEmpresa()+operacionDeOperacion.getCentro()+operacionDeOperacion.getTerminal()
//						+operacionDeOperacion.getTransaccion()+operacionDeOperacion.getFecha()+operacionDeOperacion.getHora() ;
//			}
//			if (operacionDeOperacion.getAbono()!=null){
//				paymentVEPOpCC = operacionDeOperacion.getAbono() ;
//			}
//		}
//		
//		payment.setPaymentVEPCode(paymentVEPCode);
//		payment.setPaymentPGPCode(paymentPGPCode);
//		payment.setPaymentMaskedCard(paymentMaskedCard);
//		payment.setPaymentVEPDate(paymentVEPDate);
//		payment.setPaymentVEPTime(paymentVEPTime);
//		payment.setPaymentVEPSubType(paymentVEPSubType);
//		payment.setPaymentVEPSeller(paymentVEPSeller);
//		payment.setPaymentVEPAuthorizationCode(paymentVEPAuthorizationCode);
//		payment.setPaymentVEPType(paymentVEPType);
//		payment.setPaymentVEPOrigin(paymentVEPOrigin);
//		payment.setPaymentTotalAmount(paymentTotalAmount);
//		payment.setPaymentChargedAmount(paymentChargedAmount);
//		payment.setPaymentPendingAmount(paymentPendingAmount);
//		payment.setPaymentReturnAmount(paymentReturnAmount);
//		payment.setPaymentVEPOpType(paymentVEPOpType);
//		payment.setPaymentVEPOpNo(paymentVEPOpNo);
//		payment.setPaymentVEPOpCC(paymentVEPOpCC);
//		
//		return payment;
//		
//	}
//
//	private static ArrayList<PaymentTotals> createStringListPaymentTotals(ArrayList<Payment> listPayments) {
//		
//		if (logging.isTrazaEnabled(LOGNAME)) {
//		      logging.traza(LOGNAME, "::StringsManager::createStringListPaymentTotals:: Se agrupan 'listPayment' en 'listPaymentTotals'");
//		}
//		ArrayList<PaymentTotals> listPaymentTotals = new ArrayList<PaymentTotals>();
//		HashMap<String, PaymentTotals> mapGroupedListPaymentTotals = new HashMap<String, PaymentTotals>();
//		PaymentTotals paymentTotal = null;
//		for (Payment currentPayment:listPayments){
//			if (logging.isTrazaEnabled(LOGNAME)) {
//			      logging.traza(LOGNAME, "::StringsManager::createStringListPaymentTotals:: Se lee el 'Payment': "+ currentPayment.toString());
//			}
//			paymentTotal = new PaymentTotals();
//			paymentTotal.setPaymentVEPCode(currentPayment.getPaymentVEPCode());
//			paymentTotal.setPaymentPGPCode(currentPayment.getPaymentPGPCode());
//			paymentTotal.setPaymentMaskedCard(currentPayment.getPaymentMaskedCard());
//			String key = currentPayment.getPaymentVEPCode()+currentPayment.getPaymentPGPCode()+currentPayment.getPaymentMaskedCard();
//			if (mapGroupedListPaymentTotals.containsKey(key)){
//				if (logging.isTrazaEnabled(LOGNAME)) {
//				      logging.traza(LOGNAME, "::StringsManager::createStringListPaymentTotals:: Se arupa con: "+mapGroupedListPaymentTotals.get(key).toString());
//				}
//				paymentTotal.setPaymentChargedAmount(String.valueOf(
//						Double.parseDouble(currentPayment.getPaymentChargedAmount())
//						+Double.parseDouble(mapGroupedListPaymentTotals.get(key).getPaymentChargedAmount())));
//				paymentTotal.setPaymentPendingAmount(String.valueOf(
//						Double.parseDouble(currentPayment.getPaymentPendingAmount())
//						+Double.parseDouble(mapGroupedListPaymentTotals.get(key).getPaymentPendingAmount())));
//				paymentTotal.setPaymentReturnAmount(String.valueOf(
//						Double.parseDouble(currentPayment.getPaymentReturnAmount())
//						+Double.parseDouble(mapGroupedListPaymentTotals.get(key).getPaymentReturnAmount())));
//			}else{
//				paymentTotal.setPaymentChargedAmount(String.valueOf(Double.parseDouble(currentPayment.getPaymentChargedAmount())));
//				paymentTotal.setPaymentPendingAmount(String.valueOf(Double.parseDouble(currentPayment.getPaymentPendingAmount())));
//				paymentTotal.setPaymentReturnAmount(String.valueOf(Double.parseDouble(currentPayment.getPaymentReturnAmount())));
//			}
//			paymentTotal.setPaymentTotalAmount(String.valueOf(
//					Double.parseDouble(paymentTotal.getPaymentChargedAmount())+
//					Double.parseDouble(paymentTotal.getPaymentPendingAmount())-
//					Double.parseDouble(paymentTotal.getPaymentReturnAmount())));
//			if (logging.isTrazaEnabled(LOGNAME)) {
//			      logging.traza(LOGNAME, "::StringsManager::createStringListPaymentTotals:: Se añade/actualiza al 'listPaymentTotals' el PaymenTotal: "+paymentTotal.toString());
//			}
//			mapGroupedListPaymentTotals.put(key, paymentTotal);
//		}
//		for (Entry<String, PaymentTotals> pt: mapGroupedListPaymentTotals.entrySet()) {
//			listPaymentTotals.add(pt.getValue());
//		}
//	
//		return listPaymentTotals;
//		
//	}
//	
//	private static void setStringTotals(String operation, ArrayList<PaymentTotals> listPaymentTotals) {
//		
//		if (logging.isTrazaEnabled(LOGNAME)) {
//		      logging.traza(LOGNAME, "::StringsManager::setStringTotals:: Se calculan los totales para lo operation: "+operation);
//		}
//		String paymentTotalAmount = Constantes.LITERAL_0;
//		String paymentChargedAmount = Constantes.LITERAL_0;
//		String paymentPendingAmount = Constantes.LITERAL_0;
//		String paymentReturnAmount = Constantes.LITERAL_0;
//		for (PaymentTotals currentPaymentTotal:listPaymentTotals){ 
//			if (logging.isTrazaEnabled(LOGNAME)) {
//			      logging.traza(LOGNAME, "::StringsManager::setStringTotals:: Se lee el 'paymentTotal': "+ currentPaymentTotal.toString());
//			}
//			paymentChargedAmount = String.valueOf(Double.parseDouble(paymentChargedAmount)
//												 +Double.parseDouble(currentPaymentTotal.getPaymentChargedAmount()));
//			paymentPendingAmount = String.valueOf(Double.parseDouble(paymentPendingAmount)
//												 +Double.parseDouble(currentPaymentTotal.getPaymentPendingAmount()));	
//			paymentReturnAmount = String.valueOf(Double.parseDouble(paymentReturnAmount)
//												 +Double.parseDouble(currentPaymentTotal.getPaymentReturnAmount()));
//		}
//		paymentTotalAmount = String.valueOf(Double.parseDouble(paymentChargedAmount)
//										   +Double.parseDouble(paymentPendingAmount)
//										   +Double.parseDouble(paymentReturnAmount));
//		operation.setPaymentTotalAmount(paymentTotalAmount);
//		operation.setPaymentChargedAmount(paymentChargedAmount);
//		operation.setPaymentPendingAmount(paymentPendingAmount);
//		operation.setPaymentReturnAmount(paymentReturnAmount);
//		if (logging.isTrazaEnabled(LOGNAME)) {
//		      logging.traza(LOGNAME, "::StringsManager::setStringTotals:: Totales calculados: "
//		      									+"'paymentTotalAmount='"+paymentTotalAmount
//												+"'paymentChargedAmount='"+paymentChargedAmount
//												+"'paymentPendingAmount='"+paymentPendingAmount   
//												+"'paymentReturnAmount='"+paymentReturnAmount);
//		}
//		
//	}

	public List<String> getListStrings() {
		return listStrings;
	}

	public void setListStrings(List<String> listStrings) {
		this.listStrings = listStrings;
	}
	
	public String getString() {
		return saleOpInput;
	}

	public void setString(String saleOpInput) {
		this.saleOpInput = saleOpInput;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	
	
}
