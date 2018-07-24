package cn.chaboshi.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_car_no:
                PlateNumberDialog dialog = new PlateNumberDialog(this);
                dialog.setOnItemSelectedListener(new PlateNumberDialog.OnItemSelectedListener() {
                    @Override
                    public void onSelectedListener(String province) {
                        Toast.makeText(MainActivity.this, province, Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

                break;
        }
    }
}
