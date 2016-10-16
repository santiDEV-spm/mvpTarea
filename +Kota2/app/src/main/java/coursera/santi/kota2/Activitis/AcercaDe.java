package coursera.santi.kota2.Activitis;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import coursera.santi.kota2.R;

public class AcercaDe extends AppCompatActivity {

    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        fab = (FloatingActionButton)findViewById(R.id.fab);


    }

    public void onclikFab(View v){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Gracias por tu apoyo",Snackbar.LENGTH_INDEFINITE).show();
            }
        });
    }
}
