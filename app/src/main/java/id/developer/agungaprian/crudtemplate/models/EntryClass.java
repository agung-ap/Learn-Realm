package id.developer.agungaprian.crudtemplate.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by agungaprian on 06/07/17.
 */

public class EntryClass extends RealmObject{
    @PrimaryKey
    private long id;
    private String judul;
    private String bahan;
    private String instruksi;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getInstruksi() {
        return instruksi;
    }

    public void setInstruksi(String instruksi) {
        this.instruksi = instruksi;
    }
}
