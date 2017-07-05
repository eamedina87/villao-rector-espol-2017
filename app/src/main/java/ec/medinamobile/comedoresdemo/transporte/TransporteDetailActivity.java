package ec.medinamobile.comedoresdemo.transporte;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.Utils;
import ec.medinamobile.comedoresdemo.comedores.main.MainActivity;
import ec.medinamobile.comedoresdemo.principal.PrincipalActivity;

/**
 * Created by Erick on 4/7/17.
 */

public class TransporteDetailActivity extends AppCompatActivity{

    private int paradaId;

    private TextView timer;
    private CountDownTimer countDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte_detail);
        Intent intent = getIntent();
        if (intent!=null && intent.hasExtra("paradaId")){
            paradaId = intent.getIntExtra("paradaId", -1);
        }
        setViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDown!=null) countDown.cancel();
    }

    private void setViews() {
        getSupportActionBar().setTitle(Utils.getParadaName(paradaId));
        timer = (TextView)findViewById(R.id.transporte_tiempo);
        startCountdown(Utils.getRandomDuration());
        //((TextView)findViewById(R.id.textView7)).setBackgroundColor(Utils.getBackgroudColor(this, paradaId));
        //((Button)findViewById(R.id.calificar_btn)).setBackgroundColor(Utils.getBackgroudColor(this, paradaId));
        //((Button)findViewById(R.id.enviar_btn)).setBackgroundColor(Utils.getBackgroudColor(this, paradaId));

    }

    private void startCountdown(long duration){
        ((TextView)findViewById(R.id.transporte_placa)).
                setText(Utils.getRandomPlataString(this));
        ((TextView)findViewById(R.id.transporte_disco)).
                setText(Utils.getRandomDiscoString());
        countDown = new CountDownTimer(duration, Utils.getIntervalForTime(duration)){

            @Override
            public void onTick(long l) {
                timer.setText(Utils.formatRemainingTime(l));

            }

            @Override
            public void onFinish() {
                showBusArrived();
            }
        }.start();
    }

    public void mostrarCalificar(View view){
        view.setVisibility(View.GONE);
        ((LinearLayout)findViewById(R.id.transporte_calificar)).setVisibility(View.VISIBLE);
    }

    private void showBusArrived() {
        showMessage("Tu bus ha arrivado");
        startCountdown(Utils.getRandomDuration());
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
            Intent intent = new Intent(this, PrincipalActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }


    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



}
