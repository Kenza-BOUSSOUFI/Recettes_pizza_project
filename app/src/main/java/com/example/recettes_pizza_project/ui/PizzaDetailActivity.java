package com.example.recettes_pizza_project.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recettes_pizza_project.R;
import com.example.recettes_pizza_project.classes.Produit;
import com.example.recettes_pizza_project.service.ProduitService;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;


public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pizza_detail);

        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        ImageView img = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView meta = findViewById(R.id.meta);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView desc = findViewById(R.id.desc);
        TextView steps = findViewById(R.id.steps);

        if (p != null) {
            img.setImageResource(p.getImageRes());
            title.setText(p.getNom());
            meta.setText(p.getDuree() + " • " + p.getPrix() + " €");
            ingredients.setText(p.getIngredients());
            desc.setText(p.getDescription());
            steps.setText(p.getEtapes());
        } else {
            title.setText("Pizza introuvable !");
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_share) {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                    "Check out these amazing pizza recipes!");

            startActivity(Intent.createChooser(shareIntent, "Share via"));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
