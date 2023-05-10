package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Activity_Page extends AppCompatActivity {
    TextView timer,comment,Question,OptionA,OptionB,OptionC,OptionD,score;
    int Randomnumber1,Randomnumber2, operators,NUM,DENO,option;
    String operation;
    String sign[]={"%","x","-","+"};
    static int flag;
    Button playagin;
    String permu[]={"0234","0243","0342","0324","0423","0432","2034","2043","2304","2340","2430","2403","3024","3042","3204","3240","3402","3420","4032","4023","4203","4230","4302","4320"};
    boolean m;
    CountDownTimer countDownTimer;

    public void gameagain(View view){
        score.setText("0/0");
        OptionA.setEnabled(true);
        OptionB.setEnabled(true);
        OptionC.setEnabled(true);
        OptionD.setEnabled(true);
        countDownTimer.start();
        NUM=0;
        DENO=0;
        playagin.setEnabled(false);
    }


    public void changeQuestion(View view){
        playagin.setVisibility(0);
        comment.setVisibility(1);
        TextView Ans = (TextView) view;
        if(m) {
            m=false;
            if (operators == Integer.parseInt(Ans.getTag().toString())) {
                comment.setText("RIGHT :)");
                NUM = NUM + 1;
                DENO = DENO + 1;
            } else {
                comment.setText("WRONG :D");
                DENO = DENO + 1;
            }
        }
        else{
            if(permu[option].charAt(Integer.parseInt(Ans.getTag().toString()))=='0'){
                comment.setText("RIGHT :)");
                NUM = NUM + 1;
                DENO = DENO + 1;
            }
            else {
                comment.setText("WRONG :D");
                DENO = DENO + 1;
            }
        }
        score.setText(Integer.toString(NUM)+"/"+Integer.toString(DENO));
        Random random = new Random();
        Randomnumber1=random.nextInt(250)+1;
        Randomnumber2=random.nextInt(250)+251;
         operators=random.nextInt(4);
        operation=sign[operators];
        Question.setText(Integer.toString(Randomnumber1)+operation+Integer.toString(Randomnumber2));
        option=random.nextInt(24);
        if(operators==0) {
            OptionA.setText(Integer.toString((Randomnumber1+(Integer.parseInt(String.valueOf(permu[option].charAt(0))))) % (Randomnumber2+(Integer.parseInt(String.valueOf(permu[option].charAt(0)))))));
            OptionB.setText(Integer.toString((Randomnumber1 +(Integer.parseInt(String.valueOf(permu[option].charAt(1))))) % (Randomnumber2 + (Integer.parseInt(String.valueOf(permu[option].charAt(1)))))));
            OptionC.setText(Integer.toString((Randomnumber1 + (Integer.parseInt(String.valueOf(permu[option].charAt(2))))) % (Randomnumber2 + (Integer.parseInt(String.valueOf(permu[option].charAt(2)))))));
            OptionD.setText(Integer.toString((Randomnumber1 + (Integer.parseInt(String.valueOf(permu[option].charAt(3))))) % (Randomnumber2 + (Integer.parseInt(String.valueOf(permu[option].charAt(3)))))));
        }
        else if(operators==1) {
            OptionA.setText(Integer.toString((Randomnumber1+(Integer.parseInt(String.valueOf(permu[option].charAt(0))))) * (Randomnumber2+(Integer.parseInt(String.valueOf(permu[option].charAt(0)))))));
            OptionB.setText(Integer.toString((Randomnumber1+(Integer.parseInt(String.valueOf(permu[option].charAt(1)))))  * (Randomnumber2+(Integer.parseInt(String.valueOf(permu[option].charAt(1)))))));
            OptionC.setText(Integer.toString((Randomnumber1 + (Integer.parseInt(String.valueOf(permu[option].charAt(2))))) * (Randomnumber2 +(Integer.parseInt(String.valueOf(permu[option].charAt(2)))))));
            OptionD.setText(Integer.toString((Randomnumber1 + (Integer.parseInt(String.valueOf(permu[option].charAt(3))))) * (Randomnumber2 + (Integer.parseInt(String.valueOf(permu[option].charAt(3)))))));
        }
        else if(operators==2) {
            OptionA.setText(Integer.toString((Randomnumber1) -(Randomnumber2)+(Integer.parseInt(String.valueOf(permu[option].charAt(0))))));
            OptionB.setText(Integer.toString((Randomnumber1 ) -(Randomnumber2 )+(Integer.parseInt(String.valueOf(permu[option].charAt(1))))));
            OptionC.setText(Integer.toString((Randomnumber1) - (Randomnumber2)+(Integer.parseInt(String.valueOf(permu[option].charAt(2))))));
            OptionD.setText(Integer.toString((Randomnumber1) - (Randomnumber2 )+(Integer.parseInt(String.valueOf(permu[option].charAt(3))))));
        }
        else if(operators==3) {
            OptionA.setText(Integer.toString((Randomnumber1+(Integer.parseInt(String.valueOf(permu[option].charAt(0))))) + (Randomnumber2+(Integer.parseInt(String.valueOf(permu[option].charAt(0)))))));
            OptionB.setText(Integer.toString((Randomnumber1 + (Integer.parseInt(String.valueOf(permu[option].charAt(1))))) + (Randomnumber2 + (Integer.parseInt(String.valueOf(permu[option].charAt(1)))))));
            OptionC.setText(Integer.toString((Randomnumber1 + (Integer.parseInt(String.valueOf(permu[option].charAt(2))))) + (Randomnumber2 + (Integer.parseInt(String.valueOf(permu[option].charAt(2)))))));
            OptionD.setText(Integer.toString((Randomnumber1 +(Integer.parseInt(String.valueOf(permu[option].charAt(3)))))+  (Randomnumber2+(Integer.parseInt(String.valueOf(permu[option].charAt(3)))) )));
        }
    }

    public void updatetimer(int progress){
        String seconds= Integer.toString(progress);
        if(progress<=9){
            seconds='0'+Integer.toString(progress);
        }
        timer.setText(seconds +"s");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        comment =findViewById(R.id.textView5);
        countDownTimer = new CountDownTimer(30*1000+100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updatetimer((int) millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                comment.setText("Time's Up");
                OptionA.setEnabled(false);
                OptionB.setEnabled(false);
                OptionC.setEnabled(false);
                OptionD.setEnabled(false);
                playagin.setEnabled(true);

            }
        }.start();
        timer=findViewById(R.id.textView);
        Question=findViewById(R.id.textView3);
        OptionA=findViewById(R.id.textView4);
        OptionB=findViewById(R.id.textView6);
        OptionC=findViewById(R.id.textView7);
        OptionD=findViewById(R.id.textView8);


        Random rand = new Random();
        Randomnumber1=rand.nextInt(250)+1;
        Randomnumber2=rand.nextInt(250)+251;
        operators=rand.nextInt(4);
        operation=sign[operators];
        Question.setText(Integer.toString(Randomnumber1)+operation+Integer.toString(Randomnumber2));

        m=true;

        OptionA.setText(Integer.toString(Randomnumber1%Randomnumber2));
        OptionB.setText(Integer.toString(Randomnumber1*Randomnumber2));
        OptionC.setText(Integer.toString(Randomnumber1-Randomnumber2));
        OptionD.setText(Integer.toString(Randomnumber1+Randomnumber2));
        flag=0;
        playagin=(Button) findViewById(R.id.button);

        score=(TextView) findViewById(R.id.textView2);
        playagin.setEnabled(false);

    }
}