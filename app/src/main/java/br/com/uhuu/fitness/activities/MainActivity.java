package br.com.uhuu.fitness.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.uhuu.fitness.R;
import br.com.uhuu.fitness.dao.UsuarioDAO;
import br.com.uhuu.fitness.model.Usuario;
import br.com.uhuu.fitness.repositorio.UsuarioRepositorio;


public class MainActivity extends ActionBarActivity {

    private EditText editName;
    private EditText editAge;
    private UsuarioRepositorio userRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editName = (EditText) findViewById(R.id.editName);
        this.editAge = (EditText) findViewById(R.id.editAge);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportActionBar().setTitle("MyApplication");
        userRep = new UsuarioDAO(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void salvar(View v) {
        Usuario user = new Usuario();
        user.setName(this.editName.getText().toString());
        user.setAge(Integer.parseInt(this.editAge.getText().toString()));
        userRep.create(user);
        Toast.makeText(this, "Salvou!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
