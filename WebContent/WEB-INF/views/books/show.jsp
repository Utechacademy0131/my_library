<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${book != null}">
                <h2>本の詳細ページ</h2>
                <table>
                    <tbody>
                        <tr>
                            <th>タイトル</th>
                            <td><c:out value="${book.title}" /></td>
                        </tr>
                        <tr>
                            <th>著者名</th>
                            <td><c:out value="${book.writer}" /></td>
                        </tr>
                        <tr>
                            <th>出版社</th>
                            <td><c:out value="${book.publisher}" /></td>
                        </tr>
                        <tr>
                            <th>内容</th>
                            <td>
                                <pre><c:out value="${book.content}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${book.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${book.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h2>お探しの本は見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/books/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>