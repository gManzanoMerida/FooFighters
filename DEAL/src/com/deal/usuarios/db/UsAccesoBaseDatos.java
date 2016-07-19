package com.deal.usuarios.db;

import com.deal.datasource.DBConnection;
import com.deal.common.DLException;
import com.deal.common.Utils;
import com.deal.common._K;
import com.deal.common.ConfigPantalla;
import com.deal.common.RstAplicar;
import com.deal.usuarios.bean.UsBean;
import com.deal.usuarios.bean.UsBeanFiltro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class UsAccesoBaseDatos {
    public String tabla   = "T_usuarios";
    public String lf_UPD  = "T_usuarios";
    public String lf_RTV  = "V_US_RTV_Usuarios"; 
    protected final boolean isParmViaFS = false;
    ////////////////////////////////////////////////////////////////////
    protected File fo;
    protected BufferedWriter dout;
    public UsAccesoBaseDatos() {fo=null;dout=null;}
/////////////////////////////////////////////////
// usuarios:
/////////////////////////////////////////////////
    protected void callSistemaExterno( final String idOp ) throws DLException {
    	// System.out.println("\r\n*** callSistemaExterno( "+idOp+" )");

    	String[] params = new String [4];
    	params[0] = _K.caminoExecExterno + _K.ejecutableExterno;
    	params[1] = _K.caminoExecExterno;
    	params[2] = idOp;
    	params[3] = _K.unidadIntercambio;
    	
    	// String salidaTerminal = 
    			Utils.run_comando_sincro(params);
    	// System.out.println( salidaTerminal );
    }
    protected void runSql(DBConnection dataBase, String sql) throws DLException {
        //////////////////////////////////////////////
        try {
            if (dataBase==null) dataBase = new DBConnection();
            dataBase.executeUpdate(sql);
        } catch (DLException ex) {
            throw ex;
        }
        //////////////////////////////////////////////
    }
    public void us_crtObj(DBConnection bd, UsBean registro) throws DLException {

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Variante para versi�n de paso de par�metros por FileSystem:
        if (isParmViaFS) {
	    	final String idOp = Integer.toHexString(hashCode()).toUpperCase() + "_us_CRT";
	        //////////////////////////////////////////////
	        // 1.grabar par�metros, 
	    	us_putParFS_bean( idOp, registro );
	        // 2.Invocar Sistema Externo S�NCRONO!
	        callSistemaExterno( idOp );
	        // 3.Leer resultados
	    	us_getParFS_RetCode(idOp);
	    	return;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
    	
        //////////////////////////////////////////////
        if (bd==null) bd = new DBConnection();
        //////////////////////////////////////////////
        String sql =
                "INSERT INTO \"" + Utils.getG_DB_LIBDAT(bd.getCurrentDb()) + "\".\""  + this.lf_UPD + "\" " +
                "( " + 
		"  \"Sincro\"" + // Sincro
		", \"Marca\"" + // Marca
		", \"Suprimido\"" + // Suprimido
		", \"Autor\"" + // Autor
		", \"Usuario\"" + // Usuario
		", \"Nombre\"" + // Nombre
		", \"Apellidos\"" + // Apellidos
		", \"Password\"" + // Password
		", \"Cuenta\"" + // Cuenta 
		", \"eMail\"" + // eMail
		", \"HashCode\"" + // HashCode 
		", \"FotoBase64\"" + // FotoBase64 
		", \"isBloqueado\"" + // isBloqueado
		", \"isAdministrador\"" + // isAdministrador
                "  ) VALUES ( " + 
		"  "  + registro.getUs_Sincro() + "" + // Sincro
		", '"  + registro.getUs_Marca() + "'" + // Marca
		", '"  + registro.getUs_Suprimido() + "'" + // Suprimido
		", '"  + registro.getUs_Autor() + "'" + // Autor
		", '"  + registro.getUs_Usuario() + "'" + // Usuario
		", '"  + registro.getUs_Nombre() + "'" + // Nombre
		", '"  + registro.getUs_Apellidos() + "'" + // Apellidos
		", '"  + registro.getUs_Password() + "'" + // Password
		", '"  + registro.getUs_Cuenta() + "'" + // Cuenta
		", '"  + registro.getUs_eMail() + "'" + // eMail
		", '"  + registro.getUs_HashCode() + "'" + // HashCode
		", '"  + registro.getUs_FotoBase64() + "'" + // FotoBase64
		", '"  + registro.getUs_isBloqueado() + "'" + // isBloqueado
		", '"  + registro.getUs_isAdministrador() + "'" + // isAdministrador 
                ")"
                ;
        //////////////////////////////////////////////
        runSql(bd,sql);
        //////////////////////////////////////////////
    }
    public void us_chgObj(DBConnection bd, UsBean registro) throws DLException {

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Variante para versi�n de paso de par�metros por FileSystem:
        if (isParmViaFS) {
	    	final String idOp = Integer.toHexString(hashCode()).toUpperCase() + "_us_CHG";
	        //////////////////////////////////////////////
	        // 1.grabar par�metros, 
	    	us_putParFS_bean( idOp, registro );
	        // 2.Invocar Sistema Externo S�NCRONO!
	        callSistemaExterno( idOp );
	        // 3.Leer resultados
	    	us_getParFS_RetCode(idOp);
	    	return;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
    	
        //////////////////////////////////////////////
        if (bd==null) bd = new DBConnection();
        //////////////////////////////////////////////
        String sql =
                "UPDATE \"" + Utils.getG_DB_LIBDAT(bd.getCurrentDb()) + "\".\""  + this.lf_UPD + "\" " +
                "   SET " + 
		"  \"Sincro\" = "  + registro.getUs_Sincro() + "" + // Sincro
		", \"Marca\" = '"  + registro.getUs_Marca() + "'" + // Marca
		", \"Suprimido\" = '"  + registro.getUs_Suprimido() + "'" + // Suprimido
		", \"Autor\" = '"  + registro.getUs_Autor() + "'" + // Autor
		", \"Usuario\" = '"  + registro.getUs_Usuario() + "'" + // Usuario
		", \"Nombre\" = '"  + registro.getUs_Nombre() + "'" + // Nombre
		", \"Apellidos\" = '"  + registro.getUs_Apellidos() + "'" + // Apellidos
		", \"Password\" = '"  + registro.getUs_Password() + "'" + // Password
		", \"Cuenta\" = '"  + registro.getUs_Cuenta() + "'" + // Cuenta
		", \"eMail\" = '"  + registro.getUs_eMail() + "'" + // eMail
		", \"HashCode\" = '"  + registro.getUs_HashCode() + "'" + // HashCode
		", \"FotoBase64\" = '"  + registro.getUs_FotoBase64() + "'" + // FotoBase64
		", \"isBloqueado\" = '"  + registro.getUs_isBloqueado() + "'" + // isBloqueado
		", \"isAdministrador\" = '"  + registro.getUs_isAdministrador() + "'" + // isAdministrador
                " WHERE " + 
		"  \"Usuario\" = '" + registro.getUs_Usuario() + "'" + // Usuario
                ""
                ;
        //////////////////////////////////////////////
        runSql(bd,sql);
        //////////////////////////////////////////////
    }
    public void us_dltObj(DBConnection bd, UsBean registro) throws DLException {

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Variante para versi�n de paso de par�metros por FileSystem:
        if (isParmViaFS) {
	    	final String idOp = Integer.toHexString(hashCode()).toUpperCase() + "_us_DLT";
	        //////////////////////////////////////////////
	        // 1.grabar par�metros, 
	    	us_putParFS_bean( idOp, registro );
	        // 2.Invocar Sistema Externo S�NCRONO!
	        callSistemaExterno( idOp );
	        // 3.Leer resultados
	    	us_getParFS_RetCode(idOp);
	    	return;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
    	
        //////////////////////////////////////////////
        if (bd==null) bd = new DBConnection();
        //////////////////////////////////////////////
        String sql =
                "DELETE " +
                " FROM \"" + Utils.getG_DB_LIBDAT(bd.getCurrentDb()) + "\".\""  + this.lf_UPD + "\" " +
                " WHERE " + 
		"  \"Usuario\" = '" + registro.getUs_Usuario() + "'" + // Usuario
                ""
                ;
        //////////////////////////////////////////////
        runSql(bd,sql);
        //////////////////////////////////////////////
    }
    public UsBean   us_getRcd(DBConnection dataBase, UsBean registro) throws DLException {

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Variante para versi�n de paso de par�metros por FileSystem:
        if (isParmViaFS) {
	    	final String idOp = Integer.toHexString(hashCode()).toUpperCase() + "_us_GET";
	        //////////////////////////////////////////////
	        // 1.grabar par�metros, 
	    	us_putParFS_bean( idOp, registro );
	        // 2.Invocar Sistema Externo S�NCRONO!
	        callSistemaExterno( idOp );
	        // 3.Leer resultados
	    	return us_getParFS_GET(idOp);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
    	
        //////////////////////////////////////////////
        if (dataBase==null) dataBase= new DBConnection();
        //////////////////////////////////////////////
        String sql =
                "SELECT \"A\".*" +
                " FROM \"" + Utils.getG_DB_LIBDAT(dataBase.getCurrentDb()) + "\".\""  + this.lf_RTV + "\" \"A\"" +
                " WHERE " + 
		"  \"Usuario\" = '" + registro.getUs_Usuario() + "'" + // Usuario
                ""
                ;
        ResultSet rs = null;
        UsBean regRead = null;
        //////////////////////////////////////////////
        //if (dataBase==null) dataBase = new DBConnection();
        try {
            rs = dataBase.executeQuery(sql);
            if (rs.next()){
                regRead = new UsBean();
                
		regRead.setUs_Sincro( rs.getLong("Sincro") );  // Sincro
		regRead.setUs_Marca( rs.getString("Marca") ); regRead.setUs_Marca( (regRead.getUs_Marca() == null)?"":regRead.getUs_Marca().trim() ); // Marca
		regRead.setUs_Suprimido( rs.getString("Suprimido") ); regRead.setUs_Suprimido( (regRead.getUs_Suprimido() == null)?"":regRead.getUs_Suprimido().trim() ); // Suprimido
		regRead.setUs_Autor( rs.getString("Autor") ); regRead.setUs_Autor( (regRead.getUs_Autor() == null)?"":regRead.getUs_Autor().trim() ); // Autor
		regRead.setUs_Usuario( rs.getString("Usuario") ); regRead.setUs_Usuario( (regRead.getUs_Usuario() == null)?"":regRead.getUs_Usuario().trim() ); // Usuario
		regRead.setUs_Nombre( rs.getString("Nombre") ); regRead.setUs_Nombre( (regRead.getUs_Nombre() == null)?"":regRead.getUs_Nombre().trim() ); // Nombre
		regRead.setUs_Apellidos( rs.getString("Apellidos") ); regRead.setUs_Apellidos( (regRead.getUs_Apellidos() == null)?"":regRead.getUs_Apellidos().trim() ); // Apellidos
		regRead.setUs_Password( rs.getString("Password") ); regRead.setUs_Password( (regRead.getUs_Password() == null)?"":regRead.getUs_Password().trim() ); // Password
		regRead.setUs_Cuenta( rs.getString("Cuenta") ); regRead.setUs_Cuenta( (regRead.getUs_Cuenta() == null)?"":regRead.getUs_Cuenta().trim() ); // Cuenta
		regRead.setUs_eMail( rs.getString("eMail") ); regRead.setUs_eMail( (regRead.getUs_eMail() == null)?"":regRead.getUs_eMail().trim() ); // eMail
		regRead.setUs_HashCode( rs.getString("HashCode") ); regRead.setUs_HashCode( (regRead.getUs_HashCode() == null)?"":regRead.getUs_HashCode().trim() ); // HashCode
		regRead.setUs_FotoBase64( rs.getString("FotoBase64") ); regRead.setUs_FotoBase64( (regRead.getUs_FotoBase64() == null)?"":regRead.getUs_FotoBase64().trim() ); // FotoBase64
		regRead.setUs_isBloqueado( rs.getString("isBloqueado") ); regRead.setUs_isBloqueado( (regRead.getUs_isBloqueado() == null)?"":regRead.getUs_isBloqueado().trim() ); // isBloqueado
		regRead.setUs_isAdministrador( rs.getString("isAdministrador") ); regRead.setUs_isAdministrador( (regRead.getUs_isAdministrador() == null)?"":regRead.getUs_isAdministrador().trim() ); // isAdministrador
            }
        } catch (SQLException ex0) {
            throw new DLException(ex0.getMessage());
        } catch (DLException ex1) {
            throw new DLException(ex1.getMessage());
        } finally {
            try {
                if ( rs != null ) { DBConnection.rsClose( dataBase, rs ); }
            } catch (SQLException ex2) {
                throw new DLException(ex2.getMessage());
            }
        }
        //////////////////////////////////////////////
        
        return regRead;
    }
    public UsBean[] us_getSeq(DBConnection dataBase, ConfigPantalla extCfg, UsBeanFiltro rst ) throws DLException {
        UsBean[] filasRecuperadas = null;
        ///////////////////////////////////////////////////////
        ConfigPantalla cfg = (extCfg!=null)?extCfg:new ConfigPantalla();
        if ( cfg.isExportar() ) {
            cfg.setFilaInicioGrid(1);
            cfg.setFilasGrid(Integer.MAX_VALUE);
            cfg.setFilasTotales(0);
            getSeq_Sub_ExportIni( cfg.getTituloPantalla() );
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Variante para versi�n de paso de par�metros por FileSystem:
        if (isParmViaFS) {
	    	final String idOp = Integer.toHexString(hashCode()).toUpperCase() + "_us_GETSEQ";
	        //////////////////////////////////////////////
	        // 1.grabar par�metros, 
            us_putParFS_GETSEQ( idOp, cfg, rst );
	        // 2.Invocar Sistema Externo S�NCRONO!
	        callSistemaExterno( idOp );
	        // 3.Leer resultados
            return us_getParFS_GETSEQ( idOp, cfg );
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        //////////////////////////////////////////////
        if (dataBase==null) dataBase= new DBConnection();
        ///////////////////////////////////////////////////////
        String sql =
                "SELECT \"A\".*" +
                " FROM \"" + Utils.getG_DB_LIBDAT(dataBase.getCurrentDb()) + "\".\""  + this.lf_RTV + "\" \"A\""
                ;
        String sqlWhere = "";
        ///////////////////////////////////////////////////////
        // Filtros de la lista:
        RstAplicar fltOper = new RstAplicar(dataBase.getRwUpperCase(),dataBase.getRwLike(),dataBase.getRwAnyString());
	
	sqlWhere = fltOper.getNUM_EQ(rst.getUs_Sincro(),"Sincro",sqlWhere);   // Sincro
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Marca(),"Marca",sqlWhere);   // Marca
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Suprimido(),"Suprimido",sqlWhere);   // Suprimido
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Autor(),"Autor",sqlWhere);   // Autor
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Usuario(),"Usuario",sqlWhere);   // Usuario
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Nombre(),"Nombre",sqlWhere);   // Nombre
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Apellidos(),"Apellidos",sqlWhere);   // Apellidos
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Password(),"Password",sqlWhere);   // Password
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Cuenta(),"Cuenta",sqlWhere);   // Cuenta
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_eMail(),"eMail",sqlWhere);   // eMail
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_HashCode(),"HashCode",sqlWhere);   // HashCode
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_FotoBase64(),"FotoBase64",sqlWhere);   // FotoBase64
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_isBloqueado(),"isBloqueado",sqlWhere);   // isBloqueado
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_isAdministrador(),"isAdministrador",sqlWhere);   // isAdministrador
        //////////////////////////////////////////////////////
        
	   

        //////////////////////////////////////////////////////
        sql += sqlWhere;
        // Campos de ordenaci�n:
        sql += " ORDER BY \"Usuario\" ASC";
        //////////////////////////////////////////////////////
        ResultSet rs = null;
        UsBean regRead = null;
        ArrayList<UsBean> arrayTmp = new ArrayList<UsBean>();
        //////////////////////////////////////////////
        //if (dataBase==null) dataBase = new DBConnection();
        try {
            ///////////////////////////////////////
            // Configuraci�n del DSPFIL (NumFilas, NumPantallas...)
            if (cfg != null) {
                String sqlCount = "SELECT COUNT(*) AS nFilas FROM \"" + Utils.getG_DB_LIBDAT(dataBase.getCurrentDb()) + "\".\""  + lf_RTV + "\" \"A\"";
                sqlCount += sqlWhere;
                rs = dataBase.executeQuery(sqlCount);
                cfg.setFilasTotales(0);
                if ( rs.next() ) cfg.setFilasTotales( rs.getInt("nFilas") );
                if ( rs != null ) { DBConnection.rsClose( dataBase, rs ); }
                ///////////////////////////////////////
                if ( cfg.isExportar() ) {
                    if ( cfg.getFilasTotales() > 5000 ) {
                        getSeq_Sub_ExportFin();
                        throw new DLException("Se permiten exportar hasta 5000 filas.\r\nPor favor aplique una selecci�n mas restrictiva.");
                    }
                }
            }
            ///////////////////////////////////////

			// C�digo para postgres
            sql += " LIMIT "  + cfg.getFilasGrid();
            sql += " OFFSET " + (cfg.getFilaInicioGrid()-1);
            rs = dataBase.executeQuery(sql);
            if ( rs != null ) {
                int filas = 0;
                  if ( rs.next() ) {
                    do {
                        regRead = new UsBean();
                        
		regRead.setUs_Sincro( rs.getLong("Sincro") );  // Sincro
		regRead.setUs_Marca( rs.getString("Marca") ); regRead.setUs_Marca( (regRead.getUs_Marca() == null)?"":regRead.getUs_Marca().trim() ); // Marca
		regRead.setUs_Suprimido( rs.getString("Suprimido") ); regRead.setUs_Suprimido( (regRead.getUs_Suprimido() == null)?"":regRead.getUs_Suprimido().trim() ); // Suprimido
		regRead.setUs_Autor( rs.getString("Autor") ); regRead.setUs_Autor( (regRead.getUs_Autor() == null)?"":regRead.getUs_Autor().trim() ); // Autor
		regRead.setUs_Usuario( rs.getString("Usuario") ); regRead.setUs_Usuario( (regRead.getUs_Usuario() == null)?"":regRead.getUs_Usuario().trim() ); // Usuario
		regRead.setUs_Nombre( rs.getString("Nombre") ); regRead.setUs_Nombre( (regRead.getUs_Nombre() == null)?"":regRead.getUs_Nombre().trim() ); // Nombre
		regRead.setUs_Apellidos( rs.getString("Apellidos") ); regRead.setUs_Apellidos( (regRead.getUs_Apellidos() == null)?"":regRead.getUs_Apellidos().trim() ); // Apellidos
		regRead.setUs_Password( rs.getString("Password") ); regRead.setUs_Password( (regRead.getUs_Password() == null)?"":regRead.getUs_Password().trim() ); // Password
		regRead.setUs_Cuenta( rs.getString("Cuenta") ); regRead.setUs_Cuenta( (regRead.getUs_Cuenta() == null)?"":regRead.getUs_Cuenta().trim() ); // Cuenta
		regRead.setUs_eMail( rs.getString("eMail") ); regRead.setUs_eMail( (regRead.getUs_eMail() == null)?"":regRead.getUs_eMail().trim() ); // eMail
		regRead.setUs_HashCode( rs.getString("HashCode") ); regRead.setUs_HashCode( (regRead.getUs_HashCode() == null)?"":regRead.getUs_HashCode().trim() ); // HashCode
		regRead.setUs_FotoBase64( rs.getString("FotoBase64") ); regRead.setUs_FotoBase64( (regRead.getUs_FotoBase64() == null)?"":regRead.getUs_FotoBase64().trim() ); // FotoBase64
		regRead.setUs_isBloqueado( rs.getString("isBloqueado") ); regRead.setUs_isBloqueado( (regRead.getUs_isBloqueado() == null)?"":regRead.getUs_isBloqueado().trim() ); // isBloqueado
		regRead.setUs_isAdministrador( rs.getString("isAdministrador") ); regRead.setUs_isAdministrador( (regRead.getUs_isAdministrador() == null)?"":regRead.getUs_isAdministrador().trim() ); // isAdministrador
                        
                        if ( cfg.isExportar() ) getSeq_Sub_ExportMid( regRead );
                        else                    arrayTmp.add( regRead );

                        filas++;
                    } while( rs.next() && filas < (  (cfg!=null)?cfg.getFilasGrid():(new ConfigPantalla()).getFilasGrid() ) );
                }
            }
        } catch (SQLException ex0) {
            throw new DLException(ex0.getMessage());
        } catch (DLException ex1) {
            throw new DLException(ex1.getMessage());
        } finally {
            try {
                if ( rs != null ) { DBConnection.rsClose( dataBase, rs ); }
            } catch (SQLException ex2) {
                throw new DLException(ex2.getMessage());
            }
        }
        //////////////////////////////////////////////
        if ( cfg.isExportar() ) {
            getSeq_Sub_ExportFin();
        }
        //////////////////////////////////////////////
        filasRecuperadas = new UsBean[arrayTmp.size()];
        filasRecuperadas = arrayTmp.toArray(filasRecuperadas);
        return filasRecuperadas;
    }
    
    public UsBean[] us_getUsNoCtNGe(DBConnection dataBase, ConfigPantalla extCfg, UsBeanFiltro rst ) throws DLException {
        UsBean[] filasRecuperadas = null;
        ///////////////////////////////////////////////////////
        ConfigPantalla cfg = (extCfg!=null)?extCfg:new ConfigPantalla();
        if ( cfg.isExportar() ) {
            cfg.setFilaInicioGrid(1);
            cfg.setFilasGrid(Integer.MAX_VALUE);
            cfg.setFilasTotales(0);
            getSeq_Sub_ExportIni( cfg.getTituloPantalla() );
        }

        //////////////////////////////////////////////////////////////////////////////////////////// 
        ////////////////////////////////////////////////////////////////////////////////////////////
        // Variante para versi�n de paso de par�metros por FileSystem:
        if (isParmViaFS) {
	    	final String idOp = Integer.toHexString(hashCode()).toUpperCase() + "_us_GETSEQ";
	        //////////////////////////////////////////////
	        // 1.grabar par�metros, 
            us_putParFS_GETSEQ( idOp, cfg, rst );
	        // 2.Invocar Sistema Externo S�NCRONO!
	        callSistemaExterno( idOp );
	        // 3.Leer resultados
            return us_getParFS_GETSEQ( idOp, cfg );
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        //////////////////////////////////////////////
        if (dataBase==null) dataBase= new DBConnection();
        ///////////////////////////////////////////////////////
        String sqlWhere = "";
        String sql =
                "SELECT * FROM \"Billin\".\"T_usuarios\" US ";
        String condicion = "US.\"Cuenta\"='' AND US.\"Usuario\" NOT IN (SELECT GE.\"Autor\" FROM  \"Billin\".\"T_GE_Gestores\" GE WHERE GE.\"Autor\"!=US.\"Usuario\")"
                ;
        
        ///////////////////////////////////////////////////////
        // Filtros de la lista:
        RstAplicar fltOper = new RstAplicar(dataBase.getRwUpperCase(),dataBase.getRwLike(),dataBase.getRwAnyString());
	
	sqlWhere = fltOper.getNUM_EQ(rst.getUs_Sincro(),"Sincro",sqlWhere);   // Sincro
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Marca(),"Marca",sqlWhere);   // Marca
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Suprimido(),"Suprimido",sqlWhere);   // Suprimido
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Autor(),"Autor",sqlWhere);   // Autor
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Usuario(),"Usuario",sqlWhere);   // Usuario
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Nombre(),"Nombre",sqlWhere);   // Nombre
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Apellidos(),"Apellidos",sqlWhere);   // Apellidos
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Password(),"Password",sqlWhere);   // Password
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Cuenta(),"Cuenta",sqlWhere);   // Cuenta 
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_eMail(),"eMail",sqlWhere);   // eMail
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_HashCode(),"HashCode",sqlWhere);   // HashCode
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_FotoBase64(),"FotoBase64",sqlWhere);   // FotoBase64
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_isBloqueado(),"isBloqueado",sqlWhere);   // isBloqueado
	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_isAdministrador(),"isAdministrador",sqlWhere);   // isAdministrador
        //////////////////////////////////////////////////////
        
	   

        //////////////////////////////////////////////////////
        sql += sqlWhere;
        if (null!=sql && !sqlWhere.isEmpty()){
        	sql+=" AND "+condicion;
        } else {
        	sql+=" WHERE "+condicion;
        }
        // Campos de ordenaci�n:
        sql += " ORDER BY US.\"Usuario\" ASC";
        //////////////////////////////////////////////////////
        ResultSet rs = null;
        UsBean regRead = null;
        ArrayList<UsBean> arrayTmp = new ArrayList<UsBean>();
        //////////////////////////////////////////////
        //if (dataBase==null) dataBase = new DBConnection();
        try {
            ///////////////////////////////////////
            // Configuraci�n del DSPFIL (NumFilas, NumPantallas...)
            if (cfg != null) {
                String sqlCount = "SELECT COUNT(*) AS nFilas FROM \"Billin\".\"T_usuarios\" US";// WHERE US.\"Cuenta\"='' AND US.\"Usuario\" NOT IN (SELECT GE.\"Autor\" FROM  \"Billin\".\"T_GE_Gestores\" GE WHERE GE.\"Autor\"!=US.\"Usuario\")";
                sqlCount += sqlWhere;
                if (null!=sql && !sqlWhere.isEmpty()){
                	sqlCount+=" AND "+condicion;
                } else {
                	sqlCount+=" WHERE "+condicion;
                }
                rs = dataBase.executeQuery(sqlCount);
                cfg.setFilasTotales(0);
                if ( rs.next() ) cfg.setFilasTotales( rs.getInt("nFilas") );
                if ( rs != null ) { DBConnection.rsClose( dataBase, rs ); }
                ///////////////////////////////////////
                if ( cfg.isExportar() ) {
                    if ( cfg.getFilasTotales() > 5000 ) {
                        getSeq_Sub_ExportFin();
                        throw new DLException("Se permiten exportar hasta 5000 filas.\r\nPor favor aplique una selecci�n mas restrictiva.");
                    }
                }
            }
            ///////////////////////////////////////

			// C�digo para postgres
            sql += " LIMIT "  + cfg.getFilasGrid();
            sql += " OFFSET " + (cfg.getFilaInicioGrid()-1);
            System.out.println("us_getUsNoCtNGe \n"+sql);
            rs = dataBase.executeQuery(sql);
            if ( rs != null ) {
                int filas = 0;
                  if ( rs.next() ) {
                    do {
                        regRead = new UsBean();
                        
		regRead.setUs_Sincro( rs.getLong("Sincro") );  // Sincro
		regRead.setUs_Marca( rs.getString("Marca") ); regRead.setUs_Marca( (regRead.getUs_Marca() == null)?"":regRead.getUs_Marca().trim() ); // Marca
		regRead.setUs_Suprimido( rs.getString("Suprimido") ); regRead.setUs_Suprimido( (regRead.getUs_Suprimido() == null)?"":regRead.getUs_Suprimido().trim() ); // Suprimido
		regRead.setUs_Autor( rs.getString("Autor") ); regRead.setUs_Autor( (regRead.getUs_Autor() == null)?"":regRead.getUs_Autor().trim() ); // Autor
		regRead.setUs_Usuario( rs.getString("Usuario") ); regRead.setUs_Usuario( (regRead.getUs_Usuario() == null)?"":regRead.getUs_Usuario().trim() ); // Usuario
		regRead.setUs_Nombre( rs.getString("Nombre") ); regRead.setUs_Nombre( (regRead.getUs_Nombre() == null)?"":regRead.getUs_Nombre().trim() ); // Nombre
		regRead.setUs_Apellidos( rs.getString("Apellidos") ); regRead.setUs_Apellidos( (regRead.getUs_Apellidos() == null)?"":regRead.getUs_Apellidos().trim() ); // Apellidos
		regRead.setUs_Password( rs.getString("Password") ); regRead.setUs_Password( (regRead.getUs_Password() == null)?"":regRead.getUs_Password().trim() ); // Password
		regRead.setUs_Cuenta( rs.getString("Cuenta") ); regRead.setUs_Cuenta( (regRead.getUs_Cuenta() == null)?"":regRead.getUs_Cuenta().trim() ); // Cuenta
		regRead.setUs_eMail( rs.getString("eMail") ); regRead.setUs_eMail( (regRead.getUs_eMail() == null)?"":regRead.getUs_eMail().trim() ); // eMail
		regRead.setUs_HashCode( rs.getString("HashCode") ); regRead.setUs_HashCode( (regRead.getUs_HashCode() == null)?"":regRead.getUs_HashCode().trim() ); // HashCode
		regRead.setUs_FotoBase64( rs.getString("FotoBase64") ); regRead.setUs_FotoBase64( (regRead.getUs_FotoBase64() == null)?"":regRead.getUs_FotoBase64().trim() ); // FotoBase64
		regRead.setUs_isBloqueado( rs.getString("isBloqueado") ); regRead.setUs_isBloqueado( (regRead.getUs_isBloqueado() == null)?"":regRead.getUs_isBloqueado().trim() ); // isBloqueado
		regRead.setUs_isAdministrador( rs.getString("isAdministrador") ); regRead.setUs_isAdministrador( (regRead.getUs_isAdministrador() == null)?"":regRead.getUs_isAdministrador().trim() ); // isAdministrador
                        
                        if ( cfg.isExportar() ) getSeq_Sub_ExportMid( regRead );
                        else                    arrayTmp.add( regRead );

                        filas++;
                    } while( rs.next() && filas < (  (cfg!=null)?cfg.getFilasGrid():(new ConfigPantalla()).getFilasGrid() ) );
                }
            }
        } catch (SQLException ex0) {
            throw new DLException(ex0.getMessage());
        } catch (DLException ex1) {
            throw new DLException(ex1.getMessage());
        } finally {
            try {
                if ( rs != null ) { DBConnection.rsClose( dataBase, rs ); }
            } catch (SQLException ex2) {
                throw new DLException(ex2.getMessage());
            }
        }
        //////////////////////////////////////////////
        if ( cfg.isExportar() ) {
            getSeq_Sub_ExportFin();
        }
        //////////////////////////////////////////////
        filasRecuperadas = new UsBean[arrayTmp.size()];
        filasRecuperadas = arrayTmp.toArray(filasRecuperadas);
        return filasRecuperadas;
    }
    protected void getSeq_Sub_ExportIni( String NombreArchivo ) throws DLException {
        /////////////////////////////
        // Nombre completo del archivo viene por par�metros.
        /////////////////////////////
        fo = new File( NombreArchivo );
        try {
        	
//        	int i = fo.getAbsolutePath().lastIndexOf(File.separator);
//        	if ( i > -1 ) {
//        		try { 
//        			new File(fo.getAbsolutePath().substring(0, i)).mkdirs();
//				} catch (Exception e) {;}
//        	}
        	
            dout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fo)));
            if (dout!=null) {
				String s = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";
				s += "\r\n<html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=iso-8859-1\"><title>"+fo.getName()+"</title></head><body><table>\r\n";
				s += "<tr>";
				s += "<td><strong style='color:darkblue;'>" + "Sincro" + "</strong></td>";  // Sincro
				s += "<td><strong style='color:darkblue;'>" + "Marca" + "</strong></td>";  // Marca
				s += "<td><strong style='color:darkblue;'>" + "Suprimido" + "</strong></td>";  // Suprimido
				s += "<td><strong style='color:darkblue;'>" + "Autor" + "</strong></td>";  // Autor
				s += "<td><strong style='color:darkblue;'>" + "Usuario" + "</strong></td>";  // Usuario
				s += "<td><strong style='color:darkblue;'>" + "Nombre" + "</strong></td>";  // Nombre
				s += "<td><strong style='color:darkblue;'>" + "Apellidos" + "</strong></td>";  // Apellidos
				s += "<td><strong style='color:darkblue;'>" + "Password" + "</strong></td>";  // Password
				s += "<td><strong style='color:darkblue;'>" + "Cuenta" + "</strong></td>";  // Cuenta 
				s += "<td><strong style='color:darkblue;'>" + "eMail" + "</strong></td>";  // eMail
				s += "<td><strong style='color:darkblue;'>" + "HashCode" + "</strong></td>";  // HashCode 
				s += "<td><strong style='color:darkblue;'>" + "FotoBase64" + "</strong></td>";  // FotoBase64 
				s += "<td><strong style='color:darkblue;'>" + "isBloqueado" + "</strong></td>";  // isBloqueado
				s += "<td><strong style='color:darkblue;'>" + "isAdministrador" + "</strong></td>";  // isAdministrador
				s += "</tr>\r\n";
                dout.write(s);
            }
        } catch (FileNotFoundException ex1) {
            throw new DLException(ex1.getMessage());
        } catch (IOException ex2) {
            throw new DLException(ex2.getMessage());
        }
        /////////////////////////////
    }
    protected void getSeq_Sub_ExportMid(UsBean registro) throws DLException {
        String s = "";
		String tmp = "";
		
		s += "<tr>";
				s += "<td>" + new Long(registro.getUs_Sincro()).toString() + "</td>";  // Sincro
				tmp = registro.getUs_Marca();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Marca
				tmp = registro.getUs_Suprimido();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Suprimido
				tmp = registro.getUs_Autor();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Autor
				tmp = registro.getUs_Usuario();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Usuario
				tmp = registro.getUs_Nombre();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Nombre
				tmp = registro.getUs_Apellidos();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Apellidos
				tmp = registro.getUs_Password();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Password
				tmp = registro.getUs_Cuenta();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Cuenta
				tmp = registro.getUs_eMail();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // eMail
				tmp = registro.getUs_HashCode();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // HashCode
				tmp = registro.getUs_FotoBase64();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // FotoBase64
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // Empresa3
				tmp = registro.getUs_isBloqueado();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // isBloqueado
				tmp = registro.getUs_isAdministrador();
				try {tmp = new String( tmp.getBytes(), "iso-8859-1" );} catch (UnsupportedEncodingException ex) {;}
				s += "<td>" + tmp + "</td>";  // isAdministrador
		s += "</tr>\r\n";

        // Grabar en el archivo de salida:
        if (fo==null) return;
        if (dout==null) return;
        try {
            dout.write(s);
        } catch (FileNotFoundException ex1) {
            throw new DLException(ex1.getMessage());
        } catch (IOException ex2) {
            throw new DLException(ex2.getMessage());
        }
    }
    protected void getSeq_Sub_ExportFin() throws DLException {
        try {
            dout.write("</table></body></html>");
            dout.close();
        } catch (IOException ex) {
            throw new DLException(ex.getMessage());
        }
    }
/////////////////////////////////////////////////
    protected void     us_putParFS_bean( final String idOp, UsBean par ) throws DLException {
    	StringBuffer log = new StringBuffer();

    	new File( _K.caminoSalida  ).mkdirs();

    	// Propagar mis par�metros de ENTRADA:
    	final String pPar = _K.caminoSalida  + idOp + "_par" + _K.extFicParm;

    	// 1d3.Generar archivos de par�metros:
    	Utils.grabFile(log, pPar, par.serializar().getBytes() ); if(log.toString().trim().length()>0){throw new DLException(log.toString());}
//    	  par.deserializar( Utils.readFile(log, pPar ) );	// TEST

    }
    protected void     us_putParFS_GETSEQ( final String idOp, ConfigPantalla cfg, UsBeanFiltro rst ) throws DLException {
    	StringBuffer log = new StringBuffer();

    	new File( _K.caminoSalida  ).mkdirs();

    	// Propagar mis par�metros de ENTRADA:
    	final String pCfg = _K.caminoSalida  + idOp + "_cfg" + _K.extFicParm;
    	final String pRst = _K.caminoSalida  + idOp + "_rst" + _K.extFicParm;

    	// 1d3.Generar archivos de par�metros:
    	Utils.grabFile(log, pCfg, cfg.serializar().getBytes() ); if(log.toString().trim().length()>0){throw new DLException(log.toString());}
    	Utils.grabFile(log, pRst, rst.serializar().getBytes() ); if(log.toString().trim().length()>0){throw new DLException(log.toString());}

//        cfg.deserializar( Utils.readFile(log, pCfg ) );	// TEST
//        rst.deserializar( Utils.readFile(log, pRst ) );	// TEST

    }

    protected void     us_getParFS_RetCode( final String idOp ) throws DLException {
        StringBuffer log = new StringBuffer();

        new File( _K.caminoEntrada ).mkdirs();
        
        // Recoger mis par�metros de SALIDA:
        final String pRC = _K.caminoEntrada + idOp + "_RC" + _K.extFicParm;
        
        // 3d3.Leer resultados
        String rc = Utils.readFile(log, pRC ); if(log.toString().trim().length()>0){throw new DLException(log.toString());}

        try { new File(pRC).delete(); } catch (Exception e) {;} // Sistema LECTOR, SUPRIME lo leido

        if ( rc == null ) { throw new DLException("El sistema externo no retorna valor."); }
        if ( rc != null && rc.trim().length() > 0 ) { throw new DLException(rc); }
        
    }
    protected UsBean   us_getParFS_GET( final String idOp ) throws DLException {
    	
    	UsBean reg = null;
    	
        StringBuffer log = new StringBuffer();

        new File( _K.caminoEntrada ).mkdirs();
        
        // Recoger mis par�metros de SALIDA:
        final String pResultados = _K.caminoEntrada + idOp + _K.extFicParm;
        
        // 3d3.Leer resultados
        us_getParFS_RetCode( idOp );
        String rg = Utils.readFile(log, pResultados );	 if(log.toString().trim().length()>0){throw new DLException(log.toString());}

        try { new File(pResultados).delete(); } catch (Exception e) {;} // Sistema LECTOR, SUPRIME lo leido
        
        if ( rg != null && rg.trim().length() > 0 ) { 
            reg = new UsBean();
            reg.deserializar(rg);
        }

		return reg;
    }
    protected UsBean[] us_getParFS_GETSEQ( final String idOp, ConfigPantalla cfg ) throws DLException {

    	UsBean[] resultado = null;

        StringBuffer log = new StringBuffer();

        new File( _K.caminoEntrada ).mkdirs();

        // Recoger mis par�metros de SALIDA:
        final String pResultados = _K.caminoEntrada + idOp          + _K.extFicParm;
        final String pConfigPant = _K.caminoEntrada + idOp + "_cfg" + _K.extFicParm;

        // 3d3.Leer resultados
        us_getParFS_RetCode( idOp );
        String regs = Utils.readFile(log, pResultados ); if(log.toString().trim().length()>0){throw new DLException(log.toString());}
        String sCfg = Utils.readFile(log, pConfigPant ); //if(log.toString().trim().length()>0){throw new DLException(log.toString());}

        try { new File(pResultados).delete(); } catch (Exception e) {;} // Sistema LECTOR, SUPRIME lo leido
        try { new File(pConfigPant).delete(); } catch (Exception e) {;} // Sistema LECTOR, SUPRIME lo leido

        if ( regs != null && regs.trim().length() > 0 ) {
        	String[] lstRegs = regs.split( _K.sepReg );
        	resultado = new UsBean[lstRegs.length];
        	int i = 0;
        	for ( String e : lstRegs ) {
            	resultado[i] = new UsBean();
                if ( e != null && e.trim().length() > 0 ) { 
                	resultado[i].deserializar( e );
                }
                i++;
        	}
        } else {
        	resultado = new UsBean[0];
        }

		if ( sCfg != null && sCfg.trim().length() > 0 ) {
			cfg.deserializar(sCfg);
		}

        return resultado;
    }
/////////////////////////////////////////////////
	public JSONObject beanArray2json( UsBean[] lista ) {
		JSONObject jsonObject = new JSONObject(); 
		JSONArray jsonArray = new JSONArray();
		//////////////////////
		
		jsonObject.put("tabla", tabla);
		
		jsonArray.add( "Sincro" ); // Sincro
		jsonArray.add( "Marca" ); // Marca
		jsonArray.add( "Suprimido" ); // Suprimido
		jsonArray.add( "Autor" ); // Autor
		jsonArray.add( "Usuario" ); // Usuario
		jsonArray.add( "Nombre" ); // Nombre
		jsonArray.add( "Apellidos" ); // Apellidos
		jsonArray.add( "Password" ); // Password
		jsonArray.add( "Cuenta" ); // Cuenta 
		jsonArray.add( "eMail" ); // eMail
		jsonArray.add( "HashCode" ); // HashCode 
		jsonArray.add( "Idioma" ); // Idioma
		jsonArray.add( "FotoBase64" ); // FotoBase64 
		jsonArray.add( "isBloqueado" ); // isBloqueado
		jsonArray.add( "isAdministrador" ); // isAdministrador
		
		jsonObject.put("campos", jsonArray);
		
		if ( lista != null ) {
			for ( int i=0; i < lista.length; i++ ) {
				jsonArray.clear();
				
			jsonArray.add(  lista[i].getUs_Sincro() ); // Sincro
			jsonArray.add(  lista[i].getUs_Marca() ); // Marca
			jsonArray.add(  lista[i].getUs_Suprimido() ); // Suprimido
			jsonArray.add(  lista[i].getUs_Autor() ); // Autor
			jsonArray.add(  lista[i].getUs_Usuario() ); // Usuario
			jsonArray.add(  lista[i].getUs_Nombre() ); // Nombre
			jsonArray.add(  lista[i].getUs_Apellidos() ); // Apellidos
			jsonArray.add(  lista[i].getUs_Password() ); // Password
			jsonArray.add(  lista[i].getUs_Cuenta() ); // Cuenta
			jsonArray.add(  lista[i].getUs_eMail() ); // eMail
			jsonArray.add(  lista[i].getUs_HashCode() ); // HashCode
			jsonArray.add(  lista[i].getUs_FotoBase64() ); // FotoBase64
			jsonArray.add(  lista[i].getUs_isBloqueado() ); // isBloqueado
			jsonArray.add(  lista[i].getUs_isAdministrador() ); // isAdministrador
		
				jsonObject.put("r"+(i+1), jsonArray);
			}
		}
		
		//////////////////////
		return jsonObject;
		
	}
	public UsBean[] json2beanArray(JSONObject jsonObject) {
		UsBean[] resultado = null;

		ArrayList<UsBean> arrayTmp = new ArrayList<UsBean>();
		JSONArray jsonReg = null;

		if ( jsonObject != null ) {
			int i = 1;
			do {
				jsonReg = null;
				try {
					jsonReg = jsonObject.getJSONArray( "r" + (i++) );
					UsBean registro = new UsBean();
					
				registro.setUs_Sincro( jsonReg.getLong(0) );	// Sincro
				registro.setUs_Marca( jsonReg.getString(1) );	// Marca
				registro.setUs_Suprimido( jsonReg.getString(2) );	// Suprimido
				registro.setUs_Autor( jsonReg.getString(3) );	// Autor
				registro.setUs_Usuario( jsonReg.getString(4) );	// Usuario
				registro.setUs_Nombre( jsonReg.getString(5) );	// Nombre
				registro.setUs_Apellidos( jsonReg.getString(6) );	// Apellidos
				registro.setUs_Password( jsonReg.getString(7) );	// Password
				registro.setUs_Cuenta( jsonReg.getString(8) );	// Cuenta
				registro.setUs_eMail( jsonReg.getString(16) );	// eMail
				registro.setUs_HashCode( jsonReg.getString(17) );	// HashCode
				registro.setUs_FotoBase64( jsonReg.getString(20) );	// FotoBase64
				registro.setUs_isBloqueado( jsonReg.getString(27) );	// isBloqueado
				registro.setUs_isAdministrador( jsonReg.getString(28) );	// isAdministrador
					
					arrayTmp.add(registro);
				} catch (Exception e) {;}
			} while( jsonReg != null );
		}

		//////////////////////////////////////////////
		resultado = new UsBean[arrayTmp.size()];
		resultado = arrayTmp.toArray(resultado);
		arrayTmp.clear();

		return resultado;

	}
/////////////////////////////////////////////////
	
	  public long us_getCount(DBConnection dataBase, UsBeanFiltro rst ) throws DLException {
	        long resultado = 0L;

	        //////////////////////////////////////////////
	        if (dataBase==null || DBConnection.isPool) { dataBase = new DBConnection(); }
	        ///////////////////////////////////////////////////////
	        String sqlWhere = "";
	        ///////////////////////////////////////////////////////
	        // Filtros de la lista:
	        RstAplicar fltOper = new RstAplicar(dataBase.getRwUpperCase(),dataBase.getRwLike(),dataBase.getRwAnyString());
		
	   	sqlWhere = fltOper.getNUM_EQ(rst.getUs_Sincro(),"Sincro",sqlWhere);   // Sincro
	   	sqlWhere = fltOper.getCHAR_EQ(rst.getUs_Marca(),"Marca",sqlWhere);   // Marca
	   	sqlWhere = fltOper.getCHAR_EQ(rst.getUs_Suprimido(),"Suprimido",sqlWhere);   // Suprimido
	   	sqlWhere = fltOper.getCHAR_EQ(rst.getUs_Autor(),"Autor",sqlWhere);   // Autor
	   	sqlWhere = fltOper.getCHAR_EQ(rst.getUs_Usuario(),"Usuario",sqlWhere);   // Usuario
	   	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Nombre(),"Nombre",sqlWhere);   // Nombre
	   	sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_Apellidos(),"Apellidos",sqlWhere);   // Apellidos
	   	sqlWhere = fltOper.getCHAR_EQ(rst.getUs_Password(),"Password",sqlWhere);   // Password
	   	sqlWhere = fltOper.getCHAR_EQ(rst.getUs_Cuenta(),"Cuenta",sqlWhere);   // Cuenta
		sqlWhere = fltOper.getCHAR_EQ(rst.getUs_eMail(),"eMail",sqlWhere);   // eMail
		sqlWhere = fltOper.getCHAR_EQ(rst.getUs_HashCode(),"HashCode",sqlWhere);   // HashCode
		sqlWhere = fltOper.getCHAR_EQ(rst.getUs_FotoBase64(),"FotoBase64",sqlWhere);   // FotoBase64
		sqlWhere = fltOper.getCHAR_EQ(rst.getUs_isBloqueado(),"isBloqueado",sqlWhere);   // isBloqueado
		sqlWhere = fltOper.getCHAR_LIKE(rst.getUs_isAdministrador(),"isAdministrador",sqlWhere);   // isAdministrador
	        //////////////////////////////////////////////////////

		ResultSet rs = null;
		try {
	            ///////////////////////////////////////
	            // Configuraci�n del DSPFIL (NumFilas, NumPantallas...)
	            String sqlCount = "SELECT COUNT(*) AS nFilas FROM \"" + Utils.getG_DB_LIBDAT(dataBase.getCurrentDb()) + "\".\""  + lf_RTV + "\" \"A\"";
	            sqlCount += sqlWhere;
	            rs = dataBase.executeQuery(sqlCount);
	            if ( rs.next() ) resultado = rs.getLong("nFilas");
	            if ( rs != null ) { DBConnection.rsClose( dataBase, rs ); }
	            ///////////////////////////////////////
		    } catch (SQLException ex0) {
		        throw new DLException(ex0.getMessage());
		    } catch (DLException ex1) {
		        throw new DLException(ex1.getMessage());
		    }
		return resultado;
	    }
}
