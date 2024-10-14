<%-- 
    Document   : productos
    Created on : 12 oct 2024, 21:34:14
    Author     : Miguel Martinez <mmartinezdev.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<jsp:include page="../header.jsp"/>
<jsp:include page="../menu/navbar.jsp"/>

<div class="container mt-4">
    <div class="text-end mb-3">
        <c:if test="${fn:contains(sessionScope.permisos, 'Agregar nuevos productos')}">
            <a href="agregarProducto" class="btn btn-secondary">
                <i class="fas fa-plus"></i> Agregar Producto
            </a>
        </c:if>
        <c:if test="${fn:contains(sessionScope.permisos, 'Ver módulo del histórico')}">
            <a href="movimientos" class="btn btn-success">
                <i class="fas fa-book"></i> Historial de Movimientos
            </a>
        </c:if>
    </div>

    <!-- Card para la tabla -->
    <div class="card">
        <div class="card-header">
            <h5 class="mb-0">Lista de Productos</h5>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table id="productosTable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Cantidad</th>
                            <th>Estatus</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.id}</td>
                                <td>${producto.nombre}</td>
                                <td>${producto.descripcion}</td>
                                <td>${producto.cantidad}</td>
                                <td>${producto.estatus}</td>
                                <td>
                                    <div class="btn-group" role="group">
                                        <c:if test="${fn:contains(sessionScope.permisos, 'Aumentar inventario')}">
                                            <form action="${pageContext.request.contextPath}/editarInventario" method="get" class="d-inline">
                                                <input type="hidden" name="id" value="${producto.id}">
                                                <button type="submit" class="btn btn-warning btn-sm" title="Actualizar Inventario">
                                                    <i class="fas fa-edit"></i>
                                                </button>
                                            </form>
                                        </c:if>
                                        <c:if test="${fn:contains(sessionScope.permisos, 'Ver módulo para Salida de productos')}">
                                            <form action="${pageContext.request.contextPath}/editarSalidaInventario" method="get" class="d-inline">
                                                <input type="hidden" name="id" value="${producto.id}">
                                                <button type="submit" class="btn btn-info btn-sm" title="Registrar Salida">
                                                    <i class="fas fa-sign-out-alt"></i>
                                                </button>
                                            </form>
                                        </c:if>
                                        <c:if test="${fn:contains(sessionScope.permisos, 'Dar de baja/reactivar un producto')}">
                                            <form action="${pageContext.request.contextPath}/actualizarEstatus" method="post" class="d-inline">
                                                <input type="hidden" name="id" value="${producto.id}">
                                                <input type="hidden" name="estatus" value="${producto.estatus == 'activo' ? 'inactivo' : 'activo'}">
                                                <button type="submit" class="btn ${producto.estatus == 'activo' ? 'btn-danger' : 'btn-success'} btn-sm" title="${producto.estatus == 'activo' ? 'Dar Baja' : 'Dar Alta'}">
                                                    <i class="${producto.estatus == 'activo' ? 'fas fa-times' : 'fas fa-check'}"></i>
                                                </button>
                                            </form>
                                        </c:if>
                                    </div>
                                </td>
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
        $('#productosTable').DataTable({
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