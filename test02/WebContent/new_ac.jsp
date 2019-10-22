<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>新規登録画面</title>
  </head>
  <body>
    <h1>新規登録画面</h1>
    <h2>以下の項目を入力して新規登録をしてください</h2>
    <form action="new_ac" name="ac_form" method="post">
      <ol>
        <li><p>名前    <input type="text" name="new_name"></p></li>
        <li><p>ログインid    <input type="text" name="new_id"></p></li>
        <li><p>パスワード    <input type="password" name="new_pw"></p></li>
        <li><p>パスワード（確認用）    <input type="password" name="ag_new_pw"></p></li>
      </ol>
      <input type="reset" value="リセット">
      <input type="submit" value="新規登録">
      <p>idとパスワードを入力する際には、以下のことに気をつけてください</p>
      <ul>
        <li><p>idまたはパスワード、名前がデータベース内で重複していると登録できません。ユニークな値にしてください</p></li>
        <li><p>id、パスワード、名前は全て半角にしてください</p></li>
      </ul>
      <% if(request.getAttribute("error") != null){ %>
      <p>システムの動作中にエラーが発生しました。パスワードがあってるか、空白がないかなどを確認し、再度試してください</p>
      <% }; %>
    </form>
  </body>
</html>