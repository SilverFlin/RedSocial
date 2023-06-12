package edu.itson.dominio;

import java.time.LocalDateTime;

/**
 *
 */
public class Usuario {

    /**
     * ID del usuario
     */
    private Object id;
    /**
     * Nombre completo del usuario.
     */
    private NombreCompleto nombreCompleto;
    /**
     * Constraseña del usuario.
     */
    private String password;
    /**
     * Teléfono del usuario.
     */
    private String telefono;
    /**
     * Avatar del usuario.
     */
    private Imagen avatar;
    /**
     * Fecha de nacimiento del usuario.
     */
    private LocalDateTime fechaNacimiento;
    /**
     * Género del usuario.
     */
    private GeneroUsuario genero;
    /**
     * Dirección del usuario.
     */
    private Direccion direccion;
    /**
     * Tipo de usuario.
     */
    private TipoUsuario tipoUsuario;

    /**
     * Constructor vacío.
     *
     * @param tipoUsuario
     */
    public Usuario(final TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /**
     * Aqui se crea el constructor completo del usuario
     * @param id
     * @param nombreCompleto
     * @param password
     * @param telefono
     * @param avatar
     * @param fechaNacimiento
     * @param genero
     * @param direccion
     * @param tipoUsuario 
     */
    public Usuario(Object id, NombreCompleto nombreCompleto, String password, String telefono, Imagen avatar, LocalDateTime fechaNacimiento, GeneroUsuario genero, Direccion direccion, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.telefono = telefono;
        this.avatar = avatar;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
    }
    
    /**
     * Aqui es el constuctor del usuario sin id
     * @param nombreCompleto
     * @param password
     * @param telefono
     * @param avatar
     * @param fechaNacimiento
     * @param genero
     * @param direccion
     * @param tipoUsuario 
     */
    public Usuario(NombreCompleto nombreCompleto, String password, String telefono, Imagen avatar, LocalDateTime fechaNacimiento, GeneroUsuario genero, Direccion direccion, TipoUsuario tipoUsuario) {
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.telefono = telefono;
        this.avatar = avatar;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
    }
    /**
     * Construsctor por ausencia
     */
    public Usuario() {
    }
    
    /**
     * Obtiene nombre completo del usuario.
     *
     * @return nombre completo del usuario.
     */
    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto
     */
    public void setNombreCompleto(final NombreCompleto nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return el teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefono
     */
    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el avatar del usuario.
     *
     * @return el avatar del usuario.
     */
    public Imagen getAvatar() {
        return avatar;
    }

    /**
     * Establece el avatar del usuario.
     *
     * @param avatar
     */
    public void setAvatar(final Imagen avatar) {
        this.avatar = avatar;
    }

    /**
     * Obtiene la fecha de nacimiento del ususario.
     *
     * @return fecha de nacimiento del ususario.
     */
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del ususario.
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(final LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el genero del usuario.
     *
     * @return genero del usuario.
     */
    public GeneroUsuario getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero
     */
    public void setGenero(final GeneroUsuario genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección.
     *
     * @return la dirección del usuario
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Obtiene la dirección del usuario.
     *
     * @param direccion
     */
    public void setDireccion(final Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Obtiene el tipo de usuario que obtiene el cliente
     * 
     * @param tipoUsuario 
     */
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    /**
     * Obtiene el tipo de usuario.
     *
     * @return tipo de usuario.
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    /**
     * Obtiene el id
     * 
     * @return el id del usuario
     */
    public Object getId() {
        return id;
    }
    /**
     * Obtiene el id del usuario
     * 
     * @param id 
     */
    public void setId(Object id) {
        this.id = id;
    }
    
    
    
}   
