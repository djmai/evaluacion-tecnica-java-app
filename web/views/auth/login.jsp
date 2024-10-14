<%-- 
    Document   : auth
    Created on : 13 oct 2024, 20:44:01
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<jsp:include page="../header.jsp"/>

<style>
    body {
        background: linear-gradient(to right, #6a11cb, #2575fc);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: 'Arial', sans-serif;
    }
    .login-container {
        background: white;
        border-radius: 1rem;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
        padding: 2rem;
        width: 100%;
        max-width: 400px;
    }
    .login-container h2 {
        margin-bottom: 1.5rem;
    }
    .btn-custom {
        background-color: #6a11cb;
        color: white;
    }
    .btn-custom:hover {
        background-color: #2575fc;
        color: white;
    }
</style>

<div class="login-container">

    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <h2 class="text-center">Iniciar Sesión</h2>
    <form action="${pageContext.request.contextPath}/" method="post">
        <div class="mb-3">
            <label for="correo" class="form-label">Nombre de Usuario</label>
            <input type="email" name="correo" class="form-control" required value="juan.perez@empresa.com">
        </div>
        <div class="mb-3">
            <label for="contrasena" class="form-label">Contraseña</label>
            <input type="password" name="contrasena" class="form-control" required value="password123">
        </div>
        <input type="submit" class="btn btn-custom w-100" value="Iniciar Sesión">
    </form>
</div>


<jsp:include page="../footer.jsp"/>