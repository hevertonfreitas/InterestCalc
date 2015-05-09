package com.heverton.interestcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText montanteText = (EditText) findViewById(R.id.editMontante);
		final EditText taxaText = (EditText) findViewById(R.id.editTaxa);
		final EditText tempoText = (EditText) findViewById(R.id.editTempo);
		final EditText capitalText = (EditText) findViewById(R.id.editCapital);

		Button calcular = (Button) findViewById(R.id.button_calcular);
		Button resetar = (Button) findViewById(R.id.button_resetar);

		calcular.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {

				int count = 0;
				int countMontante = 0;
				int countText = 0;
				int countTempo = 0;
				int countCapital = 0;

				if (montanteText.getText().toString().trim().length() == 0) {
					countMontante = 1;
				}
				if (taxaText.getText().toString().trim().length() == 0) {
					countText = 1;
				}
				if (tempoText.getText().toString().trim().length() == 0) {
					countTempo = 1;
				}
				if (capitalText.getText().toString().trim().length() == 0) {
					countCapital = 1;
				}

				count = countMontante + countText + countTempo + countCapital;

				if (count == 1) {
					if (montanteText.getText().toString().length() == 0) {
						Log.v("CALCULO", "MONTANTE");

						Double taxa = Double.parseDouble(taxaText.getText()
								.toString());
						Double tempo = Double.parseDouble(tempoText.getText()
								.toString());
						Double capital = Double.parseDouble(capitalText
								.getText().toString());

						Double resultado = (capital * (Math.pow(
								(1 + (taxa / 100)), tempo)));
						montanteText.setText(String.valueOf(Math
								.ceil(resultado))
								+ " ou "
								+ String.valueOf(resultado));

					} else if (taxaText.getText().toString().length() == 0) {
						Log.v("CALCULO", "TAXA");

						Double montante = Double.parseDouble(montanteText
								.getText().toString());
						Double tempo = Double.parseDouble(tempoText.getText()
								.toString());
						Double capital = Double.parseDouble(capitalText
								.getText().toString());

						Double resultado = ((Math.pow((montante / capital),
								(1 / tempo)) - 1) * 100);
						taxaText.setText(String.valueOf(Math.ceil(resultado))
								+ " ou " + String.valueOf(resultado));

					} else if (tempoText.getText().toString().length() == 0) {
						Log.v("CALCULO", "TEMPO");

						Double montante = Double.parseDouble(montanteText
								.getText().toString());
						Double taxa = Double.parseDouble(taxaText.getText()
								.toString());
						Double capital = Double.parseDouble(capitalText
								.getText().toString());

						Double resultado = ((Math.log(montante / capital)) / (Math
								.log(1 + (taxa / 100))));
						tempoText.setText(String.valueOf(Math.ceil(resultado))
								+ " ou " + String.valueOf((resultado)));

					} else if (capitalText.getText().toString().length() == 0) {
						Log.v("CALCULO", "CAPITAL");

						Double montante = Double.parseDouble(montanteText
								.getText().toString());
						Double taxa = Double.parseDouble(taxaText.getText()
								.toString());
						Double tempo = Double.parseDouble(tempoText.getText()
								.toString());

						Double resultado = (montante / (Math.pow(
								(1 + (taxa / 100)), tempo)));
						capitalText.setText(String.valueOf(Math.ceil(resultado)));

					} else if ((montanteText.getText().toString().length() > 0)
							&& (taxaText.getText().toString().length() > 0)
							&& (tempoText.getText().toString().length() > 0)
							&& (capitalText.getText().toString().length() > 0)) {
						Log.v("ERRO", "CAMPOS NÃO PREENCHIDOS");
					}
				} else {
					Toast.makeText(
							getApplicationContext(),
							R.string.empty_fields,
							Toast.LENGTH_SHORT).show();
				}

				count = 0;
				countMontante = 0;
				countText = 0;
				countTempo = 0;
				countCapital = 0;
			}
		});

		resetar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				montanteText.setText(null);
				taxaText.setText(null);
				tempoText.setText(null);
				capitalText.setText(null);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_about:
			// Lembre-se de adicionar a Activity no AndroidManifest.xml
			Intent i = new Intent(this, About.class);
			this.startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
