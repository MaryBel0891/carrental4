<!DOCTYPE HTML>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%--    <link rel="stylesheet"  href="../../static/test.css" type="text/css">--%>
    <style><%@include file="/resources/static/test.css"%></style>
</head>

<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-4 logo">
                <div >Car Rental</div>
            </div>
            <div class="col-4 buttons">
            </div>
            <div class="col-4 logout">
            </div>
        </div>
    </div>
</header>

<nav class="menu">
    <div class="container">
        <ul>
            <li><a href="/web/" >Main</a></li>
            <li><a href="/web/login">Login</a></li>
            <li><a href="/web/registration">SignUp</a></li>
        </ul>
    </div>
</nav>
<section class="title_with_img">
    Car Rental
</section>
<section class="descr">
    <div class="container">
        Фірма видає напрокат автомобілі.
        При цьому фіксуються дані про клієнта, дані про автомобіль, дата початку прокату і кількість днів прокату, вартість одного дня прокату.
        Вартість одного дня прокату може відрізнятися для різних автомобілів.
        Для кожного автомобіля визначається страхова вартість.
        Вартість прокату автомобіля визначається як вартість одного дня прокату x Кількість днів прокату.
        Фірма щорічно страхує автомобілі, які видаються клієнтам.
        Страховий внесок, який виплачується фірмою, дорівнює 10 відсоткам від страхової вартості автомобіля.
    </div>
</section>
<footer>
    <div class="container">
        <div class="row footer_info">
            <div class="col-4 footer-col logo">
                Car Rental
            </div>

        </div>
    </div>
</footer>
</body>
</html>