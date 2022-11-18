package com.example.recycledview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements MyRecyclerViewAdapter.ItemClickListener{
MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //preparamos un array con los elementos a mostrar
        ArrayList<String> animalNames= new ArrayList<>();
        animalNames.add("Caballo");
        animalNames.add("Vaca");
        animalNames.add("Oveja");
        animalNames.add("Pollo");
        animalNames.add("Cordero");
        animalNames.add("Conejo");
        animalNames.add("Oca");
        animalNames.add("Gallina");
        animalNames.add("Perro");
        animalNames.add("Gato");

        //set up recyclerview
        RecyclerView recyclerView=findViewById(R.id.rvAnimales);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyRecyclerViewAdapter(this,animalNames);
        adapter.setClickListener(this);
        //ponemos una linea de separación entre elementos(opt)

        //añadimos el adaptador a la vista
        recyclerView.setAdapter(adapter);
        //
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,""+adapter.getItem(position),Toast.LENGTH_LONG).show();
    }
}