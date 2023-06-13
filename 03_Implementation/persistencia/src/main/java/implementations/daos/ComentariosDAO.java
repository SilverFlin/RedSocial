/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.persistencia.implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.itson.dominio.Comentario;
import edu.itson.persistencia.interfaces.IComentarios;
import interfaces.IConectionDB;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author MoonA
 */
public class ComentariosDAO implements IComentarios {

    public final IConectionDB connectionDB;

    public ComentariosDAO(IConectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Comentario agregar(Comentario t) {
        try {
            if (t != null) {
                MongoDatabase database = connectionDB.crearConexion();
                MongoCollection<Comentario> coleccion = database.getCollection("comentarios", Comentario.class);
                coleccion.insertOne(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Comentario eliminar(Comentario t) {
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Comentario> coleccion = database.getCollection("usuarios", Comentario.class);
            Document filtros = new Document();
            filtros.append("_id", t.getUsuario().getId());
            coleccion.deleteOne(filtros);
        } catch (Exception ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Comentario actualizar(Comentario t) {
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Comentario> coleccion = database.getCollection("comentarios", Comentario.class);
            Document filtroActualizacion = new Document("_id", t.getUsuario().getId());
            Document cambiosARealizar = new Document();
            cambiosARealizar.append("$set", new Document()
                    .append("usuario", t.getUsuario())
                    .append("objetivo", t.getObjetivo())
                    .append("fechaHoraCreacion", t.getFechaHoraCreacion())
                    .append("contenido", t.getContenido()));
        } catch (Exception ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Comentario buscarID(String id) {
        Comentario comentario = null;
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Comentario> coleccion = database.getCollection("comentarios", Comentario.class);
            Document filtros = new Document();
            filtros.append("_id", id);
            FindIterable<Comentario> comentarios = coleccion.find(filtros);
            comentario = comentarios.first();
            return comentario;
        } catch (Exception ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentario;
    }

    @Override
    public List<Comentario> buscarTodos() {
        List<Comentario> listacomentario = null;
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Comentario> coleccion = database.getCollection("comentarios", Comentario.class);
            listacomentario = new LinkedList<>();
            return coleccion.find().into(listacomentario);
        } catch (Exception ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listacomentario;
    }

}
