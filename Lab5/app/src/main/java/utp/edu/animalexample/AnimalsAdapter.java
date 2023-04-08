package utp.edu.animalexample;

import static android.graphics.Color.rgb;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder> {
    private List<Animal> animals;
    public AnimalsAdapter(List<Animal> animals) {
        this.animals = animals;
    }
    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        public TextView animalName;
        public ImageView animalImage;
        public ImageButton animalDeleteButton;

        @RequiresApi(api = Build.VERSION_CODES.P)
        public AnimalViewHolder(View v){
            super(v);
            Log.d("Info", "PackageResourcePath()=" + v.getParent());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_activity, parent, false);
        AnimalViewHolder viewHolder = new AnimalViewHolder(v);
        viewHolder.animalName = v.findViewById(R.id.animal_name);
        viewHolder.animalImage = v.findViewById(R.id.animal_image);
        viewHolder.animalDeleteButton = v.findViewById(R.id.delete_animal_button);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);

        holder.animalName.setText(animal.name);
        holder.animalImage.setImageResource(animal.image);

        int color = Color.rgb(131, 14, 33);
        if (position % 2 == 0) {
            color = Color.GRAY;
        }
        holder.animalName.setBackgroundColor(color);
        holder.animalName.setTextColor(Color.WHITE);
        holder.animalName.setTextSize(20);
        holder.animalName.setGravity(Gravity.CENTER_HORIZONTAL);

        holder.animalDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Toast.makeText(view.getContext(), "Usunąłem - " + animals.get(position).name, Toast.LENGTH_SHORT).show();
                animals.remove(position);
                notifyItemRemoved(position);
            }
        });

        holder.animalImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                Toast.makeText(v.getContext(), "onLongClick - " + animals.get(position).name + " |", Toast.LENGTH_SHORT).show();
                Log.d("Info", "setOnLongClickListener" + v.getPivotX());
                return true;
            }
        });

        holder.animalName.setOnGenericMotionListener(new View.OnGenericMotionListener() {
            @Override
            public boolean onGenericMotion(View v, MotionEvent event) {
                Log.d("Info", "onGenericMotion = " + event.getSource());
                return true;
            }
        });

        holder.animalImage.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event){
                int position = holder.getAdapterPosition();
                Toast.makeText(v.getContext(), "onTouch - "+animals.get(position).name, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @NonNull
    @Override
    public int getItemCount() { return animals.size(); }
}
