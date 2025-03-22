package ru.mirea.alyamovskiyvy.listviewapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<History> countries = getListData();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new HistoryRecyclerViewAdapter(countries));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this,
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<History> getListData() {
        List<History> countries = new ArrayList<History>() {{
            add(new History("Крещение Руси", "ic_baptism", "Меры по созданию на Руси церковной организации и среды"));
            add(new History("Куликовская битва", "ic_kulikovo", "крупное средневековое сражение между объединённым русским войском и войском правителя западной части Золотой Орды Мамая"));
            add(new History("Судебник", "ic_sudebnik", "Свод законов Русского государства, памятник русского права XV века"));
            add(new History("Стоглавый собор", "ic_chronicle", "Поместный собор Русской церкви и земский собор"));
            add(new History("Земский собор", "ic_election", "Собрание представителей различных земель и сословий Русского царства"));
            add(new History("Манифест о вольности дворянства", "ic_manifest", "Один из ключевых законодательных актов непродолжительного царствования Петра III"));
        }};

        return countries;
    }
}