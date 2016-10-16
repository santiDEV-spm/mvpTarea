package coursera.santi.kota2.Activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import coursera.santi.kota2.R;
import coursera.santi.kota2.Sendeemail.SendMail;

public class contacto extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar mytoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);

        Button login=(Button)findViewById(R.id.btn_submit);
        editTextEmail=(EditText)findViewById(R.id.et_to);
        editTextSubject=(EditText)findViewById(R.id.et_sub);
        editTextMessage= (EditText)findViewById(R.id.et_text);

        login.setOnClickListener(this);
    }

    public  void sendEmail(){
        String email = editTextEmail.getText().toString();
        String subject = editTextSubject.getText().toString();
        String message = editTextMessage.getText().toString();

        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
     sendEmail();
    }
}
