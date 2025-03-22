package ru.mirea.alyamovskiyvy.listviewapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Map<String, List<String>> books = new HashMap<String, List<String>>() {{
        put("Лев Толстой", new ArrayList<>(Arrays.asList("Война и мир", "После бала", "Детство")));
        put("Александр Грибоедов", new ArrayList<>(Arrays.asList("Горе от ума", "Студент")));
        put("Александр Пушкин", new ArrayList<>(Arrays.asList("Евгений Онегин", "Метель", "Барышня-крестьянка")));
        put("Антон Чехов", new ArrayList<>(Arrays.asList("Беседа пьяного с трезвым чертом", "Ванька", "Толстый и тонкий")));
        put("Михаил Лермонтов", new ArrayList<>(Arrays.asList("Герой нашего времени", "Ашик-Кериб")));
        put("Александр Куприн", new ArrayList<>(Arrays.asList("Чудесный доктор", "В клетке зверя")));
        put("Федор Достоевский", new ArrayList<>(Arrays.asList("Преступление и наказание", "Идиот")));
        put("Александр Грин", new ArrayList<>(Arrays.asList("Зеленая лампа", "Голос и глаз", "Заколоченный дом")));
        put("Николай Гоголь", new ArrayList<>(Arrays.asList("Ревизор", "Мертвые души", "Шинель")));
        put("Иван Тургенев", new ArrayList<>(Arrays.asList("Муму", "Бежин луг")));
        put("Владимир Даль", new ArrayList<>(Arrays.asList("Что значит досуг")));
        put("Афанасий Фет", new ArrayList<>(Arrays.asList("Кактус", "Талисман")));
        put("Денис Фонвизин", new ArrayList<>(Arrays.asList("Недоросль", "Встреча")));
        put("Николай Островский", new ArrayList<>(Arrays.asList("Как закалялась сталь")));
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Book> bookList = new ArrayList<>();

        for (String key :
                books.keySet()) {
            for (String title :
                    books.get(key)) {
                bookList.add(new Book(title, key));
            }
        }

        ArrayAdapter adapter = new ArrayAdapter<Book>(this,
                R.layout.item,
                R.id.bookTitle,
                bookList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView bookTitle = view.findViewById(R.id.bookTitle);
                TextView bookAuthor = view.findViewById(R.id.bookAuthor);

                Book book = getItem(position);
                bookAuthor.setText(book.getAuthor());
                bookTitle.setText(book.getTitle());
                return view;
            }
        };
        ((ListView) findViewById(R.id.country_list_view)).setAdapter(adapter);
    }
}