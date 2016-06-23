package demo.flowlayout.oldmilk.psn.flowlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import psn.oldmilk.flowlayout.FlowLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flowlayout);
        final Button button = (Button) findViewById(R.id.button_addview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button button1 = new Button(MainActivity.this);
                Random random1 = new Random();
                int length = random1.nextInt(10);
                String name = randomString(length+1);
                button1.setText(name);
                flowLayout.addView(button1);
            }
        });
    }

    public static String randomString(int length) {

        return randomString("ABCDEF012GHIJKL345MNOPQR678STUVWXYZ9", length);

        // char[] chars1 = "ABCDEF012GHIJKL345MNOPQR678STUVWXYZ9".toCharArray();
        // StringBuilder sb1 = new StringBuilder();
        // Random random1 = new Random();
        // for (int i = 0; i < length; i++) {
        // char c1 = chars1[random1.nextInt(chars1.length)];
        // sb1.append(c1);
        // }
        // return sb1.toString();

    }

    public static String randomString(String pattern, int length) {

        char[] chars1 = pattern.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        Random random1 = new Random();
        for (int i = 0; i < length; i++) {
            char c1 = chars1[random1.nextInt(chars1.length)];
            sb1.append(c1);
        }
        return sb1.toString();

    }
}
