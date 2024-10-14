<%-- 
    Document   : acerca
    Created on : 14 oct 2024, 00:26:41
    Author     : Miguel Martinez <mmartinezdev.com>
--%>


<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../menu/navbar.jsp"/>

<style>
    body {
        background-color: #f8f9fa; /* Color de fondo */
    }
    .card {
        border-radius: 15px; /* Bordes redondeados */
    }
    h1 {
        color: #0d6efd; /* Color del título */
    }
    .social-icons a {
        margin: 0 10px; /* Espaciado entre íconos */
        color: #0d6efd; /* Color de los íconos */
        font-size: 1.5rem; /* Tamaño de los íconos */
    }
</style>


<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header text-center">
            <h1>Acerca de Mí</h1>
        </div>
        <div class="card-body text-center">
            <h3>Datos Personales</h3>
            <br>
            <p><strong>Nombre:</strong> Miguel Manuel Martínez Vázquez</p>
            <p><strong>Correo Electrónico:</strong> miguel.martinez88@outlook.es</p>
            <p><strong>Celular:</strong> 472 104 8426</p>

            <br>
            <p>
                <a href="https://mmartinezdev.com" target="_blank"><i class="fa-solid fa-globe"></i></a>
            </p>
            <div class="social-icons">
                <h4>Sígueme en Redes Sociales</h4>
                <div class="social-icons">
                    <a href="https://linktr.ee/eltresm" target="_blank"><i class="fa-solid fa-square-share-nodes"></i></a> 
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer.jsp"/>