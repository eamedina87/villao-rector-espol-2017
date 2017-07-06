package ec.medinamobile.comedoresdemo.propuestas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import ec.medinamobile.comedoresdemo.R;

/**
 * Created by Erick on 5/7/17.
 */

public class PropuestasActivity extends AppCompatActivity {

    private ScrollView scrollLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuestas);

        scrollLayout = (ScrollView)findViewById(R.id.scrollLayout);

        ((SubsamplingScaleImageView)findViewById(R.id.img_propuesta_1)).setImage(ImageSource.resource(R.drawable.img_prop_1));
        ((SubsamplingScaleImageView)findViewById(R.id.img_propuesta_2)).setImage(ImageSource.resource(R.drawable.img_prop_2));
        ((SubsamplingScaleImageView)findViewById(R.id.img_propuesta_3)).setImage(ImageSource.resource(R.drawable.img_prop_3));
        ((SubsamplingScaleImageView)findViewById(R.id.img_propuesta_4)).setImage(ImageSource.resource(R.drawable.img_prop_4));

    }

}
