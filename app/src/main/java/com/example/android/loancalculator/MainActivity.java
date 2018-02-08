package com.example.android.loancalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText costView;
    private EditText paymentView;
    private EditText aprView;
    private TextView outputPayment;
    private TextView barLabel;
    private SeekBar seekBar;
    private RadioButton radioLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        costView=findViewById(R.id.costView);
        paymentView=findViewById(R.id.paymentView);
        aprView=findViewById(R.id.aprView);
        outputPayment=findViewById(R.id.outputPayment);
        barLabel=findViewById(R.id.barLabel);
        seekBar=findViewById(R.id.seekBar);
        radioLoan=findViewById(R.id.radioLoan);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        barLabel.setText("Length of Loan (months): "+i+"");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    public void buttonPressed(View v) {
        String inputcost=costView.getText().toString();
        double cost=Double.parseDouble(inputcost);

        String inputpayment=paymentView.getText().toString();
        double payment=Double.parseDouble(inputpayment);

        String inputapr=aprView.getText().toString();
        double apr=Double.parseDouble(inputapr);

        int i=seekBar.getProgress();

        double mr=(apr/100)/12;
        double L=cost-payment;
        double n=i;
        double cost2;
        double P;

        if (radioLoan.isChecked()) {
            P=mr*L/(1-Math.pow(1+mr,-n));
        }
        else {
            cost2=cost/3;
            L=cost2-payment;
            P=mr*L/(1-Math.pow(1+mr,-36));
        }
        String twodecimals=String.format("%.02f", P);
        outputPayment.setText("$"+twodecimals+"");
    }

}
