package com.estsoft.alertdialogexample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialogMessage(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle( "알림" );
        builder.setIcon( R.mipmap.ic_launcher );
        builder.setMessage( "Hello World" );
        builder.show();
    }

    public void dialogCloseButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle( "알림" );
        builder.setIcon( R.mipmap.ic_launcher );
        builder.setMessage( "Hello World" );
        //builder.setCancelable( true );
        builder.setNegativeButton( "닫기" , null );

        builder.show();
    }

    public void dialogOKCancleButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle( "알림" );
        builder.setIcon( R.mipmap.ic_launcher );
        builder.setMessage( "Hello World" );

        // NegativeButton이 항상 왼쪽에 먼저 나옴
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "YES", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void dialogList(View view){

        final String[] s = getResources().getStringArray( R.array.lists );

        new AlertDialog.Builder( this ).
                setTitle( "선택하세요" ).
                setItems(R.array.lists, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("~~~~~~>", "selected:" + which + ":" + s[which]);
                    }
                }).
                show();
    }

    public void dialogProgress(View view){
        ProgressDialog progressDialog = new ProgressDialog( this );
        progressDialog.setTitle( "처리중" );
        progressDialog.setIcon( android.R.drawable.ic_lock_idle_alarm );
        progressDialog.setMessage( "잠시만 기다려주세요..." );
        progressDialog.show();
    }

    public void dialogSingleChoice(View view){
        new AlertDialog.Builder( this ).
                setIcon( android.R.drawable.ic_dialog_info ).
                setTitle( "Single Choice" ).
                setSingleChoiceItems(R.array.lists, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("--->", ""+which);
                    }
                }).
                show();
    }

    public void dialogMultipleChoice(View view){
        new AlertDialog.Builder( this ).
                setIcon( android.R.drawable.ic_dialog_info ).
                setTitle( "Multiple Choice" ).
                setMultiChoiceItems(R.array.lists, new boolean[]{true, false, true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.d("--->",which+"");
                    }
                }).
                show();
    }

    public void dialogCustomLayout(View view){
        LayoutInflater inflater = getLayoutInflater();
        final View customView = inflater.inflate( R.layout.dialog_custom, null);      // 다른 linearLayout이 있으면 그 layout을 넣겠다. 없으면 root

        new AlertDialog.Builder( this ).
                setTitle( "Custom Layout Dialog" ).
                setView( customView ).
                setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView tv = (TextView)customView.findViewById( R.id.password );
                        String password = tv.getText().toString();
                        Log.d("--->",password);
                    }
                }).
                show();

    }

}
