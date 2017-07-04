package ec.medinamobile.comedoresdemo.comedores.entities;

/**
 * Created by Erick on 4/7/17.
 */

public class Comedor {
    private int id;
    private Comida[] menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comida[] getMenu() {
        return menu;
    }

    public void setMenu(Comida[] menu) {
        this.menu = menu;
    }
}
