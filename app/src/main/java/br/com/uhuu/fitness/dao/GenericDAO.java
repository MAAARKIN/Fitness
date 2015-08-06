package br.com.uhuu.fitness.dao;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uhuu.fitness.datasource.ORMLiteHelper;
import br.com.uhuu.fitness.repositorio.Repositorio;

/**
 * Created by Marquinhos on 07/02/15.
 */
public abstract class GenericDAO<T> implements Repositorio<T> {

    private Class<T> entityClass;
    private ORMLiteHelper helper;
    private Dao<T, Integer> dao;

    public GenericDAO(Class<T> entityClass, Context context) {
        this.entityClass = entityClass;
        this.helper = new ORMLiteHelper(context);
    }

    @Override
    public void create(T entity) {
        try {
            getDao().create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        try {
            getDao().update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        try {
            getDao().delete(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T findById(int id) {

        T obj = null;
        try {
            obj = getDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public List<T> listAll() {
        List<T> list = new ArrayList<T>();
        try {
            list = getDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected Dao<T, Integer> getDao() {
        try {
            dao = helper.getDao(entityClass);
        } catch (SQLException e) {
            Log.e("GenericDAO", e.getMessage());
        }
        return dao;
    }

    @Override
    public void closeDatabase() {
        helper.close();
    }
}
