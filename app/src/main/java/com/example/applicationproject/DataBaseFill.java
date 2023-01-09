package com.example.applicationproject;

import android.content.Context;

public class DataBaseFill implements Runnable {

    private final Context context;

    public DataBaseFill(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Parsing parsing = new Parsing(this.context);

        Parsing.Obi obi_parsing = parsing.new Obi();
        Parsing.Obi.Wallpaper w = obi_parsing.new Wallpaper();
        Parse(w);
    }

    private void Parse(Parsing.Obi.Wallpaper obj) {
        String[] wallpapers_url = {
                "https://clck.ru/33Cjpe", "https://clck.ru/33Cjof", "https://clck.ru/33Cjpn",
                "https://clck.ru/33Cjpz", "https://clck.ru/33Cjq4", "https://clck.ru/33Cjqu",
                "https://clck.ru/33Cjqz"};

        for (String s : wallpapers_url) {
            obj.parseWallpaper(s);
        }
    }
}

