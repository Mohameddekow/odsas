package com.example.odsas.students_module.presentation.book_appointment_screen.componets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.odsas.R
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite

@Composable
fun MyDescription() {

    var desc by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 3.dp)
            .fillMaxWidth()
            .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

        value = desc,
        onValueChange = {
            desc = it
        },
        placeholder = {
            Text(
                modifier = Modifier,
                text = "Description",
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
                    painter = painterResource(id = R.drawable.note),
                    contentDescription = "desc",
                    tint = CustomBlue,
                    modifier = Modifier.size(20.dp)
                )
            }
        } ,
        trailingIcon = {
            IconButton(
                onClick = {
                    desc = ""
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
            onClick = {
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp) ,
            colors = ButtonDefaults.buttonColors(CustomBlue),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Book appointment", color = CustomWhite)
        }
    }

}
