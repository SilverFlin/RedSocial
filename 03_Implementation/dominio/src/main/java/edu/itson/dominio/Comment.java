package edu.itson.dominio;

import interfaces.Comentable;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 *
 */
public class Comment implements Comentable {

    /**
     * Atributo id asignado al comentario.
     */
    private ObjectId id;
    /**
     * Usuario que realiza el comentario.
     */
    private User creador;
    /**
     * Objeto al que se le realiza el comentario.
     */
    private Comentable objetivo;
    /**
     * Hora de creación del comentario.
     */
    private LocalDateTime fechaHoraCreacion;
    /**
     * Contenido del comentario.
     */
    private CommentContent contenido;

    /**
     * Constructor vacío.
     */
    public Comment() {
        // No hace falta hacer nada.
    }

    /**
     * Obtiene le id del comentario.
     *
     * @return id del comentario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Actualiza el id del comentario.
     *
     * @param id
     */
    public void setId(final ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el creador.
     *
     * @return obtiene el creador del comentario.
     */
    public User getCreador() {
        return creador;
    }

    /**
     * actualizar el creador del comentario.
     *
     * @param creador
     */
    public void setCreador(final User creador) {
        this.creador = creador;
    }

    /**
     * Obtiene el usuario que creó el comentario.
     *
     * @return El usuario creador.
     */
    public User getUsuario() {
        return creador;
    }

    /**
     * Establece el usuario creador del comentario.
     *
     * @param creador
     */
    public void setUsuario(final User creador) {
        this.creador = creador;
    }

    /**
     * Obtiene el objetivo del comentario.
     *
     * @return Objetivo del comentario.
     */
    public Comentable getObjetivo() {
        return objetivo;
    }

    /**
     * Establece el objetivo del comentario.
     *
     * @param objetivo
     */
    public void setObjetivo(final Comentable objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Obtiene la fecha y hora de creación del comentario.
     *
     * @return fecha y hora de creación del comentario.
     */
    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y hora de creación del comentario.
     *
     * @param fechaHoraCreacion
     */
    public void setFechaHoraCreacion(final LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return contenido del comentario.
     */
    public CommentContent getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido
     */
    public void setContenido(final CommentContent contenido) {
        this.contenido = contenido;
    }

}
