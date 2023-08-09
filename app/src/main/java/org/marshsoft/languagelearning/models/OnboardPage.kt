package org.marshsoft.languagelearning.models

import org.marshsoft.languagelearning.R

class OnboardPage(
    val image:Int,
    val title:Int,
    val subTitle:Int
){
    companion object{
        fun getData(): List<OnboardPage>{
            return listOf(
                OnboardPage(R.drawable.illustrationshelloorientation, R.string.firstOnboardPageTitle, R.string.firstOnboardPageContent),
                OnboardPage(R.drawable.illustrationstimetolearn, R.string.secondOnboardPageTitle, R.string.secondOnboardPageContent),
                OnboardPage(R.drawable.illustrationslessons, R.string.thirdOnboardPageTitle, R.string.thirdOnboardPageContent)
            )
        }
    }
}