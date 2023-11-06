package com.example.recycle_permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.recycle_permisos.adapters.PersmisoAdapter;
import com.example.recycle_permisos.models.Permisos;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Permisos> ListaPermisos = new ArrayList<>();

        ListaPermisos.add(new Permisos(Manifest.permission.CALL_PHONE, "Llamar"));
        ListaPermisos.add(new Permisos(Manifest.permission.CAMERA, "Camara"));

        RecyclerView rvpermiso = findViewById(R.id.rvpermiso);
        rvpermiso.setLayoutManager(new LinearLayoutManager(this));
        rvpermiso.setHasFixedSize(true);

// Pasa la lista y el contexto al adaptador
        PersmisoAdapter adapter = new PersmisoAdapter(ListaPermisos, this);
        rvpermiso.setAdapter(adapter);
    }
}