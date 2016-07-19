package com.deal.usuarios.bean;

import com.deal.common.DLBean;
import com.deal.common.Utils;
import com.deal.common._K;

public class UsBean extends DLBean {

	public long   us_Sincro; // Sincro
	public String us_Marca; // Marca
	public String us_Suprimido; // Suprimido
	public String us_Autor; // Autor
	public String us_Usuario; // Usuario
	public String us_Nombre; // Nombre
	public String us_Apellidos; // Apellidos
	public String us_Password; // Password
	public String us_Cuenta; // Cuenta 
	public String us_eMail; // eMail
	public String us_HashCode; // HashCode 
	public String us_FotoBase64; // FotoBase64 
	public String us_isBloqueado; // isBloqueado
	public String us_isAdministrador; // isAdministrador
    
    public UsBean() {
        super();
        inicializar();
    }
    
    // Constructor que deja 'null' en todos sus miembros
    public UsBean(Object nulo) { super(); }

    public void inicializar() {
	this.setUs_Sincro( 0 ); // Sincro
	this.setUs_Marca( "" ); // Marca
	this.setUs_Suprimido( "" ); // Suprimido
	this.setUs_Autor( "" ); // Autor
	this.setUs_Usuario( "" ); // Usuario
	this.setUs_Nombre( "" ); // Nombre
	this.setUs_Apellidos( "" ); // Apellidos
	this.setUs_Password( "" ); // Password
	this.setUs_Cuenta( "" ); // Cuenta 
	this.setUs_eMail( "" ); // eMail
	this.setUs_HashCode( "" ); // HashCode 
	this.setUs_FotoBase64( "" ); // FotoBase64 
	this.setUs_isBloqueado( "" ); // isBloqueado
	this.setUs_isAdministrador( "" ); // isAdministrador
    } 
 /*
    public void copyTo(StBean beanDestino) {
        UsBean Destino = (UsBean)beanDestino;

	Destino.setUs_Sincro( getUs_Sincro() ); // Sincro
	Destino.setUs_Marca( getUs_Marca() ); // Marca
	Destino.setUs_Suprimido( getUs_Suprimido() ); // Suprimido
	Destino.setUs_Autor( getUs_Autor() ); // Autor
	Destino.setUs_Usuario( getUs_Usuario() ); // Usuario
	Destino.setUs_Nombre( getUs_Nombre() ); // Nombre
	Destino.setUs_Apellidos( getUs_Apellidos() ); // Apellidos
	Destino.setUs_Password( getUs_Password() ); // Password
	Destino.setUs_Cuenta( getUs_Cuenta() ); // Cuenta
	Destino.setUs_ct_isPublica( getUs_ct_isPublica() ); // ct_isPublica
	Destino.setUs_CT_Nombre( getUs_CT_Nombre() ); // CT_Nombre
	Destino.setUs_CT_Estado( getUs_CT_Estado() ); // CT_Estado
	Destino.setUs_CT_LogoBase64( getUs_CT_LogoBase64() ); // CT_LogoBase64
	Destino.setUs_CT_HashCode( getUs_CT_HashCode() ); // CT_HashCode
	Destino.setUs_lzPK( getUs_lzPK() ); // lzPK
	Destino.setUs_dcPK( getUs_dcPK() ); // dcPK
	Destino.setUs_eMail( getUs_eMail() ); // eMail
	Destino.setUs_HashCode( getUs_HashCode() ); // HashCode
	Destino.setUs_Modo_mis_CP( getUs_Modo_mis_CP() ); // Modo_mis_CP
	Destino.setUs_Idioma( getUs_Idioma() ); // Idioma
	Destino.setUs_FotoBase64( getUs_FotoBase64() ); // FotoBase64
	Destino.setUs_Cargo1( getUs_Cargo1() ); // Cargo1
	Destino.setUs_Empresa1( getUs_Empresa1() ); // Empresa1
	Destino.setUs_Cargo2( getUs_Cargo2() ); // Cargo2
	Destino.setUs_Empresa2( getUs_Empresa2() ); // Empresa2
	Destino.setUs_Cargo3( getUs_Cargo3() ); // Cargo3
	Destino.setUs_Empresa3( getUs_Empresa3() ); // Empresa3
	Destino.setUs_isBloqueado( getUs_isBloqueado() ); // isBloqueado
	Destino.setUs_isAdministrador( getUs_isAdministrador() ); // isAdministrador
    }
    
    public void copyFrom(StBean beanOrigen) {
        UsBean Origen = (UsBean)beanOrigen;

	setUs_Sincro( Origen.getUs_Sincro() ); // Sincro
	setUs_Marca( Origen.getUs_Marca() ); // Marca
	setUs_Suprimido( Origen.getUs_Suprimido() ); // Suprimido
	setUs_Autor( Origen.getUs_Autor() ); // Autor
	setUs_Usuario( Origen.getUs_Usuario() ); // Usuario
	setUs_Nombre( Origen.getUs_Nombre() ); // Nombre
	setUs_Apellidos( Origen.getUs_Apellidos() ); // Apellidos
	setUs_Password( Origen.getUs_Password() ); // Password
	setUs_Cuenta( Origen.getUs_Cuenta() ); // Cuenta
	setUs_ct_isPublica( Origen.getUs_ct_isPublica() ); // ct_isPublica
	setUs_CT_Nombre( Origen.getUs_CT_Nombre() ); // CT_Nombre
	setUs_CT_Estado( Origen.getUs_CT_Estado() ); // CT_Estado
	setUs_CT_LogoBase64( Origen.getUs_CT_LogoBase64() ); // CT_LogoBase64
	setUs_CT_HashCode( Origen.getUs_CT_HashCode() ); // CT_HashCode
	setUs_lzPK( Origen.getUs_lzPK() ); // lzPK
	setUs_dcPK( Origen.getUs_dcPK() ); // dcPK
	setUs_eMail( Origen.getUs_eMail() ); // eMail
	setUs_HashCode( Origen.getUs_HashCode() ); // HashCode
	setUs_Modo_mis_CP( Origen.getUs_Modo_mis_CP() ); // Modo_mis_CP
	setUs_Idioma( Origen.getUs_Idioma() ); // Idioma
	setUs_FotoBase64( Origen.getUs_FotoBase64() ); // FotoBase64
	setUs_Cargo1( Origen.getUs_Cargo1() ); // Cargo1
	setUs_Empresa1( Origen.getUs_Empresa1() ); // Empresa1
	setUs_Cargo2( Origen.getUs_Cargo2() ); // Cargo2
	setUs_Empresa2( Origen.getUs_Empresa2() ); // Empresa2
	setUs_Cargo3( Origen.getUs_Cargo3() ); // Cargo3
	setUs_Empresa3( Origen.getUs_Empresa3() ); // Empresa3
	setUs_isBloqueado( Origen.getUs_isBloqueado() ); // isBloqueado
	setUs_isAdministrador( Origen.getUs_isAdministrador() ); // isAdministrador
    }
*/


	/** Get Sincro*/
	public long getUs_Sincro() {return us_Sincro;}
	/** Set Sincro*/
	public void setUs_Sincro(long us_Sincro) {this.us_Sincro = us_Sincro;}

	/** Get Marca*/
	public String getUs_Marca() {return us_Marca;}
	/** Set Marca*/
	public void setUs_Marca(String us_Marca) {this.us_Marca = us_Marca;}

	/** Get Suprimido*/
	public String getUs_Suprimido() {return us_Suprimido;}
	/** Set Suprimido*/
	public void setUs_Suprimido(String us_Suprimido) {this.us_Suprimido = us_Suprimido;}

	/** Get Autor*/
	public String getUs_Autor() {return us_Autor;}
	/** Set Autor*/
	public void setUs_Autor(String us_Autor) {this.us_Autor = us_Autor;}

	/** Get Usuario*/
	public String getUs_Usuario() {return us_Usuario;}
	/** Set Usuario*/
	public void setUs_Usuario(String us_Usuario) {this.us_Usuario = us_Usuario;}

	/** Get Nombre*/
	public String getUs_Nombre() {return us_Nombre;}
	/** Set Nombre*/
	public void setUs_Nombre(String us_Nombre) {this.us_Nombre = us_Nombre;}

	/** Get Apellidos*/
	public String getUs_Apellidos() {return us_Apellidos;}
	/** Set Apellidos*/
	public void setUs_Apellidos(String us_Apellidos) {this.us_Apellidos = us_Apellidos;}

	/** Get Password*/
	public String getUs_Password() {return us_Password;}
	/** Set Password*/
	public void setUs_Password(String us_Password) {this.us_Password = us_Password;}

	/** Get Cuenta*/
	public String getUs_Cuenta() {return us_Cuenta;}
	/** Set Cuenta*/
	public void setUs_Cuenta(String us_Cuenta) {this.us_Cuenta = us_Cuenta;}

	 
	/** Get eMail*/
	public String getUs_eMail() {return us_eMail;}
	/** Set eMail*/
	public void setUs_eMail(String us_eMail) {this.us_eMail = us_eMail;}

	/** Get HashCode*/
	public String getUs_HashCode() {return us_HashCode;}
	/** Set HashCode*/
	public void setUs_HashCode(String us_HashCode) {this.us_HashCode = us_HashCode;}

  
	/** Get FotoBase64*/
	public String getUs_FotoBase64() {return us_FotoBase64;}
	/** Set FotoBase64*/
	public void setUs_FotoBase64(String us_FotoBase64) {this.us_FotoBase64 = us_FotoBase64;}
   
	/** Get isBloqueado*/
	public String getUs_isBloqueado() {return us_isBloqueado;}
	/** Set isBloqueado*/
	public void setUs_isBloqueado(String us_isBloqueado) {this.us_isBloqueado = us_isBloqueado;}

	/** Get isAdministrador*/
	public String getUs_isAdministrador() {return us_isAdministrador;}
	/** Set isAdministrador*/
	public void setUs_isAdministrador(String us_isAdministrador) {this.us_isAdministrador = us_isAdministrador;}


	////////////////////////////////////////////////////////////
    public String getKey(){
		 return us_Usuario;}

    public void setKey(String key){
            String k="";
	k = key; this.setUs_Usuario( k );
    }
	////////////////////////////////////////////////////////////
	public String serializar() {
		StringBuffer out = new StringBuffer();
		
		                         out.append( this.getUs_Sincro() ); // Sincro
		out.append( _K.sepFld ); out.append( this.getUs_Marca()==null?"":this.getUs_Marca() ); // Marca
		out.append( _K.sepFld ); out.append( this.getUs_Suprimido()==null?"":this.getUs_Suprimido() ); // Suprimido
		out.append( _K.sepFld ); out.append( this.getUs_Autor()==null?"":this.getUs_Autor() ); // Autor
		out.append( _K.sepFld ); out.append( this.getUs_Usuario()==null?"":this.getUs_Usuario() ); // Usuario
		out.append( _K.sepFld ); out.append( this.getUs_Nombre()==null?"":this.getUs_Nombre() ); // Nombre
		out.append( _K.sepFld ); out.append( this.getUs_Apellidos()==null?"":this.getUs_Apellidos() ); // Apellidos
		out.append( _K.sepFld ); out.append( this.getUs_Password()==null?"":this.getUs_Password() ); // Password
		out.append( _K.sepFld ); out.append( this.getUs_Cuenta()==null?"":this.getUs_Cuenta() ); // Cuenta 
		out.append( _K.sepFld ); out.append( this.getUs_eMail()==null?"":this.getUs_eMail() ); // eMail
		out.append( _K.sepFld ); out.append( this.getUs_HashCode()==null?"":this.getUs_HashCode() ); // HashCode 
		out.append( _K.sepFld ); out.append( this.getUs_FotoBase64()==null?"":this.getUs_FotoBase64() ); // FotoBase64 
		out.append( _K.sepFld ); out.append( this.getUs_isBloqueado()==null?"":this.getUs_isBloqueado() ); // isBloqueado
		out.append( _K.sepFld ); out.append( this.getUs_isAdministrador()==null?"":this.getUs_isAdministrador() ); // isAdministrador

		out.append( _K.sepReg );
		
		return out.toString();
	}
	public void deserializar(String in) {
		inicializar();
		if ( in != null && in.length() > 0 ) {
			
			String s = in.replaceAll( _K.sepReg, "" );
                   s =  s.replaceAll( _K.sepReg_0x0D, "" );
                   s =  s.replaceAll( _K.sepReg_0x0A, "" );
			String[] trozos = s.split( _K.sepFld );
			
			try { this.setUs_Sincro( Utils.parse_long( trozos[0] )); } catch (Exception e) {;} // Sincro
			try { this.setUs_Marca( trozos[1] ); } catch (Exception e) {;} // Marca
			try { this.setUs_Suprimido( trozos[2] ); } catch (Exception e) {;} // Suprimido
			try { this.setUs_Autor( trozos[3] ); } catch (Exception e) {;} // Autor
			try { this.setUs_Usuario( trozos[4] ); } catch (Exception e) {;} // Usuario
			try { this.setUs_Nombre( trozos[5] ); } catch (Exception e) {;} // Nombre
			try { this.setUs_Apellidos( trozos[6] ); } catch (Exception e) {;} // Apellidos
			try { this.setUs_Password( trozos[7] ); } catch (Exception e) {;} // Password
			try { this.setUs_Cuenta( trozos[8] ); } catch (Exception e) {;} // Cuenta 
			try { this.setUs_eMail( trozos[9] ); } catch (Exception e) {;} // eMail
			try { this.setUs_HashCode( trozos[10] ); } catch (Exception e) {;} // HashCode 
			try { this.setUs_FotoBase64( trozos[11] ); } catch (Exception e) {;} // FotoBase64 
			try { this.setUs_isBloqueado( trozos[12] ); } catch (Exception e) {;} // isBloqueado
			try { this.setUs_isAdministrador( trozos[13] ); } catch (Exception e) {;} // isAdministrador
			
		}
	}
	////////////////////////////////////////////////////////////

}
