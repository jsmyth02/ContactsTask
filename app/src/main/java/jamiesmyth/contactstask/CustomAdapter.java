package jamiesmyth.contactstask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ContactsStore.Contact>{

    private ArrayList<ContactsStore.Contact> dataSet;
    Context mContext;

    // Set the viewholder up
    private static class ViewHolder
    {
        ImageView imgContactPicture;
        TextView txtFirstName;
        TextView txtSecondName;
        TextView txtAge;
        TextView txtGender;
        TextView txtNotes;
    }

    public CustomAdapter(ArrayList<ContactsStore.Contact> data, Context context) {
        super(context, R.layout.list_view_layout, data);
        this.dataSet = data;
        this.mContext=context;
    }

    // Setup view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContactsStore.Contact contactModel = getItem(position);
        ViewHolder viewHolder;

        // Get views from list view layout
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view_layout, parent, false);
            viewHolder.imgContactPicture = (ImageView) convertView.findViewById(R.id.list_image);
            viewHolder.txtFirstName = (TextView) convertView.findViewById(R.id.FirstName);
            viewHolder.txtSecondName = (TextView) convertView.findViewById(R.id.SecondName);
            viewHolder.txtAge = (TextView) convertView.findViewById(R.id.Age);
            viewHolder.txtGender = (TextView) convertView.findViewById(R.id.Gender);
            viewHolder.txtNotes = (TextView) convertView.findViewById(R.id.Notes);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set data from the data model to correct view from the list_view_layout
        Glide.with(mContext).load(contactModel.getImageUrl()).centerCrop().crossFade().into(viewHolder.imgContactPicture);
        viewHolder.txtFirstName.setText(contactModel.getFirstName());
        viewHolder.txtSecondName.setText(contactModel.getLastName());
        viewHolder.txtAge.setText(Integer.toString(contactModel.getAge()));
        viewHolder.txtGender.setText(contactModel.getSex());
        viewHolder.txtNotes.setText(contactModel.getNotes());
        return convertView;
    }



}
