/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.persistencia.implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import edu.itson.dominio.Post;
import edu.itson.persistencia.interfaces.IPostDAO;
import interfaces.IConectionDB;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

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
                MongoCollection<Post> coleccion = database.getCollection("posts", Post.class);
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
            Document filtroActualizacion = new Document("_id", new ObjectId(newpost.getId().toString()));
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
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Post> coleccion = database.getCollection("posts", Post.class);
            Post post = coleccion.find(new Document("_id", new ObjectId(id))).first();
            return post;
        } catch (Exception ex) {
            Logger.getLogger(PostsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Post> buscarTodos() {
        List<Post> listaPosts = null;
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Post> coleccion = database.getCollection("posts", Post.class);
            MongoCursor<Post> resultadoConsulta = coleccion.find().iterator();
            ArrayList<Post> listaP = new ArrayList<>();
            while (resultadoConsulta.hasNext()) {
                listaP.add(resultadoConsulta.next());
            }
            List<Post> lista = listaP;
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPosts;
    }

}
