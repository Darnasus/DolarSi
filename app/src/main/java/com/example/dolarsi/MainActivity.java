package com.example.dolarsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        rq= Volley.newRequestQueue(this);
    }

    public void recuperar(View v)
    {
        tv1.setText("");
        String url="https://www.dolarsi.com/api/api.php?type=valoresprincipales";
        JsonArrayRequest requerimiento=new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i<response.length();i++)
                        {
                            try {

                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                for (int j=0; j<objeto.length();j++)
                                {
                                    try {
                                        JSONObject objeto1 = new JSONObject(objeto.get("casa").toString());

                                        tv1.append("Tipo: " + objeto1.getString("nombre")+"\n");
                                        tv1.append("Venta: " + objeto1.getString("venta")+"\n");
                                        tv1.append("Compra: " + objeto1.getString("compra")+"\n");
                                        tv1.append("Agencia: " + objeto1.getString("agencia")+"\n");
                                        tv1.append("-------------------------\n");


                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                //tv1.append(objeto.getString("casa")+"\n");
                                //tv1.append("-------------------------\n");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                     }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();

        }
    });

    rq.add(requerimiento);

    }
}