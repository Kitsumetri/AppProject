package com.example.applicationproject;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.applicationproject.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        com.example.applicationproject.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        Parser p = new Parser();
        p.execute();

        DataBaseFill db = new DataBaseFill(this);
        db.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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


//class DataBase
//{
//    public void fillDataBase(Context context)
//    {
//        ProductData obi_oboi_prDt_help;
//        obi_oboi_prDt_main = new CalcDataBase(context);
//        int index = -1;
//        for (int i = 0; i < obi_names.size(); i++) {
//            try{
//                obi_oboi_prDt_help = new ProductData(
//                        i + 1, obiOboiHashCode,
//                        obi_names.get(i).text(),
//                        "Description",
//                        Float.parseFloat(obi_prices.get(i)
//                                .text()
//                                .replaceAll(" ", "")
//                                .replace("₽", "")
//                                .replace(",", ".")),
//                        "Metadata2", "Metadata3",
//                        "ImageLink", "ImagePath",
//                        1,
//                        Float.parseFloat(obi_ratings.
//                                get(i)
//                                .text()
//                                .replace("(", "")
//                                .replace(")", "")),
//                        1,
//                        true,
//                        "Oboi");
//                index = index + 2;
//                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
//                Log.i("OBI", obi_image.get(index).absUrl("src"));
//                Log.i("OBI", obi_names.get(i).toString());
//
//            } catch (Exception e){
//                obi_oboi_prDt_help = new ProductData(
//                        -1,
//                        "error",
//                        "error",
//                        "error",
//                        0,
//                        "error", "error",
//                        "error", "error",
//                        0, 0, 0,
//                        false,
//                        "error");
//
//                obi_isSuccesfullyAddedToDataBase = obi_oboi_prDt_main.addOne(obi_oboi_prDt_help);
//                Log.i("OBI", String.valueOf(obi_isSuccesfullyAddedToDataBase));
//            }
//        }
//    }
//}
