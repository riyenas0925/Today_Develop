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
                <div class="row" id="cards">
                </div>
            </div>
            <%@ include file="include/footer.jsp" %>
        </div>
    </div>

<%@ include file="include/plugins.jsp" %>
</body>
</html>


<script language="JavaScript">
    $(document).ready(function () {
        getAllList();
        
        function getAllList() {
            $.getJSON("devBlog/random", function (data) {
                var str = "";
                $(data).each(
                    function () {
                        str += '<div class="col-lg-4">'
                        str +=     '<div class="card">'
                        str +=         '<div class="' + this.cardColor + '" style="border-top: 5px solid;">';
                        str +=             '<div class="card-header">';
                        str +=                 '<h3 class="card-title">';
                        str +=                     '<a href="' + this.cardUrl +'" target="_blank" rel="noopener">'
                        str +=                         this.cardTitle
                        str +=                     '</a>';
                        str +=                 '</h3>';
                        str +=                 '<h5 class="card-category">';
                        str +=                     '<i class="tim-icons icon-bell-55 text-primary"></i>';
                        str +=                      this.cardCategory;
                        str +=                 '</h5>';
                        str +=             '</div>';
                        str +=             '<div class="card-body">';
                        str +=                 '<a>' + this.cardContent +'</a>';
                        str +=             '</div>';
                        str +=             '<div class="card-footer text-muted">';
                        str +=                 '<a>' + this.cardDate +'</a>';
                        str +=             '</div>';
                        str +=         '</div>';
                        str +=     '</div>';
                        str += '</div>';
                    });
                $("#cards").html(str);
            }).fail(function (result) {
                window.location.replace("/devBlog/init");
            });
        }
    });
</script>