package co.diana.parcialdianag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private TextView textViewJuli;
    private TextView textViewDe;
    private TextView textViewDigite;
    private EditText editTextPuntaje;
    private Button botonOk;
    private FirebaseDatabase database;
    private Pregunta pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewJuli=findViewById(R.id.textViewJuli);
        textViewDe= findViewById(R.id.textViewDe);
        textViewDigite= findViewById(R.id.textViewDigite);
        editTextPuntaje= findViewById(R.id.editTextPuntaje);
        botonOk= findViewById(R.id.botonOk);

        database= FirebaseDatabase.getInstance();
        database.getReference().child("preguntaactual").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            for (DataSnapshot child:dataSnapshot.getChildren()
                                 ) {
                                pregunta=child.getValue(Pregunta.class);
                                textViewDe.setText(pregunta.getTexto());

                            }
                        }
                        else{
                            textViewDe.setText("No hay pregunta");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );


        botonOk.setOnClickListener(
                (v)->{
                    if(Integer.parseInt(editTextPuntaje.getText().toString())>=0 && Integer.parseInt(editTextPuntaje.getText().toString())<=10 ){

                    Voto voto= new Voto( UUID.randomUUID().toString(),pregunta.getId(),Integer.parseInt(editTextPuntaje.getText().toString()));
                    database.getReference().child("votos/"+voto.getId()).setValue(voto);
                    }


                }
        );
    }


}