package com.example.openfinancesample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.openfinancesample.ui.theme.OpenFinanceSampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenFinanceSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(::setSuperDigitalIntent)
                }
            }
        }
    }


    private fun setSuperDigitalIntent() {
        val uri = Uri.parse("https://openfinance.dev.gruposuperdigital.com/openbanking?resumePath=%2Fas%2FAt5iB%2Fresume%2Fas%2Fauthorization.ping&allowInteraction=true&reauth=false&connectionId=superdigital-5015966c-a2bc-41c9-995b-f4810942e0c7-1.00&REF=EE889A2F9D1AFE5252FCE04013BBFAA73B74F3827539C56419C25E6D3711&scope=openid+resources+openid+payments+consent%3Aurn%3Asuperdigital%3Apay-4a5f8d5c-bc91-4fd9-9531-5c70cfb9eaf2&connectTimeout=500&socketTimeout=10000&response_type=code+id_token&connectionRequestTimeout=500&redirect_uri=https%3A%2F%2Fweb.conformance.directory.openbankingbrasil.org.br%2Ftest%2Fa%2Fsuper-04%2Fcallback&request_uri=urn%3Aietf%3Aparams%3Aoauth%3Arequest_uri%3AirZ9fOriIKIWQ8CkRBO2MK4V395ebTcR&client_id=superdigital-5015966c-a2bc-41c9-995b-f4810942e0c7-1.00")

        val intent = Intent(Intent.ACTION_VIEW, uri)

//        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
//        }
    }

}

@Composable
fun Greeting(setSuperDigitalIntent: (() -> Unit)?) {

    Button(modifier = Modifier
        .wrapContentHeight()
        .padding(16.dp), onClick = {
        setSuperDigitalIntent?.invoke()
    }) {
        Text(text = "Compartilhar dados")
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpenFinanceSampleTheme {
        Greeting(null)
    }
}