package com.example.gustav.androidmenyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Auction auction = (Auction) intent.getSerializableExtra(MainActivity.AUCTION);

        TextView nameView = (TextView) findViewById(R.id.auctionNameViewDetail);
        TextView priceView = (TextView)  findViewById(R.id.auctionPriceViewDetail);
        ImageView imageView = (ImageView) findViewById(R.id.auctionImageViewDetail);

        Locale swedish = new Locale("sv", "SWE");
        NumberFormat priceFormat = NumberFormat.getNumberInstance(swedish);
        String price = priceFormat.format(auction.getPrice());

        nameView.setText(auction.getName());
        priceView.setText(price);
        Picasso.with(this).load(auction.getImageUrl()).into(imageView);
    }
}
