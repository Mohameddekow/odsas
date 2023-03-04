package com.example.odsas.students_module.presentation.home_screen.componets

import com.example.odsas.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.OdsasTheme

@Composable
fun TopBar(
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(null) //profile image
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.dr_mutua),
            contentDescription = "image",
            modifier = Modifier
                .size(44.dp)
                .alpha(1f)
                .clip(RoundedCornerShape(50)),
            contentScale = ContentScale.Crop,
            fallback = painterResource(id = R.drawable.placeholder)
        )

        IconButton(
            modifier = Modifier.padding(start = 1.dp, top = 1.dp),
            onClick = {
                navController.navigate(Screens.NotificationScreen.route) {
                    popUpTo(Screens.NotificationScreen.route) {
                        inclusive = true
                    }
                }
            }) {
            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "menu",
                modifier = Modifier
                    .size(36.dp),
//                tint = Color.White,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OdsasTheme {
        TopBar(navController = rememberNavController())
    }
}