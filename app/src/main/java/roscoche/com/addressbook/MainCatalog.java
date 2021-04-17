package roscoche.com.addressbook;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainCatalog extends AppCompatActivity {

    private ListView list;
    private ArrayList<Contact> contactList=new ArrayList<>();
    private ArrayList<String> contactNames=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_catalog);

        list=(ListView) findViewById(R.id.contact_list);

        ArrayAdapter<String> itemlist;

        SqliteUtilities db=new SqliteUtilities(this);
        //db.droptables();
        //db.upgradetable();
        String sql = "SELECT contactID, firstName, lastName,phoneNumber,email,address1,address2,city,state,zip,country FROM addressbook ORDER BY lastName;";
        Cursor cursor = db.getResultSet(sql);
        while(cursor.moveToNext()){
            Contact contact = new Contact(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10));
            contactList.add(contact);
            contactNames.add(contact.simpleList());
        }
        itemlist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,contactNames);
        list.setAdapter(itemlist);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = contactList.get(position);
                String selectedContactID = selectedContact.getContactID();
                editContact(findViewById(android.R.id.content), selectedContact);
                //Toast.makeText(getApplicationContext(), selectedContactID, Toast.LENGTH_LONG).show();
            }
        });
        db.close();
    }
    public void addNewContact(View view){
        Intent intent = new Intent(MainCatalog.this, NewContact.class);
        MainCatalog.this.startActivity(intent);
    }
    public void editContact(View view,Contact selectedcontact){
        Intent intent = new Intent(MainCatalog.this, ViewEditContact.class);
        intent.putExtra("contactID",selectedcontact.getContactID());
        intent.putExtra("firstName",selectedcontact.getFirstName());
        intent.putExtra("lastName",selectedcontact.getLastName());
        intent.putExtra("phoneNumber",selectedcontact.getPhonenumber());
        intent.putExtra("email",selectedcontact.getEmail());
        intent.putExtra("address1",selectedcontact.getAddress1());
        intent.putExtra("address2",selectedcontact.getAddress2());
        intent.putExtra("city",selectedcontact.getCity());
        intent.putExtra("state",selectedcontact.getState());
        intent.putExtra("zip",selectedcontact.getZip());
        intent.putExtra("country",selectedcontact.getCountry());

        MainCatalog.this.startActivity(intent);
    }


}
