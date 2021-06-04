package za.co.masekofortune.groceryshop.ui.screens.auth

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.masekofortune.groceryshop.R
import za.co.masekofortune.groceryshop.ui.theme.CatskillWhite
import za.co.masekofortune.groceryshop.ui.theme.GroceryShopTheme

@Composable
fun AddNumberScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 5.dp,
                title = { Text(stringResource(R.string.add_number_screen_title)) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back_arrow_content_description)
                        )
                    }
                }
            )
        },
        backgroundColor = CatskillWhite
    ) {

    }
}

@Preview("Add number screen", showBackground = true)
@Composable
fun AddNumberScreenPreview() {
    GroceryShopTheme {
        AddNumberScreen()
    }
}
