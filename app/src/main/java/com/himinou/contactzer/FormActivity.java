package com.himinou.contactzer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FormActivity extends AppCompatActivity {

    CircleImageView profile;
    FloatingActionButton btn_cProfile;
    Button btn_enregistrer;
    //les valeurs de nos champs
    RadioGroup genre;
    EditText nom;
    EditText prenom;
    EditText numero;
    EditText dateNaissance;
    EditText email;
    CheckBox cbFavori;
    ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Les methodes pour gerer notre formulaire
        profile = findViewById(R.id.profile_image);
        btn_cProfile = findViewById(R.id.btn_cProfile);

        btn_cProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(FormActivity.this)
                        .maxResultSize(1080, 10180)
                        .start(20);

            }
        });

        //on associe à nos vues
        btn_enregistrer = findViewById(R.id.btn_enregister);

        //les metthodes pour gerer les entrer
        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom = findViewById(R.id.et_nom);
                prenom = findViewById(R.id.et_prenom);
                numero = findViewById(R.id.et_numero);
                dateNaissance = findViewById(R.id.et_dateNaissance);
                email = findViewById(R.id.et_email);
                genre = findViewById(R.id.rg_genre);

                if(nom.getText().toString().isEmpty()||prenom.getText().toString().isEmpty()||numero.getText().toString().isEmpty()||dateNaissance.getText().toString().isEmpty()||email.getText().toString().isEmpty()){
                    //le petit toast
                    Toast.makeText(FormActivity.this, "Veuillez remplir tous les champs obligatoire", Toast.LENGTH_SHORT).show();
                }else{
                    Contact data = new Contact(nom.getText().toString().trim(), prenom.getText().toString().trim(), numero.getText().toString().trim());
                    contactArrayList.add(data);

                    //on send les data dans MainActivity
                    Intent sendData = new Intent(FormActivity.this,MainActivity.class);
                    sendData.putExtra(MainActivity.contactArrayList,contactArrayList );
                    FormActivity.this.startActivity(sendData);
                    Toast.makeText(FormActivity.this, "Contact Ajouté", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        profile.setImageURI(uri);

    }




}
