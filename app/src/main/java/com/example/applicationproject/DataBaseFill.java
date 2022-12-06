package com.example.applicationproject;

import static com.example.applicationproject.Parser.obiOboiHashCode;
import static com.example.applicationproject.Parser.obi_image;
import static com.example.applicationproject.Parser.obi_isSuccesfullyAddedToDataBase;
import static com.example.applicationproject.Parser.obi_names;
import static com.example.applicationproject.Parser.obi_oboi_prDt_main;
import static com.example.applicationproject.Parser.obi_prices;
import static com.example.applicationproject.Parser.obi_ratings;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


public class DataBaseFill extends AsyncTask<Void, Void, Void> {

    private final Context context;


    DataBaseFill(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        ProductData obi_oboi_prDt_help;
        obi_oboi_prDt_main = new CalcDataBase(this.context);
        int index = -1;
        for (int i = 0; i < obi_names.size(); i++) {
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
                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
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

                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
                Log.i("OBI", String.valueOf(obi_isSuccesfullyAddedToDataBase));
            }
        }
        return null;
    }
}