package ec.medinamobile.comedoresdemo.comedores.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.Utils;
import ec.medinamobile.comedoresdemo.comedores.calificar.CalificarActivity;
import ec.medinamobile.comedoresdemo.comedores.entities.Comida;

/**
 * Created by Erick on 4/7/17.
 */

public class OrderActivity extends AppCompatActivity {

    private int comedorId;
    private Comida comida;
    private boolean isCodigoVisible=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        if (intent!=null && intent.getExtras()!=null){
            comedorId = intent.getIntExtra("comedorId", -1);
            comida = intent.getParcelableExtra("comida");
        }
        getSupportActionBar().setTitle("Revisar Orden");
        setViews();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("comida", comida);
        outState.putInt("comedorId", comedorId);
        outState.putBoolean("visible", isCodigoVisible);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        comedorId = savedInstanceState.getInt("comedorId");
        comida = savedInstanceState.getParcelable("comida");
        isCodigoVisible = savedInstanceState.getBoolean("visible", false);
        setViews();
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
        Button btn = (Button)findViewById(R.id.orden_btn);
        if (!isCodigoVisible){
            btn.setVisibility(View.VISIBLE);
            btn.setTextColor(Utils.getBackgroudColor(this, comedorId));
        } else {
            confirmOrder(btn);
        }


    }

    public void confirmOrder(View view){
        isCodigoVisible = true;
        view.setVisibility(View.GONE);
        LinearLayout codigoLayout = (LinearLayout)findViewById(R.id.orden_codigo_layout);
        codigoLayout.setVisibility(View.VISIBLE);
        Button btn = (Button)findViewById(R.id.calificar_btn);
        btn.setTextColor(Utils.getBackgroudColor(this, comedorId));
    }

    public void calificarOrden(View view){
        Intent intent = new Intent(this, CalificarActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("comida", comida);
        bundle.putInt("comedorId", comedorId);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
