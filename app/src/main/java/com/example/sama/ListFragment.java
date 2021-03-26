package com.example.sama;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {
    static private int countAd=0;
    // Add RecyclerView member
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, //LayoutInflater - из layout -файла создает view-элемент
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.main_fragment,container,false);
        RecyclerView recyclerView= view.findViewById(R.id.recyclerview);//находим созданный recycleView по ID
        setRetainInstance(true);//сохраняем фрагмент для новой активности
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // если портретная ориентация - 3 столбца
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.setLayoutManager( new GridLayoutManager(getActivity(), 3));
        else { // если ланшафтная ориентация - 4 столбца
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) ;
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        }

       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final NewsAdapter NewsAdapterEx=new NewsAdapter();//определяем адаптер
        recyclerView.setAdapter(NewsAdapterEx);//устанавливаем адаптер
        Bundle bundle = this.getArguments();
        if (countAd > 0) {
            for (int i = 0; i < countAd; i++) {
                NewsAdapterEx.insert(DataSource.AddItem());
            }
        }
        Button AddBut=view.findViewById(R.id.AddNew);
        AddBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsAdapterEx.insert(DataSource.AddItem());
                countAd++;
            }
        });
        return view;
    }
}
