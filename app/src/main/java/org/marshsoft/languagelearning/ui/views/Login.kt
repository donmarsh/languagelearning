package org.marshsoft.languagelearning.ui.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.marshsoft.languagelearning.R
import org.marshsoft.languagelearning.ui.theme.ButtonBlue
import org.marshsoft.languagelearning.ui.theme.TopBarBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    Scaffold(
        topBar = { LoginTopBar() },
        content = { contentPadding->LoginContent(navController = navController, contentPadding) },

        )
}
@Composable
fun LoginContent(navController: NavController, contentPadding: PaddingValues)
{
    Column (modifier = Modifier
        .padding(
            top = contentPadding.calculateTopPadding(),
            start = 24.dp,
            end = 24.dp,
            bottom = contentPadding.calculateBottomPadding()
        )
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.illustrations),
            contentScale = ContentScale.FillBounds,
            contentDescription = "person",
            modifier = Modifier
                .width(105.dp)
                .height(82.dp)
                .clip(RectangleShape)
                .background(color = Color.Transparent)


        )
        Text(
            text = "For free, join now and start learning",
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily(Font(R.font.fredoka)),
                fontWeight = FontWeight(500),
                color = Color(0xFF080E1E),
                textAlign = TextAlign.Center,
                letterSpacing = 0.22.sp,
            )
        )
        CustomTextField(labelText = "Email Address", placeholderText = "Enter your email")
        CustomTextField(labelText = "Password", placeholderText = "Enter your password" )
        Text("Forgot Password", style = TextStyle(textAlign = TextAlign.Start,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.fredoka)),
            fontWeight = FontWeight(400),
            color = Color(0xFFD6185D),
            letterSpacing = 0.15.sp),
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp).clickable(indication = null,interactionSource = remember { MutableInteractionSource() }) { navController.navigate("login") })

        Button(content = {Text("Login", style = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.fredoka)),
            fontWeight = FontWeight(500),
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
            letterSpacing = 0.2.sp,
        ) )}, onClick = {},
            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = ButtonBlue,

                )
        )
        DottedOrLine()
        SocialLogins()
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("Not a member?")
            Button(content = {Text("Signup")}, onClick = {navController.navigate("signup")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = ButtonBlue
                ), contentPadding = PaddingValues(start = 0.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopBar(){
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Login", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)

            }},
        navigationIcon = { IconButton(onClick = { Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show() }) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = "back icon")
        }},
        modifier = Modifier.background(color = TopBarBlue)

    )
}