package com.deal.logon.actions; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.deal.datasource.DBConnection;
import com.deal.common.DLException;
import com.deal.common.Utils;
import com.deal.logon.forms.Logon_AF;

public class Logon_A extends Action {
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        Logon_AF pantalla = (Logon_AF) form;
        
        request.getSession().invalidate();
        
        String resultado = "OK";
        
        if ( 
			 pantalla == null || 
			 pantalla.getLogon_USR() == null || 
			 pantalla.getLogon_USR().trim().length() < 1 || 
			 pantalla.getLogon_PWD().trim().length() < 1 
			 ) {
            ActionMessages errores = new ActionMessages();
            errores.add("error", new ActionMessage( "errors.detail", "Campos obligatorios." ));
            saveErrors(request,errores);
        } else {
            if ( chkUsrPwd(request,form) ) {
                request.getSession(true).setAttribute( "logon_USR", pantalla.getLogon_USR().trim() );
                resultado = "ENTRAR";
//            } else {
//                ActionMessages errores = new ActionMessages();
//                errores.add("error", new ActionMessage( "errors.detail", "No se superó el chequeo de seguridad." ));
//                saveErrors(request,errores);
            }
        }
        
        return mapping.findForward(resultado);
        
    }
    
    private boolean chkUsrPwd(HttpServletRequest request, ActionForm  form) {
        boolean resultado = false;
        /////////////////////////////////////
        Logon_AF pantalla = (Logon_AF) form;
        /////////////////////////////////////
        ActionMessages errores = new ActionMessages();
        DBConnection dataBase = new Utils().getDBConnection(request);
        /////////////////////////////////////
        // ..acceso a BD para comprobar la contraseña...
        
        try {
            com.deal.usuarios.db.UsAccesoBaseDatos dao = new com.deal.usuarios.db.UsAccesoBaseDatos();
            com.deal.usuarios.bean.UsBean          reg = new com.deal.usuarios.bean.UsBean();
            reg.setUs_Usuario( pantalla.getLogon_USR() );
        	reg = dao.us_getRcd(dataBase, reg);
        	if ( reg != null && reg.getUs_Password().equalsIgnoreCase( pantalla.getLogon_PWD() ) && 
        		 reg.getUs_isAdministrador() != null && reg.getUs_isAdministrador().trim().length() > 0 ) {
            		resultado = true;
        	} else {
        		errores.add("error", new ActionMessage( "errors.detail", "Usuario indebido o contraseña no válida." ));
        	}
		} catch (DLException e) {
    		errores.add("error", new ActionMessage( "errors.detail", e.getMessage() ));
		}
        
        if ( ! errores.isEmpty() ) {
    		saveErrors(request,errores);
        }
        /////////////////////////////////////
        return resultado;
    }
    
}