package com.deal.common;
 

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject; 
import com.deal.common.HttpRestClient; 
import com.deal.datasource.DBConnection;

import org.apache.http.message.BasicNameValuePair;

/**
 * @author Gabriel Manzano Mérida 2015
 *
 */
public class Utils {

//	private final static String tag = "Utils";
	
	public final static long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
	final static long DESDE = 1420070400000L;
	
	private static final int g_filas_DSPFIL = 50;

	public static final int DECIMALES = 2;

	public static String archivo_config = "com.bq.struts.ApplicationResource";
	public static String archivo_es     = "com.bq.struts.ApplicationResource";
	public static String archivo_en     = "com.bq.struts.ApplicationResource";
	
	private static String m_modoEjecucion;

	public Utils() {
		String msgId  = "configuracion.modo";
		m_modoEjecucion = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
	}
	////////////////////////
	public void sincroSesion_COMUN( HttpServletRequest request, String usr ) {
		if ( request == null || usr == null || usr.trim().length() < 1 ) return;
		///////////////////////////////////////
		
		///////////////////////////////////////
	}
	////////////////////////
	public static void sincro(final DBConnection bd, final String cuenta, final String usrLogon, final String emisor, final String receptor) {

//		System.out.println("Solicitud de sincroBD()...");
		
//        new Thread( new Runnable() {
//			public void run() {
//		        Sincronizacion.getInstance().sincronizar( bd, usrLogon, emisor, receptor );
//			}
//		} ).start();
	}
	///////////////////////////
	public boolean controlAcceso(HttpServletRequest request, String usr, String pgm) {
		
		if ( "Admin".equals( request.getSession().getAttribute("Admin") ) ) {
//			System.out.println("*** ADMIN : " + usr + " -> " + pgm );
			return true;
		}
		
		return controlAcceso(getDBConnection(request),usr,pgm);
	}
	public boolean controlAcceso(DBConnection dbConn, String usr, String pgm) {
		boolean resultado = false;
		///////////////////////////////////////////////////
		if ( usr == null || usr.trim().length() < 1 || pgm == null || pgm.trim().length() < 1 ) return resultado;
		///////////////////////////////////////
		// ..acceso a BD para comprobar si el usuario contempla la acción...

		// Ejemplo:
		//        com.sl.se_SeguridadUsuarioProgramas.db.SeAccesoBaseDatos db = new com.hh.se_SeguridadUsuarioProgramas.db.SeAccesoBaseDatos();
		//        com.hh.se_SeguridadUsuarioProgramas.bean.SeBean    reg_Se = new com.hh.se_SeguridadUsuarioProgramas.bean.SeBean();
		//        reg_Se.setSe_ANADVN( usr ); reg_Se.setSe_ANBATX( pgm );
		//        try {
		//            reg_Se = db.se_getRcd( dbConn, reg_Se );
		//            if (reg_Se!=null)
		resultado = true;
		//        } catch (DLException ex) {;}
		///////////////////////////////////////////////////
		return resultado;
	}
	public void Autenticacion_FS() {
		/////////////////////////////////////////
		// En OR: 2012/05/25 Se sospecha que ésto provoca "cuelgues" e impide el resto del proceso.
		// La solución ha sido incluirlo en un servlet de "startup". 
		// Por ejemplo, así quedaría en el "web.xml" con orden de inicio '0':
		
//    <servlet>
//        <servlet-name>atmStartUp</servlet-name>
//        <servlet-class>com.tm.__main.startup.atmStartUp</servlet-class>
//        <load-on-startup>0</load-on-startup>
//    </servlet>
//    <servlet-mapping>
//        <servlet-name>atmStartUp</servlet-name>
//        <url-pattern>/atmStartUp</url-pattern>
//    </servlet-mapping>
	
	// Y en el método "init()" del sevlet referido, se incluye la llamada:
		
//	public void init() {
//		try { super.init(); } catch (ServletException ex) { ex.printStackTrace(); }
//		com.tm._comun.Utils subrut = new com.tm._comun.Utils();
//		subrut.Autenticacion_FS();
//    }

		System.out.println("**** Autenticacion_FS() >>>>>>");
		/////////////////////
		DBConnection bd = null;
		try {
			bd = new DBConnection();
			if ( bd != null ) {
				String camino_red = getDBValueFromKey( bd, "SEG_pathDocs_NETUSE" );
				String usr_red    = getDBValueFromKey( bd, "SEG_pathDocs_USR");
				String pwd_red    = getDBValueFromKey( bd, "SEG_pathDocs_PWD");
				String strError   = "";
				try {
					System.out.println( "Aportando credenciales para " + camino_red );
					strError = logonRecursoRedWindows_sincro(camino_red, usr_red, pwd_red);
					if ( strError != null && strError.trim().length() > 01 ) {
						System.out.println( strError );
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		} catch (DLException ex) {
			ex.printStackTrace();
		}
		/////////////////////
		System.out.println("**** Autenticacion_FS() <<<<<<");
	}
	public String logonRecursoRedWindows_sincro(String camino, String usuario, String password) throws IOException, InterruptedException {

		/////////////////////////////////////////
		// En OR: 2012/05/25 Se sospecha que ésto provoca "cuelgues" e impide el resto del proceso.
		// Ver nota en 'Autenticacion_FS()'...
		/////////////////////////////////////////

		Process process = null;
		String strError = "";
		String strOutput = "";
		String comando = "cmd.exe /c NET USE " + camino + " " + password + " /USER:" + usuario;

		process = (Runtime.getRuntime()).exec( comando );

		if ( process != null ) {
			///////////////////////
			// Canales de entrada/salida del proceso:
			String line;
			java.io.BufferedReader ir = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
			java.io.BufferedReader er = new java.io.BufferedReader(new java.io.InputStreamReader(process.getErrorStream()));

			while ((line = er.readLine()) != null) {
				System.out.println(line);
				strError += line + '\n';
			}
			while ((line = ir.readLine()) != null) {
				System.out.println(line);
				strOutput += line + '\n';
			}

			ir.close();
			er.close();
			process.waitFor();
			process.destroy();
			///////////////////////
		}
		return strError;
	}
	////////////////////////
	public static String run_comando_sincro( String[] params ) throws DLException {
		String strError = "";
		String strOutput = "";
		Process process = null;
		try {
			process = new ProcessBuilder( params ).start();
			if ( process != null ) {
				///////////////////////
				// Canales de entrada/salida del proceso:
				String line;
				java.io.BufferedReader ir = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
				java.io.BufferedReader er = new java.io.BufferedReader(new java.io.InputStreamReader(process.getErrorStream()));

				while ((line = er.readLine()) != null) {
					// System.err.println(line);
					strError += line + '\n';
				}
				while ((line = ir.readLine()) != null) {
					// System.out.println(line);
					strOutput += line + '\n';
				}

				ir.close();
				er.close();
				process.waitFor();
				process.destroy();
				
				if ( strError != null && strError.trim().length() > 0 ) {
					throw new DLException( strError );
				}
				
				///////////////////////
			}
	    	
		} catch (IOException e) { 
			throw new DLException( e.getMessage() ); 
		} catch (InterruptedException e) {
			throw new DLException( e.getMessage() ); 
		}

		return strOutput;
	}
	////////////////////////
	public DBConnection getDBConnection(HttpServletRequest request) {
		/////////////////////////
		DBConnection bd = (DBConnection) request.getSession().getAttribute("DBConnection");
		try {
			if ( bd == null || bd.getConexion().isClosed() ) {
				try {bd = new DBConnection();} catch (DLException ex) {;}
			}
		} catch (SQLException ex) {;}

		request.getSession(true).setAttribute( "DBConnection", bd );
		return bd;
		/////////////////////////
	}
	 
	////////////////////////
	public static int getG_filas_DSPFIL() {
		return g_filas_DSPFIL;
	}
	public static String getG_DB_LIBDAT(String db) {
		String msgId = "configuracion." + db + ".LIBDAT." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_DRIVER(String db) {
		String msgId = "configuracion." + db + ".DRIVER." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_PRE_IP(String db) {
		String msgId = "configuracion." + db + ".PRE_IP." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_IP(String db) {
		String msgId = "configuracion." + db + ".DIR_IP." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_POS_IP(String db) {
		String msgId = "configuracion." + db + ".POS_IP." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_USR(String db) {
		String msgId = "configuracion." + db + ".RMTUSR." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_PWD(String db) {
		String msgId = "configuracion." + db + ".RMTPWD." + m_modoEjecucion;
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_RWUPPERCASE(String db) {
		String msgId = "configuracion." + db + ".RW.UPPERCASE";
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_RWLIKE(String db) {
		String msgId = "configuracion." + db + ".RW.LIKE";
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	public static String getG_DB_RWANYPATTERN(String db) {
		String msgId = "configuracion." + db + ".RW.ANYPATTERN";
		String r = org.apache.struts.util.MessageResources.getMessageResources(Utils.archivo_config).getMessage(msgId);
		if (r == null) {
			System.out.println("Error en archivo '" + Utils.archivo_config + "' en key: '" + msgId + "'");
		}
		return r;
	}
	////////////////////////
	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}
	public static String padLeft(String s, int n) {
		return String.format("%1$#" + n + "s", s);
	}
	public static String padLeftCeros(long dato, int n) {
		return String.format("%0" + n + "d", dato);
	}
	////////////////////////
	public static int    parse_integer( String s ) {
		int res = 0;
		try { res = Integer.parseInt(s); } catch (NumberFormatException ex) {;}
		return res;
	}
	public static long   parse_long( String s ) {
		long res = 0;
		try { res = Long.parseLong(s); } catch (NumberFormatException ex) {;}
		return res;
	}
	public static double parse_double( String s ) {
		double res = 0.0;
		try { res = Double.parseDouble(s); } catch (NumberFormatException ex) {;}
		return res;
	}
	public static String bytesToHex(byte[] b) {
        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                           '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuffer buf = new StringBuffer();
        for (int j=0; j<b.length; j++) {
           buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
           buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
     }
    public static String getRandomHashCode() {
    	String resultado = "???";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			// byte[] bytes = digest.digest( usr.getBytes() );	// Siewmpre devuelve el mismo valor.
			Integer pito = (int) (Math.random() * 10000);		// hashCode aleatorio
			byte[] bytes = digest.digest( pito.toString().getBytes() );
			resultado = Utils.bytesToHex( bytes );
		} catch (NoSuchAlgorithmException e) {;}
		
		return resultado;
    }
    public static String getComputername() {
    	String computername = "SinNombre";
    	try { computername = InetAddress.getLocalHost().getHostName();} catch (UnknownHostException e) {;}
    	return computername;
    }
    public static URL[] getClassPath(boolean isPrint) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
        if (isPrint) {
	        for(URL url: urls){
	        	System.out.println(url.getFile());
	        }
        }
    	System.out.println();
    	return urls;
   }
    public static void getClassPathFrom(String nombreClase) {
    	try {
//    		Class myclass = Class.forName("org.apache.commons.logging.Log"); /*or any other class you wish*/
    		Class myclass = Class.forName(nombreClase);
    		if ( myclass != null ) {
        		System.out.println(myclass.getProtectionDomain().getCodeSource().getLocation());
    		}
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	System.out.println();
    }
    //////////////////////
	// FICHEROS
	public static int ZIP_addFiles         ( final StringBuffer logVar_o_null, final String[] fileNamesList,  final String nombreZipFicheroCompleto ) {
		int resultado = 0;
		if(logVar_o_null!=null) logVar_o_null.append("\r\n" + "ZIP_addFiles( " + nombreZipFicheroCompleto + " ) >>>>>>>>>>>>>>");

		if ( fileNamesList == null || fileNamesList.length < 1 ) return resultado;

		try {
			File file = new File( nombreZipFicheroCompleto );
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			ZipOutputStream  zos = new ZipOutputStream(fos);
			try {
				for (int i = 0; i < fileNamesList.length; ++i) {
					byte[] bytes = readFileBin( logVar_o_null, fileNamesList[i] );
					try {
						if(logVar_o_null!=null) logVar_o_null.append("\r\n" + "ZIP_addFiles() ADD '" + fileNamesList[i] + "'...");
						zos.putNextEntry( new ZipEntry( fileNamesList[i] ) );
						zos.write(bytes);
						++resultado;
					} catch (IOException e) {
						if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
					} finally {
						zos.closeEntry();
						bytes = null;
					}
				}
			} catch (IOException e) {
				if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
			} finally {
				zos.close();
			}
		} catch (IOException e) {
			if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
		}
		if(logVar_o_null!=null) logVar_o_null.append("\r\n" + "ZIP_addFiles( " + nombreZipFicheroCompleto + " ) <<<<<<<<<<<<<<");
		return resultado;
	}
	public static int ZIP_extraerConFiltro ( final StringBuffer logVar_o_null, final String nombreZipFicheroCompleto, final String dirDestino, final String filtroDeNombres_patron) {
		int numExtraidos = 0;
		String patron = (filtroDeNombres_patron==null)?"":filtroDeNombres_patron.trim();
		FileInputStream fis = null;
		ZipInputStream zis = null;
		ZipEntry ze = null;
		File zipFile = new File( nombreZipFicheroCompleto );
		//////////////////////////////////////
		if ( zipFile.exists() && zipFile.canRead() ) {
			try {
				fis = new FileInputStream( zipFile );
				zis = new ZipInputStream( new BufferedInputStream(fis) );
				try {
					try {
						String nomFicComp = null;
						String filename  = null;
						while ((ze = zis.getNextEntry()) != null) {

							filename = ze.getName().replace('\\', '/');

							if ( !ze.isDirectory() && filename.indexOf( patron ) > -1 ) {
								ByteArrayOutputStream baos = new ByteArrayOutputStream();
								byte[] buffer = new byte[65536];
								int count;
								while ( (count = zis.read(buffer)) != -1 ) {
									baos.write(buffer, 0, count);
								}
								//////////////////////////////////////////
								nomFicComp = dirDestino + File.separator + filename;
								if ( grabFile( logVar_o_null, nomFicComp, baos.toByteArray() ) ) {
									if(logVar_o_null!=null) logVar_o_null.append("\r\n" + nomFicComp);
									numExtraidos++;
								}
								//////////////////////////////////////////
							}

						}
					} catch (IOException e) {
						if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
						e.printStackTrace();
					}
				} finally {
					try {
						if ( zis != null ) zis.close();
					} catch (IOException e) {
						if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException e) {
				if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			if(logVar_o_null!=null) logVar_o_null.append("\r\n" + "El fichero \n\r\t" + nombreZipFicheroCompleto + "\n\r no existe o no se puede leer.");
		}
		//////////////////////////////////////
		return numExtraidos;
	}
	public static boolean grabFile         ( final StringBuffer logVar_o_null, final String nombreFicheroCompleto, final byte[] contenido ) {
		boolean resultado = false;

		String nomCamino = nombreFicheroCompleto.replace('\\', '/');
		int idx = nomCamino.lastIndexOf( '/' );
		if (idx > -1 ) nomCamino = nomCamino.substring( 0, idx );

		crtDir(logVar_o_null, nomCamino);

		FileOutputStream fos = null;
		try {
			File file = new File( nombreFicheroCompleto );
			file.delete();
			file.createNewFile();
			fos = new FileOutputStream(file);
			fos.write( contenido );
			resultado = true;
		} catch (FileNotFoundException e) {
			if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
					if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return resultado;
	}
	public static String  readFile         ( final StringBuffer logVar_o_null, final String nombreFicheroCompleto ) {
		String contenido = "";
		try {
			byte[] buff = readFileBin( logVar_o_null, nombreFicheroCompleto );
			if ( buff != null ) {
				contenido = new String( buff , "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
		}
		return contenido;
	}
	public static byte[]  readFileBin      ( final StringBuffer logVar_o_null, final String nombreFicheroCompleto ) {

		byte[] bytes = null;

		File fichero = new File ( nombreFicheroCompleto );
		int lenFic = (int) fichero.length();
		bytes = new byte[ lenFic ];

		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream(fichero);
			dis = new DataInputStream( fis );
			dis.readFully(bytes, 0, lenFic);
		} catch (IOException e) {
			if(logVar_o_null!=null) logVar_o_null.append("\r\n" + e.getMessage());
		} finally {
			try { if (fis!=null) { fis.close(); } } catch (IOException e) {;}
		}

		return bytes;
	}
	public static boolean crtDir           ( final StringBuffer logVar_o_null, final String nombreDirectorio ) {
		boolean resultado = false;
		//////////////////////////////////
		File dir = new File( nombreDirectorio );
		if ( !dir.exists() ) dir.mkdirs();
		if ( dir.exists() && dir.canWrite() ) resultado = true;
		//////////////////////////////////
		return resultado;
	}
	

	
	public static long getDirSize(String ruta) {
		long total=0;
		File path=new File(ruta);
		if (path.exists()){
			File[] files=path.listFiles();
			for (int i=0;i<files.length;i++){
				if (files[i].isDirectory()){
					total+=getDirSize(files[i].getAbsolutePath());
				} else {
					total+=files[i].length();
				}
			}
		}
		
		return total;  
	} 
	
	public static File[] getFicherosFromDirKLz( File fLazo ) {
		if ( fLazo != null && fLazo.exists() ) {
			return Utils.getFiles_startsWith( fLazo, "" );
		}
		return null;		
	}
	
	public static File[] getFiles_startsWith(File dir, final String prefijo ) {
		// Por ejemplo que empiezan por "123^321^"
	    return dir.listFiles(new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	            return name.toLowerCase().startsWith( prefijo.toLowerCase() );
	        }
	    });
	}	
	///////////////////////////////////////////////////////////////////
	

	public static String neutralizarCaracteresEspeciales(String inOut) {
	    // La representación o descomposición canónica consiste en la descomposición del carácter en 2 partes:
		//- Parte 1: Letra base
		//- Parte 2: Acento
		// Descomposición canónica
	    inOut = Normalizer.normalize(inOut, Normalizer.Form.NFD);
	    // Nos quedamos únicamente con los caracteres ASCII
	    Pattern pattern = Pattern.compile("\\P{ASCII}+");
	    inOut = pattern.matcher(inOut).replaceAll(""); 
	    pattern = null;
	    return inOut;
	}
	public static String neutralizarCaracteresEspeciales_bis(String inOut) {
	    String original = "áàäéèëíìïóòöúùüñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    String ascii    = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    for (int i=0; i<original.length(); i++) {
	        inOut = inOut.replace(original.charAt(i),ascii.charAt(i));
	    }
	    return inOut;
	}
	public static String neutralizarCaracteres_CompatibilizarConFileNames(String inOut, char caracterSustituto) {
		//    \ / : * ? " < > |
	    inOut = inOut.replace('\\', caracterSustituto);
	    inOut = inOut.replace( '/', caracterSustituto);
	    inOut = inOut.replace( ':', caracterSustituto);
	    inOut = inOut.replace( '*', caracterSustituto);
	    inOut = inOut.replace( '?', caracterSustituto);
	    inOut = inOut.replace( '"', caracterSustituto);
	    inOut = inOut.replace( '<', caracterSustituto);
	    inOut = inOut.replace( '>', caracterSustituto);
	    inOut = inOut.replace( '|', caracterSustituto);
	    return inOut;
	}
	
	
//	public static int getPesoMedioFactura() {
//		int totalFacturas=0;
//		long pesoFacturas=0L;
//		File path=new File(_K.PATH_UPLOAD);
//		if (path.exists()){
//			File[] files=path.listFiles();
//			for (int i=0;i<files.length;i++){
//				if (files[i].isDirectory() && esDirectorioValido(files[i].getName())){
//					pesoFacturas+=getDirSize(files[i].getAbsolutePath());
//				} else {
//					pesoFacturas+=files[i].length();
//					totalFacturas++;
//				}
//			}
//		}
//		
//		return (int)pesoFacturas/totalFacturas; 
//	}
	
	 
	
	

	private static long getSizeSubDir(String ruta) {
		long total=0;
		File path=new File(ruta);
		if (path.exists()){
			File[] files=path.listFiles();
			for (int i=0;i<files.length;i++){
				if (files[i].isFile()){
					total+=files[i].length();
				}				
			}
		}
		return total;
	} 
	
	/**
	 * Valida si el directorio es de tipo Long
	 * @param directorio
	 * @return
	 */
	private static boolean esDirectorioValido(String directorio) {
		return null!=directorio 
				&& !directorio.isEmpty() 
				&& Utils.parse_long(directorio)!=0;		
	}
	

	
	////////////////////////
	// FECHAS
	public static Date addDays(Date date, int numDiasConSigno) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, numDiasConSigno);
		return cal.getTime();
	}
	

	public static String getFechaHumana() {
		return getFechaHumana(new Date());
	}
	public static String getFecha_aammdd() {
		return getFecha_aammdd(new Date());
	}
	public static String getFecha_aaaa_mm_dd() {
		return getFecha_aaaa_mm_dd(new Date());
	}
	public static String getHora_HHMMSS() {
		return getHora_HHMMSS(new Date());
	}
	public static String getFechaHumana(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getTime().toString();
	}
	public static String getFecha_aammdd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String aaaa = "" + cal.get(Calendar.YEAR);
		String mm = padLeftCeros( 1 + cal.get(Calendar.MONTH),2);
		String dd = padLeftCeros(cal.get(Calendar.DAY_OF_MONTH),2);
		return aaaa.substring(2) + mm + dd;
	}
	public static String getFecha_aaaa_mm_dd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String aaaa = "" + cal.get(Calendar.YEAR);
		String mm = padLeftCeros( 1 + cal.get(Calendar.MONTH),2);
		String dd = padLeftCeros(cal.get(Calendar.DAY_OF_MONTH),2);
		return aaaa + "-" + mm + "-" + dd;
	}
	public static String getHora_HHMMSS(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String hh = padLeftCeros(cal.get(Calendar.HOUR_OF_DAY),2);
		String mm = padLeftCeros(cal.get(Calendar.MINUTE),2);
		String ss = padLeftCeros(cal.get(Calendar.SECOND),2);
		return hh + mm + ss;
	}
	public static long   getDateInMills() {
		return Calendar.getInstance().getTimeInMillis();
	}
	
	public static String cvtFec_dd_mm_aa__saammdd(String dd_mm_aa) {
		String res = dd_mm_aa;
		if ( res != null && res.trim().length() == 8 ) {
			res = res.trim();
			res = "1" + res.substring(6) + res.substring(3,5) + res.substring(0,2);
		}
		return res;
	}
	public static String cvtFec_dd_mm_aa__aammdd(String dd_mm_aa) {
		String res = dd_mm_aa;
		if ( res != null && res.trim().length() == 8 ) {
			res = res.trim();
			res = res.substring(6) + res.substring(3,5) + res.substring(0,2);
		}
		return res;
	}
	public static String cvtFec_saammdd__dd_mm_aa(String saammdd) {
		String res = saammdd;
		if ( res != null && res.trim().length() == 7 ) {
			res = res.trim();
			res = res.substring(5) + "/" + res.substring(3,5) + "/" + res.substring(1,3);
		}
		return res;
	}
	public static String cvtFec_dd_mm_aa__aaaa_mm_dd(String dd_mm_aa) {
		String res = dd_mm_aa;
		if ( res != null && res.trim().length() == 8 ) {
			res = res.trim();
			res = "20" + res.substring(6) + "-" + res.substring(3,5) + "-" + res.substring(0,2);
		}
		return res;
	}
	public static String cvtFec_aaaa_mm_dd__dd_mm_aa(String aaaa_mm_dd) {
		String res = aaaa_mm_dd;
		if ( res != null && res.trim().length() == 10 ) {
			res = res.trim();
			res = res.substring(8) + "/" + res.substring(5,7) + "/" + res.substring(2,4);
		}
		return res;
	}
	
	public static String cvtFec_mills__aaaa_mm_dd( long date ) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		cal.add(Calendar.MONTH, 1);
		return getFecha_aaaa_mm_dd( cal.getTime() );
	}
	public static String cvtFec_mills__aaaa_mm_dd_menos_un_mes( long date ) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
//		String horas = String.valueOf(cal.getTime().getHours());
//		horas = "0".equals(horas) ? "00":horas;
//		String minutos = String.valueOf(cal.getTime().getMinutes());
//		minutos = "0".equals(minutos) ? "00":minutos;
//		String segundos = String.valueOf(cal.getTime().getSeconds());
//		segundos = "0".equals(segundos) ? "00":segundos;
		return getFecha_aaaa_mm_dd( cal.getTime() );//+" "+horas+":"+minutos+":"+segundos;
	}
	 
	
	////////////////////////
	public String getDBValueFromKey(DBConnection dbConn, String key) {
		String resultado = null;
		///////////////////////////////
		//	if ( key == null || key.trim().length() < 1 || dbConn == null ) return resultado;
		//	com.tm.nveq_ValoresServidor.db.NveqAccesoBaseDatos db = new com.tm.nveq_ValoresServidor.db.NveqAccesoBaseDatos();
		//	com.tm.nveq_ValoresServidor.bean.NveqBean          rg = new com.tm.nveq_ValoresServidor.bean.NveqBean();
		//	rg.setNveq_EQF4CX(key);
		//	try {
		//	    rg = db.nveq_getRcd(dbConn,rg);
		//	    if ( rg != null ) {
		//		resultado = rg.getNveq_EQSRTY(); // Value
		//	    }
		//	} catch (DLException ex) {;
		//	} finally {
		//	    db = null;
		//	    rg = null;
		//	}
		///////////////////////////////
		return resultado;
	}
	///////////////////////

	  
	
	public static Date   cvtFec_aaaa_mm_dd__date(String aaaa_mm_dd) {
		Date parsed = null;
		 try {
			 if ( aaaa_mm_dd != null && aaaa_mm_dd.trim().length() == 10 ) {
				parsed = new SimpleDateFormat("yyyy-MM-dd").parse(aaaa_mm_dd);
			 }
		} catch (ParseException e) {System.err.println(e.getMessage());}
		return parsed;		
	}
	
	public static long   getDateInMills(Date date) {
		if ( date != null ) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.getTimeInMillis();
		}
		return 0L;
	}
	
	public static float porcentaje(int total, int score) {
		float resultado = 0;
		if (total!=0 && score!=0){
			resultado = (score * 100) / total;
		}
		return resultado;
	}
	
	public static float tasaCrecimiento(int valorFinal, int valorInicial, int periodo) {
		return (float)Math.pow((valorFinal/valorInicial),(1/periodo))-1;
	}
	
	public static Date addWeeks(Date date, int numSemanasConSigno) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, numSemanasConSigno*7 );
		return cal.getTime();
	}
	
	public static Date addMonths(Date date, int numMesesConSigno) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, numMesesConSigno);
		return cal.getTime();
	}
	
	public static Date addYears(Date date, int numYearsConSigno) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, numYearsConSigno);
		return cal.getTime();
	}
	public static String newDate_yyyy_MM_dd_hh_mm_ss_nextDay(String date){
		String newDate = "";
		if (null!=date && !date.isEmpty()){
			int year = parse_integer(date.substring(0, 4));
			int month = parse_integer(date.substring(5, 7))-1;
			int day = parse_integer(date.substring(8,10));
			int hours = 0;
			int minutes = 0;
			int seconds =0;
			Calendar cal = Calendar.getInstance();
			cal.set(year, month, day, hours, minutes, seconds);
			cal.add(Calendar.DATE, 1);
			newDate = String.valueOf(cal.getTimeInMillis()); 
		}
		return newDate;
	}
	
	public static String newDate_yyyy_MM_dd_hh_mm_ss(String date){
		String newDate = "";
		if (null!=date && !date.isEmpty() && date.length()>=10){
			int year = parse_integer(date.substring(0, 4));
			int month = parse_integer(date.substring(5, 7))-1;
			int day = parse_integer(date.substring(8,10));
			Calendar cal = Calendar.getInstance();
			cal.set(year, month, day);
			if (date.length()>10){
				int hours = parse_integer(date.substring(11,13)==null ? "0":date.substring(11,13));
				int minutes = parse_integer(date.substring(14,16)==null ? "0":date.substring(14,16));
				int seconds = parse_integer(date.substring(17,19)==null ? "0":date.substring(17,19));
				cal.set(year, month, day, hours, minutes, seconds);
			}
			newDate = String.valueOf(cal.getTimeInMillis());
		}
		return newDate;
	}
	
	public static String newDate_yyyy_MM_dd(String date){
		String newDate = "";
		if (null!=date && !date.isEmpty()){
			int year = parse_integer(date.substring(0, 4));
			int month = parse_integer(date.substring(5, 7))-1;
			int day = parse_integer(date.substring(8,10));
//			int hours = parse_integer(date.substring(11,13));
//			int minutes = parse_integer(date.substring(14,16));
//			int seconds = parse_integer(date.substring(17,19));
			Calendar cal = Calendar.getInstance();
			cal.set(year, month, day);//, hours, minutes, seconds);
			newDate = String.valueOf(cal.getTimeInMillis());
		}
		return newDate;
	} 
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static int ejecutaQuery(HttpServletRequest request, String sql) {
		int total = 0;
		try{
        	DBConnection dataBase = new Utils().getDBConnection(request);
        	ResultSet resultSet = dataBase.executeQuery(sql); 
        	if (resultSet.next()){ // nos devuelve algo
        		total = resultSet.getInt(1);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
		}
		
		return total;
	} 
	
	public static BigDecimal ejecutaQueryToBigDecimal(HttpServletRequest request, String sql) {
		BigDecimal total = new BigDecimal("0");
		try{
        	DBConnection dataBase = new Utils().getDBConnection(request);
        	ResultSet resultSet = dataBase.executeQuery(sql); 
        	if (resultSet.next()){ // nos devuelve algo
        		total = resultSet.getBigDecimal(1);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
		}
		
		return total.setScale(DECIMALES, BigDecimal.ROUND_UP);
	} 
	
	 
	 
	  
	
	/**
	 * Ejemplo de llamada
	 * https://www.billin.net/meServlet?ACC=GETALM
	 */
	public static String restGet(String host, String param, String value){
		  //////////////////////
	    HttpRestClient httpRestClient = new HttpRestClient(host);
	    ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
	    nameValuePairs.add( new BasicNameValuePair(param,value) );
	    String respuesta = httpRestClient.postData(nameValuePairs, 8000);
	    System.out.println( respuesta  );

	    return respuesta;	
	}
	
	/**
	 * Siendo cada valor:
	 *        nLazos       // Número de LAZOS registrados en BD.
	 *        nFiles      // Número de FICHEROS de cualquier tipo dependientes de los LAZOS anteriores incluyendo PDFs.
	 *        nBytes       // Número de BYTES que ocupan todos los ficheros dependientes de los LAZOS anteriores.
	 *        nPDFs       // Número de PDFs dependientes de los LAZOS anteriores.
	 *        nPDFBytes    // Número de BYTES que ocupan todos los ficheros PDF dependientes de los LAZOS anteriores.
	 *        nNegocios    // Número de NEGOCIOS registrados.
	 *        nUsuarios    // Número de USUARIOS registrados.
	 *        
	 * Llamada: https://www.billin.net/meServlet?ACC=GETALM
	 * 
	 * Devuelte todo
	 * 
	 */
	public static JSONObject getALM(){
		String respuesta = restGet("https://www.billin.net/meServlet","ACC","GETALM");
		 //////////////////////
	    JSONObject json = null;
	    if ( respuesta != null && respuesta.trim().length() > 0 ) {
	        json = JSONObject.fromObject( respuesta );
	        json = JSONObject.fromObject( json.getString("text") );
	        System.out.println( "nLazos:\t" + json.getString("nLazos")  );
	        System.out.println( "nFiles:\t" + json.getString("nFiles")  );
	        System.out.println( "nBytes:\t" + json.getString("nBytes")  );
	        System.out.println( "nPDFs:\t" + json.getString("nPDFs")  );
	        System.out.println( "nPDFBytes:\t" + json.getString("nPDFBytes")  );
	        System.out.println( "nNegocios:\t" + json.getString("nNegocios")  );
	        System.out.println( "nUsuarios:\t" + json.getString("nUsuarios")  );
	    }
	    //////////////////////
	    
	    return json;
	}
	
	
	/**
	 * Devuelve un de los elementos del json
	 * @param param
	 * @return
	 */
	public static String getALM(String param){
		String respuesta  = restGet("https://www.billin.net/meServlet","ACC","GETALM");
		String resultado = "";
		 //////////////////////
	    JSONObject json = null;
	    if ( respuesta != null && respuesta.trim().length() > 0 ) {
	        json = JSONObject.fromObject( respuesta );
	        json = JSONObject.fromObject( json.getString("text") );
	        resultado =  json.getString(param) ; 
	    }
	    //////////////////////
	    
	    return resultado;
	}
	
	 
	
}