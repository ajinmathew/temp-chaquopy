package com.ajinmathew.json_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class PortSocket extends AppCompatActivity {

    EditText ed1;
    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port_socket);

        ed1 = (EditText) findViewById(R.id.hostPortSocket);
        btn = (Button) findViewById(R.id.scanPortSocket);
        txt = (TextView) findViewById(R.id.opPortSocket);

        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject pyObject = py.getModule("threadport");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inpHost = ed1.getText().toString().trim();
                //String inpPort = ed2.getText().toString().trim();

                PyObject pyObj = pyObject.callAttr("main",inpHost);

                txt.setText(pyObj.toString());
                Toast.makeText(getApplicationContext(), pyObj.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}