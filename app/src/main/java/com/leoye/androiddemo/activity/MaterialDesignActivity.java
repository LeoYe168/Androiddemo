package com.leoye.androiddemo.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.leoye.androiddemo.R;

public class MaterialDesignActivity extends FragmentActivity implements View.OnClickListener {


    TextView snackBarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        initView();

    }

    private void initView() {
        snackBarText = (TextView) findViewById(R.id.text_snackbar);
        snackBarText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_snackbar:
                Snackbar.make(v, "hi,i am snackbar", Snackbar.LENGTH_INDEFINITE).setAction("click button", this).show();
                break;

            default:

                break;
        }
    }
}


