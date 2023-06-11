/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.persistencia.implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.itson.dominio.Usuario;
import edu.itson.persistencia.interfaces.IUsuarios;
import edu.itson.dominio.Usuario;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author luis-
 */
public class UsuariosDAO implements IUsuarios {

    private MongoCollection<Document> usuariosCollection;

    // Constructor que recibe la conexión a la base de datos
    public UsuariosDAO(MongoDatabase database) {
        usuariosCollection = database.getCollection("Usuarios");
    }

    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        try{
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
        }catch(Exception e){
          throw new RuntimeException("Error. No es posible agregar el usuario" + e.getMessage(), e);
        }
        
        return usuario;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario eliminarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario buscarPorID(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
