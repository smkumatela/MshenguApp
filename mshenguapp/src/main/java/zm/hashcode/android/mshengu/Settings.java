package zm.hashcode.android.mshengu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

import zm.hashcode.android.mshengu.R;
import zm.hashcode.android.mshengu.services.TrucksIntentService;


public class Settings extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Button homeButton=(Button)findViewById(R.id.settings_home_button);
        Button loadDataDeviceButton=(Button)findViewById(R.id.settings_load_device_data_Button);
        Button setDeviceData=(Button)findViewById(R.id.settings_set_data_device);
        final TextView setDataStatus = (TextView)findViewById(R.id.settings_set_data_status);
        final TextView loadDataStatus= (TextView)findViewById(R.id.settings_load_data_status);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                TrucksIntentService.startActionLoadTrucks(v.getContext());
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        } );


        loadDataDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoadData.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                loadDataStatus.setText("");


            }
        });

        setDeviceData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SetDevice.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                setDataStatus.setText("");

            }
        });

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
