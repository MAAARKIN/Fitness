package br.com.uhuu.fitness.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Marquinhos on 07/02/15.
 */
public abstract class Entity {

    @DatabaseField(generatedId = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
