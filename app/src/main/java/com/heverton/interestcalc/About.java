package com.heverton.interestcalc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class About extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		ImageButton imagem_si = (ImageButton) findViewById(R.id.logo_si);
		ImageButton imagem_unipar = (ImageButton) findViewById(R.id.logo_unipar);

		imagem_si.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Uri uriUrl = Uri
						.parse("http://www.unipar.br/cursos/graduacao/sistemas-de-informacao-umuarama-noturno/umuarama/campus-i/");
				Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
				startActivity(launchBrowser);
			}
		});

		imagem_unipar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Uri uriUrl = Uri.parse("http://www.unipar.br");
				Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
				startActivity(launchBrowser);
			}
		});
	}
}
