package com.sheng.floatingview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private FloatWindowManager floatWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatWindowManager = FloatWindowManager.getInstance(getApplicationContext());
    }

    /**
     * 显示小窗口
     *
     * @param view
     */
    public void show(View view) {
        // 需要传递小悬浮窗布局，以及根布局的id，启动后台服务
        Intent intent = new Intent();
        intent.putExtra(FloatWindowService.LAYOUT_RES_ID,
                R.layout.float_window_small);
        intent.putExtra(FloatWindowService.ROOT_LAYOUT_ID,
                R.id.small_window_layout);
        intent.setPackage(getPackageName());
        intent.setAction("com.test.action");
        startService(intent);
//        finish();
        floatWindowManager.setOnClickListener(new FloatWindowSmallView.OnClickListener() {
            @Override
            public void click() {
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 移除所有的悬浮窗
     *
     * @param view
     */
    public void remove(View view) {
        floatWindowManager.removeAll();
    }

    public void addActivity(View view){
        startActivity(new Intent(this,LoginActivity.class));
    }

}
