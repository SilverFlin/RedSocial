package edu.itson.dominio;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 *
 */
public class User {

    /**
     * ID del usuario.
     */
    private ObjectId id;
    /**
     * Nombre completo del usuario.
     */
    private CompleteName nombreCompleto;

    /**
     * Email del usuario.
     */
    private String email;
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
    private Image avatar;
    /**
     * Fecha de nacimiento del usuario.
     */
    private LocalDateTime fechaNacimiento;
    /**
     * Género del usuario.
     */
    private UserGender genero;
    /**
     * Dirección del usuario.
     */
    private Address direccion;
    /**
     * Tipo de usuario.
     */
    private UserType tipoUsuario;

    /**
     * Constructor vacío.
     *
     * @param tipoUsuario
     */
    public User(final UserType tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Constructor vacio.
     */
    public User() {
    }

    /**
     * Obtiene nombre completo del usuario.
     *
     * @return nombre completo del usuario.
     */
    public CompleteName getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto
     */
    public void setNombreCompleto(final CompleteName nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obitene el ID.
     *
     * @return el ID del usuario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @param id
     */
    public void setId(final ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el email del usuario.
     *
     * @return emaild el usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     *
     * @param email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña encirptada del usuario.
     *
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña encriptada del usuario.
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
    public Image getAvatar() {
        return avatar;
    }

    /**
     * Establece el avatar del usuario.
     *
     * @param avatar
     */
    public void setAvatar(final Image avatar) {
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
    public UserGender getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero
     */
    public void setGenero(final UserGender genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección.
     *
     * @return la dirección del usuario
     */
    public Address getDireccion() {
        return direccion;
    }

    /**
     * Obtiene la dirección del usuario.
     *
     * @param direccion
     */
    public void setDireccion(final Address direccion) {
        this.direccion = direccion;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoUsuario
     */
    public void setTipoUsuario(final UserType tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return tipo de usuario.
     */
    public UserType getTipoUsuario() {
        return tipoUsuario;
    }

}
