package com.example.odsas.students_module.presentation.profile_screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import com.example.odsas.R
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.odsas.students_module.domain.model.UserModel
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ProfileScreen(
    navController: NavHostController,
) {

    //logout a user
    //initialize
    val auth = FirebaseAuth.getInstance()

    val profileViewModel: ProfileViewModel = hiltViewModel()
    val state = profileViewModel.userState.value.user

    Log.d("prof", state?.userEmail.toString())

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        //profile navigation box
        Box(
            modifier = Modifier
                .background(color = CustomWhite)
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {

                //user profile
                ProfileItem(navController = navController, state)


                RowItems(
                    title = "My Location",
                    icon = R.drawable.loc_marker,
                    modifier = Modifier
                )
                RowItems(
                    title = "Settings",
                    icon = R.drawable.settings,
                    modifier = Modifier
                )
                RowItems(
                    title = "Help",
                    icon = R.drawable.help,
                    modifier = Modifier
                )
                RowItems(
                    title = "Support",
                    icon = R.drawable.support,
                    modifier = Modifier
                )

            }

            //sing out row
            RowItems(
                title = "Signout",
                icon = R.drawable.sign_out,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 150.dp)
                    .clickable {
                        auth.signOut()

                        navController.navigate(Screens.LoginScreen.route) {
                            popUpTo(Screens.LoginScreen.route) {
                                inclusive = true
                            }
                        }
                    }
            )
        }

    }

}


@Composable
fun ProfileItem(
    navController: NavHostController,
    user: UserModel?
) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp, top = 50.dp, start = 20.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
            ) {


                Image(
                    painter = painterResource(id = R.drawable.per),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .size(60.dp),
                    contentScale = ContentScale.Crop
                )


                Column(
                    modifier = Modifier
                        .padding(start = 7.dp),
                    verticalArrangement = Arrangement.Center,
                ) {

                    Text(
                        text = user?.userName ?: "Mohamed Dekow",
                        modifier = Modifier.padding(top = 3.dp),
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = user?.userEmail ?: "mohadekow@gmail.com", modifier = Modifier
                            .alpha(0.8f)
                            .padding(end = 20.dp)
                    )
                }

            }


            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 14.dp)
                        .size(24.dp),
                    tint = CustomBlue//if (darkTheme) LightModeBackgroundWhite else Color.Black
                )
            }
        }


    }

@Composable
fun RowItems(
    icon: Int,
    title: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(start = 20.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

        ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "location",
            Modifier.size(25.dp)
        )
        Text(text = title, modifier = Modifier.padding(start = 10.dp))
    }
}

