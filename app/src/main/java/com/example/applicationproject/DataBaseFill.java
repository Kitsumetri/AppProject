package com.example.applicationproject;

import android.content.Context;
import android.util.Log;

public class DataBaseFill implements Runnable {

    private final Context context;

    public DataBaseFill(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Parsing parsing = new Parsing(this.context);
        /*
        Parsing.Obi obi_parsing = parsing.new Obi();
        Parsing.Obi.ObiWallpaper obw = obi_parsing.new ObiWallpaper();
        ObiParse(obw); */

        Parsing.Maxidom mw = parsing.new Maxidom();
        MaxidomParse(mw);
    }
    /*
    private void ObiParse(Parsing.Obi.ObiWallpaper obj) {
        String[] wallpapers_url = {
                "https://clck.ru/33Cjpe", "https://clck.ru/33Cjof", "https://clck.ru/33Cjpn",
                "https://clck.ru/33Cjpz", "https://clck.ru/33Cjq4", "https://clck.ru/33Cjqu",
                "https://clck.ru/33Cjqz"};

        for (String s : wallpapers_url) {
            obj.parseObiWallpaper(s);
        }
        //String wallpapers_url = "https://obi.ru/vsjo-dlja-doma/oboi/flizelinovye-oboi?page=";
        /* for (int i =0; i <=5; i++){
            obj.parseWallpaper(wallpapers_url + i);
        }
        //obj.parseWallpaper((wallpapers_url + 2));
    } */

    private void MaxidomParse(Parsing.Maxidom obj) {
        String wallpapers_url = "https://www.maxidom.ru/catalog/oboi/?amount=12&PAGEN_3=";
        String laminat_url = "https://www.maxidom.ru/catalog/laminat/?amount=12&PAGEN_3=";
        String plitka_url = "https://www.maxidom.ru/catalog/plitka-napolnaya/";
        String shtory_url = "https://www.maxidom.ru/catalog/shtory/";
        String dveri_url = "https://www.maxidom.ru/catalog/dveri-mezhkomnatnye/";
        String pot_plitka_url = "https://www.maxidom.ru/catalog/plitki-potolochnye/";
        /*for (int i = 1; i < 99; i++){
            obj.parseMaxidomWallpaper(wallpapers_url + i);
            obj.parseMaxidomLaminat(laminat_url + i);
            //Log.i("RABOTYAGA", String.valueOf(i));
        } */
        obj.parseMaxidomWallpaper(wallpapers_url + 1);
        obj.parseMaxidomLaminat(laminat_url + 1);
        obj.parseMaxidomPlitka(plitka_url);
        obj.parseMaxidomShtory(shtory_url);
        obj.parseMaxidomDveri(dveri_url);
        obj.parseMaxidomPotPlitka(pot_plitka_url);
    }
}

