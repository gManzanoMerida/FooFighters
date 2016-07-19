package com.deal.usuarios.bean;

import com.deal.common._K;

public class UsBeanFiltro extends Object {

	private String us_Sincro; // Sincro
	private String us_Marca; // Marca
	private String us_Suprimido; // Suprimido
	private String us_Autor; // Autor
	private String us_Usuario; // Usuario
	private String us_Nombre; // Nombre
	private String us_Apellidos; // Apellidos
	private String us_Password; // Password
	private String us_Cuenta; // Cuenta 
	private String us_eMail; // eMail
	private String us_HashCode; // HashCode 
	private String us_FotoBase64; // FotoBase64 
	private String us_isBloqueado; // isBloqueado
	private String us_isAdministrador; // isAdministrador
    
    public UsBeanFiltro() {
        super();
        inicializar();
    }
    
    // Constructor que deja 'null' en todos sus miembros
    public UsBeanFiltro(Object nulo) { super(); }

    public void inicializar() {
	this.setUs_Sincro( "" ); // Sincro
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

    public UsBeanFiltro coalesce(UsBeanFiltro pri, UsBeanFiltro sec) {
        UsBeanFiltro r = new UsBeanFiltro(null);
        if ( pri!=null && sec!=null ) {
		r.setUs_Sincro( (pri.getUs_Sincro()==null)?sec.getUs_Sincro():pri.getUs_Sincro() );	// Sincro
		r.setUs_Marca( (pri.getUs_Marca()==null)?sec.getUs_Marca():pri.getUs_Marca() );	// Marca
		r.setUs_Suprimido( (pri.getUs_Suprimido()==null)?sec.getUs_Suprimido():pri.getUs_Suprimido() );	// Suprimido
		r.setUs_Autor( (pri.getUs_Autor()==null)?sec.getUs_Autor():pri.getUs_Autor() );	// Autor
		r.setUs_Usuario( (pri.getUs_Usuario()==null)?sec.getUs_Usuario():pri.getUs_Usuario() );	// Usuario
		r.setUs_Nombre( (pri.getUs_Nombre()==null)?sec.getUs_Nombre():pri.getUs_Nombre() );	// Nombre
		r.setUs_Apellidos( (pri.getUs_Apellidos()==null)?sec.getUs_Apellidos():pri.getUs_Apellidos() );	// Apellidos
		r.setUs_Password( (pri.getUs_Password()==null)?sec.getUs_Password():pri.getUs_Password() );	// Password
		r.setUs_Cuenta( (pri.getUs_Cuenta()==null)?sec.getUs_Cuenta():pri.getUs_Cuenta() );	// Cuenta 
		r.setUs_eMail( (pri.getUs_eMail()==null)?sec.getUs_eMail():pri.getUs_eMail() );	// eMail
		r.setUs_HashCode( (pri.getUs_HashCode()==null)?sec.getUs_HashCode():pri.getUs_HashCode() );	// HashCode 
		r.setUs_FotoBase64( (pri.getUs_FotoBase64()==null)?sec.getUs_FotoBase64():pri.getUs_FotoBase64() );	// FotoBase64 
		r.setUs_isBloqueado( (pri.getUs_isBloqueado()==null)?sec.getUs_isBloqueado():pri.getUs_isBloqueado() );	// isBloqueado
		r.setUs_isAdministrador( (pri.getUs_isAdministrador()==null)?sec.getUs_isAdministrador():pri.getUs_isAdministrador() );	// isAdministrador
        }
        return r;
    }
    
    public void copyTo(UsBeanFiltro Destino) {
	Destino.setUs_Sincro( getUs_Sincro() ); // Sincro
	Destino.setUs_Marca( getUs_Marca() ); // Marca
	Destino.setUs_Suprimido( getUs_Suprimido() ); // Suprimido
	Destino.setUs_Autor( getUs_Autor() ); // Autor
	Destino.setUs_Usuario( getUs_Usuario() ); // Usuario
	Destino.setUs_Nombre( getUs_Nombre() ); // Nombre
	Destino.setUs_Apellidos( getUs_Apellidos() ); // Apellidos
	Destino.setUs_Password( getUs_Password() ); // Password
	Destino.setUs_Cuenta( getUs_Cuenta() ); // Cuenta 
	Destino.setUs_eMail( getUs_eMail() ); // eMail
	Destino.setUs_HashCode( getUs_HashCode() ); // HashCode 
	Destino.setUs_FotoBase64( getUs_FotoBase64() ); // FotoBase64 
	Destino.setUs_isBloqueado( getUs_isBloqueado() ); // isBloqueado
	Destino.setUs_isAdministrador( getUs_isAdministrador() ); // isAdministrador
    }
    
    public void copyFrom(UsBeanFiltro Origen) {
	setUs_Sincro( Origen.getUs_Sincro() ); // Sincro
	setUs_Marca( Origen.getUs_Marca() ); // Marca
	setUs_Suprimido( Origen.getUs_Suprimido() ); // Suprimido
	setUs_Autor( Origen.getUs_Autor() ); // Autor
	setUs_Usuario( Origen.getUs_Usuario() ); // Usuario
	setUs_Nombre( Origen.getUs_Nombre() ); // Nombre
	setUs_Apellidos( Origen.getUs_Apellidos() ); // Apellidos
	setUs_Password( Origen.getUs_Password() ); // Password
	setUs_Cuenta( Origen.getUs_Cuenta() ); // Cuenta 
	setUs_eMail( Origen.getUs_eMail() ); // eMail
	setUs_HashCode( Origen.getUs_HashCode() ); // HashCode 
	setUs_FotoBase64( Origen.getUs_FotoBase64() ); // FotoBase64 
	setUs_isBloqueado( Origen.getUs_isBloqueado() ); // isBloqueado
	setUs_isAdministrador( Origen.getUs_isAdministrador() ); // isAdministrador
    }
	////////////////////////////////////////////////////////////
	public String serializar() {
		StringBuffer out = new StringBuffer();
		
		                         out.append( this.getUs_Sincro()==null?"":this.getUs_Sincro() ); // Sincro
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
			
			try { this.setUs_Sincro( trozos[0] ); } catch (Exception e) {;} // Sincro
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

	/** Get Sincro*/
	public String getUs_Sincro() {return us_Sincro;}
	/** Set Sincro*/
	public void setUs_Sincro(String us_Sincro) {this.us_Sincro = us_Sincro;}

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

}
