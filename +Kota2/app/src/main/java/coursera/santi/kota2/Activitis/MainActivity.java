package coursera.santi.kota2.Activitis;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import coursera.santi.kota2.R;
import coursera.santi.kota2.adapters.PageAdapter;
import coursera.santi.kota2.fragments.PerfilFragment;
import coursera.santi.kota2.fragments.RecyclerFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar         =       (Toolbar)findViewById(R.id.toolbar);
        tabLayout    =      (TabLayout)findViewById(R.id.tabLayout);
        viewPager     =     (ViewPager)findViewById(R.id.viewPager);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

        setUpViewPager();




    }

    public ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment>fragments= new ArrayList<>();

        fragments.add(new RecyclerFragment() );
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public  void setUpViewPager(){

         viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.a_cerca:

                Intent i = new Intent(this,AcercaDe.class);
                startActivity(i);
                break;

            case R.id.contacto:
                Intent intent = new Intent(this,contacto.class);
                startActivity(intent);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
