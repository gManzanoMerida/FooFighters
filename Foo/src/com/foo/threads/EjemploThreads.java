package com.foo.threads;

public class EjemploThreads {
//	
//private void createBasketListOperationsThreads(TotalInfo totalsInfo, TotalInfoRS totalInfoRS) {
//		
//		boolean allThreadsDone = false;
//		List<OperationsManagerThread> operationsManagerThreadList = new ArrayList<OperationsManagerThread>();
//		List<Operation> listOperations =  new ArrayList<Operation>();
//		
//		//Lanzamos un thread para cada operaciond de venta de la cesta y salvamos todos los threads ebn un array
//		for(SaleOpInput saleOpInput:totalsInfo.getTotalInfo()) {			
//			OperationsManagerThread operationsManagerThread = new OperationsManagerThread(saleOpInput);
//			operationsManagerThreadList.add(operationsManagerThread);			
//			operationsManagerThread.start();
//		} 
//		
//		//Gestion de hilos: si algún hilo no ha terminado se le da 1 segundo de tiempo, durante 12 intentos o segundos (1000 ms * 12).
//		//Este calculo sale del tiempo max de la llamada a VeP mas 2 segundos, (10+2), por si a caso.
//		int numIntentos = 0;
//		while (!allThreadsDone && numIntentos < MAX_INTENTOS_THREADS) {
//			for (OperationsManagerThread op:operationsManagerThreadList) {
//				allThreadsDone = op.isFin();
//				if (!allThreadsDone) {
//					try {
//						Thread.sleep(1000);
//					} catch (Exception e) {
//					}
//					break;	
//				}
//			}
//			numIntentos++;
//		}
//		
//		// Ya es seguro que han terminado todos O alguno no termina de ninguna forma.
//		//Acumulamos todas las suboperaciones de cada operacion en una lista 
//		for (OperationsManagerThread op:operationsManagerThreadList) {
//			listOperations.addAll(op.getListOperations());			
//		}
//		//Asignamos la lista completa a la respuesta del TOT
//		if (listOperations!=null && !listOperations.isEmpty()) {
//			totalInfoRS.setListOperations(listOperations);	
//		}
//		
//	}
	
	
	public static void main(String[] args) {
	
		//Como gestionar multiples threas
		
	}

}
