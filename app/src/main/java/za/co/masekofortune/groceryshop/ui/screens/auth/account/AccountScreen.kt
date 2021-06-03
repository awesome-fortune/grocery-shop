package za.co.masekofortune.groceryshop.ui.screens.auth.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import za.co.masekofortune.groceryshop.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import za.co.masekofortune.groceryshop.ui.theme.*

enum class AccountScreenAction { SignIn, SignUp }

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    action: AccountScreenAction = AccountScreenAction.SignIn
) {
    var screenAction by rememberSaveable { mutableStateOf(action) }

    Column(
        Modifier
            .background(color = CatskillWhite)
            .fillMaxSize()
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            TextButton(
                onClick = { screenAction = AccountScreenAction.SignIn },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = if (screenAction == AccountScreenAction.SignIn) Green400 else Raven
                )
            ) {
                Text(stringResource(R.string.sign_in))
            }
            TextButton(
                onClick = { screenAction = AccountScreenAction.SignUp },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = if (screenAction == AccountScreenAction.SignUp) Green400 else Raven
                )
            ) {
                Text(stringResource(R.string.sign_up))
            }
        }
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            if (screenAction == AccountScreenAction.SignUp) {
                AccountScreenText(
                    title = stringResource(R.string.sign_up_screen_title),
                    subtitle = stringResource(R.string.sign_up_screen_subtitle)
                )
            } else {
                AccountScreenText(
                    title = stringResource(R.string.sign_in_screen_title),
                    subtitle = stringResource(R.string.sign_in_screen_subtitle)
                )
            }
            Spacer(Modifier.height(32.dp))
            AccountFormFields(screenAction)
            Spacer(Modifier.height(8.dp))
            AccountFormFooter(screenAction)
        }
    }

}

@Composable
fun AccountFormFooter(screenAction: AccountScreenAction) {
    if (screenAction == AccountScreenAction.SignIn) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Raven,
                    backgroundColor = Color.White
                )
            ) {
                Text(stringResource(R.string.forgot_password))
            }
            Button(onClick = { /*TODO*/ }) {
                Text(
                    stringResource(R.string.sign_in).toUpperCase(Locale.current),
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
                )
            }
        }
    } else {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(R.string.sign_up).toUpperCase(Locale.current))
            }
        }
    }
}

@Composable
fun AccountFormFields(screenAction: AccountScreenAction) {
    TextField(
        onValueChange = {},
        value = "",
        label = { Text(stringResource(R.string.username)) },
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    )
    if (screenAction == AccountScreenAction.SignUp) {
        TextField(
            onValueChange = {},
            value = "",
            label = { Text(stringResource(R.string.email_address)) },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
    }
    TextField(
        onValueChange = {},
        value = "",
        label = { Text(stringResource(R.string.password)) },
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun AccountScreenText(title: String, subtitle: String) {
    Text(
        title,
        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Medium, color = EbonyClay)
    )
    Text(subtitle, style = MaterialTheme.typography.subtitle1.copy(color = Raven))
}

@Preview("Sign in screen", showBackground = true)
@Composable
fun SignInScreenPreview() {
    GroceryShopTheme {
        AccountScreen(action = AccountScreenAction.SignIn)
    }
}

@Preview("Sign up screen", showBackground = true)
@Composable
fun SignUpScreenPreview() {
    GroceryShopTheme {
        AccountScreen(action = AccountScreenAction.SignUp)
    }
}
