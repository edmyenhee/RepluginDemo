package tw.com.bnct.replugindemo;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qihoo360.replugin.RePlugin;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("replugin-plugin2",
                        "tw.com.bnct.replugindemo2.MainActivity"));
//                RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("com.qihoo360.replugin.sample.demo1", "com.qihoo360.replugin.sample.demo1.MainActivity"));

            }
        });


    }

    private void testThreadClassLoader() {
        // 在2.1.7及以前版本，如果直接调用此方法，则拿到的ClassLoader可能是PathClassLoader或者为空。有极个别Java库会用到此方法
        // 这里务必确保：cl == getClassLoader()，才符合预期
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl != getClassLoader()) {
            throw new RuntimeException("Thread.current.classLoader != getClassLoader(). cl=" + cl + "; getC=" + getClassLoader());
        }
    }
}
