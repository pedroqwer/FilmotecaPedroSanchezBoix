package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FilmDataSource.Initialize();
        ListView lista=(ListView) findViewById(R.id.listaa);
        FilmListActivity filmListActivity=new FilmListActivity(this,R.layout.mostrar, FilmDataSource.films);
        lista.setAdapter(filmListActivity);
        lista.setOnItemClickListener(this);


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Acción al clickar sobre un elemento determinado
        Intent intent = new Intent(MainActivity.this, FilmDataActivity.class);
        intent.putExtra("FILM_POSITION", position);
        Toast.makeText(getApplicationContext(),"Película selecionada : "+FilmDataSource.films.get(position).getTitle(), Toast.LENGTH_LONG).show();
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){

        int id=item.getItemId();

        if(id==R.id.opcion1){
            Toast.makeText(getApplicationContext(), "Has pulsado Acerca de ", Toast.LENGTH_LONG).show();
            Intent si=new Intent(this,AboutActivity.class);
            startActivity(si);
            return true;
        }else if (id==R.id.opcion2){
            Toast.makeText(getApplicationContext(),"Has pulsado añadir peliculas",Toast.LENGTH_LONG).show();
            //Intent si=new Intent();
            //startActivity(si);
            return true;
        }

        return  super.onOptionsItemSelected(item);
    }

}