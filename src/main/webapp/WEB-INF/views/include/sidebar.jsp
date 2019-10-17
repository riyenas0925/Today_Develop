<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar" data="blue">
    <!--
      Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
  -->
    <div class="sidebar-wrapper">
        <div class="logo">
            <a href="javascript:void(0)" class="simple-text logo-mini">
                TD
            </a>
            <a href="javascript:void(0)" class="simple-text logo-normal">
                Today Develop
            </a>
        </div>
        <ul class="nav">
            <li>
                <a href="${path}/">
                    <i class="tim-icons icon-atom"></i>
                    <p>Dev Blog</p>
                </a>
            </li>

            <hr style="width: 87%; height: 0.1px; background-color: rgba(255, 255, 255, 0.5);">

            <li>
                <a href="${path}/devBlog/NaverD2">
                    <i class="tim-icons icon-book-bookmark"></i>
                    <p>Naver D2</p>
                </a>
            </li>

            <li>
                <a href="${path}/devBlog/WooWaBros">
                    <i class="tim-icons icon-book-bookmark"></i>
                    <p>우아한 형제들</p>
                </a>
            </li>

            <li>
                <a href="${path}/devBlog/Lezhin">
                    <i class="tim-icons icon-book-bookmark"></i>
                    <p>레진 코믹스</p>
                </a>
            </li>
        </ul>
    </div>
</div>