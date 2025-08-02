package dev.yummy.android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import dev.yummy.android.R

// Headlines
@OptIn(ExperimentalTextApi::class)
val fontFamilyPodkova = FontFamily(
    Font(
        R.font.podkova_variable_weight,
        variationSettings = FontVariation.Settings(FontVariation.weight(700))
    )
)

// General Text
@OptIn(ExperimentalTextApi::class)
val fontFamilyJost = FontFamily(
    Font(
        R.font.jost_variable_weight,
        variationSettings = FontVariation.Settings(FontVariation.weight(700))
    ),
    Font(
        R.font.jost_variable_weight,
        variationSettings = FontVariation.Settings(FontVariation.weight(600))
    ),
    Font(
        R.font.jost_variable_weight,
        variationSettings = FontVariation.Settings(FontVariation.weight(500))
    ),
    Font(
        R.font.jost_variable_weight,
        variationSettings = FontVariation.Settings(FontVariation.weight(400))
    ),
)


// Styles
val styleH1 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 36.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleH2 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 32.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleH3 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 28.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleH4 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 25.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleH5 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleH6 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 14.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleH7 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 12.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)

val styleDisplay1 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 45.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleDisplay2 = TextStyle(fontFamily = fontFamilyPodkova, fontSize = 18.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)

val styleBody1 = TextStyle(fontFamily = fontFamilyJost, fontSize = 18.sp, fontWeight = FontWeight.Normal, lineHeight = 1.2.em)
val styleBody2 = TextStyle(fontFamily = fontFamilyJost, fontSize = 16.sp, fontWeight = FontWeight.Normal, lineHeight = 1.2.em)
val styleBody3 = TextStyle(fontFamily = fontFamilyJost, fontSize = 14.sp, fontWeight = FontWeight.Normal, lineHeight = 1.2.em)
val styleBody4 = TextStyle(fontFamily = fontFamilyJost, fontSize = 14.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)
val styleBody5 = TextStyle(fontFamily = fontFamilyJost, fontSize = 12.sp, fontWeight = FontWeight.Normal, lineHeight = 1.2.em)
val styleBody6 = TextStyle(fontFamily = fontFamilyJost, fontSize = 12.sp, fontWeight = FontWeight.Bold, lineHeight = 1.2.em)

val styleCaption1 =
    TextStyle(fontFamily = fontFamilyJost, fontSize = 12.sp, fontWeight = FontWeight.Normal, lineHeight = 1.25.em)
val styleCaption2 =
    TextStyle(fontFamily = fontFamilyJost, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, lineHeight = 1.25.em)

val styleButton = TextStyle(fontFamily = fontFamilyJost, fontSize = 16.sp, fontWeight = FontWeight.Medium, lineHeight = 1.2.em)

val styleSubtitle1 = TextStyle(fontFamily = fontFamilyJost, fontSize = 18.sp, fontWeight = FontWeight.Medium)
val styleSubtitle2 = TextStyle(fontFamily = fontFamilyJost, fontSize = 16.sp, fontWeight = FontWeight.Medium)


// Typography for material3 theme
val baseline = Typography()

val Typography = Typography( // should be by docs
    displayLarge = baseline.displayLarge.merge(styleH1), // h1
    displayMedium = baseline.displayMedium.merge(styleH2), // h2
    displaySmall = baseline.displaySmall.merge(styleH3), // h3
    headlineLarge = baseline.headlineLarge.merge(styleH4), // N/A
    headlineMedium = baseline.headlineMedium.merge(styleH5), // h4
    headlineSmall = baseline.headlineSmall.merge(styleH6), // h5
    titleLarge = baseline.titleLarge.merge(styleH7), // h6
    titleMedium = baseline.titleMedium.merge(styleSubtitle1), // subtitle1
    titleSmall = baseline.titleSmall.merge(styleSubtitle2), // subtitle2
    bodyLarge = baseline.bodyLarge.merge(styleBody1), // body1
    bodyMedium = baseline.bodyMedium.merge(styleBody2), // body2
    bodySmall = baseline.bodySmall.merge(styleBody3), // caption
    labelLarge = baseline.labelLarge.merge(styleButton), // button
    labelMedium = baseline.labelMedium.merge(styleCaption1), // N/A
    labelSmall = baseline.labelSmall.merge(styleCaption2) // overline
)


// M2 type of typography, but with additions
val Typography.h1: TextStyle get() = styleH1
val Typography.h2: TextStyle get() = styleH2
val Typography.h3: TextStyle get() = styleH3
val Typography.h4: TextStyle get() = styleH4
val Typography.h5: TextStyle get() = styleH5
val Typography.h6: TextStyle get() = styleH6
val Typography.h7: TextStyle get() = styleH7

val Typography.display1: TextStyle get() = styleDisplay1
val Typography.display2: TextStyle get() = styleDisplay2

val Typography.body1: TextStyle get() = styleBody1
val Typography.body2: TextStyle get() = styleBody2
val Typography.body3: TextStyle get() = styleBody3
val Typography.body4: TextStyle get() = styleBody4
val Typography.body5: TextStyle get() = styleBody5
val Typography.body6: TextStyle get() = styleBody6

val Typography.caption1: TextStyle get() = styleCaption1
val Typography.caption2: TextStyle get() = styleCaption2

val Typography.button: TextStyle get() = styleButton

val Typography.subtitle1: TextStyle get() = styleSubtitle1
val Typography.subtitle2: TextStyle get() = styleSubtitle2