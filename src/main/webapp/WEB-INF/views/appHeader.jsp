<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-between">
        <a href="/" class="navbar-brand main-logo main-logo-smaller">
            Zaplanuj <span>Jedzonko</span>
        </a>
        <div class="d-flex justify-content-around">
            <h4 class="text-light mr-3">${email}</h4>
            <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>

            <div style="margin-left: 5px">
                <a href="/logout" class="btn btn-danger">Wyloguj</a>
            </div>


        </div>
    </nav>
</header>