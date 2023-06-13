/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Implementacion;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import java.util.ArrayList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

public abstract class BaseDAO<T> {

    public MongoClient getConexionMongoClient() {
        //Creamos un proveedor de codecs para las clases POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        //Creamos la configuración del cliente de MongoDB      
        MongoClient mongoC = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        return mongoC;
    }

    public MongoDatabase getMongoDB(String nomBD) {
        return getConexionMongoClient().getDatabase(nomBD);
    }

    public abstract void guardar(T entidad);

    public abstract void eliminar(T entidad) throws DAOException;

    public abstract void actualizar(T entidad) throws DAOException;

    public abstract T buscarPorID(ObjectId id);

    public abstract ArrayList<T> buscarTodos();

    public abstract MongoCollection<T> getCollection();
}
