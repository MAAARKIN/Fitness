package br.com.uhuu.fitness.dao;

import android.content.Context;

import br.com.uhuu.fitness.model.Usuario;
import br.com.uhuu.fitness.repositorio.UsuarioRepositorio;

/**
 * Created by Marquinhos on 07/02/15.
 */
public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioRepositorio {
    public UsuarioDAO(Context context) {
        super(Usuario.class, context);
    }
}
