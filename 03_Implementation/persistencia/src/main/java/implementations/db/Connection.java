/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author MoonA
 */
public final class ConectionDB implements interfaces.IConectionDB {

    /**
     * Atributo que almacena el host de la base de datos
     */
    private final String HOST = "localhost";
    /**
     * Atributo que almacena el puerto del la BD
     */
    private final String PUERTO = "27017";
    /**
     * Atributo que almacena el nombre de la BD
     */
    private final String BASE_DATOS = "redsocial";

    /**
     * Método que permite la creación de la conexión hacia la BD
     *
     * @return objeto tipo MongoDatabase
     * @throws Exception
     */
    @Override
    public MongoDatabase crearConexion() throws Exception {
        MongoDatabase database = null;
        try {
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
            ConnectionString cadenaConexion = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);
            MongoClientSettings clientsSettings = MongoClientSettings.builder().applyConnectionString(cadenaConexion).codecRegistry(codecRegistry).build();
            MongoClient client = MongoClients.create(clientsSettings);
            database = client.getDatabase(BASE_DATOS);
        } catch (Exception e) {
            throw new Exception(e.getCause());
        }
        return database;
    }

}
