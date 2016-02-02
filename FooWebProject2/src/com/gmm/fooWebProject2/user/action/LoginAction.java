package com.gmm.fooWebProject2.user.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.gmm.fooWebProject2.dao.UserDAO;
import com.gmm.fooWebProject2.user.User;
import com.gmm.fooWebProject2.util.Constantes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

 

@Namespace("/User")
@ResultPath(value="/")
//@Result(name="success",location="pages/login.jsp")
@Results({
	@Result(name="success",location="pages/login.jsp"),
	@Result(name="error", location="pages/error.jsp")
})
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 5554901011312978205L;
	
	final static Logger logger = Logger.getLogger(LoginAction.class);
	
	private String username="";
	private String password="";
	private String usuarioActivo="";   //Flag para que la web no muestre el formulario de login si hay un usuario en sesion
	private String userNoEncontrado="";
	private String mensaje="";
	
	
	@Action(value = "checkUser", results = { 
			@Result(name = "success", location = "pages/login.jsp"),
			@Result(name = "error", location = "pages/error.jsp")})
	public String execute() {
		User user = null;
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		user = (User) session.get("user");
		if (user!=null){ 
			System.out.println("La sesión ya está creada con el usuario: " + user.getName()); 
			setUsername(user.getName());
			setUsuarioActivo("ok");
		} else {
			setUsuarioActivo("ko");
			setUsername("");
			System.out.println("No está creada la sesión");
		}
		
		return SUCCESS;

	}
	
	
	@Action(value = "loginActionForm", results = { 
			@Result(name = "success", location = "pages/welcome_user.jsp"),
			@Result(name = "error", location = "pages/login.jsp")})
	public String login(){
		
		String result = SUCCESS;
		
		User user = new User();
		user.setName(getUsername());
		user.setPass(getPassword());
		
		/////////////////////////////////////////////////////////////////////////
		//// Control de sesion
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("user") == null) {
			System.out.println("No está creada la sesión");
			session.put(Constantes.USER, user);

			////////////////////
			//Try loggin
			UserDAO dao = new UserDAO();
			boolean ok = dao.exist(user);

			if (ok) {
				setUserNoEncontrado("");
			} else {
				setUserNoEncontrado("true");
				setMensaje("Usuario no encontrado.");
				result = ERROR;
			}  

		/////////////////////77
		// Sesion creada
		} else {
			System.out.println("Está creada la sesión");
		}

		return result;
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////// GETTERS & SETTERS
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsuarioActivo() {
		return usuarioActivo;
	}


	public void setUsuarioActivo(String usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}


	public String getUserNoEncontrado() {
		return userNoEncontrado;
	}


	public void setUserNoEncontrado(String userNoEncontrado) {
		this.userNoEncontrado = userNoEncontrado;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
}