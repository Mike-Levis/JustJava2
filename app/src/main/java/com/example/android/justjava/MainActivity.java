package com.example.android.justjava;

import android.os.StrictMode;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity >= 10) {
            Toast.makeText(getApplicationContext(), "You can order a maximum of 10 cups of coffee", Toast.LENGTH_SHORT).show();
        } else {
            quantity += 1;
            display(quantity);
        }
    }

    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(getApplicationContext(), "At least one cup of coffee should be ordered", Toast.LENGTH_SHORT).show();
        } else {
            quantity -= 1;
            display(quantity);
        }
    }

    public void submitOrder(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);

        String name = nameEditText.getText().toString();
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasChocolate, hasWhippedCream);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
    }

    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream) {
        int finalPrice = 5;

        if (hasChocolate) { finalPrice += 2; }
        if (hasWhippedCream) { finalPrice += 1; }
        return finalPrice * quantity;
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        /*
        priceMessage += "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit.";
        priceMessage += "\nPhasellus non dui ut metus sodales scelerisque quis et lectus. Suspendisse vitae tristique dolor, nec feugiat felis.";
        priceMessage += "\nAenean et justo tortor. Nullam congue mi ligula, et pharetra lacus tempor sit amet. Nunc nec viverra mi.";
        priceMessage += "\nCurabitur gravida tortor at ullamcorper luctus. Pellentesque vitae magna nec orci semper gravida.";
        priceMessage += "\nSed varius fermentum mi ac tempor. Etiam fermentum nec mauris eget ullamcorper. Suspendisse eu blandit sem.";
        priceMessage += "\nPraesent eleifend nisl ac nunc venenatis gravida. Ut quis hendrerit sapien. Proin ut dapibus leo.";
        priceMessage += "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit.";
        priceMessage += "\nPhasellus non dui ut metus sodales scelerisque quis et lectus. Suspendisse vitae tristique dolor, nec feugiat felis.";
        priceMessage += "\nAenean et justo tortor. Nullam congue mi ligula, et pharetra lacus tempor sit amet. Nunc nec viverra mi.";
        priceMessage += "\nCurabitur gravida tortor at ullamcorper luctus. Pellentesque vitae magna nec orci semper gravida.";
        priceMessage += "\nSed varius fermentum mi ac tempor. Etiam fermentum nec mauris eget ullamcorper. Suspendisse eu blandit sem.";
        priceMessage += "\nPraesent eleifend nisl ac nunc venenatis gravida. Ut quis hendrerit sapien. Proin ut dapibus leo.";
        */
        return priceMessage;
    }

    private void display(int quantity) {
        ((TextView) findViewById(R.id.display_text_view)).setText(String.valueOf(quantity));
    }

    private void displayMessage(String priceMessage) {
        ((TextView) findViewById(R.id.order_summary_text_view)).setText(priceMessage);
    }
}