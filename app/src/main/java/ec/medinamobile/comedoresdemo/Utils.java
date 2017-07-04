package ec.medinamobile.comedoresdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;

import java.util.Random;

import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.comedores.order.OrderActivity;

/**
 * Created by Supertel on 4/7/17.
 */

public class Utils {

    private static final long ONE_SECOND = 1000;
    public static long ONE_HOUR = 1000*60*60;
    public static long ONE_MINUTE = 1000*60;

    public static String getComedorName(int comedorId) {
        switch (comedorId){
            case 1: return "Comedor Central";
            case 2: return "Comedor Fiec";
            case 3: return "Comedor Mecánica";
        }
        return "";
    }

    public static Drawable getDrawableForComedor(Context context, int comedorId) {
        switch (comedorId){
            case 1: AppCompatResources.getDrawable(context, R.drawable.ic_action_name);
            case 2: AppCompatResources.getDrawable(context,R.drawable.ic_comedor_fiec);
            case 3: AppCompatResources.getDrawable(context,R.drawable.ic_comedor_mecanica);
        }
        return null;
    }

    public static String getParadaName(int comedorId) {
        switch (comedorId){
            case 1: return "Parada Tecnologías";
            case 2: return "Parada Rectorado";
            case 3: return "Parada FEN";
        }
        return "";
    }

    public static int getBackgroudColor(Context context, int comedorId) {
        switch (comedorId){
            case 1: return context.getResources().getColor(R.color.colorPrincipal);
            case 2: return context.getResources().getColor(R.color.colorFiec);
            case 3: return context.getResources().getColor(R.color.colorMecanica);
        }
        return 0;
    }

    public static long getIntervalForTime(long l){
        if (l>ONE_HOUR){
            return ONE_MINUTE;
        } else {
            return ONE_SECOND;
        }
    }

    public static String formatRemainingTime(long l) {
        String time = "";

        if (l>ONE_HOUR){
            //Mayor a una hora
            int hours_remaining = (int) (l/ONE_HOUR);
            int minutes_remaining = (int) ((l%ONE_HOUR) / ONE_MINUTE);
            time = String.format("%dh%dm", hours_remaining, minutes_remaining);
        } else {
            //Menor a una hora
            int minutes_remaining = (int) (l/ONE_MINUTE);
            int second_remaining = (int) ((l%ONE_MINUTE) / ONE_SECOND);
            if (minutes_remaining==0){
                time = String.format("%ds", second_remaining);
            } else {
                time = String.format("%dm%ds", minutes_remaining, second_remaining);
            }

        }
        return time;
    }

    public static long getRandomDuration() {
        Random random = new Random();
        int number = (random.nextInt(10));
        return ONE_MINUTE*number;
    }

    public static long getRandomDisco() {
        Random random = new Random();
        int number = (random.nextInt(49)+1);
        return number;
    }

    public static int getRandomPlaca() {
        Random random = new Random();
        int number = (random.nextInt(999));
        return number;
    }

    public static String getRandomPlataString(Context context) {
        int placa = Utils.getRandomPlaca();
        return  String.format(context.getString(R.string.transporte_placa),placa);

    }

    public static String getRandomDiscoString() {
        return String.valueOf(getRandomDisco());
    }
}
