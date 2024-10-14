<%-- 
    Document   : administrarUsuarios
    Created on : 13 oct 2024, 00:47:45
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../menu/navbar.jsp"/>

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header text-center">
            <h2>Lista de Usuarios</h2>
        </div>
        <div class="card-body">

            <div class="tablet-responsive">
                <div class="mb-3 text-end">
                    <c:if test="${fn:contains(sessionScope.permisos, 'Agregar nuevos productos')}">
                        <a href="altaUsuario" class="btn btn-primary">
                            <i class="fas fa-user-plus"></i> Agregar Usuario
                        </a>
                    </c:if>
                </div>

                <table id="usuariosTable" class="table table-striped table-bordered" >
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Rol</th>
                            <th>Estatus</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}">
                            <tr>
                                <td>${usuario.id}</td>
                                <td>${usuario.nombre}</td>
                                <td>${usuario.correo}</td>
                                <td>${usuario.rol.descripcion}</td>
                                <td>${usuario.estatus}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/eliminarUsuario" method="post" class="d-inline">
                                        <input type="hidden" name="id" value="${usuario.id}">
                                        <input type="hidden" name="estatus" value="${usuario.estatus == 'activo' ? 'inactivo' : 'activo'}">
                                        <button type="submit" class="btn btn-sm ${usuario.estatus == 'activo' ? 'btn-danger' : 'btn-success'}" title="${usuario.estatus == 'activo' ? 'Dar de baja' : 'Activar'}">
                                            <i class="fas ${usuario.estatus == 'activo' ? 'fa-user-slash' : 'fa-user-check'}"></i>
                                        </button>
                                    </form>
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
        $('#usuariosTable').DataTable({
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