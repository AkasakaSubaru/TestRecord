<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<jsp:useBean id="mb" class="bean.MyDBBean" scope="request"/>
<%
List<Integer> ja_list = (List<Integer>)request.getAttribute("ja_list");
List<String> name_list = (List<String>)request.getAttribute("name_list");
List<Integer> mo_list = (List<Integer>)request.getAttribute("mo_list");
List<Integer> so_list = (List<Integer>)request.getAttribute("so_list");
List<Integer> sc_list = (List<Integer>)request.getAttribute("sc_list");
List<Integer> en_list = (List<Integer>)request.getAttribute("en_list");
List<Integer> sum_list =  new ArrayList<Integer>();
int sum = 0;
int max_sum = 0;
for (int n=0;n < name_list.size();n++){
	sum = ja_list.get(n) + mo_list.get(n) + so_list.get(n) + sc_list.get(n) + en_list.get(n);
	sum_list.add(sum);
	if(max_sum < sum_list.get(n)){
		max_sum = sum_list.get(n);
	}
	sum = 0;
};
%>
<!DOCTYPE html>
<html>
  <head>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>ホーム</title>
  </head>
  <body>
    <h2>ようこそ<%=request.getAttribute("name") %>さん</h2>
    <h1>今までのテストの記録:<%= name_list.size() %>回</h1>
    <table border="1">
      <tr>
        <th>テスト名</th>
        <th>国語</th>
        <th>数学</th>
        <th>社会</th>
        <th>理科</th>
        <th>英語</th>
        <th>合計</th>
      </tr>
          <%
          int test_count = 0;
          for(test_count=0; test_count < name_list.size(); test_count++){
          %>
          <tr>
            <td>
            <%= name_list.get(test_count)%>
            </td>
            <td>
            <%= ja_list.get(test_count) %>
            </td>
            <td>
            <%= mo_list.get(test_count) %>
            </td>
            <td>
            <%= so_list.get(test_count) %>
            </td>
            <td>
            <%= sc_list.get(test_count) %>
            </td>
            <td>
            <%= en_list.get(test_count) %>
            </td>
            <td>
            <% if(sum_list.get(test_count) == max_sum){ %>
              <font color = "red">
              <%= max_sum %>
              </font>
             <%}else{ %>
             <%=sum_list.get(test_count) %>
             <%}; %>
          </tr>
          <%};%>
    </table>
  </body>
</html>