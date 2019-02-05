package com.example.frank.yssh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Button;

import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Button yinyue,dianying,denglu;
    private Button speechBtn; // 按钮控制开始朗读
    private TextView speechTxt; // 需要朗读的内容
    private TextToSpeech textToSpeech; // TTS对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final AlertDialog.Builder alertDialog  =new AlertDialog.Builder(this);
        yinyue=(Button)this.findViewById(R.id.button1);
        dianying=(Button)this.findViewById(R.id.button2);
        denglu=(Button)this.findViewById(R.id.button3);

        /*speechBtn = (Button) findViewById(R.id.button);
        speechBtn.setOnClickListener((OnClickListener) this);
        speechTxt = (TextView) findViewById(R.id.textView2);*/
        //textToSpeech = new TextToSpeech(Main2Activity.this,this); // 参数Context,TextToSpeech.OnInitListener
        /*textToSpeech.setLanguage(Locale.US);
        textToSpeech.setPitch(0.5f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
        textToSpeech.speak("主人你好，某人有给你留言，内容如下：",TextToSpeech.QUEUE_FLUSH, null);*/

        yinyue.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);

            }
        });


        dianying.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);

            }
        });


        denglu.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                PackageManager pm=getPackageManager();
                List<PackageInfo> list2=pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);


                String appdiaoyong=null;
                for (PackageInfo packageInfo:list2) {
                    String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                    String packageName = packageInfo.packageName;

                    if (appName.equals("QQ")) {
                        appdiaoyong = packageName;
                    }
                }
                if (appdiaoyong!=null){
                    startActivity(getPackageManager().getLaunchIntentForPackage(appdiaoyong));
                }
                else {
                    alertDialog.setTitle("系统提示").setMessage("你尚未安装QQ，无法登陆领取红包，请下载安装后再来登录领取！").setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            Intent intent = new Intent(Main2Activity.this, Main5Activity.class);
//                    intent.setData(Uri.parse("http://yun.baidu.com"));
//                    intent.setAction(Intent.ACTION_VIEW);
                            startActivity(intent);
                        }
                    }).show();
                }
            }
        });







    }




    /**
     * 用来初始化TextToSpeech引擎
     * status:SUCCESS或ERROR这2个值
     * setLanguage设置语言，帮助文档里面写了有22种
     * TextToSpeech.LANG_MISSING_DATA：表示语言的数据丢失。
     * TextToSpeech.LANG_NOT_SUPPORTED:不支持
     */
    //@Override
   /* public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //@Override
    public void onClick(View v) {
        if (textToSpeech != null && !textToSpeech.isSpeaking()) {
            textToSpeech.setPitch(0.5f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
            textToSpeech.speak(speechTxt.getText().toString(),
                    TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.stop(); // 不管是否正在朗读TTS都被打断
        textToSpeech.shutdown(); // 关闭，释放资源
    }*/





}
