package jamiesmyth.contactstask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter adapter;
        ArrayList<ContactsStore.Contact> contactsModel;
        ListView listView;
        ContactsStore.Contact[] contacts;

        listView = (ListView) findViewById(R.id.list);

        // Gets contacts from ContactsStore
        ContactsStore contactsStore = ContactsStore.getStore();
        contacts = contactsStore.getContacts();

       // Creates and populates contacts model
        contactsModel = new ArrayList<>(Arrays.asList(contacts));

        // Sets custom adapter up to be used for the list view
        adapter = new CustomAdapter(contactsModel, getApplicationContext());

        // Sets the adapter to the listview
        listView.setAdapter(adapter);
    }


}
