package ec.medinamobile.comedoresdemo.comedores.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ec.medinamobile.comedoresdemo.comedores.entities.Comida;
import ec.medinamobile.comedoresdemo.R;
import ec.medinamobile.comedoresdemo.comedores.menu.OnComidaClickListener;

/**
 * Created by Erick on 4/7/17.
 */

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

    private final Comida[] mMenu;
    private final OnComidaClickListener mListener;
    private final int mId;
    private Context mContext;

    public ComidaAdapter(int comedorId,Comida[] menu, OnComidaClickListener listener){
        mId = comedorId;
        mMenu = menu;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comida comida = mMenu[position];
        holder.position = position;
        holder.title.setText(String.format(mContext.getString(R.string.comida_opcion),position+1));
        setTitleBackground(mId, holder.title);
        holder.sopa.setText(comida.getSopa());
        holder.segundo.setText(comida.getSegundo());
        holder.jugo.setText(comida.getJugo());
    }

    private void setTitleBackground(int mId, TextView title) {
        switch (mId){
            case 1:{
                title.setBackgroundResource(R.color.colorPrincipal);
                break;
            }
            case 2:{
                title.setBackgroundResource(R.color.colorFiec);
                break;
            }
            case 3:{
                title.setBackgroundResource(R.color.colorMecanica);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return (mMenu==null)?0:mMenu.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView sopa;
        TextView segundo;
        TextView jugo;
        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.menu_title);
            sopa = (TextView) itemView.findViewById(R.id.menu_sopa);
            segundo = (TextView) itemView.findViewById(R.id.menu_segundo);
            jugo = (TextView) itemView.findViewById(R.id.menu_jugo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onComidadClicked(mMenu[position]);
                }
            });
        }


    }
}
