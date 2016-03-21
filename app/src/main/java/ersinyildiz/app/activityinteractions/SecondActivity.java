package ersinyildiz.app.activityinteractions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private int number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        number1 = getIntent().getIntExtra("Value1",0);
        number2 = getIntent().getIntExtra("Value2",0);

    }

    public void OnPlusClicked(View v){
        SetResultAndFinish(number1 + number2);
    }
    public void OnMinusClicked(View v){
        SetResultAndFinish(number1 - number2);
    }
    public void OnCrossClicked(View v){
        SetResultAndFinish(number1 * number2);
    }
    public void OnDivideClicked(View v){
        SetResultAndFinish(number1 / number2);
    }
    public void SetResultAndFinish(int result){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result",result);
        setResult(RESULT_OK,resultIntent);
        finish();
    }
}
