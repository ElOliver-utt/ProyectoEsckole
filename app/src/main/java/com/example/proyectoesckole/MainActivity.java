package com.example.proyectoesckole;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.proyectoesckole.iFragments.iFragments;
import com.example.proyectoesckole.cFragments.alumnos;
import com.example.proyectoesckole.cFragments.calificaciones;
import com.example.proyectoesckole.cFragments.contacto;
import com.example.proyectoesckole.cFragments.notificaciones;
import com.example.proyectoesckole.iFragments.iFragments;

public class MainActivity extends AppCompatActivity implements iFragments {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = new  alumnos();
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            boolean ban = false;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);
                    fragment = new alumnos();
                    return ban = true;
                case R.id.navigation_dashboard:
                    //  mTextMessage.setText(R.string.title_dashboard);
                    fragment = new calificaciones();
                    return ban = true;
                case R.id.navigation_notifications:
                    // mTextMessage.setText(R.string.title_notifications);
                    fragment = new notificaciones();
                    return ban = true;

                case R.id.navigation_contact:
                    // mTextMessage.setText("Contacto");
                    fragment = new contacto();
                    return ban = true;
            }

            if (ban)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
