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

                private Parser (String _url)
                { this.url = _url; }

                protected Document getDocument() {
                    obi_doc = null;
                    try {
                        obi_doc = Jsoup.connect(this.url).userAgent("Opera").timeout(100 * 100).get();
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

                int index = -1;
                for (int i = 0; i < obi_names.size(); i++) {
                    try {
                        index = index + 2;
                        Log.i("RABOTYAGA", "OBI " + obi_names.get(i).text());

                    } catch (Exception e) {
                        Log.i("RABOTYAGA", "obi oboi be rabotaet");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public class Maxidom {

        public class MaxidomWallpaper implements Runnable {
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

            @Override
            public void run()
            {
                String wallpapers_url = "https://www.maxidom.ru/catalog/oboi/?amount=12&PAGEN_3=2";
                for (int i = 0; i < 4; i++) {
                    parseMaxidomWallpaper(wallpapers_url + i);
                    Log.i("APPTHREADS_01", Thread.currentThread().getName());
                }
            }

            private void parseMaxidomWallpaper(String url) {
                Parsing.Maxidom.MaxidomWallpaper.MaxiParser p = new Parsing.Maxidom.MaxidomWallpaper.MaxiParser(url);

                Document max_doc = p.getDocument();
                if (max_doc == null) {
                    return;
                }

                Elements max_names = max_doc.select("a.name-big");
                Elements max_prices = max_doc.select("span._3IeOW");
                Elements max_ratings = max_doc.getElementsByClass("_1N_Nr");
                Elements max_image = max_doc.getElementsByAttributeValueContaining("itemprop", "image");

                int counter = 0;
                for (int i = 0; i < max_names.size(); i++) {
                    try {
                        Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                        counter += 1;

                    } catch (Exception e) {
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

                int counter = 0;
                for (int i = 0; i < max_names.size(); i++) {
                    try {
                        Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                        counter += 1;

                    } catch (Exception e) {
                        Log.i("RABOTYAGA", "maxidom laminat ne rabotaet");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
