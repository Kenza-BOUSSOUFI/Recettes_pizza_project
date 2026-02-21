package com.example.recettes_pizza_project.service;

import com.example.recettes_pizza_project.R;
import com.example.recettes_pizza_project.classes.Produit;
import com.example.recettes_pizza_project.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }
//==================les différents pizzas qui sont dans le receuil de pizza========================
    private void seed() {
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3.0,
                R.mipmap.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce...",
                "Pizza au poulet barbecue simple et rapide.",
                "STEP 1: Griller le poulet.\nSTEP 2: Garnir et cuire."));
        data.add(new Produit("BRUSCHETTA PIZZA", 5.0,
                R.mipmap.pizza2, "35 min",
                "- Sausage\n- Turkey pepperoni\n- Mozzarella\n- Tomatoes\n- Basil",
                "Hearty pizza full of Italian flavor.",
                "STEP 1:\nCook sausage.\n\nSTEP 2:\nBake and add tomato mix."));

        data.add(new Produit("SPINACH PIZZA", 2.0,
                R.mipmap.pizza3, "25 min",
                "- Alfredo sauce\n- Spinach\n- Tomatoes\n- Italian cheese",
                "Easy veggie pizza.",
                "STEP 1:\nPrepare dough.\n\nSTEP 2:\nAdd toppings.\n\nSTEP 3:\nBake."));

        data.add(new Produit("DEEP-DISH SAUSAGE PIZZA", 8.0,
                R.mipmap.pizza4, "45 min",
                "- Yeast\n- Flour\n- Mozzarella\n- Sausage\n- Tomatoes",
                "Grandma’s deep dish pizza.",
                "STEP 1:\nPrepare dough.\n\nSTEP 2:\nLayer ingredients.\n\nSTEP 3:\nBake."));

        data.add(new Produit("HOMEMADE PIZZA", 4.0,
                R.mipmap.pizza5, "50 min",
                "- Yeast\n- Flour\n- Ground beef\n- Tomato sauce\n- Mozzarella",
                "Classic homemade pizza.",
                "STEP 1:\nPrepare dough.\n\nSTEP 2:\nCook beef.\n\nSTEP 3:\nBake."));

        data.add(new Produit("PESTO CHICKEN PIZZA", 3.0,
                R.mipmap.pizza6, "50 min",
                "- Chicken\n- Pesto\n- Peppers\n- Mushrooms\n- Mozzarella",
                "Healthy pesto chicken pizza.",
                "STEP 1:\nPrepare dough.\n\nSTEP 2:\nCook chicken.\n\nSTEP 3:\nBake."));

        data.add(new Produit("LOADED MEXICAN PIZZA", 3.0,
                R.mipmap.pizza7, "30 min",
                "- Black beans\n- Onion\n- Tomatoes\n- Spinach\n- Cheddar",
                "Mexican style pizza.",
                "STEP 1:\nMash beans.\n\nSTEP 2:\nAdd toppings.\n\nSTEP 3:\nBake."));

        data.add(new Produit("BACON CHEESEBURGER PIZZA", 2.0,
                R.mipmap.pizza8, "20 min",
                "- Ground beef\n- Bacon\n- Pickles\n- Mozzarella\n- Cheddar",
                "Kids favorite pizza.",
                "STEP 1:\nCook beef.\n\nSTEP 2:\nAdd toppings.\n\nSTEP 3:\nBake."));

        data.add(new Produit("PIZZA MARGHERITA", 1.0,
                R.mipmap.pizza9, "30 min",
                "- Yeast\n- Flour\n- Tomatoes\n- Mozzarella\n- Basil",
                "Classic Italian pizza.",
                "STEP 1:\nPrepare dough.\n\nSTEP 2:\nAdd toppings.\n\nSTEP 3:\nBake."));

        data.add(new Produit("PEPPERONI-SAUSAGE STUFFED PIZZA", 5.0,
                R.mipmap.pizza10, "45 min",
                "- Yeast\n- Flour\n- Mozzarella\n- Pepperoni\n- Sausage",
                "Stuffed pizza full of cheese.",
                "STEP 1:\nPrepare dough.\n\nSTEP 2:\nAdd filling.\n\nSTEP 3:\nBake."));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) if (p.getId() == id) return p;
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}