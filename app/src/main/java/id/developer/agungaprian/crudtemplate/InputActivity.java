package id.developer.agungaprian.crudtemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import id.developer.agungaprian.crudtemplate.models.EntryClass;
import io.realm.Realm;

public class InputActivity extends AppCompatActivity {
    private EditText judul , bahan , instruksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_add) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    judul = (EditText)findViewById(R.id.judul);
                    bahan = (EditText)findViewById(R.id.bahan);
                    instruksi = (EditText)findViewById(R.id.instruksi);

                    //get text from editText
                    String judulMasakan = judul.getText().toString();
                    String bahanMasakan = bahan.getText().toString();
                    String instruksiMasakan = instruksi.getText().toString();

                    Number currentIdNum = realm.where(EntryClass.class).max("id");
                    long idData = 0;
                    if(currentIdNum == null){
                        idData =1;
                    }else {
                        idData = currentIdNum.longValue() + 1;
                    }
                    EntryClass entryClass = new EntryClass();

                    entryClass.setId(idData);
                    entryClass.setJudul(judulMasakan);
                    entryClass.setBahan(bahanMasakan);
                    entryClass.setBahan(instruksiMasakan);

                    realm.insert(entryClass);
                }
            });

            Toast.makeText(this, "Data berhasil di simpan", Toast.LENGTH_SHORT).show();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
