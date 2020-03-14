package com.example.downloadimge_usingasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button downloadBtn ;
    EditText link_img ;
    ImageView imgView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadBtn=findViewById(R.id.btnDownload);
        link_img =findViewById(R.id.link);
        imgView=findViewById(R.id.imageView);
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AsyncTask task=new AsyncDownload();
            task.execute(link_img.getText().toString());
            }
        });

    }
    Bitmap Download(String uri)
    {
        Bitmap result =null ;
        return result ;
    }
//<data type send , intger progress bar ,result data type>
    //af any thing not sent write Void
     class AsyncDownload extends AsyncTask<String,Void, Bitmap>
    {
        /*at least implement do method
        * take send data as parameter args and return the result
        * */

        @Override
        protected Bitmap doInBackground(String... uris) {
            Bitmap result =null ;
            result=Download(uris[0]);
            // here write lengthy operation or block code EX : downloading image
            return result;
        }
            //here can process the result and show it in img View
        //update UI
        @Override
        protected void onPostExecute(Bitmap img) {
            super.onPostExecute(img);
            imgView.setImageBitmap(img);
            Toast.makeText
                    (MainActivity.this,"Donloaded Sucsessfully ",Toast.LENGTH_LONG).show();
        }
    }
}
