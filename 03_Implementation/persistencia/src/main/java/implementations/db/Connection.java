package implementations.db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 */
public final class Connection {

    /**
     * Atributo que almacena el host de la base de datos.
     */
    private static final String HOST = "localhost";
    /**
     * Atributo que almacena el puerto del la BD.
     */
    private static final String PUERTO = "27017";
    /**
     * Atributo que almacena el nombre de la BD.
     */
    private static final String BASE_DATOS = "redsocial";

    /**
     * Instancia de la base de datos.
     */
    private static MongoDatabase database;

    private Connection() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Método que regresa una instancia de la base de datos. Implementa el
     * patrón Singleton.
     *
     * @return instancia de la base de datos.
     */
    public static MongoDatabase getDb() {
        if (Connection.database != null) {
            return Connection.database;
        }

        CodecRegistry pojoCodecRegistry
                = fromProviders(
                        PojoCodecProvider
                                .builder()
                                .automatic(true)
                                .build()
                );

        CodecRegistry codecRegistry
                = fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        pojoCodecRegistry
                );

        ConnectionString cadenaConexion
                = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);

        MongoClientSettings clientsSettings
                = MongoClientSettings
                        .builder()
                        .applyConnectionString(cadenaConexion)
                        .codecRegistry(codecRegistry)
                        .build();

        MongoClient client = MongoClients.create(clientsSettings);
        Connection.database = client.getDatabase(BASE_DATOS);

        return database;
    }

}
