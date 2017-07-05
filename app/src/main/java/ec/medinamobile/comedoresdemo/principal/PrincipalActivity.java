package ec.medinamobile.comedoresdemo.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.comedores.main.MainActivity;
import ec.medinamobile.comedoresdemo.propuestas.PropuestasActivity;
import ec.medinamobile.comedoresdemo.transporte.TransporteMainActivity;

/**
 * Created by Erick on 4/7/17.
 */

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    }

    public void verDemoRestaurantes(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void verDemoTransporte(View view){
        startActivity(new Intent(this, TransporteMainActivity.class));
    }

    public void verPropuestas(View view){
        startActivity(new Intent(this, PropuestasActivity.class));
    }
}
