package com.example.linearlayout2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText etProductCode, etProductName, etProductPrice;
    Button btnAddProduct, btnCancel, btnShowProducts;
    TextView tvProductList;

    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProductCode = findViewById(R.id.etProductCode);
        etProductName = findViewById(R.id.etProductName);
        etProductPrice = findViewById(R.id.etProductPrice);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnCancel = findViewById(R.id.btnCancel);
        btnShowProducts = findViewById(R.id.btnShowProducts);
        tvProductList = findViewById(R.id.tvProductList);

        productList = new ArrayList<>();

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = etProductCode.getText().toString();
                String name = etProductName.getText().toString();
                String priceText = etProductPrice.getText().toString();

                if (TextUtils.isEmpty(code) || TextUtils.isEmpty(name) || TextUtils.isEmpty(priceText)) {
                    Toast.makeText(MainActivity.this, "Töltsd ki az összes mezőt!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double price;
                try {
                    price = Double.parseDouble(priceText);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Érvényes árat adj meg!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Product product = new Product(code, name, price);
                productList.add(product);

                Toast.makeText(MainActivity.this, "Termék hozzáadva", Toast.LENGTH_SHORT).show();

                clearFields();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        btnShowProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProducts();
            }
        });
    }

    private void clearFields() {
        etProductCode.setText("");
        etProductName.setText("");
        etProductPrice.setText("");
    }

    private void showProducts() {
        StringBuilder builder = new StringBuilder();
        for (Product p : productList) {
            builder.append("Code: ").append(p.getCode())
                    .append(", Name: ").append(p.getName())
                    .append(", Price: ").append(p.getPrice()).append("\n");
        }
        tvProductList.setText(builder.toString());
    }


    class Product {
        private String code;
        private String name;
        private double price;

        public Product(String code, String name, double price) {
            this.code = code;
            this.name = name;
            this.price = price;
        }

        public String getCode() { return code; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }
}