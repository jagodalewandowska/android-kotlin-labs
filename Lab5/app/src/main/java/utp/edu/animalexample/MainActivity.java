package utp.edu.animalexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalsAdapter mAdapter;
    private final boolean wybor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Animal[] possibleAnimals = {
                new Animal("Pies", R.drawable.dog_image),
                new Animal("Kot", R.drawable.cat_image),
                new Animal("Słoń", R.drawable.elephant_image),
                new Animal("Leniwiec", R.drawable.leniwiec),
                new Animal("Lemur", R.drawable.lemur),
                new Animal("Lama", R.drawable.lama),
                new Animal("Hiena", R.drawable.hiena),
                new Animal("Borsuk", R.drawable.borsuk),
                new Animal("Koń", R.drawable.kon)};


        List<Animal> animals = new ArrayList<>(100);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Animal randomAnimal = possibleAnimals[random.nextInt(possibleAnimals.length)];
            Animal animal = new Animal(randomAnimal.name + " " + (i + 1), randomAnimal.image);
            animals.add(animal);
        }
        if (wybor) {
            GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            mAdapter = new AnimalsAdapter(animals);
            recyclerView.setAdapter(mAdapter);
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        recyclerView.setAdapter(new AnimalsAdapter(animals));
    }
}