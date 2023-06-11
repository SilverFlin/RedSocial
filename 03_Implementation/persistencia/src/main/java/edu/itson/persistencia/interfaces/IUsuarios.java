/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.itson.persistencia.interfaces;
import edu.itson.dominio.Usuario;
import java.util.List;

/**
 *
 * @author luis-
 */
public interface IUsuarios {
    public Usuario agregarUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public Usuario eliminarUsuario(Usuario usuario);
    public Usuario buscarPorID(Object id);
    public List<Usuario>buscarTodos();
 
}
