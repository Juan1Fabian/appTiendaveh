package com.example.apptiendavehiculos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Buscar extends AppCompatActivity {

    EditText bsrPlaca;
    Button btnBuscar;
    ListView lstResultado;
    RequestQueue queue;

    private void loadUI(){
        bsrPlaca = findViewById(R.id.bsrPlaca);
        btnBuscar = findViewById(R.id.btnBuscar);
        lstResultado = findViewById(R.id.lstResultado);

        queue = Volley.newRequestQueue(this);

        btnBuscar.setOnClickListener(v -> {
            String placa = bsrPlaca.getText().toString().trim();
            if(!placa.isEmpty()){
                buscarVehiculo(placa);
            }else{
                Toast.makeText(this, "Ingrese una placa", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            //Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadUI();
    }

    private void buscarVehiculo(String placa){
        String url = "http://IP_PC:3000/vehiculos/placa/" + placa;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        boolean success = response.getBoolean("succes");
                        if(success){
                            JSONObject data = response.getJSONObject("data");
                            // Mostrar placa y modelo
                            String info = "Placa: " + data.getString("placa") +
                                            "\nModelo: " + data.getString("modelo") +
                                            "\nMarca: " + data.getString("marca") +
                                            "\nColor: " + data.getString("color") +
                                            "\nPrecio: " + data.getString("precio");
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                    android.R.layout.simple_list_item_1,
                                    new String[]{info});
                            lstResultado.setAdapter(adapter);
                        }else{
                            Toast.makeText(this, "Vehículo no encontrado", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(this, "Error en la conexión", Toast.LENGTH_SHORT).show();
                });

        queue.add(request);
    }
}