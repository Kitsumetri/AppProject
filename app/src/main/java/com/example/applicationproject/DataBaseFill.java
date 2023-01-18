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
        ObiParse(obw);

        Parsing.Maxidom max_parsing = parsing.new Maxidom();
        Parsing.Maxidom.MaxidomWallpaper mw = max_parsing.new MaxidomWallpaper();
        MaxidomParse(mw); */

        Parsing.Order ord_parsing = parsing.new Order();
        Parsing.Order.OrderWallpaper orw = ord_parsing.new OrderWallpaper();
        OrdParse(orw);
    }

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
        } */
        //obj.parseWallpaper((wallpapers_url + 2));
    }

    private void MaxidomParse(Parsing.Maxidom.MaxidomWallpaper obj) {
        String wallpapers_url = "https://www.maxidom.ru/catalog/oboi/?amount=12&PAGEN_3=";
        String laminat_url = "https://www.maxidom.ru/catalog/laminat/?amount=12&PAGEN_3=";
        for (int i =0; i < 99; i++){
            obj.parseMaxidomWallpaper(wallpapers_url + i);
            obj.parseMaxidomLaminat(laminat_url + i);
            //Log.i("RABOTYAGA", String.valueOf(i));
        }
    }

    private void OrdParse(Parsing.Order.OrderWallpaper obj) {
        String wallpapers_url = "https://order-nn.ru/kmo/catalog/6316/?PAGEN_1=";
        //String laminat_url = "https://www.maxidom.ru/catalog/laminat/?amount=12&PAGEN_3=";
        for (int i =0; i < 80; i++){
            obj.parseOrderWallpaper(wallpapers_url + i);
            //obj.parseMaxidomLaminat(laminat_url + i);
            //Log.i("RABOTYAGA", String.valueOf(i));
        }
    }
}

