package br.com.uhuu.fitness.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.uhuu.fitness.model.Usuario;

/**
 * Created by Marquinhos on 07/02/15.
 */
public class ORMLiteHelper extends OrmLiteSqliteOpenHelper {

    // Nome da base de dados.
    private static final String DATABASE_NAME = "fitness.db";
    // Versão da base de dados.
    private static final int DATABASE_VERSION = 2;

    public ORMLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            Log.i("FITNESS", "onCreate");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.i("FITNESS", "onUpdate");
        if (newVersion == 2) {
            Log.i("FITNESS", "version 2");
            // we added the age column in version 2
            try {
                Dao<Usuario, Integer> dao = getDao(Usuario.class);
                dao.executeRaw("ALTER TABLE `usuario` ADD COLUMN teste VARCHAR;");
            } catch (SQLException e) {
                Log.e("FITNESS", "onUpgrade", e);
            }
        }
    }
}
