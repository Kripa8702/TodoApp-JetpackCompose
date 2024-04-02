import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedCheckbox(
    modifier: Modifier = Modifier
) {
    var checked by remember { mutableStateOf(false) }

    // Define the color for the checkbox background
    val checkboxColor by animateColorAsState(
        targetValue = if (checked) Color.White else MaterialTheme.colorScheme.secondary,
        animationSpec = tween(durationMillis = 200), label = "checkbox"
    )

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(color = checkboxColor, shape = CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSecondary,
                    shape = CircleShape
                )
                .padding(2.dp)
                .clickable { checked = !checked }
        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
