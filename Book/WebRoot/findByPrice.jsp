<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
   
  </head>
  
  <body>
    
    <table border="1">
        <tr>
            <td>书号</td>
            <td>书名</td>
            <td>作者</td>
            <td>类型</td>
            <td>价格</td>
            <td>数量</td>
            <td>出版日期</td>
        </tr>
        
   	 	<s:iterator value="#request.book" id="book">
    	<tr>
            <td><s:property value="#book.bid"/></td>
            <td><s:property value="#book.bname"/></td>
            <td><s:property value="#book.bauther"/></td>
            <td><s:property value="#book.btype"/></td>
            <td><s:property value="#book.bprice"/></td>
            <td><s:property value="#book.bamount"/></td>
            <td><s:property value="#book.bpubdate"/></td>
        </tr>
   	 	</s:iterator>
   	 	
 	</table>
    
    
    
  </body>
</html>
