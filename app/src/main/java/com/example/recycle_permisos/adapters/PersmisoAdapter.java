package com.example.recycle_permisos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.widget.CompoundButton;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_permisos.R;
import com.example.recycle_permisos.models.Permisos;

import java.util.List;

public class PersmisoAdapter extends RecyclerView.Adapter<PersmisoAdapter.ViewHolder> {

    List<Permisos> LP;
    private Context context;

    public PersmisoAdapter(List<Permisos> LP, Context context) {
        this.LP = LP;
        this.context = context;
    }

    @NonNull
    @Override
    public PersmisoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.permisositem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersmisoAdapter.ViewHolder holder, int position) {
        Permisos permisos = LP.get(position);
        holder.setData(permisos);
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPermiso;
        Switch swPermiso;
        Permisos permisos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso = itemView.findViewById(R.id.permiso);
            swPermiso = itemView.findViewById(R.id.switch1);
            swPermiso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        if (txtPermiso.getText().toString().equals("Llamar")) {
                            requestPermission(Manifest.permission.CALL_PHONE, 1987);
                        } else if (txtPermiso.getText().toString().equals("Camara")) {
                            requestPermission(Manifest.permission.CAMERA, 1988);
                        }
                    } else {

                    }
                }
            });
        }

        public void setData(Permisos persmisos) {
            txtPermiso.setText(persmisos.getDescripcion());
        }

        private void requestPermission(String permission, int requestCode) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, requestCode);
            }
        }
    }
}
