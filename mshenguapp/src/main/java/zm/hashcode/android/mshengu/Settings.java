package zm.hashcode.android.mshengu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

import zm.hashcode.android.mshengu.R;
import zm.hashcode.android.mshengu.services.TrucksIntentService;


public class Settings extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Button loadTrucksButton=(Button)findViewById(R.id.loadTrucksButton);
        loadTrucksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TrucksIntentService.startActionLoadTrucks(v.getContext());
                DisplayToast("You have clicked the Open button");
            }
        } );

//        Button cancel=(Button) findViewById(R.id.loadTrucksButton);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println( "CLICKED CLICKED ");
//
//            }
//        });

    }

    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}