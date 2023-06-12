/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.MongoException;
import implementaciones.ConectionDB;
import interfaces.IConectionDB;

/**
 *
 * @author MoonA
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /**
         * Prueba de conexión
         */
        try {
            IConectionDB conectionDB = new ConectionDB();
            conectionDB.crearConexion();
        } catch (MongoException e) {
            System.out.println(e.getCause());
        }
    }
}
