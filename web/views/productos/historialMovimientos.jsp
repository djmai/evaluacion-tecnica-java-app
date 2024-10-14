<%-- 
    Document   : historialMovimientos
    Created on : 13 oct 2024, 00:16:20
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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
    .table th, .table td {
        vertical-align: middle; /* Centrar verticalmente */
    }
</style>

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header text-center">
            <h5 class="highlighted-title">Historial de Movimientos</h5>
        </div>
        <div class="card-body">

            <div class="table-responsive">

                <form action="${pageContext.request.contextPath}/movimientos" method="get" class="mb-4">
                    <div class="input-group mb-3">
                        <label for="tipoMovimiento" class="input-group-text">Filtrar por Tipo de Movimiento:</label>
                        <select id="tipoMovimiento" name="tipo_movimiento" class="form-select">
                            <option value="">Todos</option>
                            <option value="ENTRADA" ${param.tipoMovimiento == 'ENTRADA' ? 'selected' : ''}>Entrada</option>
                            <option value="SALIDA" ${param.tipoMovimiento == 'SALIDA' ? 'selected' : ''}>Salida</option>
                        </select>
                        <button type="submit" class="btn btn-primary">Filtrar</button>
                    </div>
                </form>

                <table id="movimientosTable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Producto</th>
                            <th>Tipo de Movimiento</th>
                            <th>Cantidad</th>
                            <th>Usuario</th>
                            <th>Fecha y Hora</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="movimiento" items="${listaMovimientos}">
                            <tr>
                                <td>${movimiento.id}</td>
                                <td>${movimiento.descripcionProducto}</td>
                                <td>${movimiento.tipoMovimiento}</td>
                                <td>${movimiento.cantidad}</td>
                                <td>${movimiento.nombreUsuario}</td>
                                <td><fmt:formatDate value="${movimiento.fechaHora}" pattern="dd/MM/yyyy HH:mm"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer.jsp"/>

<script>
    $(document).ready(function () {
        $('#movimientosTable').DataTable({
            "pageLength": 10, // Cambia este número para mostrar más o menos filas
            "lengthMenu": [5, 10, 25, 50, 100], // Opciones de número de filas a mostrar
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros disponibles",
                "infoFiltered": "(filtrado de _MAX_ total de registros)",
                "search": "Buscar:",
                "paginate": {
                    "first": "Primero",
                    "last": "Último",
                    "next": "Siguiente",
                    "previous": "Anterior"
                }
            }
        });
    });
</script>