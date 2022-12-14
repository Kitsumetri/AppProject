package com.example.applicationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CalcDataBase extends SQLiteOpenHelper {

    private static final String PRODUCTS_DATA = "PRODUCTS_DATA";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_HASH_ID = "HASH" + COLUMN_ID;
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    private static final String COLUMN_PRICE = "PRICE";
    private static final String COLUMN_METADATA_2 = "METADATA2";
    private static final String COLUMN_METADATA_3 = "METADATA3";
    private static final String COLUMN_ITEM_SOURCE_LINK = "ITEMSOURCELINK";
    private static final String COLUMN_IMAGE_PATH = "IMAGEPATH";
    private static final String COLUMN_NUMBER_OF_CALLS = "NUMBEROFCALLS";
    private static final String COLUMN_RATING = "RATING";
    private static final String COLUMN_PRIORITY = "PRIORITY";
    private static final String COLUMN_IS_IN_STORE = "ISINSTORE";
    private static final String COLUMN_CATEGORY = "CATEGORY";

    public CalcDataBase(Context context) {
        super(context, "calculatorBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + PRODUCTS_DATA +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_HASH_ID + " STRING, " + COLUMN_NAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_PRICE + " FLOAT, " + COLUMN_METADATA_2 + " STRING, " + COLUMN_METADATA_3 + " STRING, " + COLUMN_ITEM_SOURCE_LINK + " STRING, " + COLUMN_IMAGE_PATH + " STRING, " + COLUMN_NUMBER_OF_CALLS + " INTEGER, " + COLUMN_RATING + " FLOAT, " + COLUMN_PRIORITY + " INTEGER, " + COLUMN_IS_IN_STORE + " BOOLEAN, " + COLUMN_CATEGORY + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(ProductData productData){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HASH_ID, productData.getHashId());
        cv.put(COLUMN_NAME, productData.getName());
        cv.put(COLUMN_DESCRIPTION, productData.getDescription());
        cv.put(COLUMN_PRICE, productData.getPrice());
        cv.put(COLUMN_METADATA_2, productData.getMetaData2());
        cv.put(COLUMN_METADATA_3, productData.getMetaData3());
        cv.put(COLUMN_ITEM_SOURCE_LINK, productData.getItemSourceLink());
        cv.put(COLUMN_IMAGE_PATH, productData.getImagePath());
        cv.put(COLUMN_NUMBER_OF_CALLS, productData.getNumberOfCalls());
        cv.put(COLUMN_RATING, productData.getRating());
        cv.put(COLUMN_PRIORITY, productData.getPriority());
        cv.put(COLUMN_IS_IN_STORE, productData.getIsInStore());
        cv.put(COLUMN_CATEGORY, productData.getCategory());

        long insert = db.insert(PRODUCTS_DATA, null, cv);

        return insert != -1;
    }
}
