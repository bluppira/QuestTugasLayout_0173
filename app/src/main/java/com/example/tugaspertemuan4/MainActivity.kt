package com.example.tugaspertemuan4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreen() }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.screen_background))
            .padding(dimensionResource(R.dimen.screen_padding)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(dimensionResource(R.dimen.top_spacing)))

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = stringResource(R.string.logo_desc),
            contentScale = ContentScale.Fit,
            modifier = Modifier.height(dimensionResource(R.dimen.header_logo_height))
        )

        Spacer(Modifier.height(dimensionResource(R.dimen.small_spacing)))

        Text(
            text = stringResource(R.string.title),
            fontSize = dimensionResource(R.dimen.title_size).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.text_title)
        )
        Text(
            text = stringResource(R.string.subtitle),
            fontSize = dimensionResource(R.dimen.subtitle_size).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.text_dark)
        )

        Spacer(Modifier.height(dimensionResource(R.dimen.card_spacing)))

        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.card_spacing))
        ) {
            ProfileCard(
                name = R.string.name_1,
                description = R.string.description_1,
                backgroundColor = R.color.card_red,
                image = R.drawable.strawberry,
                imageOnRight = true,
                nameColor = R.color.text_white,
                descriptionColor = R.color.text_cream
            )
            ProfileCard(
                name = R.string.name_2,
                description = R.string.description_2,
                backgroundColor = R.color.card_olive,
                image = R.drawable.blueberry,
                imageOnRight = false,
                nameColor = R.color.text_white,
                descriptionColor = R.color.text_cream
            )
            ProfileCard(
                name = R.string.name_3,
                description = R.string.description_3,
                backgroundColor = R.color.card_rose,
                image = R.drawable.plum,
                imageOnRight = true,
                nameColor = R.color.text_white,
                descriptionColor = R.color.text_cream
            )
            ProfileCard(
                name = R.string.name_4,
                description = R.string.description_4,
                backgroundColor = R.color.card_blush,
                image = R.drawable.lemon,
                imageOnRight = false,
                nameColor = R.color.text_dark,
                descriptionColor = R.color.text_dark
            )
        }

        Spacer(Modifier.weight(1f))

        Text(
            text = stringResource(R.string.copyright),
            fontSize = dimensionResource(R.dimen.copyright_size).value.sp,
            color = colorResource(R.color.text_dark)
        )
    }
}

