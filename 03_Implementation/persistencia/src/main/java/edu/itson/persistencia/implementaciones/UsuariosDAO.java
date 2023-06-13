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
import edu.itson.dominio.Direccion;
import edu.itson.dominio.GeneroUsuario;
import edu.itson.dominio.Imagen;
import edu.itson.dominio.NombreCompleto;
import edu.itson.dominio.TipoUsuario;
import edu.itson.dominio.Usuario;
import edu.itson.persistencia.interfaces.IUsuarios;
import edu.itson.dominio.Usuario;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

/**
 *
 * @author luis-
 */
public class UsuariosDAO implements IUsuarios {

    MongoClient mc = new MongoClient("localHost", 27017);

    private MongoCollection<Document> usuariosCollection;

    // Constructor que recibe la conexión a la base de datos
    public UsuariosDAO(MongoDatabase database) {
        usuariosCollection = database.getCollection("Usuarios");
    }
    @Override
    public Usuario agregar(Usuario usuario) {
        try {
            Document d = new Document("nombreCompleto", new Document()
                    .append("nombres", usuario.getNombreCompleto().getNombres())
                    .append("apellidoPaternos", usuario.getNombreCompleto().getApellidoPaterno())
                    .append("apellidoMaterno", usuario.getNombreCompleto().getApellidoMaterno()))
                    .append("password", usuario.getPassword())
                    .append("telefono", usuario.getTelefono())
                    .append("avatar", new Document()
                            .append("nombreImagen", usuario.getAvatar().getFileName())
                            .append("data", usuario.getAvatar().getImageData()))
                    .append("fechaNacimiento", usuario.getFechaNacimiento())
                    .append("genero", usuario.getGenero())
                    .append("direccion", new Document()
                            .append("ciudad", usuario.getDireccion().getCiudad())
                            .append("municipio", usuario.getDireccion().getMunicipio())
                            .append("estado", usuario.getDireccion().getEstado()))
                    .append("tipoUsuario", usuario.getTipoUsuario());
            usuariosCollection.insertOne(d);
        } catch (Exception e) {
            throw new RuntimeException("Error. No es posible agregar el usuario" + e.getMessage(), e);
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
       Object id = usuario.getId();
        try {
            Document filtro = new Document("_id", id);
            Document update = new Document("$set", new Document("nombreCompleto", new Document()
                    .append("nombres", usuario.getNombreCompleto().getNombres())
                    .append("apellidoPaternos", usuario.getNombreCompleto().getApellidoPaterno())
                    .append("apellidoMaterno", usuario.getNombreCompleto().getApellidoMaterno()))
                    .append("password", usuario.getPassword())
                    .append("telefono", usuario.getTelefono())
                    .append("avatar", new Document()
                            .append("nombreImagen", usuario.getAvatar().getFileName())
                            .append("data", usuario.getAvatar().getImageData()))
                    .append("fechaNacimiento", usuario.getFechaNacimiento())
                    .append("genero", usuario.getGenero())
                    .append("direccion", new Document()
                            .append("ciudad", usuario.getDireccion().getCiudad())
                            .append("municipio", usuario.getDireccion().getMunicipio())
                            .append("estado", usuario.getDireccion().getEstado()))
                    .append("tipoUsuario", usuario.getTipoUsuario()));

            usuariosCollection.updateOne(filtro, update);
        } catch (Exception e) {
            throw new RuntimeException("Error. No es posible actualizar el usuario" + e.getMessage(), e);
        }

        return usuario;
    }

    @Override
    public Usuario buscarID(String id) {
        try {
            Document filtro = new Document("_id", id);
            Document documentoUsuario = usuariosCollection.find(filtro).first();

            if (documentoUsuario != null) {
                // Convierte el documento de MongoDB a un objeto Usuario
                Usuario usuario = new Usuario();
                usuario.setId(documentoUsuario.getObjectId("_id"));
                usuario.setNombreCompleto(new NombreCompleto(
                        documentoUsuario.get("nombreCompleto", Document.class).getString("nombres"),
                        documentoUsuario.get("nombreCompleto", Document.class).getString("apellidoPaterno"),
                        documentoUsuario.get("nombreCompleto", Document.class).getString("apellidoMaterno")
                ));
                usuario.setPassword(documentoUsuario.getString("password"));
                usuario.setTelefono(documentoUsuario.getString("telefono"));
                usuario.setAvatar(new Imagen(
                        documentoUsuario.get("avatar", Document.class).getString("nombreImagen"),
                        documentoUsuario.get("avatar", Document.class).get("data", Binary.class)
                ));

                Date fechaNacimiento = documentoUsuario.getDate("fechaNacimiento");
                Instant instant = fechaNacimiento.toInstant();
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                usuario.setFechaNacimiento(localDateTime);

                String genero = documentoUsuario.getString("genero");
                GeneroUsuario generoUsuario = GeneroUsuario.valueOf(genero);
                usuario.setGenero(generoUsuario);

                usuario.setDireccion(new Direccion(
                        documentoUsuario.get("direccion", Document.class).getString("ciudad"),
                        documentoUsuario.get("direccion", Document.class).getString("municipio"),
                        documentoUsuario.get("direccion", Document.class).getString("estado")
                ));
                String tipoUsuario = documentoUsuario.getString("tipoUsuario");
                TipoUsuario tipoUsuarioEnum = TipoUsuario.valueOf(tipoUsuario);
                usuario.setTipoUsuario(tipoUsuarioEnum);

                return usuario;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar usuario por ID: " + e.getMessage(), e);
        }

        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            FindIterable<Document> documentosUsuarios = usuariosCollection.find();
            for (Document documentoUsuario : documentosUsuarios) {
                Usuario usuario = new Usuario();
                usuario.setId(documentoUsuario.getObjectId("_id"));
                usuario.setNombreCompleto(new NombreCompleto(
                        documentoUsuario.get("nombreCompleto", Document.class).getString("nombres"),
                        documentoUsuario.get("nombreCompleto", Document.class).getString("apellidoPaterno"),
                        documentoUsuario.get("nombreCompleto", Document.class).getString("apellidoMaterno")
                ));
                usuario.setPassword(documentoUsuario.getString("password"));
                usuario.setTelefono(documentoUsuario.getString("telefono"));
                usuario.setAvatar(new Imagen(
                        documentoUsuario.get("avatar", Document.class).getString("nombreImagen"),
                        documentoUsuario.get("avatar", Document.class).get("data", Binary.class)
                ));
                Date fechaNacimiento = documentoUsuario.getDate("fechaNacimiento");
                Instant instant = fechaNacimiento.toInstant();
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                usuario.setFechaNacimiento(localDateTime);

                String genero = documentoUsuario.getString("genero");
                GeneroUsuario generoUsuario = GeneroUsuario.valueOf(genero);
                usuario.setGenero(generoUsuario);

                usuario.setDireccion(new Direccion(
                        documentoUsuario.get("direccion", Document.class).getString("ciudad"),
                        documentoUsuario.get("direccion", Document.class).getString("municipio"),
                        documentoUsuario.get("direccion", Document.class).getString("estado")
                ));
                String tipoUsuario = documentoUsuario.getString("tipoUsuario");
                TipoUsuario tipoUsuarioEnum = TipoUsuario.valueOf(tipoUsuario);
                usuario.setTipoUsuario(tipoUsuarioEnum);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar todos los usuarios: " + e.getMessage(), e);
        }

        return usuarios;
    }

}
