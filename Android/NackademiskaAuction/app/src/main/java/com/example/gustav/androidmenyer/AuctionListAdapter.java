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

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AuctionListAdapter extends ArrayAdapter<Auction> {

    private ArrayList<Auction> auctions;

    public AuctionListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Auction> objects) {
        super(context, resource, objects);

        auctions = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.auction_list_item, parent, false);
        }

        Auction auction = auctions.get(position);
        TextView auctionName = (TextView) convertView.findViewById(R.id.auctionNameView);
        TextView auctionPrice = (TextView) convertView.findViewById(R.id.auctionPriceView);
        ImageView auctionImage = (ImageView) convertView.findViewById(R.id.auctionImageView);

        auctionName.setText(auction.getName());

        Locale swedish = new Locale("sv", "SE");
        NumberFormat priceFormat = NumberFormat.getNumberInstance(swedish);
        String price = priceFormat.format(auction.getPrice());
        auctionPrice.setText(price + " SEK");

        Picasso.with(getContext()).load(auction.getImageUrl()).into(auctionImage);

        return convertView;
    }
}
