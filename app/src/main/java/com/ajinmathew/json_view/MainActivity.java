package com.ajinmathew.json_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button btnView,btnPortSocket,btnPortSan,btnBanner,btnSubEnum,btnVuln,btnTech,btnUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnView=(Button) findViewById(R.id.view);
        btnPortSan=(Button) findViewById(R.id.scapy);
        btnBanner=(Button) findViewById(R.id.banner);
        btnSubEnum=(Button) findViewById(R.id.subenum);
        btnPortSocket=(Button) findViewById(R.id.portScan);
        btnVuln=(Button) findViewById(R.id.vuln);
        btnTech=(Button) findViewById(R.id.techMain);
        btnUrl=(Button) findViewById(R.id.urlMain);

        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject pyObject = py.getModule("main");
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String n1 = ed1.getText().toString().trim();
                //String n2 = ed2.getText().toString().trim();
                //domainList = new ArrayList<>();
                PyObject pyObj = pyObject.callAttr("main");
                //returned data is converted as String array...
                //String[] n = pyObject.callAttr("main",domainname).toJava(String[].class);
                //Toast.makeText(getApplicationContext(),n.getClass().getSimpleName() , Toast.LENGTH_LONG).show();
                //converting the string array into ArrayList i.e used in the adapter...
                //for (String in : n){
                //    domainList.add(new Domain(in));

                Toast.makeText(getApplicationContext(), pyObj.toString(), Toast.LENGTH_LONG).show();
            }
            //setAdapter();
        });


        btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),BannerGrabScan.class));
            }
        });

        btnSubEnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),subenum_socket_thread.class));
            }
        });

        btnPortSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ScapyScan.class));
            }
        });
        btnPortSocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PortSocket.class));
            }
        });
        btnVuln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),VulnLister.class));
            }
        });
        btnTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Tech.class));
            }
        });
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Tech.class));
            }
        });
    }
}