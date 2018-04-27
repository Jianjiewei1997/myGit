<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>


<html>
  <head>
   
  </head>
  
  <body>
 	<s:form action="addBook" method="post" namespace="/">
     	
     	<s:textfield name="book.bid" label="书号"/>
    	<s:textfield name="book.bname" label="书名"/>
    	<s:textfield name="book.bauther" label="作者"/>
        <s:textfield name="book.btype" label="类型"/>
    	<s:textfield name="book.bprice" label="价格"/>
    	<s:textfield name="book.bamount" label="数量"/>
    	<s:textfield name="book.bpubdate" label="出版日期"/>
    	
    	<s:submit name="submit" value="提交" align="center"/>
    </s:form>
  </body>
</html>
