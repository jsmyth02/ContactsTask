package jamiesmyth.contactstask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    ContactsStore.Contact[] contacts;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        // Gets contacts from ContactsStore
        ContactsStore contactsStore = new ContactsStore();
        contacts = contactsStore.getContacts().clone();

        // Sets a new dataModel up
        dataModels = new ArrayList<>();

        // Fills dataModel with data from the contacts[] array
        for (int i = 0; i < contacts.length; i++)
        {
            //dataModels.add(new DataModel(contacts[i].getImageUrl(), contacts[i].getFirstName(), contacts[i].getLastName(), contacts[i].getSex(), Integer.toString(contacts[i].getAge()), contacts[i].getNotes()));
            dataModels.add(new DataModel(contacts[i].getImageUrl(), contacts[i].getFirstName(), contacts[i].getLastName(), contacts[i].getSex(), Integer.toString(contacts[i].getAge()), contacts[i].getNotes()));
        }

        // Sets custom adapter up to be used for the list view
        adapter = new CustomAdapter(dataModels, getApplicationContext());

        // Sets the adapter to the listview
        listView.setAdapter(adapter);
    }
}
