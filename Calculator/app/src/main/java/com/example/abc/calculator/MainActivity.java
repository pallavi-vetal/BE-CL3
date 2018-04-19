package com.example.abc.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import net.objecthunter.exp4j.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    String expression ="";
    String op ="0";
    boolean dec = false;
    boolean opr = false;
    TextView display;
    TextView mMemSave;
    Button decimal_point,equals,clear,sine,cosine,tan;
    Button ms,mr,mc;
    private SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Key ="key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView)findViewById(R.id.display);
        mMemSave = (TextView)findViewById(R.id.mMemSave);
        try
        {
            decimal_point = (Button)findViewById(R.id.decimal);
            decimal_point.setOnClickListener(this);
            equals = (Button)findViewById(R.id.equals);
            equals.setOnClickListener(this);
            clear = (Button)findViewById(R.id.clear);
            clear.setOnClickListener(this);
            sine = (Button)findViewById(R.id.sine);
            sine.setOnClickListener(this);
            cosine = (Button)findViewById(R.id.cosine);
            cosine.setOnClickListener(this);
            tan = (Button)findViewById(R.id.tan);
            tan.setOnClickListener(this);
            ms = (Button)findViewById(R.id.mem_save);
            ms.setOnClickListener(this);
            mr = (Button)findViewById(R.id.mem_recall);
            mr.setOnClickListener(this);
            mc = (Button)findViewById(R.id.mem_clear);
            mc.setOnClickListener(this);
            sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

            if(sharedPreferences.getAll().containsKey(Key))
            {
                mMemSave.setText(sharedPreferences.getString(Key,""));
            }
        }
        catch(NullPointerException e)
        {
            Log.d("ABC","Null pointer exception encountered");
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.decimal:
                if(!dec)
                {
                    expression+=".";
                    display.setText(expression);
                    dec=true;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Can't add another decimal,",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.equals:
                if(!opr)
                {
                    calculate();
                    dec=true;
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Some error",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.clear:
                expression = "";
                display.setText(expression);
                opr = false;
                dec = false;
                op ="0";
                break;

            case R.id.sine:
                expression = "sin ";
                display.setText(expression);
                op = "1";
                dec = false;
                break;

            case R.id.cosine:
                expression = "cos ";
                display.setText(expression);
                op ="2";
                dec = false;
                break;

            case R.id.tan:
                expression = "tan ";
                display.setText(expression);
                op="3";
                dec = false;
                break;

            case R.id.mem_save:
                if(!expression.equals(""))
                {
                    if(!opr)
                    {
                        if(op.equals("0"))
                        {
                            Expression expression1 = new ExpressionBuilder(expression).build();
                            expression = ""+expression1.evaluate();
                        }
                        else
                        {
                            Expression expression1 = new ExpressionBuilder(expression.substring(4)).build();
                            expression = ""+expression1.evaluate();
                            String total = null;
                            if(op.equals("1"))
                                total = Double.toString(Math.sin(Double.parseDouble(expression)*(Math.PI / 180)));
                            else if(op.equals("2"))
                                total = Double.toString(Math.cos(Double.parseDouble(expression)*(Math.PI / 180)));
                            else if(op.equals("3"))
                                total = Double.toString(Math.tan(Double.parseDouble(expression)*(Math.PI / 180)));
                            op ="0";
                            expression = total;
                        }
                        SharedPreferences.Editor editor1= sharedPreferences.edit();
                        editor1.putString(Key,String.valueOf(expression));
                        mMemSave.setText(expression);
                        display.setText(expression);
                        editor1.commit();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Can't store incomplete expression's result",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Can't store NULL value",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.mem_recall:
                if(sharedPreferences.getAll().containsKey(Key))
                {
                    if((expression.equals("") || opr) && !dec)
                    {
                        expression+=sharedPreferences.getString(Key,"");
                        display.setText(expression);
                        opr=false;
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Only recall value to null or after operator",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"No saved data",Toast.LENGTH_SHORT).show();
                break;

            case R.id.mem_clear:
                SharedPreferences.Editor editor;
                editor = sharedPreferences.edit();
                editor.remove(Key);
                mMemSave.setText("");
                editor.commit();
                break;

        }
    }

    public void calculate()
    {
        if(op.equals("0"))
        {
            Expression expression1 = new ExpressionBuilder(expression).build();
            expression = ""+expression1.evaluate();
            display.setText(expression);
        }
        else
        {
            Expression expression1 = new ExpressionBuilder(expression.substring(4)).build();
            expression = ""+expression1.evaluate();
            String total = null;
            if(op.equals("1"))
                total = Double.toString(Math.sin(Double.parseDouble(expression)*(Math.PI / 180)));
            else if(op.equals("2"))
                total = Double.toString(Math.cos(Double.parseDouble(expression)*(Math.PI / 180)));
            else if(op.equals("3"))
                total = Double.toString(Math.tan(Double.parseDouble(expression)*(Math.PI / 180)));
            op ="0";
            expression = total;
            display.setText(expression);
        }
    }

    public void demo(View view)
    {
        Button button = (Button)view;
        expression+=(String)button.getText();
        opr=false;
        display.setText(expression);
    }

    public void operator(View view)
    {
        Button button = (Button)view;
        if(!opr)
        {
            expression+=(String)button.getText();
            display.setText(expression);
            opr = true;
            dec=false;
        }
        else
            Toast.makeText(getApplicationContext(),"Can't add another operator",Toast.LENGTH_SHORT).show();
    }
}

