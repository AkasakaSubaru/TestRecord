<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ログイン</title>
  </head>
  <body>
    <h1>テストの記録表</h1>
    <h2>ログイン画面</h2>
    <!-- form入力欄開始 -->
    <form action="login" name="form" method="post">
      <p>id  <input type="text" name="id"></p>
      <br/>
      <p>password  <input type="password" name="pass"></p>
      <input type="submit" value="ログイン">
    </form>
    <!-- form入力欄終了 -->
    <%if( request.getAttribute("false") != null){ %>
      <p>データベースの接続に失敗しました</p>
    <%}; %>
    <% if(request.getAttribute("none") != null){ %>
      <p>ログインに失敗しました</p>
    <% }; %>
    <a href="new_ac.jsp">新規登録</a>
    <br>
    <a href="new_ts.jsp">テストを追加する</a>
  </body>
</html>