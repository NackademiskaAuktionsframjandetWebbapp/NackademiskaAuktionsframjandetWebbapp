package com.example.gustav.androidmenyer;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
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
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String supplierId = intent.getStringExtra(DetailActivity.SUPPLIER_ID);

        final TextView supplierName = (TextView) findViewById(R.id.textViewCompany_name);
        //EditText supplierPhone = (EditText) findViewById(R.id.editTextPhone);
        //EditText supplierEmail = (EditText) findViewById(R.id.editTextEmail);

        //supplierName.setText("email");

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest("http://nackademiska-api.azurewebsites.net/api/supplier/"+ supplierId, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    supplierName.setText(response.getString("companyName"));
                    Snackbar snack = Snackbar.make(findViewById(R.id.textViewCompany_name),"try", Snackbar.LENGTH_SHORT);
                    snack.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Snackbar snack = Snackbar.make(findViewById(R.id.textViewCompany_name),"Catch", Snackbar.LENGTH_SHORT);
                    snack.show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




        //supplierName.setText(supplier.getCompanyName());


    }


