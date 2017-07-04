package ec.medinamobile.comedoresdemo.comedores.calificar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.Utils;
import ec.medinamobile.comedoresdemo.comedores.entities.Comida;
import ec.medinamobile.comedoresdemo.comedores.main.MainActivity;

/**
 * Created by Erick on 4/7/17.
 */

public class CalificarActivity extends AppCompatActivity {

    private int comedorId;
    private Comida comida;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);
        Intent intent = getIntent();
        if (intent!=null && intent.getExtras()!=null){
            comedorId = intent.getIntExtra("comedorId", -1);
            comida = intent.getParcelableExtra("comida");
        }
        getSupportActionBar().setTitle("Calificar Orden");
        setViews();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("comida", comida);
        outState.putInt("comedorId", comedorId);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        comedorId = savedInstanceState.getInt("comedorId");
        comida = savedInstanceState.getParcelable("comida");
    }

    private void setViews() {
        TextView title = (TextView)findViewById(R.id.oden_comedor);
        title.setText(Utils.getComedorName(comedorId));
        title.setCompoundDrawables(Utils.getDrawableForComedor(this,comedorId), null, null, null);
        title.setBackgroundColor(Utils.getBackgroudColor(this, comedorId));
        TextView opcion = (TextView)findViewById(R.id.menu_title);
        opcion.setBackgroundColor(Utils.getBackgroudColor(this, comedorId));
        TextView sopa = (TextView)findViewById(R.id.menu_sopa);
        sopa.setText(comida.getSopa());
        TextView segundo = (TextView)findViewById(R.id.menu_segundo);
        segundo.setText(comida.getSegundo());
        TextView jugo = (TextView)findViewById(R.id.menu_jugo);
        jugo.setText(comida.getJugo());
        Button btnOrder = (Button)findViewById(R.id.orden_btn);
        btnOrder.setVisibility(View.GONE);
        Button btn = (Button)findViewById(R.id.calificar_btn);
        btn.setTextColor(Utils.getBackgroudColor(this, comedorId));

    }

    public void calificarOrden(View view){
        RatingBar rating = (RatingBar) findViewById(R.id.calificar_ratingBar);
        EditText comentario = (EditText) findViewById(R.id.calificar_comentario);
        if (rating.getRating()==0){
            showMessage("Por favor asigne una calificación");
        } else if (TextUtils.isEmpty(comentario.getText().toString())){
            showMessage("Por favor deje un comentario");
        } else {
            showMessage("¡Gracias por calificar el servicio!");
            this.finish();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
