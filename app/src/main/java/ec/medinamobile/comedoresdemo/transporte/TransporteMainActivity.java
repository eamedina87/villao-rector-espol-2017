package ec.medinamobile.comedoresdemo.transporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ec.medinamobile.comedoresdemo.R;

/**
 * Created by Erick on 4/7/17.
 */

public class TransporteMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_main);
        getSupportActionBar().setTitle("Seleccione Parada");
    }

    public void onParadaSelected(View view){
        int id = view.getId();
        int paradaId = -1;
        switch (id){
            case R.id.parada_tecnologias:{
                paradaId = 1;
                break;
            }
            case R.id.parada_fen:{
                paradaId = 3;
                break;
            }
            case R.id.parada_rectorado:{
                paradaId = 2;
                break;
            }
        }
        Intent intent = new Intent(this, TransporteDetailActivity.class);
        intent.putExtra("paradaId", paradaId);
        startActivity(intent);

    }
}
