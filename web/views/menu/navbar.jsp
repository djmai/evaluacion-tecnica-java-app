<%-- 
    Document   : navbar
    Created on : 13 oct 2024, 21:47:39
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    body {
        background-color: #f8f9fa;
    }
    .navbar {
        background: linear-gradient(to right, #6a11cb, #2575fc);
    }
    .navbar-brand img {
        width: 40px; /* Ajusta el tamaño de la imagen/logo */
    }
    .icon-circle {
        width: 40px; /* Ancho del círculo */
        height: 40px; /* Alto del círculo */
        background-color: white; /* Color de fondo del círculo */
        border-radius: 50%; /* Hacer el contenedor redondo */
        display: flex; /* Centrar contenido */
        align-items: center; /* Centrar verticalmente */
        justify-content: center; /* Centrar horizontalmente */
        cursor: pointer; /* Cambia el cursor a mano al pasar por encima */
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.2); /* Sombra opcional */
    }
</style>


<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="container-fluid">
        <!-- Logotipo -->
        <a class="navbar-brand text-white" href="#">
            Logo
            <!--<img src="${pageContext.request.contextPath}/resources/logo.png" alt="Logo"-->
        </a>

        <!-- Botón para móviles -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <!-- Menú de Opciones -->
            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class="nav-link text-white active" aria-current="page" href="inicio">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="productos">Productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="usuarios">Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="contacto">Contacto</a>
                </li>
            </ul>

            <!-- Ícono Redondo de Usuario -->
            <div class="dropdown">
                <div class="icon-circle" id="dropdownUser" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-user" style="color: blue; font-size: 1.5rem;"></i> <!-- Cambié aquí -->
                </div>

                <ul class="dropdown-menu dropdown-menu-end text-center" aria-labelledby="dropdownUser">
                    <li><strong><a class="dropdown-item" href="#">${sessionScope.usuario.rol.descripcion}</a></strong></li>
                    <li><a class="dropdown-item" href="#">${sessionScope.usuario.nombre}</a></li>
                    <li><a class="dropdown-item" href="#">${sessionScope.usuario.correo}</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>