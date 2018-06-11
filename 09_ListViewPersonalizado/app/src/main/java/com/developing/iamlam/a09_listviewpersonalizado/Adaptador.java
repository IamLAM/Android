package com.developing.iamlam.a09_listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class Adaptador extends BaseAdapter {

    private Context contexto;
    private int layout;
    private List<String> nombres;

    public Adaptador(Context c,int l, List<String> n){

        this.contexto=c;
        this.layout=l;
        this.nombres=n;


    }

    @Override
    public int getCount() {
        return this.nombres.size();
        /**
         * @return regresamos la medida del list
         * */
    }

    @Override
    public Object getItem(int position) {
        return this.nombres.get(position);
        /**
         * @return regresamos el nombre del usuario
         * */
    }

    @Override
    public long getItemId(int position) {
        //
        return position;
        /**
         * @return regresamos la posicion del id
         * */
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //copiamos la vista

        View v;
        LayoutInflater LI=LayoutInflater.from(this.contexto);
        v=LI.inflate(R.layout.list_items,null);

        //String NA=nombres.get(position);
        String NA=(String)getItem(position); //si se desea utilizar la funcion autogenerada por la clase

       // buscamos la caja de texto ubicada en el nuevo archivo de vista personalizado
       TextView tv=(TextView) v.findViewById(R.id.textViewContactosP);
       tv.setText(NA);
        return v;

        //retornamos la vista
    }
}
