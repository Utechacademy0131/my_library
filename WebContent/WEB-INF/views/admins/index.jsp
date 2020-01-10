<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>管理者　一覧</h2>
        <table id="admin_list">
            <tbody>
                <tr>
                    <th>氏名</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="admin" items="${admins}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${admin.name}" /></td>
                        <td>
                          <c:choose>
                                <c:when test="${admin.delete_flag == 1}">
                                    （削除済み）
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/admins/show?id=${admin.id}' />">詳細を表示</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${admins_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((admins_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/admins/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/admins/new'  />">新規管理者の登録</a></p>
        <p><a href="<c:url value='/books/index'  />">本の一覧に戻る</a></p>

    </c:param>
</c:import>