package com.feizai.mydialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.feizai.mydialog.view.CustomDialog;

public class MainActivity extends AppCompatActivity {

    private CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.aa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog == null) {
                    dialog = CustomDialog.getInstance(MainActivity.this);
                }
                dialog.setTitle("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                dialog.setContent("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                dialog.setBtnOkText("myoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooook");
                dialog.setBtnCancelText("mycanccccccccccccccccccccccccccccccccccccccccccccccccccccvvvvvvvvel");
                dialog.setOkListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast("myok");
                    }
                });
                dialog.setCancelListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast("mycancel");
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void showToast(CharSequence content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}