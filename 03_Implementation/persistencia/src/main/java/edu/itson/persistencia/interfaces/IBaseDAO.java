/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.itson.persistencia.interfaces;

import java.util.List;

/**
 *
 * @author luis-
 */
public interface IBaseDAO<T> {
    
    public T agregar(T t);
    public T eliminar(T t);
    public T actualizar(T t);
    public T buscarID(String id);
    public List<T> buscarTodos();
    
}
