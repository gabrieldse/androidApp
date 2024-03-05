package com.example.myapplication

//import com.example.compose.tutorial.SampleData
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Conversation(SampleData.conversationSample)
            }

        }
    }
}*/

data class ArtworkInformation(val title: String, val artist: String, val creationYear: Int)

//create a main typography element
val replyTypography = Typography(
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
)

@Composable
fun Gallery(artwork: ArtworkInformation) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.pika),
            contentDescription = "Artwork photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(shape = RoundedCornerShape(40.dp))
                //.border(1.5.dp, MaterialTheme.colorScheme.primaryContainer, CircleShape)
                //.fillMaxSize(1)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = artwork.title,
            color = MaterialTheme.colorScheme.secondaryContainer,
            style = MaterialTheme.typography.titleLarge,
            //textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = artwork.artist,
            color = MaterialTheme.colorScheme.secondaryContainer,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            shape = MaterialTheme.shapes.medium, tonalElevation = 1.dp
        ) {
            Text(
                text = artwork.title,
                modifier = Modifier.padding(all = 4.dp),
                style = MaterialTheme.typography.titleSmall
            )

        }
    }
}

@Preview( name = "Light Mode")
@Composable
fun PreviewMessageCard() {
    MyApplicationTheme {
        Surface {
            val artwork = ArtworkInformation(title = "'Pikachu'", artist = "Atsuko Nishid", creationYear = 1996 )
            Gallery(artwork)

        }
    }
}

/*@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn{
        items(messages) { message ->
            MessageCard(message)
        }
    }

}*/

/*@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)*/

/*@Preview
@Composable
fun PreviewConversation() {
    MyApplicationTheme {
        Conversation(SampleData.conversationSample)
    }
}*/

