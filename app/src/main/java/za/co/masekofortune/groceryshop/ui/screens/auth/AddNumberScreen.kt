package za.co.masekofortune.groceryshop.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.masekofortune.groceryshop.R
import za.co.masekofortune.groceryshop.ui.theme.CatskillWhite
import za.co.masekofortune.groceryshop.ui.theme.EbonyClay
import za.co.masekofortune.groceryshop.ui.theme.GroceryShopTheme
import za.co.masekofortune.groceryshop.ui.theme.Raven

@Composable
fun AddNumberScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 5.dp,
                title = { Text(stringResource(R.string.add_number_screen_action_bar_title)) },
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
        AddNumberForm(Modifier.padding(it))
    }
}

@Composable
fun AddNumberForm(modifier: Modifier = Modifier) {
    Surface(
        elevation = 15.dp,
        color = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
        modifier = modifier
            .fillMaxWidth()

    ) {
        Column(modifier.padding(16.dp)) {
            Text(
                stringResource(R.string.add_number_screen_title), style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Medium,
                    color = EbonyClay
                )
            )
            Text(
                stringResource(R.string.add_number_screen_subtitle),
                style = MaterialTheme.typography.subtitle1.copy(color = Raven)
            )
            TextField(
                value = "",
                onValueChange = { /* TODO */ },
                placeholder = { Text(stringResource(R.string.mobile_number_placeholder)) },
                modifier = modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
            )
            Row(horizontalArrangement = Arrangement.End, modifier = modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(stringResource(R.string.add_number_send_button).toUpperCase(Locale.current))
                }
            }
        }
    }
}

@Preview("Add number screen", showBackground = true)
@Composable
fun AddNumberScreenPreview() {
    GroceryShopTheme {
        AddNumberScreen()
    }
}
