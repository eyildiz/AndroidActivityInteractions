package ersinyildiz.app.activityinteractions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    EditText numberFirst, numberSecond;
    TextView resultText;

    // Request Code for doing arithmetic operations (custom)
    private final int REQUEST_ARITHMETIC_OPERATION = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        numberFirst= (EditText) findViewById(R.id.etFirstNumber);
        numberSecond = (EditText) findViewById(R.id.etSecondNumber);
        resultText = (TextView) findViewById(R.id.txtActivityResultData);
    }

    public void OnButtonClick(View v){
        int num1 = Integer.valueOf(numberFirst.getText().toString());
        int num2 = Integer.valueOf(numberSecond.getText().toString());

        // Explicit (Açık) Intent
        Intent explicitIntent = new Intent(FirstActivity.this, SecondActivity.class);

        // Push data (Optional)
        explicitIntent.putExtra("Value1",num1);
        explicitIntent.putExtra("Value2",num2);

        startActivityForResult(explicitIntent,REQUEST_ARITHMETIC_OPERATION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ARITHMETIC_OPERATION){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result",0);
                resultText.setText(String.valueOf(result));
            }
        }
    }
}
