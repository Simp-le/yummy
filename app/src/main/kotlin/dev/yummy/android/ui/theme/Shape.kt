package dev.yummy.android.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp), // text field, snackbar
    small = RoundedCornerShape(8.dp), // autocomplete menu, select menu, snackbars, standard menu, and text fields
    medium = RoundedCornerShape(8.dp), // cards and small FABs
    large = RoundedCornerShape(16.dp), // extended FABs, FABs, and navigation drawers
    extraLarge = RoundedCornerShape(16.dp), // large FABs
)