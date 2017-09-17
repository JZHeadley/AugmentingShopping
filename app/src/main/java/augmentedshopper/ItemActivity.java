package augmentedshopper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
    }

    public void storeSwitcher(View view){
        Intent intent = new Intent(this, SimilarItemsActivity.class);
        String searchTerm = "kerrygold butter"; //CHANGE TO ITEM
        searchTerm = searchTerm.replaceAll(" ", "+");
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.aisle411.com/shops/results.php?searchTerm=" + searchTerm +"&addressNear=Richmond%2C+VA%2C+USA&mapLocateLat=37.5407246&mapLocateLon=-77.4360481#"));
        view.getContext().startActivity(browserIntent);
    }
    public void recipeSwitcher(View view){
        Intent intent = new Intent(this, RecipesActivity.class);
        startActivity(intent);
    }
    public void similarSwitcher(View view){
        Intent intent = new Intent(this, SimilarItemsActivity.class);
        startActivity(intent);
    }
    public void reviewSwitcher(View view){
        Intent intent = new Intent(this, ReviewsActivity.class);
        startActivity(intent);
    }
}
