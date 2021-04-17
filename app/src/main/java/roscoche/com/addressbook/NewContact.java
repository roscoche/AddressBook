package roscoche.com.addressbook;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.UUID;

public class NewContact extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
    }

    public void saveContact(View view){
        SqliteUtilities db=new SqliteUtilities(this);
        //db.droptables();
        //db.upgradetable();
        //db=new SqliteUtilities(this);
        ContentValues cv = new ContentValues();
        TextView tvfn=(TextView) findViewById(R.id.newFirstName);
        TextView tvln=(TextView) findViewById(R.id.newLastName);
        TextView tvpn=(TextView) findViewById(R.id.newPhoneNumber);
        TextView tve=(TextView) findViewById(R.id.newEmail);
        TextView tva1=(TextView) findViewById(R.id.newAddress1);
        TextView tva2=(TextView) findViewById(R.id.newAddress2);
        TextView tvcity=(TextView) findViewById(R.id.newCity);
        TextView tvstate=(TextView) findViewById(R.id.newState);
        TextView tvzip=(TextView) findViewById(R.id.newZip);
        TextView tvcountry=(TextView) findViewById(R.id.newCountry);


        Contact contact=new Contact(UUID.randomUUID().toString(),
                tvfn.getText().toString(),tvln.getText().toString(),
                tvpn.getText().toString(),tve.getText().toString(),
                tva1.getText().toString(),tva2.getText().toString(),
                tvcity.getText().toString(),tvstate.getText().toString(),
                tvzip.getText().toString(),tvcountry.getText().toString()
        );
        Log.d("CONTATO",contact.toString());
        cv.put("contactID", contact.getContactID());
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
        db.insertRecord("addressbook", cv);
        db.close();
        Intent intent = new Intent(NewContact.this, MainCatalog.class);
        NewContact.this.startActivity(intent);
    }
}
