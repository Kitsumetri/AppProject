package com.example.applicationproject;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Parsing {
    private final Context context;
    public DatabaseReference dbRef;

    public Parsing(Context context) {
        this.context = context;
    }
    public class Maxidom {

        private class MaxiParser {
            Document max_doc;

            String url;

            private MaxiParser(String _url) {
                this.url = _url;
            }

            protected Document getDocument() {
                max_doc = null;
                try {
                    max_doc = Jsoup.connect(this.url).userAgent("Chrome").get();
                } catch (IOException e) {
                    Log.i("RABOTYAGA", "maxidom Много хочешь");
                    e.printStackTrace();
                }
                return max_doc;
            }

        }

        public void parseMaxidomWallpaper(String url) {
            Parsing.Maxidom.MaxiParser p = new Parsing.Maxidom.MaxiParser(url);

            Document max_doc = p.getDocument();
            if (max_doc == null) {
                return;
            }

            Elements max_names = max_doc.getElementsByClass("name-big");
            Elements max_prices = max_doc.getElementsByClass("price-list");
            //Elements max_image = max_doc.getElementsByAttributeValueContaining("alt", "обои");

            ProductData maxidom_prDt;
            dbRef = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference("maxidom_oboi");
            String maxOboiHashCode;
            //Log.i("RABOTYAGA", "MAXIDOM");
            for (int i = 0; i < max_names.size(); i++) {
                maxOboiHashCode = "max_oboi_" + (i + 1);
                try {
                    maxidom_prDt = new ProductData(
                            dbRef.getKey(), maxOboiHashCode,
                            max_names.get(i).text(),
                            "Description",
                            Float.parseFloat(max_prices.get(i)
                                    .text()
                                    .replaceAll(" ", "")
                                    .replace("-", "")
                                    .replace(".", "")
                                    .replace(",", "")),
                            "Metadata2", "Metadata3",
                            "ImageLink", "ImagePath",
                            1,
                            5,
                            1,
                            true,
                            "Oboi");

                    //Log.i("RABOTYAGA", max_image.get(i).absUrl("src"));
                    Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());

                    dbRef.push().setValue(maxidom_prDt);

                } catch (Exception e) {
                    maxidom_prDt = new ProductData(
                            "",
                            "error",
                            "error",
                            "error",
                            0,
                            "error", "error",
                            "error", "error",
                            0, 0, 0,
                            false,
                            "error");

                    Log.i("RABOTYAGA", "maxidom oboi ne rabotaet");
                    e.printStackTrace();
                }
            }
        }
        public void parseMaxidomLaminat(String url) {
            Parsing.Maxidom.MaxiParser p = new Parsing.Maxidom.MaxiParser(url);

            Document max_doc = p.getDocument();
            if (max_doc == null) {
                return;
            }

            Elements max_names = max_doc.getElementsByClass("name-big");
            Elements max_prices = max_doc.getElementsByAttribute("data-repid_price");

            ProductData maxidom_prDt;
            dbRef = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference("maxidom-laminat");
            String maxOboiHashCode;
            float aboba_price;
            for (int i = 0; i < max_names.size(); i++) {
                maxOboiHashCode = "max_laminat_" + (i + 1);
                try {
                    aboba_price = Float.parseFloat(max_prices.get(i)
                            .attr("data-repid_price")
                            .replaceAll(" ", "")
                            .replace("-", "")
                            .replace(".", "")
                            .replace(",", ""));

                    maxidom_prDt = new ProductData(
                            dbRef.getKey(), maxOboiHashCode,
                            max_names.get(i).text(),
                            "Description",
                            aboba_price,
                            "Metadata2", "Metadata3",
                            "ImageLink", "ImagePath",
                            1,
                            5,
                            1,
                            true,
                            "Laminat");

                    Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                    dbRef.push().setValue(maxidom_prDt);


                } catch (Exception e) {
                    maxidom_prDt = new ProductData(
                            "",
                            "error",
                            "error",
                            "error",
                            0,
                            "error", "error",
                            "error", "error",
                            0, 0, 0,
                            false,
                            "error");


                    Log.i("RABOTYAGA", "maxidom laminat ne rabotaet");
                    e.printStackTrace();
                }
            }
        }
        public void parseMaxidomPlitka(String url) {

            Parsing.Maxidom.MaxiParser p = new Parsing.Maxidom.MaxiParser(url);

            Document max_doc = p.getDocument();
            if (max_doc == null) {
                return;
            }

            Elements max_names = max_doc.getElementsByClass("name-big");
            Elements max_prices = max_doc.getElementsByAttribute("data-repid_price");
            //Elements max_image = max_doc.getElementsByAttributeValueContaining("alt", "обои");

            ProductData maxidom_prDt;
            dbRef = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference("maxidom-plitka");
            String maxOboiHashCode;
            float aboba_price;
            //Log.i("RABOTYAGA", "MAXIDOM");
            for (int i = 0; i < max_names.size(); i++) {
                maxOboiHashCode = "max_plitka_" + (i + 1);
                try {
                    aboba_price = Float.parseFloat(max_prices.get(i)
                            .attr("data-repid_price")
                            .replaceAll(" ", "")
                            .replace("-", "")
                            .replace(".", "")
                            .replace(",", ""));

                    maxidom_prDt = new ProductData(
                            dbRef.getKey(), maxOboiHashCode,
                            max_names.get(i).text(),
                            "Description",
                            aboba_price,
                            "Metadata2", "Metadata3",
                            "ImageLink", "ImagePath",
                            1,
                            5,
                            1,
                            true,
                            "Plitka");

                    Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                    dbRef.push().setValue(maxidom_prDt);


                } catch (Exception e) {
                    maxidom_prDt = new ProductData(
                            "",
                            "error",
                            "error",
                            "error",
                            0,
                            "error", "error",
                            "error", "error",
                            0, 0, 0,
                            false,
                            "error");


                    Log.i("RABOTYAGA", "maxidom plitka ne rabotaet");
                    e.printStackTrace();
                }
            }
        }
        public void parseMaxidomDveri(String url) {

            Parsing.Maxidom.MaxiParser p = new Parsing.Maxidom.MaxiParser(url);

            Document max_doc = p.getDocument();
            if (max_doc == null) {
                return;
            }

            Elements max_names = max_doc.getElementsByClass("name-big");
            Elements max_prices = max_doc.getElementsByAttribute("data-repid_price");
            //Elements max_image = max_doc.getElementsByAttributeValueContaining("alt", "обои");

            ProductData maxidom_prDt;
            dbRef = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference("maxidom-dveri");
            String maxOboiHashCode;
            float aboba_price;
            //Log.i("RABOTYAGA", "MAXIDOM");
            for (int i = 0; i < max_names.size(); i++) {
                maxOboiHashCode = "max_dveri_" + (i + 1);
                try {
                    aboba_price = Float.parseFloat(max_prices.get(i)
                            .attr("data-repid_price")
                            .replaceAll(" ", "")
                            .replace("-", "")
                            .replace(".", "")
                            .replace(",", ""));

                    maxidom_prDt = new ProductData(
                            dbRef.getKey(), maxOboiHashCode,
                            max_names.get(i).text(),
                            "Description",
                            aboba_price,
                            "Metadata2", "Metadata3",
                            "ImageLink", "ImagePath",
                            1,
                            5,
                            1,
                            true,
                            "Dveri");

                    Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                    dbRef.push().setValue(maxidom_prDt);


                } catch (Exception e) {
                    maxidom_prDt = new ProductData(
                            "",
                            "error",
                            "error",
                            "error",
                            0,
                            "error", "error",
                            "error", "error",
                            0, 0, 0,
                            false,
                            "error");


                    Log.i("RABOTYAGA", "maxidom dveri ne rabotaet");
                    e.printStackTrace();
                }
            }
        }
        public void parseMaxidomPotPlitka(String url) {

            Parsing.Maxidom.MaxiParser p = new Parsing.Maxidom.MaxiParser(url);

            Document max_doc = p.getDocument();
            if (max_doc == null) {
                return;
            }

            Elements max_names = max_doc.getElementsByClass("name-big");
            Elements max_prices = max_doc.getElementsByAttribute("data-repid_price");
            //Elements max_image = max_doc.getElementsByAttributeValueContaining("alt", "обои");

            ProductData maxidom_prDt;
            dbRef = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference("maxidom-pot-plitka");
            String maxOboiHashCode;
            float aboba_price;
            //Log.i("RABOTYAGA", "MAXIDOM");
            for (int i = 0; i < max_names.size(); i++) {
                maxOboiHashCode = "max_pot_plitka_" + (i + 1);
                try {
                    aboba_price = Float.parseFloat(max_prices.get(i)
                            .attr("data-repid_price")
                            .replaceAll(" ", "")
                            .replace("-", "")
                            .replace(".", "")
                            .replace(",", ""));

                    maxidom_prDt = new ProductData(
                            dbRef.getKey(), maxOboiHashCode,
                            max_names.get(i).text(),
                            "Description",
                            aboba_price,
                            "Metadata2", "Metadata3",
                            "ImageLink", "ImagePath",
                            1,
                            5,
                            1,
                            true,
                            "Potolochnaya plitka");

                    Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                    dbRef.push().setValue(maxidom_prDt);


                } catch (Exception e) {
                    maxidom_prDt = new ProductData(
                            "",
                            "error",
                            "error",
                            "error",
                            0,
                            "error", "error",
                            "error", "error",
                            0, 0, 0,
                            false,
                            "error");


                    Log.i("RABOTYAGA", "maxidom pot plitka ne rabotaet");
                    e.printStackTrace();
                }
            }
        }
        public void parseMaxidomShtory(String url) {

            Parsing.Maxidom.MaxiParser p = new Parsing.Maxidom.MaxiParser(url);

            Document max_doc = p.getDocument();
            if (max_doc == null) {
                return;
            }

            Elements max_names = max_doc.getElementsByClass("name-big");
            Elements max_prices = max_doc.getElementsByAttribute("data-repid_price");
            //Elements max_image = max_doc.getElementsByAttributeValueContaining("alt", "обои");

            ProductData maxidom_prDt;
            dbRef = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference("maxidom-shtory");
            String maxOboiHashCode;
            float aboba_price;
            //Log.i("RABOTYAGA", "MAXIDOM");
            for (int i = 0; i < max_names.size(); i++) {
                maxOboiHashCode = "max_shtory_" + (i + 1);
                try {
                    aboba_price = Float.parseFloat(max_prices.get(i)
                            .attr("data-repid_price")
                            .replaceAll(" ", "")
                            .replace("-", "")
                            .replace(".", "")
                            .replace(",", ""));

                    maxidom_prDt = new ProductData(
                            dbRef.getKey(), maxOboiHashCode,
                            max_names.get(i).text(),
                            "Description",
                            aboba_price,
                            "Metadata2", "Metadata3",
                            "ImageLink", "ImagePath",
                            1,
                            5,
                            1,
                            true,
                            "Shtory");

                    Log.i("RABOTYAGA", "MAXIDOM " + max_names.get(i).text());
                    dbRef.push().setValue(maxidom_prDt);


                } catch (Exception e) {
                    maxidom_prDt = new ProductData(
                            "",
                            "error",
                            "error",
                            "error",
                            0,
                            "error", "error",
                            "error", "error",
                            0, 0, 0,
                            false,
                            "error");


                    Log.i("RABOTYAGA", "maxidom shtory ne rabotaet");
                    e.printStackTrace();
                }
            }
        }
    }
}