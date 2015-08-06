package br.com.uhuu.fitness.repositorio;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Marquinhos on 07/02/15.
 */
public interface Repositorio<T> {
    public void create(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T findById(int id);
    public List<T> listAll();
    public void closeDatabase();
}
