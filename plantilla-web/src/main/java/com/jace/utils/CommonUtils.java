package com.jace.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtils {

	public static void showMessage(String... arguments) {
		String severety/*............. MESSAGE | TIPO    */= arguments[0];
		String summary/*.............. MESSAGE | TITULO  */= arguments[1];
		String detail/* .............. MESSAGE | MENSAJE */= arguments[2];
		Severity s;
		switch (severety.toUpperCase()) {
			case "INFO": s = FacesMessage.SEVERITY_INFO; break;
			case "ERROR": s = FacesMessage.SEVERITY_ERROR; break;
			case "FATAL": s = FacesMessage.SEVERITY_FATAL; break;
			case "WARN": s = FacesMessage.SEVERITY_WARN; break;
			default: s = FacesMessage.SEVERITY_INFO; break;
		}
		FacesMessage message = new FacesMessage(s, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}