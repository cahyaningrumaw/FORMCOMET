package id.sch.smktelkom_mlg.tugas01.xiirpl1012.formcomet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    RadioButton cowok, cewek;
    Spinner spkelas;
    CheckBox grammar, vocab, reading, speaking, debating;
    Button button;
    TextView result, jk, req, jumlah, kelas;
    //int jml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNama = (EditText) findViewById(R.id.etNama);
        cowok = (RadioButton) findViewById(R.id.cowok);
        cewek = (RadioButton) findViewById(R.id.cewek);
        jumlah = (TextView) findViewById(R.id.jumlah);

        spkelas = (Spinner) findViewById(R.id.spkelas);
        grammar = (CheckBox) findViewById(R.id.grammar);
        vocab = (CheckBox) findViewById(R.id.vocab);
        reading = (CheckBox) findViewById(R.id.reading);
        speaking = (CheckBox) findViewById(R.id.speaking);
        debating = (CheckBox) findViewById(R.id.debating);

        grammar.setOnCheckedChangeListener(this);
        vocab.setOnCheckedChangeListener(this);
        reading.setOnCheckedChangeListener(this);
        speaking.setOnCheckedChangeListener(this);
        debating.setOnCheckedChangeListener(this);

        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);
        jk = (TextView) findViewById(R.id.jk);
        req = (TextView) findViewById(R.id.req);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                doProcess();
            }

        });
    }

    private void doCheck() {
        String minat = "Your requested competencies :\n";
        //int startlen = minat.length();
        if (grammar.isChecked()) minat += grammar.getText() + "\n";
        if (vocab.isChecked()) minat += vocab.getText() + "\n";
        if (reading.isChecked()) minat += reading.getText() + "\n";
        if (speaking.isChecked()) minat += speaking.getText() + "\n";
        if (debating.isChecked()) minat += debating.getText() + "\n";

        //if(minat.length()==startlen) minat+="Choice is not exist";
        req.setText(minat);
    }

    private void doClick() {
        String gender = null;

        if (cowok.isChecked()) {
            gender = cowok.getText().toString();
        } else {
            gender = cewek.getText().toString();
        }
        jk.setText("You are a " + gender);
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            result.setText("Your name is " + nama);
            doClick();
            //doSpin();
            doCheck();

        }

    }

    private void doSpin() {
        kelas.setText("Your grade is " + spkelas.getSelectedItem().toString());
    }


    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Input your name");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Name must be at least 3 character");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //if(isChecked) jml+=1;
        //else jml-+1;

        //jumlah.setText("Competencies : ("+jml+" are choosen");
    }
}
