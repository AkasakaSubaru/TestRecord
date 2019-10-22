<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>新規追加画面</title>
  </head>
  <body>
    <h1>新規追加画面</h1>
    <h2>以下の項目を入力してください</h2>
    <form action="user_add" name="form" method="get">
      <ol>
        <li><p>パスワード    <input type="password" name="pw"></p></li>
        <li><p>テスト名    <input type="text" name="test_name"></p></li>
        <li><p>国語    <input type="text" name="ja_num"></p></li>
        <li><p>数学    <input type="text" name="ma_num"></p></li>
        <li><p>社会    <input type="text" name="so_num"></p></li>
        <li><p>理科    <input type="text" name="si_num"></p></li>
        <li><p>英語    <input type="text" name="en_num"></p></li>
      </ol>
      <input type="submit" value="追加">
      <input type="reset" value="リセット">
    </form>
    <% if(request.getAttribute("none") != null){ %>
    <p>id、またはパスワードが間違っています</p>
    <% }; %>
    <% if(request.getAttribute("miss") != null ){ %>
    <p>項目の追加で異常がありました。項目をもう一度確認の上、入力してください</p>
    <% }; %>
    <% if(request.getAttribute("null") != null){ %>
    <p>全ての項目を入力してください</p>
    <% }; %>
  </body>
</html>