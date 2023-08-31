package org.marshsoft.languagelearning.ui.views

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
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
import org.marshsoft.languagelearning.ui.theme.DottedLineGray
import org.marshsoft.languagelearning.ui.theme.TextFieldBackground
import org.marshsoft.languagelearning.ui.theme.TopBarBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController:NavController)
{
    Scaffold(
        topBar = { SignUpTopBar() },
        content = { contentPadding->SignUpContent(navController = navController, contentPadding) },

    )
}
@Composable
fun SignUpContent(navController: NavController, contentPadding:PaddingValues)
{
    Column (modifier = Modifier
        .padding(start = 24.dp, end = 24.dp, top = contentPadding.calculateTopPadding(), bottom = contentPadding.calculateBottomPadding())
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Text("Create an Account", style = TextStyle(
            fontSize = 22.sp,
            lineHeight = 28.sp,
            fontFamily = FontFamily(Font(R.font.fredoka_one)),
            fontWeight = FontWeight(500),
            color = Color(0xFF080E1E),
            textAlign = TextAlign.Center,
            letterSpacing = 0.22.sp,
        ) )
        CustomTextField(labelText = "First Name", placeholderText = "Enter your First Name")
        CustomTextField(labelText = "Last Name", placeholderText = "Enter your Last Name")
        CustomTextField(labelText = "Email Address", placeholderText = "Enter your email address")
        Button(content = {Text("Continue", style = TextStyle(
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

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
            Text("Already a member?")
            Button(content = {Text("Login")},contentPadding = PaddingValues(start = 0.dp), onClick = {navController.navigate("login")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = ButtonBlue
                ))
        }


    }
}
@Composable
fun SocialLogins(){
    Row(modifier = Modifier.fillMaxWidth()){
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = TextFieldBackground,

            ), modifier = Modifier.weight(1f).clip(RoundedCornerShape(10.dp)).padding(end = 15.dp)) {
            Image(painter = painterResource(id = R.drawable.facebook_logo),modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
                contentDescription = "facebook logo")
        }
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = TextFieldBackground), modifier = Modifier.weight(1f).clip(RoundedCornerShape(10.dp))) {
            Image(painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "google logo", modifier = Modifier.padding(top = 12.dp, bottom = 12.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(labelText:String, placeholderText: String){
    var text by rememberSaveable { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxWidth()){
        Text(labelText, style = TextStyle(fontSize = 15.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.fredoka)),
            fontWeight = FontWeight(400),
            color = Color(0xFF363B44),
            letterSpacing = 0.15.sp)
        )
        OutlinedTextField(value = text, onValueChange ={text=it}, label = {Text("")},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            placeholder = {Text(placeholderText)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                containerColor = TextFieldBackground,


            )
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomPasswordField(labelText: String, placeholderText: String) {
    var text by rememberSaveable { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxWidth()){
        Text(labelText, style = TextStyle(fontSize = 15.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.fredoka)),
            fontWeight = FontWeight(400),
            color = Color(0xFF363B44),
            letterSpacing = 0.15.sp)
        )
        OutlinedTextField(value = text, onValueChange ={text=it}, label = {Text("")},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            placeholder = {Text(placeholderText)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                containerColor = TextFieldBackground,


                )
        )
    }

}

@Composable
fun DottedOrLine(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        Canvas(
            Modifier
                .weight(1f)
                .height(1.dp)) {

            drawLine(
                color = DottedLineGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }
        Text("Or", modifier = Modifier.padding(start=4.dp, end = 4.dp))
        Canvas(
            Modifier
                .weight(1f)
                .height(1.dp)) {

            drawLine(
                color = DottedLineGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(){
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Sign Up", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)

            }},
        navigationIcon = { IconButton(onClick = { Toast.makeText(context,"hello", Toast.LENGTH_SHORT).show() }) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = "back icon")
        }
        },
        modifier = Modifier.background(color = TopBarBlue)

    )
}

