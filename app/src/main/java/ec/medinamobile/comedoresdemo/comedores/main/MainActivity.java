package ec.medinamobile.comedoresdemo.comedores.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.comedores.menu.MenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(getString(R.string.main_title));
    }

    public void onComedorSelected(View view){
        int comedorId = -1;
        int id = view.getId();
        switch (id){
            case R.id.comedor_central:{
                comedorId = 1;
                break;
            }
            case R.id.comedor_fiec:{
                comedorId = 2;
                break;
            }
            case R.id.comedor_mecanica:{
                comedorId = 3;
                break;
            }
        }
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("comedorId",comedorId);
        startActivity(intent);

    }
}
