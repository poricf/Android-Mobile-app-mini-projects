package com.example.astuwebsite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.activity.enableEdgeToEdge;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Column;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.padding;
import androidx.compose.material3.Button;
import androidx.compose.material3.Scaffold;
import androidx.compose.material3.Text;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.LocalContext;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;

import com.example.astuwebsite.ui.theme.ASTUWebsiteTheme;

public class MainActivity extends ComponentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContent(() -> {
            ASTUWebsiteTheme(() -> {
                Scaffold(modifier = Modifier.fillMaxSize(), (innerPadding) -> {
                    OpenASTUWebsiteButton(modifier = Modifier.padding(innerPadding));
                });
            });
        });
    }
}

@Composable
public void OpenASTUWebsiteButton(Modifier modifier) {
    Context context = LocalContext.current;
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to ASTU App", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp));
        Button(
            () -> {
                String url = "https://www.astu.edu.et/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent);
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Visit ASTU Website");
        }
    }
}

@Preview(showBackground = true)
@Composable
public void OpenASTUWebsiteButtonPreview() {
    ASTUWebsiteTheme(() -> {
        OpenASTUWebsiteButton(Modifier.getEMPTY());
    });
}