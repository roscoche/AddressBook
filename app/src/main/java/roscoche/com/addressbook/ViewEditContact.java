package roscoche.com.addressbook;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

public class ViewEditContact extends AppCompatActivity {
    private boolean alreadypressed=false;
    private boolean deleted=false;
    private String contactID;
    private TextView tvfn;
    private TextView tvln;
    private TextView tvpn;
    private TextView tve;
    private TextView tva1;
    private TextView tva2;
    private TextView tvcity;
    private TextView tvstate;
    private TextView tvzip;
    private TextView tvcountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_edit_contact);

        tvfn = (TextView) findViewById(R.id.editFirstName);
        tvln = (TextView) findViewById(R.id.editLastName);
        tvpn = (TextView) findViewById(R.id.editPhoneNumber);
        tve = (TextView) findViewById(R.id.editEmail);
        tva1 = (TextView) findViewById(R.id.editAddress1);
        tva2 = (TextView) findViewById(R.id.editAddress2);
        tvcity = (TextView) findViewById(R.id.editCity);
        tvstate = (TextView) findViewById(R.id.editState);
        tvzip = (TextView) findViewById(R.id.editZip);
        tvcountry = (TextView) findViewById(R.id.editCountry);


        definefields(findViewById(android.R.id.content));
    }
    public void deleteContact(View view){

        if(deleted) {
            SqliteUtilities db = new SqliteUtilities(this);
            String[] args = new String[1];
            args[0] = contactID;
            Log.d("ARGUMENTOS", args[0]);
            Log.d("ARGUMENTOSIZE", "" + args.length);
            db.deleteRecord("addressbook", "contactID=?", args);
            Intent intent = new Intent(ViewEditContact.this, MainCatalog.class);
            ViewEditContact.this.startActivity(intent);
        }
        else{
            Button b=(Button) findViewById(R.id.deleteButton);
            b.setText("Sure?");
            deleted=true;
        }
    }
    public void enableEditContact(View view){
        Intent intent;
        if(alreadypressed){
            SqliteUtilities db=new SqliteUtilities(this);
            ContentValues cv = new ContentValues();
            intent=new Intent();
            Contact contact=new Contact(contactID,
                    tvfn.getText().toString(),tvln.getText().toString(),
                    tvpn.getText().toString(),tve.getText().toString(),
                    tva1.getText().toString(),tva2.getText().toString(),
                    tvcity.getText().toString(),tvstate.getText().toString(),
                    tvzip.getText().toString(),tvcountry.getText().toString()
            );
            Log.d("CONTATO", contact.toString());
            cv.put("firstName", contact.getFirstName());
            cv.put("lastName", contact.getLastName());
            cv.put("phoneNumber", contact.getPhonenumber());
            cv.put("email", contact.getEmail());
            cv.put("address1", contact.getAddress1());
            cv.put("address2", contact.getAddress2());
            cv.put("city", contact.getCity());
            cv.put("state", contact.getState());
            cv.put("zip", contact.getZip());
            cv.put("country", contact.getCountry());
            String[] args=new String[1];
            args[0]=contactID;
            Log.d("ARGUMENTOS",args[0]);
            Log.d("ARGUMENTOSIZE", "" + args.length);
            int i=db.updateRecord("addressbook", cv, "contactID=?",args);

            if (i>0) Log.d("UPDATE", "SUCCESS");
            else Log.d("UPDATE", "FAIL");
            db.close();
            intent = new Intent(ViewEditContact.this, MainCatalog.class);
            ViewEditContact.this.startActivity(intent);
        }
        else {
            Button b = (Button) findViewById(R.id.editButton);
            b.setText("Save");

            tvfn.setEnabled(true);
            tvln.setEnabled(true);
            tvpn.setEnabled(true);
            tve.setEnabled(true);
            tva1.setEnabled(true);
            tva2.setEnabled(true);
            tvcity.setEnabled(true);
            tvstate.setEnabled(true);
            tvzip.setEnabled(true);
            tvcountry.setEnabled(true);
            alreadypressed=true;
        }


    }
    public void definefields(View view){
        Intent intent = getIntent();
        contactID=intent.getStringExtra("contactID");

        tvfn.setText(intent.getStringExtra("firstName"));
        tvln.setText(intent.getStringExtra("lastName"));
        tvpn.setText(intent.getStringExtra("phoneNumber"));
        tve.setText(intent.getStringExtra("email"));
        tva1.setText(intent.getStringExtra("address1"));
        tva2.setText(intent.getStringExtra("address2"));
        tvcity.setText(intent.getStringExtra("city"));
        tvstate.setText(intent.getStringExtra("state"));
        tvzip.setText(intent.getStringExtra("zip"));
        tvcountry.setText(intent.getStringExtra("country"));
        tvfn.setTextColor(Color.BLACK);
        tvln.setTextColor(Color.BLACK);
        tvpn.setTextColor(Color.BLACK);
        tve.setTextColor(Color.BLACK);
        tva1.setTextColor(Color.BLACK);
        tva2.setTextColor(Color.BLACK);
        tvcity.setTextColor(Color.BLACK);
        tvstate.setTextColor(Color.BLACK);
        tvzip.setTextColor(Color.BLACK);
        tvcountry.setTextColor(Color.BLACK);



    }
}
