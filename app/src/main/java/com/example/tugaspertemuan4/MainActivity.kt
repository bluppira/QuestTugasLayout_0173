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

@Composable
fun ProfileCard(
    @StringRes name: Int,
    @StringRes description: Int,
    @ColorRes backgroundColor: Int,
    @DrawableRes image: Int,
    imageOnRight: Boolean,
    @ColorRes nameColor: Int,
    @ColorRes descriptionColor: Int,
    modifier: Modifier = Modifier,
    @DimenRes nameSize: Int = R.dimen.name_size
) {
    val overflow = dimensionResource(R.dimen.image_overflow)
    val padding = dimensionResource(R.dimen.card_padding)
    val imageSpace = dimensionResource(R.dimen.image_space)

    Box(modifier = modifier.fillMaxWidth()) {
        // Hanya kotak card yang di-clip, gambar di luar clip sehingga bisa keluar card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = dimensionResource(R.dimen.card_height))
                .clip(RoundedCornerShape(dimensionResource(R.dimen.card_corner)))
                .background(colorResource(backgroundColor))
                .padding(
                    start = if (imageOnRight) padding else imageSpace,
                    end = if (imageOnRight) imageSpace else padding,
                    top = padding,
                    bottom = padding
                ),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(name),
                fontSize = dimensionResource(nameSize).value.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(nameColor)
            )
            Text(
                text = stringResource(description),
                fontSize = dimensionResource(R.dimen.detail_size).value.sp,
                color = colorResource(descriptionColor)
            )
        }

        Image(
            painter = painterResource(image),
            contentDescription = stringResource(R.string.logo_desc),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(if (imageOnRight) Alignment.CenterEnd else Alignment.CenterStart)
                .offset(x = if (imageOnRight) overflow else -overflow)
                .size(dimensionResource(R.dimen.image_size))
        )
    }
}