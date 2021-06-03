package za.co.masekofortune.groceryshop.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.masekofortune.groceryshop.R
import za.co.masekofortune.groceryshop.ui.theme.Green400
import za.co.masekofortune.groceryshop.ui.theme.GroceryShopTheme

@Composable
fun WelcomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Green400)
            .padding(vertical = 64.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = buildAnnotatedString {
                    append(stringResource(R.string.welcome_screen_title_part))
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(stringResource(R.string.grocery))
                    }
                    append(" ")
                    append(stringResource(R.string.shopping))
                },
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Light),
                modifier = Modifier.padding(vertical = 64.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier.padding(bottom = 8.dp)

            ) {
                Text(
                    text = stringResource(R.string.sign_in).toUpperCase(Locale.current),
                    color = Green400,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.sign_up).toUpperCase(Locale.current),
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
        }
    }
}

@Preview("Welcome screen")
@Composable
fun WelcomeScreenPreview() {
    GroceryShopTheme {
        WelcomeScreen()
    }
}

