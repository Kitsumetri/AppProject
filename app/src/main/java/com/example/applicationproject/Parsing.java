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

        public class ObiWallpaper {
            private class Parser {
                Document obi_doc;

                String url;

                private Parser (String _url) { this.url = _url; }

                protected Document getDocument() {
                    obi_doc = null;
                    try {
                        obi_doc = Jsoup.connect(this.url).userAgent("Opera").timeout(10 * 1000).get();
                    } catch (IOException e) {
                        Log.i("RABOTYAGA", "obi Много хочешь");
                        e.printStackTrace();
                    }
                    return obi_doc;
                }

            }

            public void parseObiWallpaper(String url)
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
                //Log.i("RABOTYAGA", "OBI");
                for (int i = 0; i < obi_names.size(); i++) {
                    obiOboiHashCode = "obi_oboi_" + (i + 1);
                    try {
                         /* obi_oboi_prDt_help = new ProductData(
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
                                "Oboi"); */
                        index = index + 2;
                        //Log.i("RABOTYAGA", obi_image.get(index).absUrl("src"));
                        Log.i("RABOTYAGA", "OBI " + obi_names.get(i).text());

                    } catch (Exception e) {
                        /* obi_oboi_prDt_help = new ProductData(
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
                        Log.i("OBI", String.valueOf(obi_isSuccessfullyAddedToDataBase)); */
                        Log.i("RABOTYAGA", "obi oboi be rabotaet");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public class Maxidom {

        public class MaxidomWallpaper {
            private class MaxiParser {
                Document max_doc;

                String url;

                private MaxiParser(String _url) {
                    this.url = _url;
                }

                protected Document getDocument() {
                    max_doc = null;
                    try {
                        max_doc = Jsoup.connect(this.url).userAgent("Opera").get();
                    } catch (IOException e) {
                        Log.i("RABOTYAGA", "maxidom Много хочешь");
                        e.printStackTrace();
                    }
                    return max_doc;
                }

            }

            public void parseMaxidomWallpaper(String url) {
                Parsing.Maxidom.MaxidomWallpaper.MaxiParser p = new Parsing.Maxidom.MaxidomWallpaper.MaxiParser(url);

                Document max_doc = p.getDocument();
                if (max_doc == null) {
                    return;
                }

                Elements max_names = max_doc.select("a.name-big");
                Elements max_prices = max_doc.select("span._3IeOW");
                Elements max_ratings = max_doc.getElementsByClass("_1N_Nr");
                Elements max_image = max_doc.getElementsByAttributeValueContaining("itemprop", "image");

                CalcDataBase max_oboi_prDt_main;
                ProductData max_oboi_prDt_help;
                max_oboi_prDt_main = new CalcDataBase(context);
                boolean max_isSuccessfullyAddedToDataBase;
                String maxOboiHashCode;
                //Log.i("RABOTYAGA", "MAXIDOM");
                int counter = 0;
                for (int i = 0; i < max_names.size(); i++) {
                    maxOboiHashCode = "max_oboi_" + (i + 1);
                    try {
                        /* max_oboi_prDt_help = new ProductData(
                                i + 1, maxOboiHashCode,
                                max_names.get(i).text(),
                                "Description",
                                Float.parseFloat(max_prices.get(i)
                                        .text()
                                        .replaceAll(" ", "")
                                        .replace("₽", "")
                                        .replace(",", ".")),
                                "Metadata2", "Metadata3",
                                "ImageLink", "ImagePath",
                                1,
                                Float.parseFloat(max_ratings.
                                        get(i)
                                        .text()
                                        .replace("(", "")
                                        .replace(")", "")),
                                1,
                                true,
                                "Oboi"); */
                        //Log.i("RABOTYAGA", max_image.get(i).absUrl("src"));
                        Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                        counter += 1;

                    } catch (Exception e) {
                        /* max_oboi_prDt_help = new ProductData(
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

                        max_isSuccessfullyAddedToDataBase = max_oboi_prDt_main.addOne(max_oboi_prDt_help);
                        Log.i("RABOTYAGA", String.valueOf(max_isSuccessfullyAddedToDataBase)); */
                        Log.i("RABOTYAGA", "maxidom oboi ne rabotaet");
                        e.printStackTrace();
                    }
                }
            }
            public void parseMaxidomLaminat(String url) {
                Parsing.Maxidom.MaxidomWallpaper.MaxiParser p = new Parsing.Maxidom.MaxidomWallpaper.MaxiParser(url);

                Document max_doc = p.getDocument();
                if (max_doc == null) {
                    return;
                }

                Elements max_names = max_doc.select("a.name-big");
                Elements max_prices = max_doc.select("span._3IeOW");
                Elements max_ratings = max_doc.getElementsByClass("_1N_Nr");
                Elements max_image = max_doc.getElementsByAttributeValueContaining("itemprop", "image");

                CalcDataBase max_oboi_prDt_main;
                ProductData max_oboi_prDt_help;
                max_oboi_prDt_main = new CalcDataBase(context);
                boolean max_isSuccessfullyAddedToDataBase;
                String maxOboiHashCode;
                //Log.i("RABOTYAGA", "MAXIDOM");
                int counter = 0;
                for (int i = 0; i < max_names.size(); i++) {
                    maxOboiHashCode = "max_laminat_" + (i + 1);
                    try {
                        /* max_oboi_prDt_help = new ProductData(
                                i + 1, maxOboiHashCode,
                                max_names.get(i).text(),
                                "Description",
                                Float.parseFloat(max_prices.get(i)
                                        .text()
                                        .replaceAll(" ", "")
                                        .replace("₽", "")
                                        .replace(",", ".")),
                                "Metadata2", "Metadata3",
                                "ImageLink", "ImagePath",
                                1,
                                Float.parseFloat(max_ratings.
                                        get(i)
                                        .text()
                                        .replace("(", "")
                                        .replace(")", "")),
                                1,
                                true,
                                "Oboi"); */
                        //Log.i("RABOTYAGA", max_image.get(i).absUrl("src"));
                        Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                        counter += 1;

                    } catch (Exception e) {
                        /* max_oboi_prDt_help = new ProductData(
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

                        max_isSuccessfullyAddedToDataBase = max_oboi_prDt_main.addOne(max_oboi_prDt_help);
                        Log.i("RABOTYAGA", String.valueOf(max_isSuccessfullyAddedToDataBase)); */
                        Log.i("RABOTYAGA", "maxidom laminat ne rabotaet");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
