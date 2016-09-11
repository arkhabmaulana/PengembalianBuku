package id.sch.smktelkom_mlg.tugas01.xirpl4007.pengembalianbuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    RadioGroup rgJurusan;
    CheckBox cbEdukasi;
    CheckBox cbMajalah;
    CheckBox cbKomik;
    Spinner spKelas;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        rgJurusan = (RadioGroup) findViewById(R.id.radioGroupJurusan);
        cbEdukasi = (CheckBox) findViewById(R.id.checkBoxEdukasi);
        cbMajalah = (CheckBox) findViewById(R.id.checkBoxMajalah);
        cbKomik = (CheckBox) findViewById(R.id.checkBoxKomik);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }

            private void doClick() {
                String hasil = null;
                String tugas = "";

                String nama = etNama.getText() + " ";
                if (cbEdukasi.isChecked()) {
                    tugas += cbEdukasi.getText() + " ";
                }
                if (cbMajalah.isChecked()) {
                    tugas += cbMajalah.getText() + " ";
                }
                if (cbKomik.isChecked()) {
                    tugas += cbKomik.getText() + " ";
                }
                if (rgJurusan.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = (RadioButton)
                            findViewById(rgJurusan.getCheckedRadioButtonId());
                    hasil = rb.getText().toString();
                    tvHasil.setText("Anda atas nama " + nama + ", kelas" + spKelas.getSelectedItem().toString() + " " + " jurusan "
                            + hasil + " " + " telah mengembalikan buku " + tugas);
                }
            }
        });

    }
}