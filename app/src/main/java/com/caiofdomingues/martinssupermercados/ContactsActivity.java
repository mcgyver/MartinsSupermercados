package com.caiofdomingues.martinssupermercados;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Button startBtn = (Button) findViewById(R.id.sendEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });

    }

    protected void sendEmail(){

        String[] TO = {"caiofelipe502@gmail.com"};
        TextView email = (TextView) findViewById(R.id.email);
        TextView celular = (TextView) findViewById(R.id.celular);
        TextView nome = (TextView) findViewById(R.id.nome);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contato");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email de " + nome.getText() + " Celular " +
                celular.getText() + " email " + email.getText());

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviando Email"));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactsActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
