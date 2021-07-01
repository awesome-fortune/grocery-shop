package za.co.masekofortune.groceryshop

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import za.co.masekofortune.groceryshop.ui.screens.auth.AddNumberScreen
import za.co.masekofortune.groceryshop.ui.screens.auth.VerifyNumberScreen
import za.co.masekofortune.groceryshop.ui.screens.auth.AccountScreen
import za.co.masekofortune.groceryshop.ui.screens.auth.WelcomeScreen

sealed class Screen(val route: String) {
    object Store : Screen("storeroot")
    object Auth : Screen("authroot")
}

sealed class AuthScreen(val route: String) {
    object Welcome : AuthScreen("welcome")
    object Account : AuthScreen("account/{accountAction}") {
        fun createRoute(accountAction: String) = "account/$accountAction"
    }

    object AddNumber : AuthScreen("addNumber")
    object VerifyNumber : AuthScreen("verifyNumber")
    object ForgotPassword : AuthScreen("forgotPassword")
}

@Composable
internal fun AppNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Auth.route) {
        addAuthTopLevel(navController)
    }
}

private fun NavGraphBuilder.addAuthTopLevel(navController: NavController) {
    navigation(route = Screen.Auth.route, startDestination = AuthScreen.Welcome.route) {
        addWelcome(navController)
        addAccount(navController)
        addNumber(navController)
        addVerifyNumber(navController)
    }
}

private fun NavGraphBuilder.addWelcome(navController: NavController) {
    composable(AuthScreen.Welcome.route) {
        WelcomeScreen()
    }
}

private fun NavGraphBuilder.addAccount(navController: NavController) {
    composable(AuthScreen.Account.route) {
        AccountScreen()
    }
}

private fun NavGraphBuilder.addNumber(navController: NavController) {
    composable(AuthScreen.AddNumber.route) {
        AddNumberScreen()
    }
}

private fun NavGraphBuilder.addVerifyNumber(navController: NavController) {
    composable(AuthScreen.VerifyNumber.route) {
        VerifyNumberScreen()
    }
}

private fun NavGraphBuilder.addForgotPassword(navController: NavController) {
    composable(AuthScreen.ForgotPassword.route) {

    }
}