package com.example.instagramsignpage

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramsignpage.ui.theme.InstagramSignPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramSignPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {


    var text1 by remember {
        mutableStateOf("Sign up to see photos and videos from your friends.")
    }
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Image(
            painterResource(id = R.drawable.instagram),
            contentDescription = "",

            )
        Text(
            text = text1,
            fontSize = 20.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 15.dp)

        )
        Button(
            onClick = {
                text1 = "Login with Facebook"
                alert1(context)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF4392ef)),
            modifier = Modifier
                .width(300.dp)
                .height(70.dp)
                .padding(bottom = 15.dp),
        ) {

            Text(text = "Login with Facebook", fontSize = 20.sp)
        }
        Text(
            text = "OR",
            fontSize = 20.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 15.dp)
        )

        var email by remember {
            mutableStateOf(TextFieldValue("Mobile Number or Email Address"))
        }

        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        var name by remember {
            mutableStateOf(TextFieldValue("Full Name"))
        }

        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        var user by remember {
            mutableStateOf(TextFieldValue("Username"))
        }

        TextField(
            value = user,
            onValueChange = { user = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        var pwd by remember {
            mutableStateOf(TextFieldValue("Password"))
        }

        TextField(
            value = pwd,
            onValueChange = { pwd = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
            Text(
                text = "People who use our service may have uploaded your contact information to Instagram. Learn More",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 15.dp)
            )

        Text(text = "By signing up, you agree to our Terms, Privacy Policy and Cookies Policy.",
            fontSize = 15.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 10.dp) )

        Button(
            onClick = {
                text1 = "Sign Up"
                alert2(context)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF4392ef)),
            modifier = Modifier
                .width(300.dp)
                .height(65.dp)
                .padding(top = 5.dp)
        ) {
            Text(text = "Sign Up", fontSize = 20.sp)
        }
    }

}

private fun alert1(context: Context) {
    val alertDialogBuilder = AlertDialog.Builder(context)
    alertDialogBuilder.setTitle("Go to Facebook") // Set the title of the dialog
    alertDialogBuilder.setMessage("This will direct you to your Facebook account") // Set the message of the dialog

    alertDialogBuilder.setPositiveButton("Next") { dialog, _ ->
        // Handle button click action
        dialog.dismiss() // Close the dialog
        Toast.makeText(
            context,
            "Open Facebook",
            Toast.LENGTH_SHORT
        ).show()
    }

    val alertDialog = alertDialogBuilder.create()
    alertDialog.show()
}

private fun alert2(context: Context) {
    val alertDialogBuilder = AlertDialog.Builder(context)
    alertDialogBuilder.setTitle("Sign Up") // Set the title of the dialog
    alertDialogBuilder.setMessage("You have Signed Up Successfully.") // Set the message of the dialog

    alertDialogBuilder.setPositiveButton("Next") { dialog, _ ->
        // Handle button click action
        dialog.dismiss() // Close the dialog
        Toast.makeText(
            context,
            "Enjoy Scrolling!",
            Toast.LENGTH_SHORT
        ).show()
    }

    alertDialogBuilder.setNegativeButton("Back") { dialog, _ ->
        // Handle button click action
        dialog.dismiss() // Close the dialog
        Toast.makeText(
            context,
            "Go back to Login Page",
            Toast.LENGTH_SHORT
        ).show()
    }

    val alertDialog = alertDialogBuilder.create()
    alertDialog.show()
}
}
