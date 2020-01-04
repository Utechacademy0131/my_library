<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>本一覧</h2>
        <table id="book_list">
            <tbody>
                <tr>
                    <th class="book_title">タイトル</th>
                    <th class="book_writer">著者名</th>
                    <th class="book_publisher">出版社</th>
                    <th class="book_action">内容</th>
                    <th class="book_date">日付</th>
                    <th class="book_flag">購入状況</th>
                </tr>
                <c:forEach var="book" items="${books}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="book_title">${book.title}</td>
                        <td class="book_writer">${book.writer}</td>
                        <td class="book_publisher">${book.publisher}</td>
                        <td class="book_action"><a href="<c:url value='/books/show?id=${book.id}' />">内容を見る</a></td>
                        <td class="report_date"><fmt:formatDate value='${book.book_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="book_fiag">
                        <c:choose>
                            <c:when test="${book.book_flag == 1}">未購入</c:when>
                            <c:otherwise>購入</c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${books_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((books_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/books/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/books/new' />">新しい本の登録</a></p>

    </c:param>
</c:import>