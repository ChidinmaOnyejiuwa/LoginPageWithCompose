package com.practice.loginpagewithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.loginpagewithcompose.ui.theme.LoginPageWithComposeTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginPageWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                    }
                }
            }
        }
    }
@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen(){
        var name by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier =Modifier.padding(all = 8.dp) )
        {
            Text(
                text ="Simple Login Page",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
            TextField(value = name,
                onValueChange ={nameInput ->name = nameInput},
                label = {Text ("Name")},
                modifier =Modifier
                    .fillMaxWidth()
                    .padding(bottom =10.dp))
            TextField(
                value = username,
                onValueChange = {usernameInput -> username = usernameInput},
                label = {Text("Username")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            TextField(
                value = password,
                onValueChange = {pwdInput -> password = pwdInput},
                label = {Text("Password")},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            TextField(value = email,
                onValueChange = {emailInput ->email =emailInput},
                label ={Text("Email")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            //this remember is not really necessary we added it to shorten the
            //code
                RememberMe()
            Button(onClick = {}) {
                Text(
                    text = "Login")
            }
            //the row makes the icon be side by side
            Row{
                Image(painter = painterResource(id =R.drawable.facebook),
                    contentDescription = "Clickable facebook icon",
                    modifier = Modifier.size(24.dp)
                )
                Image(painter = painterResource(id = R.drawable.gmail),
                    contentDescription ="Clickable gmail icon",
                    modifier =Modifier.size(24.dp)
                )
                Image(painter = painterResource(id = R.drawable.twitter),
                    contentDescription = "Clickable twitter icon",
                    modifier =Modifier.size(24.dp).clickable{
                        //what happens when the images are clicked
                    }
                )
            }
    }
}

@Composable
fun RememberMe(){
    //this var is for the switch button on start it will not work
    //but when you have finished inputting everything you click on it
    var isChecked by remember{ mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier =Modifier.fillMaxWidth())
    {
        Text(text = "Remember me")
        Switch(
            checked = isChecked,
            //the !ischecked give the opposite of everything
            onCheckedChange = {isChecked = !isChecked})
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
//this give the background ie the white
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
    LoginScreen()
}
}