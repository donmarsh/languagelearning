package org.marshsoft.languagelearning.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import org.marshsoft.languagelearning.models.OnboardPage.Companion.getData
import org.marshsoft.languagelearning.ui.theme.ButtonBlue
import org.marshsoft.languagelearning.ui.theme.IndicatorGrey
import org.marshsoft.languagelearning.ui.theme.Orange

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(){
    val context = LocalContext.current
    val onboardItems = getData()
    val pagerState = rememberPagerState()
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(35.dp), horizontalAlignment = Alignment.CenterHorizontally){
        HorizontalPager(count = onboardItems.size, state = pagerState) {currentPage->
            Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = onboardItems[currentPage].image), contentDescription =null,
                    modifier = Modifier.padding(bottom = 50.dp, top = 50.dp))
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Orange,
                    inactiveColor = IndicatorGrey,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp))
                Text(context.getString(onboardItems[currentPage].title,
                    ), style = TextStyle(textAlign = TextAlign.Center)
                )
                Text(context.getString(onboardItems[currentPage].subTitle),
                    style = TextStyle(textAlign = TextAlign.Center))
            }



        }

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = ButtonBlue,
            contentColor = Color.White
        ), modifier = Modifier.fillMaxWidth()){
            Text("Choose a language", style = TextStyle(

            ))
        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("Already a fillalearn user?")
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.White
            ), modifier = Modifier.padding(0.dp)){
                Text("Log in")
            }
        }
    }

}
