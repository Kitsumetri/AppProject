package com.example.applicationproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser extends AsyncTask<Void, Void, Void> {
    static int obi_wallpapers_count;
    static int order_wallpapers_count;

    ProductData obi_oboi_prDt;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Document obi_doc = null;
        //Document order_doc = null;
        //Document maxidom_doc = null;

        try {
            obi_doc = Jsoup.connect("https://clck.ru/32eAhB").get();
            String obi_hashName = "obi";
            String obi_ProductType_oboi = "oboi";
            Log.i("OBI", "OBI");
            Elements obi_names = obi_doc.select("p._1UlGi");
            Elements obi_prices = obi_doc.select("span._3IeOW");
            //Elements img = obi_doc.select("div._2iXXi");
            Elements obi_img = obi_doc.getElementsByAttributeValueContaining("src", "product");
            for (int i = 0; i < obi_names.size(); i++){
                String obiHashCode = obi_hashName + "_" + obi_ProductType_oboi + "_" + i;
                obi_oboi_prDt = new ProductData(i+1, obiHashCode, obi_names.get(i).text(), "Descriprion", Float.valueOf(obi_prices.get(i).text().replaceAll(" ", "").replace("₽", ""). replace(",", ".")),  "Metadata2", "Metadata3", "Source link", "Path", 1, 5, 1, true, "Oboi");
                //Log.i("OBI", obi_names.get(i).text());
                //Log.i("OBI", obi_prices.get(i).text());
                Log.i("OBI", obi_oboi_prDt.toString());
            }
            obi_wallpapers_count = obi_names.size();

            /*
            Log.i("ORDER", "ORDER");
            order_doc = Jsoup.connect("https://order-nn.ru/kmo/catalog/6315").get();
            Elements order_names = order_doc.select("div.horizontal-product-item-block_3_2");
            Elements order_prices = order_doc.select("span.span-price-number");
            //Elements order_img = order_doc.getElementsByAttributeValueContaining("alt", "Обои");
            for (int j = 0; j < order_names.size(); j++){
                Log.i("ORDER", order_names.get(j).text());
                Log.i("ORDER", order_prices.get(j).text());
                //Log.i("ORDER", order_img.get(i).attr("src"));
            }
            order_wallpapers_count = order_names.size();

            Log.i("MAXIDOM", "MAXIDOM");
            maxidom_doc = Jsoup.connect("https://www.maxidom.ru/catalog/oboi").get();
            Elements maxidom_names = maxidom_doc.select("a.name-big");
            Elements maxidom_prices = maxidom_doc.select("span.price-list");
            //Elements maxidom_img = maxidom_doc.getElementsByAttributeValueContaining("alt", "Обои");
            for (int f = 0; f < order_names.size(); f++){
                Log.i("MAXIDOM", maxidom_names.get(f).text());
                Log.i("MAXIDOM", maxidom_prices.get(f).text());
                //Log.i("MAXIDOM", maxidom_img.get(i).attr("src"));
            } */

        } catch (IOException e) {
            Log.i("HUI", "Много хочешь");
            e.printStackTrace();
        }
        return null;
    }

}
