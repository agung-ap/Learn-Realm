package id.developer.agungaprian.crudtemplate;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import id.developer.agungaprian.crudtemplate.models.EntryClass;
import io.realm.Realm;
import io.realm.RealmResults;

public class DetailActivity extends AppCompatActivity {
    private TextView judul , bahan , instruksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        long getId = getIntent().getLongExtra("id",0);

        judul = (TextView)findViewById(R.id.judul);
        bahan = (TextView)findViewById(R.id.bahan);
        instruksi = (TextView)findViewById(R.id.instruksi);

        if (getId != 0){
            Realm.init(this);
            Realm realm = Realm.getDefaultInstance();
            EntryClass entryClass = realm.where(EntryClass.class).equalTo("id", getId).findFirst();
            judul.setText(String.valueOf(entryClass.getJudul()));
        }

        //judul.setText(entryClass.getJudul());

    }
}
