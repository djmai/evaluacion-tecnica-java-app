<%-- 
    Document   : altaUsuario
    Created on : 13 oct 2024, 00:55:18
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../menu/navbar.jsp"/>

<style>
    h1, h2 {
        color: #0d6efd; /* Color del título */
    }
    .card {
        border-radius: 15px; /* Bordes redondeados para el card */
    }
    .error-message {
        color: red; /* Color para mensajes de error */
    }
</style>

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header text-center">
            <h1>Alta de Usuario</h1>
        </div>
        <div class="card-body">
            <c:if test="${not empty errorMessage}">
                <div class="mt-3 error-message">${errorMessage}</div>
            </c:if>

            <form action="${pageContext.request.contextPath}/altaUsuario" method="post">

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input type="text" class="form-control" name="nombre" required>
                </div>

                <div class="mb-3">
                    <label for="correo" class="form-label">Correo:</label>
                    <input type="email" class="form-control" name="correo" required>
                </div>

                <div class="mb-3">
                    <label for="contrasena" class="form-label">Contraseña:</label>
                    <input type="password" class="form-control" name="contrasena" required>
                </div>

                <div class="mb-3">
                    <label for="rol" class="form-label">Rol:</label>
                    <select name="rol" class="form-select" required>
                        <option value="1">Administrador</option>
                        <option value="2">Almacenista</option>
                    </select>
                </div>

                <div class="d-flex justify-content-end mt-3">
                    <button type="submit" class="btn btn-primary">Registrar Usuario</button>
                    <a href="${pageContext.request.contextPath}/usuarios" class="btn btn-secondary">Cancelar</a>
                </div>
            </form>

        </div>
    </div>
</div>

<jsp:include page="../footer.jsp"/>