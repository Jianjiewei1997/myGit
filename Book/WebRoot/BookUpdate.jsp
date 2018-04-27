<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    
  </head>
  
  <body>
    <s:form action="BookUpdate" method="post" namespace="/">
    	<div align="left">
    	部门修改
    	<s:textfield name="bid" label="书号"/>
    	<s:textfield name="bamount" label="数量"/>
    	<s:submit name="submit" value="确定" align="center"/>
    	<s:reset name="reset" value="重置" align="center"/>

 	</s:form>
    </div>
    
  </body>
</html>
