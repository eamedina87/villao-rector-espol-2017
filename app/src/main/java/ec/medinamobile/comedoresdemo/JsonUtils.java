package ec.medinamobile.comedoresdemo;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.comedores.entities.Comedor;


/**
 * Created by Erick on 30/6/17.
 */

public class JsonUtils {

    public static Comedor[] getComidaFromJson(String recipesJson){
        if (recipesJson==null) return null;
        Gson gson = new Gson();
        Comedor[] menu = gson.fromJson(recipesJson, Comedor[].class);
        return menu;
    }

    public static String readJsonFromAssets(Context context) {
        String json = null;
        try {
            InputStream is = context.getResources().openRawResource(R.raw.menu);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


}
