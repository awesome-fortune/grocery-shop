package za.co.masekofortune.groceryshop.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.masekofortune.groceryshop.R
import za.co.masekofortune.groceryshop.ui.theme.EbonyClay
import za.co.masekofortune.groceryshop.ui.theme.Green400
import za.co.masekofortune.groceryshop.ui.theme.GroceryShopTheme
import za.co.masekofortune.groceryshop.ui.theme.Raven

@Composable
fun VerifyNumberScreen() {
    Scaffold(topBar = {
        TopAppBar(
            elevation = 5.dp,
            title = { Text(stringResource(R.string.verify_number_screen_top_bar_title)) },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(
                            R.string.back_arrow_content_description
                        )
                    )
                }
            }
        )
    }) {
        VerifyNumberForm()
    }
}

@Composable
fun VerifyNumberForm(modifier: Modifier = Modifier) {
    Surface(
        elevation = 15.dp,
        color = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier.padding(16.dp)) {
            Text(
                stringResource(R.string.verify_number_screen_title),
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Medium,
                    color = EbonyClay
                )
            )
            Text(
                buildAnnotatedString {
                    append("4 digit code sent to ")
                    withStyle(SpanStyle(color = Green400, fontWeight = FontWeight.Bold)) {
                        append("084 111 2222")
                    }
                },
                style = MaterialTheme.typography.subtitle1,
                color = Raven
            )
            Row(
                modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FormTextField()
                FormTextField()
                FormTextField()
                FormTextField()
            }
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Raven
                    )
                ) {
                    Text(stringResource(R.string.resend_btn))
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(stringResource(R.string.verify_btn).toUpperCase(Locale.current))
                }
            }
        }

    }
}

@Composable
fun FormTextField(modifier: Modifier = Modifier) {
    TextField(
        value = "2",
        onValueChange = { /* TODO */ },
        modifier = modifier.widthIn(max = 70.dp),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        textStyle = MaterialTheme.typography.body1.copy(
            color = EbonyClay,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    )
}

@Preview("Verify number screen", showBackground = true)
@Composable
fun VerifyNumberScreenPreview() {
    GroceryShopTheme {
        VerifyNumberScreen()
    }
}