package id.sch.smktelkom_mlg.tugas1.xirpl2012.formpendaftaranclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class formpendaftaranclub extends AppCompatActivity {

    EditText etNama;
    EditText etTahun;
    Spinner spinner;
    Button bOk;
    TextView tvHasil;
    RadioButton rbL, rbP;
    CheckBox cbT, cbM, cbL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpendaftaranclub);

        etNama = (EditText) findViewById(R.id.textView3);
        etTahun = (EditText) findViewById(R.id.textView6);
        spinner = (Spinner) findViewById(R.id.kota);
        bOk = (Button) findViewById(R.id.button);
        rbL = (RadioButton) findViewById(R.id.rb_male);
        rbP = (RadioButton) findViewById(R.id.rb_female);
        cbT = (CheckBox) findViewById(R.id.checkBox);
        cbM = (CheckBox) findViewById(R.id.checkBox2);
        cbL = (CheckBox) findViewById(R.id.checkBox3);

        tvHasil = (TextView) findViewById(R.id.textView7);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Nama = etNama.getText().toString();
                String Tahun = etTahun.getText().toString();
                String Asal = spinner.getSelectedItem().toString();

                String hsl1 = null;
                if (rbL.isChecked()) {
                    hsl1 = rbL.getText().toString();
                } else if (rbP.isChecked()) {
                    hsl1 = rbL.getText().toString();
                }

                String hsl2 = "Riwayat Kesehatan :\n";
                int startlen = hsl2.length();
                if (cbT.isChecked()) hsl2 += cbT.getText() + "\n";
                if (cbM.isChecked()) hsl2 += cbM.getText() + "\n";
                if (cbL.isChecked()) hsl2 += cbL.getText() + "\n";

                if (hsl2.length() == startlen) hsl2 += "Belum Pernah Memilih";

                tvHasil.setText("Nama :\n" + Nama + "\n\nTahun : \n" + Tahun + "\n\nJenis Kelamim : \n" + hsl1 + "\n\n Asal Kota : \n" + Asal + "\n\n" + hsl2);
            }
        });

        etTahun.setText("");
        etNama.setText("");

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());


        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Harus lebih dari 3 huruf");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Isi tahun lahir anda");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Tahun lahir salah");
            valid = false;
        } else {
            etTahun.setError(null);
        }
        return valid;
    }
}
