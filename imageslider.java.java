package com.example.image_slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSlider imageSlider=findViewById(R.id.imageslider);

        List<SlideModel> slideModelList=new ArrayList<>();
        slideModelList.add(new SlideModel(R.drawable.sample1,"1", ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.sample2,"2",ScaleTypes.FIT));

        imageSlider.setImageList(slideModelList);


    }
}