package com.example.applicationproject;

import static com.example.applicationproject.Parser.obiOboiHashCode;
import static com.example.applicationproject.Parser.obi_doc;
import static com.example.applicationproject.Parser.obi_isSuccesfullyAddedToDataBase;
import static com.example.applicationproject.Parser.obi_names;
import static com.example.applicationproject.Parser.obi_oboi_count;
import static com.example.applicationproject.Parser.obi_oboi_prDt_main;
import static com.example.applicationproject.Parser.obi_prices;
import static com.example.applicationproject.Parser.obi_ratings;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.applicationproject.databinding.ActivityMainBinding;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        com.example.applicationproject.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Parser p = new Parser();
        p.execute();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        ProductData obi_oboi_prDt_help;
        obi_oboi_prDt_main = new CalcDataBase(MainActivity.this);
        for (int i = 0; i < obi_oboi_count; i++) {
            try{
                obi_oboi_prDt_help = new ProductData(i + 1, obiOboiHashCode, obi_names.get(i).text(), "Description", Float.valueOf(obi_prices.get(i).text().replaceAll(" ", "").replace("₽", "").replace(",", ".")), "Metadata2", "Metadata3", "ImageLink", "ImagePath", 1, Float.valueOf(obi_ratings.get(i).text().replace("(", "").replace(")", "")), 1, true, "Oboi");
                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
                Log.i("OBI", String.valueOf(obi_isSuccesfullyAddedToDataBase));
            } catch (Exception e){
                obi_oboi_prDt_help = new ProductData(-1, "error", "error", "error", 0, "error", "error", "error", "error", 0, 0, 0, false, "error");
                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
                Log.i("OBI", String.valueOf(obi_isSuccesfullyAddedToDataBase));
            }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
