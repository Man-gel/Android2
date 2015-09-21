package com.example.acceso;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText usuario;
	private EditText contraseña;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		usuario = (EditText)findViewById(R.id.et_usuario);
		contraseña = (EditText)findViewById(R.id.et_password);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void validarUsuario(View v)
	{
		String user = usuario.getText().toString();
		String pass = contraseña.getText().toString();		
		if(user.isEmpty() || pass.isEmpty())
		{
			mostrarToast("Debe ingresar un nombre de usuario y una contraseña");
			contraseña.setText("");
			usuario.setText("");
			usuario.requestFocus();
			return;
		}
		if( !( user.equals("root") && pass.equals("admin")) )
		{
			mostrarToast("El nombre de usuario y/o la contraseña no son correctos");
			contraseña.setText("");
			usuario.setText("");
			usuario.requestFocus();
		}
		else
		{
			contraseña.setText("");
			usuario.setText("");
			mostrarToast("Bienvenido "+user+"!");
		}
	}
	
	@SuppressLint("ShowToast")
	private void mostrarToast(CharSequence mensaje)
	{
		Context contexto = getApplicationContext();
		Toast toast = Toast.makeText(contexto, mensaje, 3);
		toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();	
	}
}
