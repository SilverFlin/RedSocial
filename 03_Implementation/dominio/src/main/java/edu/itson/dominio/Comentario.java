package edu.itson.dominio;

import interfaces.Comentable;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 *
 */
public class Comentario implements Comentable {

    /**
     * Atributo id asignado al comentario.
     */
    private ObjectId id;
    /**
     * Usuario que realiza el comentario.
     */
    private Usuario creador;
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
    private ContenidoComentario contenido;

    /**
     * Constructor vacío.
     */
    public Comentario() {
        // No hace falta hacer nada.
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    /**
     * Obtiene el usuario que creó el comentario.
     *
     * @return El usuario creador.
     */
    public Usuario getUsuario() {
        return creador;
    }

    /**
     * Establece el usuario creador del comentario.
     *
     * @param creador
     */
    public void setUsuario(final Usuario creador) {
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
    public ContenidoComentario getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario.
     *
     * @param contenido
     */
    public void setContenido(final ContenidoComentario contenido) {
        this.contenido = contenido;
    }

}
