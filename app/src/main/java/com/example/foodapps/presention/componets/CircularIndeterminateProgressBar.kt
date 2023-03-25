package com.example.foodapps.presention.componets

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        BoxWithConstraints(
             modifier = Modifier.fillMaxSize()
        ) {
            val constraints = if (minHeight < 600.dp){
               myDecoupledConstraints(0.3f)
            }else{
                myDecoupledConstraints(0.7f)
            }
            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {
                val (progressBar, text) = createRefs()
                val bottomGuideline = createGuidelineFromBottom(0.3f)
                CircularProgressIndicator(
                    modifier = Modifier.constrainAs(progressBar) {
                        bottom.linkTo(bottomGuideline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }, color = MaterialTheme.colors.primary
                )
                Text(
                    text = "Loading ....",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    ),
                    modifier = Modifier.constrainAs(text){
                        top.linkTo(progressBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
            }
        }
    }

}

private fun myDecoupledConstraints(verticalBias: Float) : androidx.constraintlayout.compose.ConstraintSet {
      return ConstraintSet{
          val guideLine = createGuidelineFromTop(verticalBias)
          val progressBar = createRefFor("progressBar")
          val text = createRefFor("text")

          constrain(progressBar){
              top.linkTo(guideLine)
              start.linkTo(parent.start)
              end.linkTo(parent.end)
          }
          constrain(text){
              top.linkTo(progressBar.bottom)
              start.linkTo(parent.start)
              end.linkTo(parent.end)
          }
      }
}