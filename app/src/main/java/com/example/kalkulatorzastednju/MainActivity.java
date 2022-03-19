package com.example.kalkulatorzastednju;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private View btn;
private EditText kamata,period,kes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //uklanja supporBar
        getSupportActionBar().hide();

        kamata=findViewById(R.id.idKamata);
        period=findViewById(R.id.idGodina);
        kes=findViewById(R.id.idStednja);


        //mogli smo putem numberDecimala za provjeru da li je input broj mnogo lakse jer se samo stavi u xml fajl :)
        /* android:inputType="numberDecimal"*/

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //provjera da li je input broj tj ako nije broj da javlja gresku
                if(!TextUtils.isDigitsOnly(kes.getText().toString())){
                    Toast.makeText(MainActivity.this,"Greska unos kesa nije broj.",Toast.LENGTH_SHORT).show();

                }else if(!TextUtils.isDigitsOnly(kamata.getText().toString())){
                    Toast.makeText(MainActivity.this,"Greska unos kamate nije broj.",Toast.LENGTH_SHORT).show();

                }else if(!TextUtils.isDigitsOnly(period.getText().toString())){
                    Toast.makeText(MainActivity.this,"Greska unos godine nije broj.",Toast.LENGTH_SHORT).show();
                }else{
                    //racunica za slozenu kamatnu stopu :)
                double p=Double.parseDouble(kes.getText().toString());
                double r=Double.parseDouble(kamata.getText().toString())/100;
                double t=Double.parseDouble(period.getText().toString());
                double res=p*(1+r*t);

                String rezultat="Vas iznos stednje za "+t+" godina uz kamatnu stopu od "+r+"% ce biti "+res;
                Toast.makeText(MainActivity.this,rezultat,Toast.LENGTH_LONG).show();



            }}
        });



    }

}