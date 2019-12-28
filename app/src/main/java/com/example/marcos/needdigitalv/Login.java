package com.example.marcos.needdigitalv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        email=(EditText)findViewById( R.id.email );
        password=(EditText)findViewById( R.id.password );
        login=(Button)findViewById( R.id.login );

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();

                Retrofit retrofit = new Retrofit.Builder().baseUrl( "http://10.0.0.345/php login/" )
                        .addConverterFactory( GsonConverterFactory.create(  ) )
                        .build();

                RequestInterface request = retrofit.create( RequestInterface.class );
                Call<JsonResponse> call =request.login( user_email, user_password );
                Call.enqueue( new Callback<JsonResponse>() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if (response.code()==200){
                            JsonResponse jsonResponse = (JsonResponse) response.body();
                            Toast.makeText( getApplicationContext(),jsonResponse.getResponse().toString(), Toast.LENGTH_SHORT ).show();
                        }
                        else {
                            Toast.makeText( getApplicationContext(),String.valueOf( response.code() ), Toast.LENGTH_SHORT ).show();
                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText( getApplicationContext(), "Error",Toast.LENGTH_SHORT ).show();
                    }
                } );
            }
        } );
    }
}
