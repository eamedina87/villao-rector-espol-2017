package ec.medinamobile.comedoresdemo.comedores.menu;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import ec.medinamobile.comedoresdemo.comedores.entities.Comedor;
import ec.medinamobile.comedoresdemo.comedores.entities.Comida;
import ec.medinamobile.comedoresdemo.comedores.main.ComidaAdapter;
import ec.medinamobile.comedoresdemo.JsonUtils;
import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.comedores.order.OrderActivity;

/**
 * Created by Erick on 4/7/17.
 */

public class MenuActivity extends AppCompatActivity implements OnComidaClickListener {


    private RecyclerView recyclerview;
    private int comedorId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerview = (RecyclerView) findViewById(R.id.menu_list);
        Intent intent = getIntent();
        if (intent!=null && intent.hasExtra("comedorId")){
            comedorId = intent.getIntExtra("comedorId", -1);
        }
        setComedorNameAndMenu(comedorId);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("comedorId", comedorId);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        comedorId = savedInstanceState.getInt("comedorId");
    }

    private void setComedorNameAndMenu(int comedorId) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        switch (comedorId){
            case 1:{
                //Comedor Central
                getSupportActionBar().setTitle("Comedor Central - Menú");
                break;
            }
            case 2:{
                //Comedor Fiec
                getSupportActionBar().setTitle("Comedor Fiec - Menú");
                break;
            }
            case 3:{
                //Comedor Mecánica
                getSupportActionBar().setTitle("Comedor Mecánica - Menú");
                break;
            }
        }
        loadMenu(this, comedorId);
    }

    private void loadMenu(final Context context, final int comedorId) {
        new AsyncTask<Void, Void, Comida[]>() {
            @Override
            protected Comida[] doInBackground(Void... voids) {
                String jsonString = JsonUtils.readJsonFromAssets(context);
                Comedor[] comedores = JsonUtils.getComidaFromJson(jsonString);
                Comida[] menu = comedores[comedorId-1].getMenu();
                return menu;
            }

            @Override
            protected void onPostExecute(Comida[] aVoid) {
                super.onPostExecute(aVoid);
                onMenuLoaded(aVoid);
            }
        }.execute();

    }

    private void onMenuLoaded(Comida[] menu) {
        ComidaAdapter adapter = new ComidaAdapter(comedorId, menu, this);
        recyclerview.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, getResources().getInteger(R.integer.grid_columns));
        recyclerview.setLayoutManager(manager);
    }

    @Override
    public void onComidadClicked(Comida comida) {
        Intent intent = new Intent(this, OrderActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("comida", comida);
        bundle.putInt("comedorId", comedorId);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}