/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.persistencia.implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.itson.dominio.Post;
import edu.itson.persistencia.interfaces.IPostDAO;
import interfaces.IConectionDB;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author gerar
 */
public class PostsDAO implements IPostDAO {

    public final IConectionDB connectionDB;

    public PostsDAO(IConectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Post agregar(Post newPost) {
        try {
            if (newPost != null) {
                MongoDatabase database = connectionDB.crearConexion();
                MongoCollection<Post> coleccion = database.getCollection("comentarios", Post.class);
                coleccion.insertOne(newPost);
            }
        } catch (Exception ex) {
            Logger.getLogger(PostsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newPost;
    }

    @Override
    public Post eliminar(Post deletedPost) {
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Post> coleccion = database.getCollection("posts", Post.class);
            Document filtros = new Document();
            filtros.append("_id", deletedPost.getId());
            coleccion.deleteOne(filtros);
        } catch (Exception ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deletedPost;
    }

    @Override
    public Post actualizar(Post newpost) {
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Post> coleccion = database.getCollection("posts", Post.class);
            Document filtroActualizacion = new Document("_id", newpost.getId());
            Document cambiosARealizar = new Document();
            cambiosARealizar.append("$set", new Document()
                    .append("contenido", newpost.getContenido())
                    .append("creador", newpost.getCreador())
                    .append("fechaHoraCreacion", newpost.getFechaHoraCreacion())
                    .append("tipopost", newpost.getTipoPost())
                    .append("titulo", newpost.getTitulo()));
        } catch (Exception ex) {
            Logger.getLogger(IPostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newpost;
    }

    @Override
    public Post buscarID(String id) {
        Post exPost = null;
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Post> coleccion = database.getCollection("posts", Post.class);
            Document filtros = new Document();
            filtros.append("id", id);
            FindIterable<Post> comentarios = coleccion.find(filtros);
            exPost = comentarios.first();
            return exPost;
        } catch (Exception ex) {
            Logger.getLogger(PostsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exPost;
    }

    @Override
    public List<Post> buscarTodos() {
        List<Post> listaPosts = null;
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Post> coleccion = database.getCollection("Posts", Post.class);
            listaPosts = new LinkedList<>();
            return coleccion.find().into(listaPosts);
        } catch (Exception ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPosts;
    }

}
