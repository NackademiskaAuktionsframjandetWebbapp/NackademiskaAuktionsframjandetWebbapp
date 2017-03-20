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
import android.widget.Toast;

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
             /*   TextView supplierText = (TextView) findViewById(R.id.supplierTextView);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, supplierText.getText());
                intent.setType("text/plain");
                startActivity(intent);*/
            }
                                  }
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView aboutText = (TextView) findViewById(R.id.aboutTextView);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, aboutText.getText());
                intent.setType("text/plain");
                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        Auction auction = (Auction) intent.getSerializableExtra(MainActivity.AUCTION);
        Bid bid = (Bid) intent.getSerializableExtra(MainActivity.BID);

        TextView nameView = (TextView) findViewById(R.id.auctionNameViewDetail);
        TextView priceView = (TextView)  findViewById(R.id.auctionPriceViewDetail);
        ImageView imageView = (ImageView) findViewById(R.id.auctionImageViewDetail);

        Locale swedish = new Locale("sv", "SE");
        NumberFormat priceFormat = NumberFormat.getNumberInstance(swedish);
        String price = priceFormat.format(auction.getPrice());

        nameView.setText(auction.getName());
        priceView.setText(price + currency);
        Picasso.with(this).load(auction.getImageUrl()).into(imageView);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_about:
                Toast toast = Toast.makeText(DetailActivity.this, "info om suppliers", Toast.LENGTH_LONG
                );
                toast.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

