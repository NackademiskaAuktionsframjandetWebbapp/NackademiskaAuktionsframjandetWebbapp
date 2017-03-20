package com.example.gustav.androidmenyer;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AuctionListAdapter extends ArrayAdapter<Auction> {

    private ArrayList<Auction> auctions;
    private String currency = "SEK";

    public AuctionListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Auction> auctionObjects) {
        super(context, resource, auctionObjects);

        auctions = auctionObjects;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.auction_list_item, parent, false);
        }


        Auction auction = auctions.get(position);
        TextView auctionBid = (TextView) convertView.findViewById(R.id.auctionHighestBidView);
        TextView auctionName = (TextView) convertView.findViewById(R.id.auctionNameView);
        TextView auctionPrice = (TextView) convertView.findViewById(R.id.auctionPriceView);
        ImageView auctionImage = (ImageView) convertView.findViewById(R.id.auctionImageView);

        auctionName.setText(auction.getName());

        Locale swedish = new Locale("sv", "SE");
        NumberFormat priceFormat = NumberFormat.getNumberInstance(swedish);
        String price = priceFormat.format(auction.getPrice());
        String bidPrice;
        auctionPrice.setText(price + " " + currency);
        if (auction.getHighestBid() == 0){
            auctionBid.setText("Inga bud");
        }
        else {
            bidPrice = priceFormat.format(auction.getHighestBid());
            auctionBid.setText(bidPrice + " " + currency);
        }

        Picasso.with(getContext()).load(auction.getImageUrl()).into(auctionImage);

        return convertView;
    }
}
