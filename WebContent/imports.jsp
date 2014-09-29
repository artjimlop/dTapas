<%@page import="business.*"%>
<%@page import="domain.*"%>
<%@page import="utils.*"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String existe = (String) session.getAttribute("session.user");
	if(existe == null){
		response.sendRedirect("index.jsp");
	}else{
%>