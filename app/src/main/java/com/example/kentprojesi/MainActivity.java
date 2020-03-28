package com.example.kentprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//nedenmon create içinde yapıyoruz?

        //apin il açıldığı gibi bi liste görmek istediğimiz için yani açılır açılmaz liste görmek için

        ListView listView=findViewById(R.id.listView);// kent simgelerinin olduğu bi liste tanımlıyoruz
        final ArrayList<String> landmarkNames=new ArrayList<>();//bi dizi tamımlıyoruz ve içine string atıyoruz
        // data da çalışıyoruz
        landmarkNames.add("Pisa");
        landmarkNames.add("Eyfel");
        landmarkNames.add("Collesseo");
        landmarkNames.add("London Bridge");

        final ArrayList<String> countryNames=new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("France");
        countryNames.add("United  Kingdom");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eyfel=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eyfel);
        Bitmap collesseo=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.collesiu);
        Bitmap londonBridge=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.london);


        final ArrayList<Bitmap> landmarkImages=new ArrayList<>();

        landmarkImages.add(pisa);
        landmarkImages.add(eyfel);
        landmarkImages.add(collesseo);
        landmarkImages.add(londonBridge);


        //listViev
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
              //  System.out.println(landmarkNames.get(i));
              //  System.out.println(countryNames.get(i));

                Intent intent=new Intent(getApplicationContext(),detayActivity.class);
                intent.putExtra("name",landmarkNames.get(i));
                intent.putExtra("country",countryNames.get(i));//küçük resimlerde kullanılır

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));


                startActivity(intent);


            }
        });

        //neden lisViev kullanıyoruz?





    }
}


