package meow.sweetbread.nekosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner SFW_spinner;
    Spinner NSFW_spinner;

    String[] SFW = {"", "Hug", "Kiss", "Pat", "Lizard", "Neko", "8ball", "Cat", "Tickle", "Feed"};
    String[] NSFW = {"", "Lewd neko", "Random_hentai_gif", "Blowjob", "Erokemo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SFW_spinner = findViewById(R.id.SFW_spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> SFW_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SFW);
        // Определяем разметку для использования при выборе элемента
        SFW_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        SFW_spinner.setAdapter(SFW_adapter);

        NSFW_spinner = findViewById(R.id.NSFW_spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> NSFW_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, NSFW);
        // Определяем разметку для использования при выборе элемента
        NSFW_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        NSFW_spinner.setAdapter(NSFW_adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                Intent i = new Intent(MainActivity.this, Viewer.class);

                switch (item) {
                    case "Neko":
                    case "Hug":
                    case "Kiss":
                    case "Pat":
                    case "Lizard":
                    case "8ball":
                    case "Tickle":
                    case "Ie":

                    case "Erokemo":
                        i.putExtra("url", "https://nekos.life/api/v2/img/" + item.toLowerCase());
                        i.putExtra("key", "url");
                        startActivity(i);
                        break;

                    case "Random_hentai_gif":
                        i.putExtra("url", "https://nekos.life/api/v2/img/Random_hentai_gif");
                        i.putExtra("key", "url");
                        startActivity(i);
                        break;

                    case "Lewd neko":
                        i.putExtra("url", "https://nekos.life/api/lewd/neko");
                        i.putExtra("key", "neko");
                        startActivity(i);
                        break;

                    case "Blowjob":
                        i.putExtra("url", "https://nekos.life/api/v2/img/bj");
                        i.putExtra("key", "url");
                        startActivity(i);
                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        SFW_spinner.setOnItemSelectedListener(itemSelectedListener);
        NSFW_spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    public void SFW_But_func(View v) {
        SFW_spinner.setEnabled(true);
        NSFW_spinner.setEnabled(false);

        SFW_spinner.setVisibility(View.VISIBLE);
        NSFW_spinner.setVisibility(View.INVISIBLE);
    }
    public void NSFW_But_func(View v) {
        NSFW_spinner.setEnabled(true);
        SFW_spinner.setEnabled(false);

        NSFW_spinner.setVisibility(View.VISIBLE);
        SFW_spinner.setVisibility(View.INVISIBLE);
    }
}