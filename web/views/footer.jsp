<%-- 
    Document   : footer
    Created on : 13 oct 2024, 21:18:24
    Author     : Miguel Martinez <mmartinezdev.com>
--%>

<style>
    body {
        display: flex;
        flex-direction: column;
        min-height: 100vh; /* Asegura que el body ocupe al menos el 100% de la altura de la ventana */
        background-color: #6a11cb;
        background-image: linear-gradient(to right, #6a11cb, #2575fc);
    }
    .content {
        flex: 1; /* Esto permite que el contenido principal ocupe el espacio restante */
    }
    footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        height: 50px; /* Altura del footer */
        color: white; /* Color del texto */
        display: flex;
        align-items: center;
        justify-content: center; /* Centrar el contenido del footer */
        z-index: 10; /* Asegura que el footer esté encima de otros elementos */
    }
</style>

<!-- Footer -->
<footer>
    <p>&copy; 2024 MMMV. Todos los derechos reservados.</p>
</footer>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- JS de DataTables -->
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.11.6/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


<script>
    // Inicializar el tooltip
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>


</body>
</html>
