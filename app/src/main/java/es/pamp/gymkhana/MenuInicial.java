package es.pamp.gymkhana;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        Button mapaBoton = (Button) findViewById(R.id.mapaBoton);
        Button ubicacionBoton = (Button) findViewById(R.id.ubicacionBoton);
        final Intent intentMapa = new Intent(this, Mapa.class);
        final Intent intentUbicacion = new Intent(this, Ubicacion.class);

       mapaBoton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(intentMapa);

           }
       });
        ubicacionBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentUbicacion);

            }
        });
    }
}
