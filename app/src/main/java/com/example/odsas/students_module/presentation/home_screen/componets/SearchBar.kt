package com.example.odsas.students_module.presentation.home_screen.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.odsas.students_module.presentation.screens.Screens

@Composable
fun SearchBar() {

 Column(
     verticalArrangement = Arrangement.Center,
     horizontalAlignment = Alignment.CenterHorizontally
 ) {


    var userName by remember { mutableStateOf("")}

    OutlinedTextField(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 10.dp)
            .fillMaxWidth()
            .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

        value = userName,
        onValueChange = {
            userName = it
        },
        placeholder = {
            Text(
                modifier = Modifier,
                //.alpha(ContentAlpha.medium),
                text = "Search your appointments here...",
                color = Color.Black
            )
        },
        textStyle = TextStyle(
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        ),
        singleLine = true,
        leadingIcon = {
            IconButton(
//                    modifier = Modifier
//                        .alpha(ContentAlpha.medium),
                onClick = {
                    //search a user
//                    navController.navigate(
//                        (Screens.UserDetailsScreen.route + "/$userName")
//                    )

                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "search icon",
                    tint = Color.Black
                )
            }
        } ,
        trailingIcon = {
            IconButton(
                onClick = {
                    //back to list screen
                    userName = ""
//                    navController.navigate(Screens.UseListScreen.route) {
//                        popUpTo(Screens.UseListScreen.route) {
//                            inclusive = true
//                        }
//                    }

                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "close icon",
                    tint = Color.Black
                )
            }
        },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.Transparent,
//                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
//            ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
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

     //elevation Shadow
    BottomShadow(alpha = 0.3f, height = 8.dp)
 }

}

