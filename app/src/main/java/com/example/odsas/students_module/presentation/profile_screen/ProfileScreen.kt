package com.example.odsas.students_module.presentation.profile_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite

//@Composable
//fun ProfileScreen(navController: NavHostController) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Text(text = "Profile Screen", modifier = Modifier)
//    }
//}

    @Composable
            fun ProfileScreen(
                navController: NavHostController,
            ) {

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
                            ProfileItem(navController = navController)


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
                        )
                    }

//                    //place holder box
//                    Box(
//                        modifier = Modifier
//                            .padding(start = 290.dp)
//                            //.fillMaxSize()
//                            .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
//                            .fillMaxHeight(0.65f)
//                            .background(Color.Blue)
//                            .alpha(1f)
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .background(Color.Gray)
//                        ) {
//
//                        }
//                    }
//
//                    //home screen background box
//                    Box(
//                        modifier = Modifier
//                            .padding(start = 300.dp)
//                            .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
//                            //.fillMaxSize()
//                            .fillMaxHeight(0.7f)
////                .clickable(enabled = false, onClickLabel = "hh", null, onClick = {})
//                            .background(Color.LightGray)
//                    ) {
//                        HomeScreen(
//                            navController = navController,
//                            sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
//                        )
//                    }


//                    //profile home button menu
//                    HomeBottomMenu(
//                        navController = navController,
//                        items = listOf(
//                            HomeBottomMenuItem(title = "home", iconId = R.drawable.ic_icons8_home_48),
//                            HomeBottomMenuItem(title = "search", iconId = R.drawable.ic_icons8_search_50),
//                            HomeBottomMenuItem(title = "person", iconId = R.drawable.ic_icons8_contacts_32)
//                        ),
//                        modifier = Modifier.align(Alignment.BottomCenter),
//                        selectedItemIndex = 2
//                    )
                }

            }


    @Composable
    fun ProfileItem(
        navController: NavHostController
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
                    painter = painterResource(id = R.drawable.mohamed),
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
                        text = "Mohamed Dekow",
                        modifier = Modifier.padding(top = 3.dp),
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = "mohadekow@gmail.com", modifier = Modifier
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

