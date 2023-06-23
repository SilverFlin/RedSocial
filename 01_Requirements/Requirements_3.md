# Requirements 3

**Implementar las siguientes funcionalidades de su proyecto final:**
- Registro de usuarios (con todo y subida de archivo de avatar),
- login,
- ver publicaciones (junto con comentarios) para todo público,
- y ver publicaciones para administradores (puede ser en una tabla o en el mismo muro de publicaciones global con las opciones de administrador, mostrando fecha de publicación, y nombre de usuario autor).

**Se debe contemplar lo siguiente:**

- Toda la funcionalidad debe ser implementada usando el patrón MVC
- Los datos deben obtener y persistir en una base de datos.
- Se debe usar el componente de acceso a datos que se les pidió en el 1er avance, es decir que se espera que se entreguen 3 proyectos de netbeans: el de web, el de acceso a datos y el de entidades de dominio (objetos negocio).
- No se debe poder ingresar a la página o servlet de publicaciones del administrador sin antes haberse autenticado.
- Al autenticarse, siempre debe saberse que usuario está autenticado sugerencia: que se vea el nombre del usuario en alguna parte de la cabecera de la aplicación.
- Debe evitarse el ataque XSS.
- No deben usarse scriptlets, utilizar en su lugar EL y JSTL.
- No se permite el uso de Ajax (todavía).
- Debe configurarse al menos 2 páginas de error: una que reaccione a códigos HTTP y la otra a alguna excepción de Java.
- Deben usarse fragmentos de JSP.


Además, se debe entregar un diagrama de componentes de UML de la solución, así como un video breve donde se demuestre la funcionalidad de la aplicación.