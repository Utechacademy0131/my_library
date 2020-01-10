<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>本の検索ページ</h2>

        <form method="POST" action="<c:url value='/books/search' />">
           <label for="content">検索用語</label><br />
           <textarea name="content" rows="5" cols="50">${book.content}</textarea>
           <br /><br />
        </form>

        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">検索</button>

        <p><a href="<c:url value='/books/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>