<%-- 
    Document   : inicio
    Created on : 13 oct 2024, 20:27:58
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<jsp:include page="header.jsp"/>

<jsp:include page="menu/navbar.jsp"/>

<style>
    .hero {
            background-color: #6a11cb; /* Color de fondo */
            background-image: linear-gradient(to right, #6a11cb, #2575fc); /* Gradiente de fondo */
            color: white; /* Color del texto */
            display: flex; /* Utiliza flexbox para centrar el contenido */
            justify-content: center; /* Centra horizontalmente */
            align-items: center; /* Centra verticalmente */
            text-align: center; /* Centra el texto */
            padding: 20px; /* Añade espaciado interno */
            flex: 1; /* Permite que hero ocupe el espacio disponible */
        }
</style>

<!-- Sección de Mensaje Central -->
<div class="hero">
    <div>
        <h1>Bienvenido a Nuestra Aplicación de <br> Evaluación Técnica de CASTORES</h1>
        <p>Desarrollado en JAVA, utilizando GlassFish y MySQL</p>
    </div>
</div>

<jsp:include page="footer.jsp"/>

