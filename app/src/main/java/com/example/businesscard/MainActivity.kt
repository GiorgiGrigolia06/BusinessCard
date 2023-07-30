package com.example.businesscard

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(rgb(210, 232, 212))),
        verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column{}
        NameAndOccupation(
            stringResource(R.string.name_lastName),
            stringResource(R.string.job_position)
        )
        ContactInformation(
            stringResource(R.string.phone_number),
            stringResource(R.string.social_media),
            stringResource(R.string.email_address)
        )
    }
}

@Composable
fun NameAndOccupation(name: String, position: String){
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .size(150.dp)
                .background(Color(rgb(7, 48, 66)))
        )

        Text(
            text = name,
            color = Color(rgb(13, 31, 19)),
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        Text(
            text = position,
            fontSize = 20.sp,
            color = Color(rgb(15, 115, 67))
        )
    }
}


@Composable
fun ContactInformation(phoneNumber: String, socialMedia: String, emailAddress: String){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

        Column(Modifier.padding(end = 30.dp)) {
            val phoneIcon = painterResource(R.drawable.baseline_local_phone_24)
            Image(
                painter = phoneIcon,
                contentDescription = null,
                Modifier
                    .padding(bottom = 15.dp)
                    .height(20.dp)
            )

            val shareIcon = painterResource(R.drawable.baseline_share_24)
            Image(
                painter = shareIcon,
                contentDescription = null,
                Modifier
                    .padding(bottom = 15.dp)
                    .height(20.dp)
            )

            val emailIcon = painterResource(R.drawable.baseline_email_24)
            Image(
                painter = emailIcon,
                contentDescription = null,
                Modifier
                    .padding(bottom = 15.dp)
                    .height(20.dp)
            )
        }

        Column {
            Text(
                text = phoneNumber,
                Modifier
                    .padding(bottom = 15.dp)
                    .height(20.dp),
                color = Color(rgb(15, 115, 67)),
                fontSize = 13.sp
            )

            Text(
                text = socialMedia,
                Modifier
                    .padding(bottom = 15.dp)
                    .height(20.dp),
                color = Color(rgb(15, 115, 67)),
                fontSize = 13.sp
            )

            Text(
                text = emailAddress,
                Modifier
                    .padding(bottom = 15.dp)
                    .height(20.dp),
                color = Color(rgb(15, 115, 67)),
                fontSize = 13.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}