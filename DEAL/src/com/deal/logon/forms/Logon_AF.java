package com.deal.logon.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class Logon_AF extends org.apache.struts.action.ActionForm {
    public static final long serialVersionUID = 1L; 
    
    private String logon_USR;
    private String logon_PWD;
    
    public Logon_AF() {super();}
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        return null;
    }

    public String getLogon_USR() {
        return logon_USR;
    }

    public void setLogon_USR(String logon_USR) {
        this.logon_USR = logon_USR;
    }

    public String getLogon_PWD() {
        return logon_PWD;
    }

    public void setLogon_PWD(String logon_PWD) {
        this.logon_PWD = logon_PWD;
    }
}