package hanks.com.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import hanks.com.mylibrary.util.ImageUtils;

/**
 * Created by Administrator on 2015/9/14.
 */
public class ClipImageActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_picture);
        bindViews();
        initViews();
        setLisenters();
    }

    private void bindViews() {
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    private void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String imagePath = getIntent().getStringExtra("imagePath");
                ImageUtils.setImageBitmap(imageView, imagePath);
            }
        }, 100);
    }

    private void setLisenters() {
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleImageView(event);
                return true;
            }
        });
    }

    private void handleImageView(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Matrix matrix = new Matrix();
                Bitmap bm;
                matrix.setTranslate();
                Canvas c;
                c.setMatrix(matrix);
                c.d
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
    }

    public static void launch(Activity activity, String imagePath) {
        Intent intent = new Intent(activity, ClipImageActivity.class);
        intent.putExtra("imagePath", imagePath);
        activity.startActivity(intent);
    }

}
