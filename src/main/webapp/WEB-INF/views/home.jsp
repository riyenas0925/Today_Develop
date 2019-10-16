<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
=========================================================
* * Black Dashboard - v1.0.1
=========================================================

* Product Page: https://www.creative-tim.com/product/black-dashboard
* Copyright 2019 Creative Tim (https://www.creative-tim.com)


* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<!DOCTYPE html>
<html lang="en">

<%@ include file="include/head.jsp" %>

    <body class="white-content">
    <div class="wrapper">

        <%@ include file="include/sidebar.jsp" %>

        <div class="main-panel">
            <%@ include file="include/navbar.jsp" %>

            <div class="content">
                <div class="row">
                    <c:forEach items="${cardList}" var="cardList">
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="<c:out value="${cardList.cardColor}"/>" style="border-top: 5px solid;">
                                    <div class="card-header">
                                        <h3 class="card-title">
                                            <a href='<c:out value="${cardList.cardUrl}"/>'>
                                                <c:out value="${cardList.cardTitle}"/>
                                            </a>
                                        </h3>
                                        <h5 class="card-category"><i class="tim-icons icon-bell-55 text-primary"></i> <c:out value="${cardList.cardCategory}"/></h5>
                                    </div>
                                    <div class="card-body">
                                        <a><c:out value="${cardList.cardContent}"/></a>
                                    </div>
                                    <div class="card-footer text-muted">
                                        <a><c:out value="${cardList.cardDate}"/></a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <%@ include file="include/footer.jsp" %>
        </div>
    </div>

<%@ include file="include/plugins.jsp" %>
</body>
</html>