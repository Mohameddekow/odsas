package com.example.odsas.students_module.presentation.auth.login_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlack
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite


@Composable
fun LoginScreen(navController: NavHostController) {

    Card(elevation = 10.dp, modifier = Modifier.padding(4.dp).fillMaxWidth()) {

        ScreenTitleBar("Login screen", navController )
    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Spacer(modifier = Modifier.height(150.dp))

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(20.dp))

        ///user name
        var userName by remember { mutableStateOf("")}

        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 0.dp, horizontal = 3.dp)
                .fillMaxWidth()
                .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

            value = userName,
            onValueChange = {
                userName = it
            },
            placeholder = {
                Text(
                    modifier = Modifier,
                    text = "Reg number",
                    color = Color.Black
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = "search icon",
                        tint = Color.Black
                    )
                }
            } ,
            trailingIcon = {
                IconButton(
                    onClick = {
                        userName = ""
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "close icon",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    //search a user
//                navController.navigate(
//                    (Screens.UserDetailsScreen.route + "/$userName")
//                )
                }
            )

        )

        Spacer(modifier = Modifier.height(20.dp))

        var userPassword by remember { mutableStateOf("")}


        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 0.dp, horizontal = 3.dp)
                .fillMaxWidth()
                .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

            value = userPassword,
            onValueChange = {
                userPassword = it
            },
            placeholder = {
                Text(
                    modifier = Modifier,
                    text = "Password",
                    color = Color.Black
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Lock,
                        contentDescription = "lock icon",
                        tint = Color.Black
                    )
                }
            } ,
            trailingIcon = {
                IconButton(
                    onClick = {
                        userPassword = ""
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "close icon",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    //search a user
//                navController.navigate(
//                    (Screens.UserDetailsScreen.route + "/$userName")
//                )
                }
            )

        )







        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier
            .padding(1.dp, 0.dp, 1.dp, 0.dp)
            .fillMaxWidth()) {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp) ,
                colors = ButtonDefaults.buttonColors(CustomBlue),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Login", color = CustomWhite)
            }
        }

//        Spacer(modifier = Modifier.height(20.dp))
//        ClickableText(
//            text = AnnotatedString("Forgot password?"),
//            onClick = { },
//            style = TextStyle(
//                color = CustomBlack,
//                fontSize = 14.sp,
//                fontFamily = FontFamily.Default
//            )
//        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ClickableText(
                text = AnnotatedString("Don't have an account?"),
                onClick = { },
                style = TextStyle(
                    color = CustomBlack,
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Default
                )
            )

            ClickableText(
                text = AnnotatedString("Register here."),
                onClick = {
                    //click event
                    navController.navigate(Screens.RegistrationScreen.route) {
                        popUpTo(Screens.RegistrationScreen.route) {
                            inclusive = true
                        }
                    }
                },
                style = TextStyle(
                    color = CustomBlue,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Default
                ),
                modifier = Modifier.padding(horizontal = 5.dp)
            )

        }


    }
}




//        TextField(
//            label = { Text(text = "Password") },
//            value = password.value,
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            onValueChange = { password.value = it })



//        TextField(
//            label = { Text(text = "Username") },
//            value = username.value,
//            onValueChange = { username.value = it })


//Box(modifier = Modifier
//.fillMaxSize()
//.padding(bottom = 10.dp), contentAlignment = Alignment.Center) {
//    ClickableText(
//        text = AnnotatedString("Sign up here"),
//        modifier = Modifier
//            .align(Alignment.BottomCenter)
//            .padding(20.dp),
//        onClick = { },
//        style = TextStyle(
//            fontSize = 14.sp,
//            fontFamily = FontFamily.Default,
//            textDecoration = TextDecoration.Underline,
//            color = CustomBlue
//        )
//    )
//}