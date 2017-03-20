package com.example.gustav.androidmenyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.function.*;

public class SupplierActivity extends AppCompatActivity {
    public static final String SUPPLIER = "SUPPLIER";
    private ArrayList<Supplier> supplier = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest("http://nackademiska-api.azurewebsites.net/api/supplier",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject supplierJson = (JSONObject) response.get(i);
                                supplier.add(new Supplier(supplierJson.getString("id"),
                                        supplierJson.getString("companyName"),
                                        supplierJson.getString("phone"), supplierJson.getString("email"),
                                        supplierJson.getString("address"), supplierJson.getString("postalCode"),
                                        supplierJson.getString("city")));
                            }
                            Intent intent = getIntent();
                            final Auction auction = (Auction) intent.getSerializableExtra(MainActivity.AUCTION);





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print("Failed response on auction");
            }
        });
        requestQueue.add(request);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



        EditText supplierName = (EditText) findViewById(R.id.editTextCompany_name);
        EditText supplierPhone = (EditText) findViewById(R.id.editTextPhone);
        EditText supplierEmail = (EditText) findViewById(R.id.editTextEmail);

        //supplierName.setText(supplier.getCompanyName());


    }


