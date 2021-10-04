<%@page import="vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Product> CartList = (ArrayList<Product>) request.getAttribute("baskeyCartList");
%>

<%@include file="header.jsp"%>






<%
	for (int i = 0; i < CartList.size(); i++) {
%>

<tr>
	<%=CartList.get(i).getName()%>



	<%-- <td><%=test.getName()%></td>
	<td><%=test.getPI_date()%></td>
	<td><%=test.getPrice()%></td> --%>
</tr>


<%
	}
%>






