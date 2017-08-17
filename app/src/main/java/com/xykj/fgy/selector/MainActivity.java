package com.xykj.fgy.selector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xykj.fgy.selector.timeview.DateListener;
import com.xykj.fgy.selector.timeview.TimeConfig;
import com.xykj.fgy.selector.timeview.TimeSelectorDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        tv.setText(s);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectorDialog dialog = new TimeSelectorDialog(MainActivity.this);
                //设置标题
                dialog.setTimeTitle("选择日期:");
                //显示类型
                dialog.setIsShowtype(TimeConfig.YEAR_MONTH);
                //默认时间
                dialog.setCurrentDate(tv.getText().toString().trim() + "-01");
                //隐藏清除按钮
                dialog.setEmptyIsShow(false);
                //设置起始时间
                dialog.setStartYear(1990);
                dialog.setDateListener(new DateListener() {
                    @Override
                    public void onReturnDate(String time, int year, int month, int day, int hour, int minute, int isShowType) {
                        //Toast.makeText(mContext,time,Toast.LENGTH_LONG).show();
                        //startDateTv.setText(year+"-"+(month+1));
                        tv.setText(time);
                    }

                    @Override
                    public void onReturnDate(String empty) {
                    }
                });
                dialog.show();
            }
        });
    }
}

