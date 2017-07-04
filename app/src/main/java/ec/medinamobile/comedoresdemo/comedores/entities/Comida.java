package ec.medinamobile.comedoresdemo.comedores.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Erick on 4/7/17.
 */

public class Comida implements Parcelable{

    private String sopa;
    private String segundo;
    private String jugo;

    protected Comida(Parcel in) {
        sopa = in.readString();
        segundo = in.readString();
        jugo = in.readString();
    }

    public static final Creator<Comida> CREATOR = new Creator<Comida>() {
        @Override
        public Comida createFromParcel(Parcel in) {
            return new Comida(in);
        }

        @Override
        public Comida[] newArray(int size) {
            return new Comida[size];
        }
    };

    public String getSopa() {
        return sopa;
    }

    public void setSopa(String sopa) {
        this.sopa = sopa;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getJugo() {
        return jugo;
    }

    public void setJugo(String jugo) {
        this.jugo = jugo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(sopa);
        parcel.writeString(segundo);
        parcel.writeString(jugo);
    }
}
