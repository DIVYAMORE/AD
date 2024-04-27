package com.example.expt5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity  implements Example_Dialog.ExampleDialogListener{
    Button btn,dialogbtn;
    Dialog mydialog;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.main_toolbar));
        TextView textView = findViewById(R.id.textview);
        textView1 = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView5);
        mydialog = new Dialog(this);
    btn  = findViewById(R.id.button);
    btn.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View v) {
                                   PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn);

                                   // Inflating popup menu from popup_menu.xml file
                                   popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                                   popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                       @Override
                                       public boolean onMenuItemClick(MenuItem menuItem) {
                                           // Toast message on menu item clicked
                                           Toast.makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                           return true;
                                       }
                                   });
                                   // Showing the popup menu
                                   popupMenu.show();
                               }
                           });

    dialogbtn = findViewById(R.id.button2);
    dialogbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Example_Dialog  exampleDialog= new Example_Dialog();
            exampleDialog.show(getSupportFragmentManager(),"example dialog");
        }
    });
        registerForContextMenu(textView);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.optionitem1)
        {
            Toast.makeText(this, "View Profile selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.optionitem2) {
            Toast.makeText(this, "Chat Theme selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.optionitem4) {
            Toast.makeText(this, "New group selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.optionitem3) {
            Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.optionitem5) {
            Toast.makeText(this, "Linked devices selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id==R.id.optionitem6) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
        }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

    inflater.inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
            if(id == R.id.item1)
            {
                Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
                return true;
            }
               else if(id==R.id.item2) {
                Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
                return true;
            }
               else {

                return super.onContextItemSelected(item);
            }
        }

    @Override
    public void applyTexts(String username, String password) {
textView1.setText(username);
textView2.setText(password);
    }
}



