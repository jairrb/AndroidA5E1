package br.com.digitalhouse.androida5e1.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.digitalhouse.androida5e1.R;

public class MainActivity extends AppCompatActivity {
    private TextView textViewHello;
    private TextView textViewName;
    private TextView textViewLastName;
    private TextView textViewAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHello = findViewById(R.id.textViewHello);
        textViewName = findViewById(R.id.textViewName);
        textViewLastName = findViewById(R.id.textViewLastName);
        textViewAge = findViewById(R.id.textViewAge);

        if (getIntent() != null && getIntent().getExtras() != null) {

            Bundle bundle = getIntent().getExtras();

            if (bundle.getString("NAME") != null &&
                    bundle.getString("LASTNAME") != null &&
                    bundle.getString("AGE") != null) {
                textViewHello.setText("Olá, " + bundle.getString("NAME") + " seja bem-vindo!");
                textViewName.setText("Nome: " + bundle.getString("NAME"));
                textViewLastName.setText("Sobrenome: " + bundle.getString("LASTNAME"));
                textViewAge.setText("Idade: " + bundle.getString("AGE"));
            }
        }
    }
}
