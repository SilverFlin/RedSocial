/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.mongodb.client.MongoDatabase;


/**
 *
 * @author MoonA
 */
public interface IConectionDB {
    /**
     * Método que permite crear una conexión a la BD
     * @return objeto MongoDataBase con la conexión a la BD
     * @throws Exception laza excepción en caso de que haya habido algún problema
     */
    public MongoDatabase crearConexion() throws Exception;
}
