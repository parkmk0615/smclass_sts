<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>중고 장터</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <header>
        <h1>학교/학원 중고 장터</h1>
        <nav>
            <a href="/">홈</a>
            <a href="/sell">상품 등록</a>
            <a href="/my-items">내 상품</a>
            <a href="/chat">채팅</a>
        </nav>
    </header>
    
    <main>
        <section class="search-bar">
            <form action="/search" method="GET">
                <input type="text" name="query" placeholder="찾고 싶은 상품을 입력하세요">
                <button type="submit">검색</button>
            </form>
        </section>
        
        <section class="product-list">
            <h2>판매 중인 상품</h2>
            <ul>
                <li th:each="item : ${items}">
                    <img th:src="${item.imageUrl}" alt="상품 이미지">
                    <h3 th:text="${item.title}"></h3>
                    <p>가격: <span th:text="${item.price} + '원'"></span></p>
                    <a th:href="@{/item/{id}(id=${item.id})}">자세히 보기</a>
                </li>
            </ul>
        </section>
    </main>
</body>
</html>
