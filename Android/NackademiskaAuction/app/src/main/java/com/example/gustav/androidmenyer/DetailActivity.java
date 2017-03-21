package com.example.gustav.androidmenyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    public static final String SUPPLIER_ID = "SUPPLIER_ID";
    private String currency = "SEK";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final TextView supplierTitle = (TextView) findViewById(R.id.supplierViewTitle);
        supplierTitle.setVisibility(View.INVISIBLE);
        final TextView companyNameTitle = (TextView) findViewById(R.id.companyViewTitle);
        companyNameTitle.setVisibility(View.INVISIBLE);
        final TextView phoneTitle = (TextView) findViewById(R.id.phoneViewTitle);
        phoneTitle.setVisibility(View.INVISIBLE);
        final TextView mailTitle = (TextView) findViewById(R.id.mailViewTitle);
        mailTitle.setVisibility(View.INVISIBLE);
        final TextView addressTitle = (TextView) findViewById(R.id.addressViewTitle);
        addressTitle.setVisibility(View.INVISIBLE);
        final TextView postalCodeTitle = (TextView) findViewById(R.id.postalCodeViewTitle);
        postalCodeTitle.setVisibility(View.INVISIBLE);
        final TextView cityTitle = (TextView) findViewById(R.id.cityViewTitle);
        cityTitle.setVisibility(View.INVISIBLE);

        final TextView companyName = (TextView) findViewById(R.id.companyNameView);
        companyName.setVisibility(View.INVISIBLE);
        final TextView phone = (TextView) findViewById(R.id.phoneView);
        phone.setVisibility(View.INVISIBLE);
        final TextView mail = (TextView) findViewById(R.id.mailView);
        mail.setVisibility(View.INVISIBLE);
        final TextView address = (TextView) findViewById(R.id.addressView);
        address.setVisibility(View.INVISIBLE);
        final TextView postalCode = (TextView) findViewById(R.id.postalCodeView);
        postalCode.setVisibility(View.INVISIBLE);
        final TextView city = (TextView) findViewById(R.id.cityView);
        city.setVisibility(View.INVISIBLE);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        final Auction auction = (Auction) intent.getSerializableExtra(MainActivity.AUCTION);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest("http://nackademiska-api.azurewebsites.net/api/supplier/"+ auction.getSupplierId(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    companyName.setText(response.getString("companyName"));
                    phone.setText(response.getString("phone"));
                    mail.setText(response.getString("email"));
                    address.setText(response.getString("address"));
                    postalCode.setText(response.getString("postalCode"));
                    city.setText(response.getString("city"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print("Failed response at Supplier");
            }
        });
        requestQueue.add(request);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);





        TextView nameView = (TextView) findViewById(R.id.auctionNameViewDetail);
        TextView priceView = (TextView) findViewById(R.id.auctionPriceViewDetail);
        TextView bidView = (TextView)  findViewById(R.id.auctionBidViewDetail);
        final TextView descTitle = (TextView) findViewById(R.id.auctionDescriptionTitleViewDetail);
        final TextView descView = (TextView)  findViewById(R.id.auctionDescriptionViewDetail);
        ImageView imageView = (ImageView) findViewById(R.id.auctionImageViewDetail);

        Locale swedish = new Locale("sv", "SE");
        final NumberFormat priceFormat = NumberFormat.getNumberInstance(swedish);
        String price = priceFormat.format(auction.getPrice());
        String bidPrice = "";
        nameView.setText(auction.getName());

        priceView.setText(price + " " + currency);
        if (auction.getHighestBid() == 0){
            bidView.setText("Inga bud");
    }
        else {
            bidPrice = priceFormat.format(auction.getHighestBid());
            bidView.setText(bidPrice + " " + currency);
        }
        descView.setText(auction.getDescription());

        Picasso.with(this).load(auction.getImageUrl()).into(imageView);

        final boolean[] clicked = {false};
        final Button button = (Button) findViewById(R.id.button_seller);
        button.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          if (clicked[0] == false) {
                                              descTitle.setVisibility(view.INVISIBLE);
                                              descView.setVisibility(view.INVISIBLE);
                                              supplierTitle.setVisibility(View.VISIBLE);
                                              companyNameTitle.setVisibility(View.VISIBLE);
                                              phoneTitle.setVisibility(View.VISIBLE);
                                              mailTitle.setVisibility(View.VISIBLE);
                                              addressTitle.setVisibility(View.VISIBLE);
                                              postalCodeTitle.setVisibility(View.VISIBLE);
                                              cityTitle.setVisibility(View.VISIBLE);
                                              companyName.setVisibility(View.VISIBLE);
                                              phone.setVisibility(View.VISIBLE);
                                              mail.setVisibility(View.VISIBLE);
                                              address.setVisibility(View.VISIBLE);
                                              postalCode.setVisibility(View.VISIBLE);
                                              city.setVisibility(View.VISIBLE);
                                              button.setText("Beskrivning");
                                              clicked[0] = true;
                                          }
                                          else {
                                              descTitle.setVisibility(view.VISIBLE);
                                              descView.setVisibility(view.VISIBLE);
                                              supplierTitle.setVisibility(View.INVISIBLE);
                                              companyNameTitle.setVisibility(View.INVISIBLE);
                                              phoneTitle.setVisibility(View.INVISIBLE);
                                              mailTitle.setVisibility(View.INVISIBLE);
                                              addressTitle.setVisibility(View.INVISIBLE);
                                              postalCodeTitle.setVisibility(View.INVISIBLE);
                                              cityTitle.setVisibility(View.INVISIBLE);
                                              companyName.setVisibility(View.INVISIBLE);
                                              phone.setVisibility(View.INVISIBLE);
                                              mail.setVisibility(View.INVISIBLE);
                                              address.setVisibility(View.INVISIBLE);
                                              postalCode.setVisibility(View.INVISIBLE);
                                              city.setVisibility(View.INVISIBLE);
                                              button.setText("Om Säljaren");
                                              clicked[0] = false;
                                          }
                                      }
                                  }
        );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Auktion");
                intent.putExtra(Intent.EXTRA_EMAIL, "nicole-sandberg@hotmail.com");
                intent.putExtra(Intent.EXTRA_TEXT, auction.getImageUrl().toString() +
                        "\n" + "Produkt namn: " + auction.getName().toString() +
                        "\n" + "Start tid: " + auction.getStartTime().toString() +
                        "\n" + "Slut tid: " + auction.getEndTime().toString() +
                        "\n" + "Högst bud: " + priceFormat.format(auction.getHighestBid()) + " " + currency +
                        "\n" + "Köp nu pris: " + priceFormat.format(auction.getPrice()) + " " + currency +
                        "\n" + "Leverantör: " + companyName.getText());



                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }

    public void getSupplier(String supplierId){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}

