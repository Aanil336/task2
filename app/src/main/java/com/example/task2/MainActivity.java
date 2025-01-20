package com.example.task2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner spinner;
    private Button button;
    private TextView textView;
    private TextCounter textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        textCounter = new TextCounter();

        // Spinner setup
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_warning, Toast.LENGTH_SHORT).show();
                } else {
                    int count = 0;
                    String countType = spinner.getSelectedItem().toString();
                    if (countType.equals(getString(R.string.word))) {
                        count = textCounter.countWords(input);
                    } else if (countType.equals(getString(R.string.character))) {
                        count = textCounter.countCharacters(input);
                    }
                    textView.setText(getString(R.string.result) + count);
                }
            }
        });
    }
}