package com.wilis.array2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;

public class array2 extends Activity {
	List<almag> model = new ArrayList<almag>();
	ArrayAdapter<almag> adapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button save = (Button) findViewById(R.id.save);

		save.setOnClickListener(onSave);

		ListView list = (ListView) findViewById(R.id.almag);
		adapter = new ArrayAdapter<almag>(this,
				android.R.layout.simple_list_item_1, model);
		list.setAdapter(adapter);
	}

	private View.OnClickListener onSave = new View.OnClickListener() {
		public void onClick(View v) {
			almag r = new almag();
			EditText nama = (EditText) findViewById(R.id.nama);
			EditText alamat = (EditText) findViewById(R.id.alamat);

			r.setNama(nama.getText().toString());
			r.setAlamat(alamat.getText().toString());

			RadioGroup jekel = (RadioGroup) findViewById(R.id.jekel);

			switch (jekel.getCheckedRadioButtonId()) {
			case R.id.pria:
				r.setJekel("pria");
				break;

			case R.id.perempuan:
				r.setJekel("perempuan");
				break;

			}

			adapter.add(r);
		}
	};
}
