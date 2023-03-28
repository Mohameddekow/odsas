package com.example.odsas.students_module.presentation.auth.registration_screen

import android.widget.Toast
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.commons.USERS_ROOT_REF
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlack
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite

@Composable
fun RegistrationScreen(
    navController: NavHostController
) {



    Card(elevation = 10.dp, modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()) {

        ScreenTitleBar("Registration screen", navController )
    }

    val registerViewModel: RegisterViewModel = hiltViewModel()
    val context = LocalContext.current


    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

//        val username = remember { mutableStateOf(TextFieldValue()) }
//        val password = remember { mutableStateOf(TextFieldValue()) }

        Spacer(modifier = Modifier.height(70.dp))

        Text(text = "Registration", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(20.dp))

//@TODO Time Name text field********  Start
        Spacer(modifier = Modifier.height(20.dp))

        ///user name
        var userName by remember { mutableStateOf("") }

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
                    text = "User name",
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
//@TODO Time Name text field********  Ends


//@TODO Time Reg num text field********  Start
        Spacer(modifier = Modifier.height(20.dp))

        ///user name
        var regNum by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 0.dp, horizontal = 3.dp)
                .fillMaxWidth()
                .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

            value = regNum,
            onValueChange = {
                regNum = it
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
                        regNum = ""
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
//@TODO Time Reg num text field********  Ends


//@TODO Time email text field********  Start
        Spacer(modifier = Modifier.height(20.dp))

        ///user email
        var userEmail by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 0.dp, horizontal = 3.dp)
                .fillMaxWidth()
                .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

            value = userEmail,
            onValueChange = {
                userEmail = it
            },
            placeholder = {
                Text(
                    modifier = Modifier,
                    text = "Email address",
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
                        userEmail = ""
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

//@TODO Time email text field********  ends


//@TODO Time password text field********  Start

        Spacer(modifier = Modifier.height(20.dp))


        var userPassword by remember { mutableStateOf("") }

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

//@TODO Time password text field********  Ends



//@TODO Time confirm password text field********  Start

        ///confirm password
        Spacer(modifier = Modifier.height(20.dp))

        var confirmUserPassword by remember { mutableStateOf("") }


        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 0.dp, horizontal = 3.dp)
                .fillMaxWidth()
                .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

            value = confirmUserPassword,
            onValueChange = {
                confirmUserPassword = it
            },
            placeholder = {
                Text(
                    modifier = Modifier,
                    text = "Confirm password",
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
                        confirmUserPassword = ""
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

 //@TODO Time confirm password text field********  Ends






//@TODO Time register btn********  Start

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier
            .padding(1.dp, 0.dp, 1.dp, 0.dp)
            .fillMaxWidth()) {
            Button(
                onClick = {
                    //Toast.makeText(context, "${userName} :::: ${userPassword}", Toast.LENGTH_SHORT).show()

                    if (userName != "" && userEmail != "" && userPassword != "" && confirmUserPassword.isNotBlank() ){

                        if (userPassword != confirmUserPassword){
                            Toast.makeText(context, "passwords aren't matching", Toast.LENGTH_SHORT).show()
                        }else{

                            registerViewModel.registerUser(
                                userName,
                                regNum,
                                userEmail,
                                userPassword,
                                USERS_ROOT_REF
                            )
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful){
                                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

                                        navController.navigate(Screens.LoginScreen.route) {
                                            popUpTo(Screens.LoginScreen.route) {
                                                inclusive = true
                                            }
                                        }
                                    }else{
                                        Toast.makeText(context, "Failed: ${task.exception?.message.toString()}", Toast.LENGTH_SHORT).show()

                                    }
                                }
                        }

                    }else{
                        Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp) ,
                colors = ButtonDefaults.buttonColors(CustomBlue),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Register", color = CustomWhite)
            }
        }

//@TODO Time register btn********  ends

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ClickableText(
                text = AnnotatedString("Already have an account?"),
                onClick = { },
                style = TextStyle(
                    color = CustomBlack,
                    fontSize = 17.sp,
                    fontFamily = FontFamily.Default
                )
            )

            ClickableText(
                text = AnnotatedString("Login here."),
                onClick = {
                    //click event
                    navController.navigate(Screens.LoginScreen.route) {
                        popUpTo(Screens.LoginScreen.route) {
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