package com.gmm.user.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.gmm.dao.JDBCUserDAO;
import com.gmm.user.User;
import com.gmm.util.Constantes;
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
	
	private String username="";
	private String password="";
	private String usuarioActivo="";   //Flag para que la web no muestre el formulario de login si hay un usuario en sesion
	
	public String execute() {
//		User user = null;
//		Map<String, Object> session = ActionContext.getContext().getSession(); 
//		user = (User) session.get("user");
//		if (user!=null){ 
//			System.out.println("No está creada la sesión"); 
//			setUsername(user.getName());
//			setUsuarioActivo("ok");
//		} else {
//			setUsuarioActivo("ko");
//		}
		
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
		
		JDBCUserDAO dao = new JDBCUserDAO();
		dao.getConnection();
		if (dao.getConnection()!=null){
				dao.exist(user);
				dao.closeConnection();
				
				///////////////////////////////////////////////////////////////
				// Control de usuario en sesion
				Map<String, Object> session = ActionContext.getContext().getSession(); 
				if (session.get("user")==null){ 
					System.out.println("No está creada la sesión"); 
					session.put(Constantes.USER, user);
				}else{ 
					System.out.println("Está creada la sesión"); 
				}  
				/////////////////////////////////////////////////////////////////				

		} else {
//			result = ERROR;
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
	
	
	
	
}