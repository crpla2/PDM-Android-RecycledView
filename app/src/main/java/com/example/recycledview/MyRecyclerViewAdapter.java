package com.example.recycledview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClicklistener;

    /**
     * Constructor
     * @param context
     * @param data
     */
    MyRecyclerViewAdapter(Context context, List<String>data){
        mInflater=LayoutInflater.from(context);
        mData=data;

    }
    /**
     * Inflar cada fila del xml cuando sea necesario
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.recicler_view_row,parent,false);
        return new ViewHolder(view);
    }

    /**
     * Enlaza los datos con el viewholder correspondiente
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setTextView(mData.get(position));
    }

    /**
     * devuelve cuantos elementos hay
     * @return
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

   /**** PARA EL LISTENER ****/


    //La actividad padre implementa este metodo para responder a los elementos de clic
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClicklistener=itemClickListener;
    }
    //Permite capturar los eventos del clic
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    //METODOS AUXILIARES
    String getItem(int pos){
       return mData.get(pos);
    }

    /**
     * Esta clase corresponde a cada fila
     * almacena y recicla las vistas según salen de la pantalla
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvAnimalName);
            itemView.setOnClickListener(this);
        }

        public void setTextView(String s) {
           textView.setText(s);
        }

        public String getMyTextView()
        {
            return textView.getText().toString();
        }

        @Override
        public void onClick(View view) {
            if(mClicklistener!=null)
                mClicklistener.onItemClick(view,getAdapterPosition());
        }
    }
}
