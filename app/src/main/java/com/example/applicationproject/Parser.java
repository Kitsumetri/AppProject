package com.example.applicationproject;

import static com.example.applicationproject.Parser.obiOboiHashCode;
import static com.example.applicationproject.Parser.obi_isSuccesfullyAddedToDataBase;
import static com.example.applicationproject.Parser.obi_names;
import static com.example.applicationproject.Parser.obi_oboi_count;
import static com.example.applicationproject.Parser.obi_oboi_prDt_main;
import static com.example.applicationproject.Parser.obi_prices;
import static com.example.applicationproject.Parser.obi_ratings;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser extends AsyncTask<Void, Void, Void> {
    static boolean obi_isSuccesfullyAddedToDataBase;
    //ProductData obi_oboi_prDt_help;
    static CalcDataBase obi_oboi_prDt_main;
    static String obiOboiHashCode;
    static Document obi_doc;
    static Elements obi_names, obi_prices, obi_ratings;
    static int obi_oboi_count;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
         obi_doc = null;
        //Document order_doc = null;
        //Document maxidom_doc = null;

        try {
            //ProductData obi_oboi_prDt_help;
            //obi_oboi_prDt_main = new CalcDataBase(null);
            obi_doc = Jsoup.connect("https://clck.ru/32eAhB").get();
            Log.i("OBI", "OBI");
            obi_names = obi_doc.select("p._1UlGi");
            obi_prices = obi_doc.select("span._3IeOW");
            obi_ratings = obi_doc.getElementsByClass("_1N_Nr");
            obi_oboi_count = obi_names.size();
            //Elements obi_img = obi_doc.getElementsByAttributeValueContaining("alt", "бои");
            //Elements obi_imgs = obi_doc.getElementsByAttributeValueContaining("src", ".jpg");
            //Elements obi_img = obi_doc.getElementsByClass("_1Z94x");
            /* for (int i = 0; i < obi_names.size(); i+=2){
                /*obiOboiHashCode = "obi_oboi_" + (i+1);
                Elements obi_img = obi_doc.getElementsByAttributeValueContaining("alt", obi_names.get(i).text());
                obi_oboi_prDt_help = new ProductData(i+1, obiOboiHashCode, obi_names.get(i).text(), obi_img.get(i).attr("alt"), Float.valueOf(obi_prices.get(i).text().replaceAll(" ", "").replace("₽", ""). replace(",", ".")),  "Metadata2", "Metadata3", obi_img.get(i).attr("src"), "Path", 1, Float.valueOf(obi_ratings.get(i).text().replace("(", "").replace(")","")), 1, true, "Oboi");
                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
                Log.i("OBI", String.valueOf(obi_isSuccesfullyAddedToDataBase)); */
                //Log.i("OBI", obi_names.get(i).text());
                //Log.i("OBI", obi_prices.get(i).text());
                //Log.i("OBI", obi_imgs.get(i).attr("src"));
            // } */
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
