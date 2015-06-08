package br.ufpe.cin.if1001.qrscanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void scanNow (View v) {
//        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
//        intent.addCategory(Intent.CATEGORY_DEFAULT);
//        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        startActivityForResult(intent, 0);



        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Aproxime a câmera do código QR");
        integrator.addExtra("SCAN_MODE", "QR_CODE_MODE");
        integrator.setCaptureActivity(CustomCaptureActivity.class);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();

        String params = "QR_CODE_TYPES, QR_CODE";
        integrator.initiateScan();

    }

    @Override

    public void onActivityResult(int requestCode,int resultCode,Intent intent){
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
        if (result != null) {
            String contents=result.getContents();
            if (contents != null) {
                String code = contents.toString();
                Toast.makeText(getApplicationContext(), code,
                        Toast.LENGTH_LONG).show();



            }
//            } else {
//                Toast.makeText(getApplicationContext(), "falhou!",
//                        Toast.LENGTH_LONG).show();
//            }
        }


//        if (resultCode == RESULT_OK) {
//            String code = intent.getStringExtra("SCAN_RESULT");
//            String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
//            // faz o que quiser aqui com o codigo
//            Toast.makeText(getApplicationContext(), (code),
//                        Toast.LENGTH_LONG).show();
//
//        } else if (resultCode == RESULT_CANCELED) {
//            // deu merda
//            Toast.makeText(getApplicationContext(), "ERROR!",
//                    Toast.LENGTH_LONG).show();
//        }

    }

}
