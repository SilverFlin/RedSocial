package edu.itson.dominio;

import interfaces.Comentable;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 *
 */
public class Post implements Comentable {

    /**
     * ID del Objeto.
     */
    private ObjectId id;
    /**
     * Fecha y hora de creación del post.
     */
    private LocalDateTime fechaHoraCreacion;
    /**
     * Creador del post.
     */
    private Usuario creador;
    /**
     * Título del post.
     */
    private String titulo;
    /**
     * Contenido del Post.
     */
    private ContenidoPost contenido;
    /**
     * Fecha y hora de la última edición.
     */
    private LocalDateTime fechaHoraEdicion;
    /**
     * Tipo del Post.
     */
    private TipoPost tipoPost;

    /**
     * Constructor vacío.
     *
     * @param tipoPost
     */
    public Post(final TipoPost tipoPost) {
        this.tipoPost = tipoPost;
    }

    /**
     * Constructor vacio.
     */
    public Post() {
    }

    /**
     * Obtiene la fecha y hora de creación del post.
     *
     * @return fecha y hora de creación del post.
     */
    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación del post.
     *
     * @param fechaHoraCreacion
     */
    public void setFechaHoraCreacion(final LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Obtiene el ID del Post.
     *
     * @return id del post.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del Post.
     *
     * @param id
     */
    public void setId(final ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el creador del post.
     *
     * @return creador del post.
     */
    public Usuario getCreador() {
        return creador;
    }

    /**
     * Establece el creador del post.
     *
     * @param creador
     */
    public void setCreador(final Usuario creador) {
        this.creador = creador;
    }

    /**
     * Obtiene el título del post.
     *
     * @return titulo del post.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del post.
     *
     * @param titulo
     */
    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el contenido del post.
     *
     * @return contenido del post.
     */
    public ContenidoPost getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del post.
     *
     * @param contenido
     */
    public void setContenido(final ContenidoPost contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha y hora de la última modificación.
     *
     * @return fecha y hora de la última modificación.
     */
    public LocalDateTime getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece fecha y hora de la última edición del post.
     *
     * @param fechaHoraEdicion
     */
    public void setFechaHoraEdicion(final LocalDateTime fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Obtiene el tipo de post de la publicación.
     *
     * @return tipo del post.
     */
    public TipoPost getTipoPost() {
        return tipoPost;
    }

    /**
     * Regresa un string con todos los atributos de la clase.
     *
     * @return todos los atributos de la clase en string.
     */
    @Override
    public String toString() {
        return "Post{"
                + "fechaHoraCreacion=" + fechaHoraCreacion
                + ", creador=" + creador
                + ", titulo=" + titulo
                + ", contenido=" + contenido
                + ", fechaHoraEdicion=" + fechaHoraEdicion
                + ", tipoPost=" + tipoPost + '}';
    }

}
