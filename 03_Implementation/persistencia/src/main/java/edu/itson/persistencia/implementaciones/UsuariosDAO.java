/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.persistencia.implementaciones;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import edu.itson.dominio.Comentario;
import edu.itson.dominio.Direccion;
import edu.itson.dominio.GeneroUsuario;
import edu.itson.dominio.Imagen;
import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
import edu.itson.persistencia.interfaces.IUsuarios;
import edu.itson.dominio.Usuario;
import interfaces.IConectionDB;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

/**
 *
 * @author luis-
 */
public class UsuariosDAO implements IUsuarios {

    private MongoCollection<Document> usuariosCollection;

    public final IConectionDB connectionDB;

    public UsuariosDAO(IConectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Usuario agregar(Usuario usuario) {
        try {
            if (usuario != null) {
                MongoDatabase database = connectionDB.crearConexion();
                MongoCollection<Usuario> usuariosCollection = database.getCollection("usuarios", Usuario.class);
                usuariosCollection.insertOne(usuario);
            }
        } catch (Exception ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public Usuario eliminar(Usuario usuario) {
        Object id = usuario.getId();
        try {
            Document filtro = new Document("_id", id);
            DeleteResult dr = usuariosCollection.deleteOne(filtro);
        } catch (Exception e) {
            throw new RuntimeException("Error. No es posible eliminar al usuario" + e.getMessage(), e);
        }
        return usuario;
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Usuario> usuariosCollection = database.getCollection("usuarios", Usuario.class);
            Document filtroActualizacion = new Document("_id", usuario.getId());
            Document cambiosARealizar = new Document();
            cambiosARealizar.append("$set", new Document()
                    .append("nombres", usuario.getNombreCompleto().getNombres())
                    .append("apellidoPaternos", usuario.getNombreCompleto().getApellidoPaterno())
                    .append("apellidoMaterno", usuario.getNombreCompleto().getApellidoMaterno()));
//                    .append("password", usuario.getPassword())
//                    .append("telefono", usuario.getTelefono())
//                    .append("avatar", new Document()
//                            .append("nombreImagen", usuario.getAvatar().getFileName())
//                            .append("data", usuario.getAvatar().getImageData()))
//                    .append("fechaNacimiento", usuario.getFechaNacimiento())
//                    .append("genero", usuario.getGenero())
//                    .append("direccion", new Document()
//                            .append("ciudad", usuario.getDireccion().getCiudad())
//                            .append("municipio", usuario.getDireccion().getMunicipio())
//                            .append("estado", usuario.getDireccion().getEstado()))
//                    .append("tipoUsuario", usuario.getTipoUsuario());
            usuariosCollection.updateOne(filtroActualizacion, cambiosARealizar);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public Usuario buscarID(String id) {
        Usuario usuario = null;
        try {
            ObjectId objectId = new ObjectId(id);
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Usuario> coleccion = database.getCollection("usuarios", Usuario.class);
            Document filtros = new Document();
            filtros.append("_id", objectId); 
            FindIterable<Usuario> usuarios = coleccion.find(filtros);
            usuario = usuarios.first();
            return usuario;
        } catch (Exception ex) {
            Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = null;
        try {
            MongoDatabase database = connectionDB.crearConexion();
            MongoCollection<Usuario> coleccion = database.getCollection("usuarios", Usuario.class);
            usuarios = new LinkedList<>();
            return coleccion.find().into(usuarios);
        } catch (Exception ex) {
            Logger.getLogger(Comentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
