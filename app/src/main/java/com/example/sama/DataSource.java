package com.example.sama;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
//тут в AddItem создается новый элемент для добавления
//mData - список наших кнопок с цифрами
public class DataSource {
    static Integer nowInt;//текущее число
    private final List<Model_Item> mData;//NewsModel-сохраняет и управляет данныеми UI, нужен чтобы сохранить данные приизменении конфигурации
    private static DataSource sInstance; //позволяет запрашивать данные из позиции


    public DataSource() {

        mData = new ArrayList<>();
        int color;
        for (Integer i = 0; i < 100; i++) {
            nowInt=i+1;
            String titleNumb = nowInt.toString();

            if(nowInt%2==0)
                color = Color.RED;
            else
                color=Color.BLUE;
            mData.add(new Model_Item(titleNumb, color));
        }
    }

    public List<Model_Item> getRemoteData() {
        return mData;
    }

    public synchronized static DataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DataSource();// если можелей нет- создаем
        }
        return sInstance;
    }
    public static Model_Item AddItem()
    {nowInt++;
        int color;
        if(nowInt%2==0)
            color = Color.RED;
        else
            color=Color.BLUE;
        return new Model_Item(nowInt.toString(), color);

    }
}
