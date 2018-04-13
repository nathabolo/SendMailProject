package com.alterbliss.wganz.sendmailproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //create variables for storing message & button objects
    EditText msgTextField;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make message text field object
        msgTextField = (EditText) findViewById(R.id.msgTextField);
        //make button object
        sendButton = (Button) findViewById(R.id.sendButton);
    }

    //When the send button is clicked
    public void send(View v)
    {

        //get message from message box
        String  msg = msgTextField.getText().toString();

        //check whether the msg empty or not
        if(msg.length()>0) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://localhost:8888/sendMail.php");

            List<BasicNameValuePair> nameValuePairs = new ArrayList<>(200);
            nameValuePairs.add(new BasicNameValuePair("id", "01"));
            nameValuePairs.add(new BasicNameValuePair("message", msg));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpclient.execute(httppost);
            msgTextField.setText(""); //reset the message text field
            Toast.makeText(getBaseContext(),"Sent",Toast.LENGTH_SHORT).show();
        } else {
            //display message if text field is empty
            Toast.makeText(getBaseContext(),"All fields are required", Toast.LENGTH_SHORT).show();
        }

    }

    protected class HttpClient {
        public void execute(HttpPost httppost) {

        }
    }

    private class ClientProtocolException extends Throwable {
    }

    private class BasicNameValuePair {
        public BasicNameValuePair(String id, String s) {

        }
    }

    private class UrlEncodedFormEntity {
        public UrlEncodedFormEntity(List<BasicNameValuePair> nameValuePairs) {

        }
    }

    private class NameValuePair {
    }

    private class DefaultHttpClient extends HttpClient {
    }

    private class HttpPost {
        public HttpPost(String s) {
            s.concat(String.valueOf(msgTextField));

        }

        public void setEntity(UrlEncodedFormEntity urlEncodedFormEntity) {

        }
    }
}
