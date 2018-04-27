<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head> 
  </head>
  
  <body>
    <form action="findByName" method="post" namespace="/">
  		书名：
  		<input type="text" name="bname">
  		<input type="submit" value="查询">
  	</form>
  	
  	<form action="findByPrice" method="post" namespace="/">
  		价格：
  		<input type="text" name="lowprice">
  		~
  		<input type="text" name="highprice">
  		<input type="submit" value="确定">
  	</form>
  	<a href="AddBook.jsp">添加书本</a>
    <table border="1">
        <tr>
            <td>书号</td>
            <td>书名</td>
            <td>作者</td>
            <td>类型</td>
            <td>价格</td>
            <td>数量</td>
            <td>出版日期</td>
            <td>操作</td>  
        </tr>
   	 	<s:iterator value="#request.book" id="books"  >
    	<tr>
            <td><s:property value="#books.bid"/></td>
            <td><s:property value="#books.bname"/></td>
            <td><s:property value="#books.bauther"/></td>
            <td><s:property value="#books.btype"/></td>
            <td><s:property value="#books.bprice"/></td>
            <td><s:property value="#books.bamount"/></td>
            <td><s:property value="#books.bpubdate"/></td>
            <td><a href="BookUpdate.jsp">修改</a></td>
        </tr>
   	 	</s:iterator>
 	</table>
 	
 	
  </body>
</html>
