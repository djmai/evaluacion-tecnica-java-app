<%-- 
    Document   : salidaInventario
    Created on : 12 oct 2024, 23:19:55
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../menu/navbar.jsp"/>

<style>
    body {
        background-color: #f1f3f5; /* Color de fondo suave */
    }
    .highlighted-title {
        color: #0d6efd; /* Color del título */
    }
    .card {
        border-radius: 15px; /* Bordes redondeados para el card */
    }
    .form-control {
        border-radius: 10px; /* Bordes redondeados para los campos */
    }
    .btn-primary {
        border-radius: 10px; /* Bordes redondeados para el botón */
        background-color: #0d6efd; /* Color del botón */
        border: none; /* Sin borde */
    }
    .alert {
        border-radius: 10px; /* Bordes redondeados para la alerta */
    }
    .card-header {
        background-color: #e9ecef; /* Color de fondo del header */
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
    }
</style>

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header text-center">
            <h5 class="highlighted-title">Salida de Inventario</h5>
        </div>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">
                ${errorMessage}
            </div>
        </c:if>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/actualizarSalidaInventario" method="post">
                <input type="hidden" name="id" value="${producto.id}">
                <input type="hidden" name="id_usuario" value="${sessionScope.usuario.id}">

                <div class="mb-3">
                    <label for="nombre_producto" class="form-label">Producto:</label>
                    <input type="text" class="form-control" id="nombre_producto" name="nombre_producto" value="${producto.nombre}" readonly>
                </div>

                <div class="mb-3">
                    <label for="cantidad_actual" class="form-label">Cantidad Actual:</label>
                    <input type="number" class="form-control" id="cantidad_actual" name="cantidad_actual" value="${producto.cantidad}" readonly>
                </div>

                <div class="mb-3">
                    <label for="cantidad_salida" class="form-label">Cantidad a Sacar:</label>
                    <input type="number" class="form-control" id="cantidad_salida" name="cantidad_salida" required>
                </div>

                <div class="d-flex justify-content-end mt-3">
                    <button type="submit" class="btn btn-primary me-2">Registrar Salida</button>
                    <a href="${pageContext.request.contextPath}/productos" class="btn btn-secondary">Cancelar</a>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../footer.jsp"/>

