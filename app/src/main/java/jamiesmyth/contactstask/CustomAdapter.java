package jamiesmyth.contactstask;

import android.app.VoiceInteractor;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by user on 01/06/2017.
 */
public class CustomAdapter extends ArrayAdapter<DataModel>{

    private ArrayList<DataModel> dataSet;
    Context mContext;
    private int lastPosition = -1;

    // Set the viewholder up
    private static class ViewHolder
    {
        ImageView imgThumbnail;
        TextView txtFirstName;
        TextView txtSecondName;
        TextView txtAge;
        TextView txtGender;
        TextView txtNotes;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.list_view_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }

    // Setup view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DataModel dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        // Get views from list view layout
        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view_layout, parent, false);
            viewHolder.imgThumbnail = (ImageView) convertView.findViewById(R.id.list_image);
            viewHolder.txtFirstName = (TextView) convertView.findViewById(R.id.FirstName);
            viewHolder.txtSecondName = (TextView) convertView.findViewById(R.id.SecondName);
            viewHolder.txtAge = (TextView) convertView.findViewById(R.id.Age);
            viewHolder.txtGender = (TextView) convertView.findViewById(R.id.Gender);
            viewHolder.txtNotes = (TextView) convertView.findViewById(R.id.Notes);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        // Set data from the data model to correct view from the list_view_layout
        new DownloadImageTask((ImageView) convertView.findViewById(R.id.list_image)).execute(dataModel.getImageURL());
        viewHolder.txtFirstName.setText(dataModel.getFirstName());
        viewHolder.txtSecondName.setText(dataModel.getSecondName());
        viewHolder.txtAge.setText(dataModel.getAge());
        viewHolder.txtGender.setText(dataModel.getGender());
        viewHolder.txtNotes.setText(dataModel.getNotes());
        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>
    {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmapImage = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                bitmapImage = BitmapFactory.decodeStream(in); // <----- Currently returning NULL
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmapImage;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

//    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
//        int width = bm.getWidth();
//        int height = bm.getHeight();
//        float scaleWidth = ((float) newWidth) / width;
//        float scaleHeight = ((float) newHeight) / height;
//        // CREATE A MATRIX FOR THE MANIPULATION
//        Matrix matrix = new Matrix();
//        // RESIZE THE BIT MAP
//        matrix.postScale(scaleWidth, scaleHeight);
//
//        // "RECREATE" THE NEW BITMAP
//        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
//                matrix, false);
//
//        return resizedBitmap;
//    }

}
