package com.photoworld.presenter.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.photoworld.R

val InterFontFamily = FontFamily(
    Font(resId = R.font.inter_regular, weight = FontWeight.Normal),
    Font(resId = R.font.inter_medium, weight = FontWeight.Medium),
    Font(resId = R.font.inter_semi_bold, weight = FontWeight.SemiBold),
    Font(resId = R.font.inter_bold, weight = FontWeight.Bold),
)

val InterNormal10TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 15.sp,
    color = White,
)
val InterNormal12TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 18.sp,
    color = White,
)
val InterNormal14TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    color = White,
)
val InterNormal16TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 21.sp,
    color = White,
)
val InterMedium10TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = 12.sp,
    color = White,
)
val InterMedium12TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 18.sp,
    color = White,
)
val InterMedium14TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    color = White,
)
val InterMedium16TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    color = White,
)
val InterMedium18TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    lineHeight = 27.sp,
    color = White,
)
val InterMedium24TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    lineHeight = 36.sp,
    color = White,
)
val InterSemiBold10TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
    lineHeight = 12.sp,
    color = White,
)
val InterSemiBold12TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    lineHeight = 18.sp,
    color = White,
)
val InterSemiBold14TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    color = White,
)
val InterBold10TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 10.sp,
    lineHeight = 12.sp,
    color = White,
)
val InterBold12TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 12.sp,
    color = White,
)
val InterBold14TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 14.sp,
    color = White,
)
val InterBold16TextStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 16.sp,
    color = White,
)

val Typography = Typography(
    defaultFontFamily = InterFontFamily,
    h6 = InterMedium24TextStyle,
    subtitle1 = InterMedium18TextStyle,
    body1 = InterBold14TextStyle,
    button = InterMedium16TextStyle
)