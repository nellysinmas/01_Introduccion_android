package betanzo.nelly.a01_introduccinaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import betanzo.nelly.a01_introduccinaandroid.modelos.Users;

public class MainActivity extends AppCompatActivity {

    //DEFINIR VARIABLES DE TIPO VISTA Y VARIABLES PARA LA LÓGICA

    //Variables tipo Vista

    private TextView lblContador;
    private Button btnClick;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistrar;

    //Variable para la Lógica

    private int contador;
    private ArrayList<Users> listaUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //ASOCIA ESTE CONTROLADOR CON SU INTERFAZ;

        //Todo code debajo del activity_main!!

        contador=0;
        listaUsers = new ArrayList<>();

        inicializaVistas();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Tu puta madre", Toast.LENGTH_SHORT).show();
                contador ++;
                lblContador.setText(contador+" veces");
                //Context acceso a MainActivity
                //Text texto a mostrar
                //toast. tiempo que va a estar emergente el txt
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                Users users = new Users(email,password);
                listaUsers.add(users);
                Toast.makeText(MainActivity.this, users.toString(), Toast.LENGTH_SHORT).show();
                txtPassword.setText("");
                txtEmail.setText("");
            }
        });


    }

    private void inicializaVistas() {
        lblContador = findViewById(R.id.lblContadorMain);
        btnClick = findViewById(R.id.btnClickMain); //Si esto sale en rojo darle a BUild - Rebuild project
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPaswordMain);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

    public void btnClickContador (View vista){

        contador ++;
        lblContador.setText(contador+" veces");

    }

}