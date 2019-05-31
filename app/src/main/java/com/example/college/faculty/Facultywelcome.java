package com.example.college.faculty;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.college.Dev;
import com.example.college.R;
import com.example.college.Rateus;
import com.example.college.Student.Demo;
import com.example.college.Student.Studentwelcome;
import com.example.college.Welcome;
import com.example.college.facgridview.Facproifile;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class Facultywelcome extends AppCompatActivity {
    Context context;
    SharedPreferences sharedPreferences;
    Drawer.Result navigationdrawerleft;
    AccountHeader.Result headerNavigationLeft;
    ViewFlipper viewFlipper;
    int images[]={R.drawable.flip,R.drawable.newflipp,R.drawable.newflippp,R.drawable.flipppp,R.drawable.newflip,R.drawable.newflipppp};
    public static ArrayList<String> divisions;
    public static Activity activity;
    ArrayList<String> basicFields;
    GridView gridView;
    FacimageAdapter facimageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultywelcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewFlipper=(ViewFlipper)findViewById(R.id.v_flipper);
        for(int i=0;i<images.length;i++)
        {
            flipperimage(images[i]);

        }
        basicFields = new ArrayList<>();
        divisions = new ArrayList<>();

        context=getApplicationContext();
        sharedPreferences=context.getSharedPreferences("MYPREF",MODE_PRIVATE);
        String tid=sharedPreferences.getString("Tid",null);

        headerNavigationLeft=new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false).withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.primary)
                .addProfiles(
                        new ProfileDrawerItem().withName(tid).withEmail("").withIcon(getResources().getDrawable(R.drawable.userprofile))
                ).build();
        navigationdrawerleft=new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .build();
        navigationdrawerleft.addItem(new ProfileDrawerItem().withName("Home").withIcon(getResources().getDrawable(R.drawable.home)));
        navigationdrawerleft.addItem(new ProfileDrawerItem().withName("My Profile").withIcon(getResources().getDrawable(R.drawable.profileicon)));
        navigationdrawerleft.addItem(new ProfileDrawerItem().withName("About Us").withIcon(getResources().getDrawable(R.drawable.abt)));
        navigationdrawerleft.addItem(new ProfileDrawerItem().withName("Share").withIcon(getResources().getDrawable(R.drawable.share)));
        navigationdrawerleft.addItem(new ProfileDrawerItem().withName("Rate Us").withIcon(getResources().getDrawable(R.drawable.ic_star_half_black_24dp)));
        navigationdrawerleft.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                switch (position)
                {
                    case 0:
                        Toast.makeText(Facultywelcome.this, "Loading Home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(Facultywelcome.this, "Loading Profile", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Facultywelcome.this, Facproifile.class));
                        break;

                    case 2:
                        Toast.makeText(Facultywelcome.this, "Loading About Developers", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Facultywelcome.this, Dev.class));
                        break;
                    case 3:
                        Toast.makeText(Facultywelcome.this, "Share with", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        String shareBody="College Application";
                        String shareSub="This app is a JNCT college property. ";
                        i.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                        i.putExtra(Intent.EXTRA_TEXT,shareSub);
                        startActivity(Intent.createChooser(i,"share using"));
                        break;
                    case 4:
                        Toast.makeText(Facultywelcome.this, "Rate Us", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Facultywelcome.this, Rateus.class));

                        break;
                    default:
                        break;

                }
            }
        });


        context=getApplicationContext();
        facimageAdapter=new FacimageAdapter(context);
        gridView=(GridView)findViewById(R.id.Gridview1);
        gridView.setAdapter(facimageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Facultywelcome.this, Facimageshow.class);
                intent.putExtra("Id",facimageAdapter.imageid[position]);
                intent.putExtra("Index",position);
                startActivity(intent);
            }
        });




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Loading Notification and ", Snackbar.LENGTH_LONG)
                  //      .setAction("wait", null).show();
                Toast.makeText(getApplicationContext(),"Student Question's",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Facultywelcome.this,Studentquery.class));

            }
        });


    }

    private void flipperimage(int image) {

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        AlertDialog.Builder builder;
        builder=new AlertDialog.Builder(this);
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings){
            Toast.makeText(getApplicationContext(),"Loading Settings",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Facultywelcome.this, Demo.class));

        }
        if (id == R.id.action_logout){
            //Toast.makeText(getApplicationContext(),"Loging Out",Toast.LENGTH_LONG).show();
            //startActivity(new Intent(Studentwelcome.this, Welcome.class));

            builder.setTitle("wait").setMessage("Are you sure you want to log out?");
            builder.setCancelable(false);
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    {
                        Toast.makeText(getApplicationContext(), "Loging Out ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Facultywelcome.this, Welcome.class));
                    }
                    //when yes is pressed intent will be execute
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Try something different", Toast.LENGTH_SHORT).show();
                    closeOptionsMenu();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.setTitle("Wait");
            alertDialog.setMessage("Are you sure you want to log out?");
            alertDialog.show();

        }



        return super.onOptionsItemSelected(item);
    }

}

