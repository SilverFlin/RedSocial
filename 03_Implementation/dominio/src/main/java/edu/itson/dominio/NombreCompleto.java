package edu.itson.dominio;

/**
 *
 */
public class NombreCompleto {

    /**
     * Nombres de la persona.
     */
    private String nombres;
    /**
     * Apellido Paterno.
     */
    private String apellidoPaterno;
    /**
     * Apellido Materno.
     */
    private String apellidoMaterno;

    /**
     * Constructor vacio.
     */
    public NombreCompleto() {
        // No hace falta hacer nada.
    }
    
    /**
     * Contructor del nombre completo
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno 
     */
    public NombreCompleto(String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    
    /**
     * Obtiene los nombres de la persona.
     *
     * @return nombres de la persona
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres de la persona.
     *
     * @param nombres
     */
    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno.
     *
     * @return el apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno.
     *
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(final String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno.
     *
     * @return apellido materno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno.
     *
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(final String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

}
