package com.example.applicationproject;

import android.content.Context;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Parsing {
    private final Context context;

    public Parsing(Context context) {
        this.context = context;
    }

    public class Obi {

        public class Wallpaper {
            private class Parser {
                Document obi_doc;

                String url;

                private Parser (String _url) { this.url = _url; }

                protected Document getDocument() {
                    obi_doc = null;
                    try {
                        obi_doc = Jsoup.connect(this.url).userAgent("Chrome").timeout(10 * 1000).get();
                    } catch (IOException e) {
                        Log.i("HUI", "Много хочешь");
                        e.printStackTrace();
                    }
                    return obi_doc;
                }

            }

            public void parseWallpaper(String url)
            {
                Parser p = new Parser(url);

                Document obi_doc = p.getDocument();
                if (obi_doc == null) {
                    return;
                }

                Elements obi_names = obi_doc.select("p._1UlGi");
                Elements obi_prices = obi_doc.select("span._3IeOW");
                Elements obi_ratings = obi_doc.getElementsByClass("_1N_Nr");
                Elements obi_image = obi_doc.getElementsByAttributeValueContaining("src", ".jpg");

                CalcDataBase obi_oboi_prDt_main;
                ProductData obi_oboi_prDt_help;
                obi_oboi_prDt_main = new CalcDataBase(context);
                boolean obi_isSuccessfullyAddedToDataBase;
                String obiOboiHashCode;
                int index = -1;
                Log.i("OBI", "OBI");
                for (int i = 0; i < obi_names.size(); i++) {
                    obiOboiHashCode = "obi_oboi_" + (i + 1);
                    try {
                        obi_oboi_prDt_help = new ProductData(
                                i + 1, obiOboiHashCode,
                                obi_names.get(i).text(),
                                "Description",
                                Float.parseFloat(obi_prices.get(i)
                                        .text()
                                        .replaceAll(" ", "")
                                        .replace("₽", "")
                                        .replace(",", ".")),
                                "Metadata2", "Metadata3",
                                "ImageLink", "ImagePath",
                                1,
                                Float.parseFloat(obi_ratings.
                                        get(i)
                                        .text()
                                        .replace("(", "")
                                        .replace(")", "")),
                                1,
                                true,
                                "Oboi");
                        index = index + 2;
                        Log.i("OBI", obi_image.get(index).absUrl("src"));
                        Log.i("OBI", obi_names.get(i).toString());

                    } catch (Exception e) {
                        obi_oboi_prDt_help = new ProductData(
                                -1,
                                "error",
                                "error",
                                "error",
                                0,
                                "error", "error",
                                "error", "error",
                                0, 0, 0,
                                false,
                                "error");

                        obi_isSuccessfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
                        Log.i("OBI", String.valueOf(obi_isSuccessfullyAddedToDataBase));
                        e.printStackTrace();
                    }
                }
            }
        }
    }

//    public class Order {
//
//    }
//
//    public class Maxidom {
//
//    }
}
