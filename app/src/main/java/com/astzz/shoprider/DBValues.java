package com.astzz.shoprider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBValues extends SQLiteOpenHelper {

    private static int INT_VERSION = 1;
    private static String DATABASE_NAME = "contact.db";
    //INTEGER PRIMARY KEY AUTOINCREMENT,
    private String CONTACT_TABLE = "CREATE TABLE customer ( contact_id INTEGER PRIMARY KEY AUTOINCREMENT, contact_name TEXT, contact_phone TEXT, contact_email TEXT, contact_address TEXT, contact_age TEXT, contact_cnic TEXT )";
    private String CONTACT_TABLE_TWO = "CREATE TABLE mechanic ( contact_id INTEGER PRIMARY KEY AUTOINCREMENT, contact_name TEXT, contact_phone TEXT, contact_email TEXT, contact_address TEXT, contact_age TEXT, contact_cnic TEXT )";
    private String CONTACT_TABLE_three = "CREATE TABLE supplier ( contact_id INTEGER PRIMARY KEY AUTOINCREMENT, contact_name TEXT, contact_phone TEXT, contact_email TEXT, contact_address TEXT, contact_age TEXT, contact_cnic TEXT )";

    public DBValues(Context context) {
        super(context, DATABASE_NAME, null, INT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CONTACT_TABLE);
        sqLiteDatabase.execSQL(CONTACT_TABLE_TWO);
        sqLiteDatabase.execSQL(CONTACT_TABLE_three);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int AddContactinDB(Contact contact,String my_table) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("contact_name", contact.getContactName());
        values.put("contact_phone", contact.getContactPhone());
        values.put("contact_email", contact.getContactEmail());
        values.put("contact_address", contact.getContactAddress());
        values.put("contact_age", contact.getContactAge());
        values.put("contact_cnic", contact.getContactCNIC());

        long row_id = db.insert(my_table, null, values);

        return (int) row_id;
    }

    public Cursor getContactFromDB(String my_table)
    {
        SQLiteDatabase db = getReadableDatabase();

        String[] values = {"contact_id", "contact_name", "contact_phone", "contact_email", "contact_address", "contact_age", "contact_cnic"};
        String sorting = "contact_name ASC";

        Cursor cursor;
        cursor = db.query(my_table, values, null, null, null, null, sorting);
        return cursor;
    }

    public int editContact(Contact contact,String my_table) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("contact_name", contact.getContactName());
        values.put("contact_phone", contact.getContactPhone());
        values.put("contact_email", contact.getContactEmail());
        values.put("contact_address", contact.getContactAddress());
        values.put("contact_age", contact.getContactAge());
        values.put("contact_cnic", contact.getContactCNIC());

        String selection = "contact_id LIKE ?";
        Log.d("ContactID", "---------------: " + contact.getContactID());
        String[] row_id = {String.valueOf(contact.getContactID())};

        int row_num = db.update(my_table, values, selection, row_id);
        return row_num;
    }

    public void deleteContact(int contact_id,String my_table) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "contact_id LIKE ?";
        String[] row_id = {String.valueOf(contact_id)};
        db.delete(my_table, selection, row_id);
    }
}
