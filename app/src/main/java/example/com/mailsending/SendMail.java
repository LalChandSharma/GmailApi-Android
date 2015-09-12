package example.com.mailsending;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SendMail extends Activity {
    /** Called when the activity is first created. */
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final Button send = (Button) this.findViewById(R.id.send);
        final EditText userid = (EditText) this.findViewById(R.id.userid);
        final EditText password = (EditText) this.findViewById(R.id.password);
//        final EditText from = (EditText) this.findViewById(R.id.from);
        final EditText to = (EditText) this.findViewById(R.id.to);
        final EditText subject = (EditText) this.findViewById(R.id.subject);
        final EditText body = (EditText) this.findViewById(R.id.body);

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GMailSender sender = new GMailSender(userid.getText()
                        .toString(), password.getText().toString());
                try {
                    sender.sendMail(subject.getText().toString(), body
                                    .getText().toString(), userid.getText().toString(),
                            to.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
    }
}
