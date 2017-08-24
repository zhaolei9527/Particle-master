package com.example.administrator.particle.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.administrator.particle.R;

import sakura.particle.Factory.BooleanFactory;
import sakura.particle.Factory.ExplodeParticleFactory;
import sakura.particle.Factory.FallingParticleFactory;
import sakura.particle.Factory.FlyawayFactory;
import sakura.particle.Factory.InnerFallingParticleFactory;
import sakura.particle.Factory.VerticalAscentFactory;
import sakura.particle.Main.ExplosionSite;


/**
 * Created by Sakura
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_1;
    private ImageView img_2;
    private ImageView img_3;
    private ImageView img_4;
    private ImageView img_5;
    private ImageView img_6;
    private LinearLayout activity_main;
    private Button button;
    private ExplosionSite explosionSite1;
    private ExplosionSite explosionSite2;
    private ExplosionSite explosionSite3;
    private ExplosionSite explosionSite4;
    private ExplosionSite explosionSite5;
    private ExplosionSite explosionSite6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        //目前提供了六种的粒子爆炸特效
        explosionSite1 = new ExplosionSite(this, new BooleanFactory());
        explosionSite2 = new ExplosionSite(this, new ExplodeParticleFactory());
        explosionSite3 = new ExplosionSite(this, new FallingParticleFactory());
        explosionSite4 = new ExplosionSite(this, new FlyawayFactory());
        explosionSite5 = new ExplosionSite(this, new InnerFallingParticleFactory());
        explosionSite6 = new ExplosionSite(this, new VerticalAscentFactory());

        //爆炸激活方式一：将View或ViewGroup添加至雷管监听，View被点击时，触发爆炸
        explosionSite1.addListener(img_1);
        explosionSite2.addListener(img_2);
        explosionSite3.addListener(img_6);
        explosionSite4.addListener(img_4);
        explosionSite5.addListener(img_5);
        explosionSite6.addListener(img_3);

    }

    private void initView() {
        img_1 = (ImageView) findViewById(R.id.img_1);
        img_2 = (ImageView) findViewById(R.id.img_2);
        img_3 = (ImageView) findViewById(R.id.img_3);
        img_4 = (ImageView) findViewById(R.id.img_4);
        img_5 = (ImageView) findViewById(R.id.img_5);
        img_6 = (ImageView) findViewById(R.id.img_6);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                //爆炸激活方式二：将View或ViewGroup直接点燃爆炸
                explosionSite1.explode(img_1);
                explosionSite2.explode(img_2);
                explosionSite3.explode(img_3);
                explosionSite4.explode(img_4);
                explosionSite5.explode(img_5);
                explosionSite6.explode(img_6);

                break;
        }
    }
}
