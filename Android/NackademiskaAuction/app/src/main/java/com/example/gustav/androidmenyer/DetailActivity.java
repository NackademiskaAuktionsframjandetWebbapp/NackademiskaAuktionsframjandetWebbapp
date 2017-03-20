package com.example.gustav.androidmenyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    private String currency = "SEK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = (Button) findViewById(R.id.button_seller);
        button.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(DetailActivity.this, SupplierActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        Intent intent = getIntent();
        final Auction auction = (Auction) intent.getSerializableExtra(MainActivity.AUCTION);

        TextView nameView = (TextView) findViewById(R.id.auctionNameViewDetail);
        TextView priceView = (TextView) findViewById(R.id.auctionPriceViewDetail);
        TextView bidView = (TextView)  findViewById(R.id.auctionBidViewDetail);
        TextView descView = (TextView)  findViewById(R.id.auctionDescriptionViewDetail);
        ImageView imageView = (ImageView) findViewById(R.id.auctionImageViewDetail);

        Locale swedish = new Locale("sv", "SE");
        NumberFormat priceFormat = NumberFormat.getNumberInstance(swedish);
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
                        "\n" + "Högst bud: " + auction.getHighestBid() + " " + currency +
                        "\n" + "Köp nu pris: " + auction.getPrice() + " " + currency);



                intent.setType("text/plain");
                startActivity(intent);
            }
        });
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

