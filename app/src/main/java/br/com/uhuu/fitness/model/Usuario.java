package br.com.uhuu.fitness.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Marquinhos on 07/02/15.
 */
@DatabaseTable(tableName = "usuario")
public class Usuario extends Entity {

    @DatabaseField
    private String name;
    @DatabaseField
    private int age;
    @DatabaseField
    private String teste;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
}
