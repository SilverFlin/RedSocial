package edu.itson.dominio;

/**
 *
 */
public class Direccion {

    /**
     * Ciudad.
     */
    private String ciudad;
    /**
     * Municipio.
     */
    private String municipio;
    /**
     * Estado.
     */
    private String estado;

    /**
     * Constructor vacío.
     */
    public Direccion() {
        // No hace falta hacer nada.
    }
    
    /**
     * Constructor de la direccion
     * @param ciudad
     * @param municipio
     * @param estado 
     */
    public Direccion(String ciudad, String municipio, String estado) {
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.estado = estado;
    }
    
    
    
    /**
     * Obtiene la ciudad de la dirección.
     *
     * @return ciudad de la dirección.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de la dirección.
     *
     * @param ciudad
     */
    public void setCiudad(final String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el municipio de la dirección.
     *
     * @return municipio de la dirección.
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio de la dirección.
     *
     * @param municipio
     */
    public void setMunicipio(final String municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el estado de la dirección.
     *
     * @return estado de la dirección.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la dirección.
     *
     * @param estado
     */
    public void setEstado(final String estado) {
        this.estado = estado;
    }
}
