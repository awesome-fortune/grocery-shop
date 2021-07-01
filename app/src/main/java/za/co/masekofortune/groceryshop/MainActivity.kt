package za.co.masekofortune.groceryshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import za.co.masekofortune.groceryshop.ui.GroceryShopApp
import za.co.masekofortune.groceryshop.ui.theme.GroceryShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryShopTheme {
                GroceryShopApp()
            }
        }
    }
}