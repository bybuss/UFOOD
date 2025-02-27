package bob.colbaskin.ufood.utils

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Preview(
    name = "My Phone",
    group = "Dark",
    widthDp = 720,
    heightDp = 1640,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Phone",
    group = "Dark",
    device = Devices.PIXEL_7,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Phone - Landscape",
    group = "Dark",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Unfolded Foldable",
    group = "Dark",
    device = Devices.PIXEL_FOLD,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Tablet",
    group = "Dark",
    device = Devices.PIXEL_TABLET,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Desktop",
    group = "Dark",
    device = "spec:width=1920dp,height=1080dp,orientation=landscape,dpi=420",
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
annotation class CustomDarkPreview

@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Preview(
    name = "My Phone",
    group = "Light",
    widthDp = 720,
    heightDp = 1640,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Phone",
    group = "Light",
    device = Devices.PIXEL_7,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Phone - Landscape",
    group = "Light",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Unfolded Foldable",
    group = "Light",
    device = Devices.PIXEL_FOLD,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Tablet",
    group = "Light",
    device = Devices.PIXEL_TABLET,
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Desktop",
    group = "Light",
    device = "spec:width=1920dp,height=1080dp,orientation=landscape,dpi=420",
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
annotation class CustomLightPreview