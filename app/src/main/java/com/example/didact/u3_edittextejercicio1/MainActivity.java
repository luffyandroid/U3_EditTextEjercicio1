package com.example.didact.u3_edittextejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etEdad;
    RadioGroup rgSexo;
    CheckBox cbEstudiante;
    TextView tvResultado;
    Spinner spProvincia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etApellido = (EditText)findViewById(R.id.et_apellido);
        etNombre = (EditText)findViewById(R.id.et_nombre);
        etEdad = (EditText)findViewById(R.id.et_edad);
        rgSexo = (RadioGroup)findViewById(R.id.rg_sexo);
        cbEstudiante = (CheckBox)findViewById(R.id.cb_estudiante);
        tvResultado = (TextView)findViewById(R.id.tv_resultado);
        spProvincia = (Spinner)findViewById(R.id.sp_provincia);
        String[] provincia={"","Almería","Jaén","Málaga","Cádiz","Sevilla","Granada","Huelva","Córdoba"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,provincia);
        spProvincia.setAdapter(adaptador);
    }

    public void obtenerNombreCompleto(View view){

        //Recogemos el valor de los et nombre y apellidos
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String edad = etEdad.getText().toString();
        int sexo = rgSexo.getCheckedRadioButtonId();
        String provincia = spProvincia.getSelectedItem().toString();
        String estudiante = "";



        if (nombre.equals("") || apellido.equals("") || sexo == -1 || provincia.equals("")){
            Toast.makeText(getApplicationContext(),"Debes rellenar al menos los campos con asteriscos",
                    Toast.LENGTH_LONG).show();
        }else{

            if (cbEstudiante.isChecked()){
                estudiante = "Si";
            }else{
                estudiante = "No";
            }

            RadioButton radiogroup = (RadioButton)findViewById(sexo);
            String txt_radiogroup = radiogroup.getText().toString()+(" ");

            tvResultado.setText("Nombre: "+nombre+"\n"+
                                "Apellido: "+apellido+"\n"+
                                "Edad: "+edad+"\n"+
                                "Sexo: "+txt_radiogroup+"\n"+
                                "Provincia: "+provincia+"\n"+
                                "Estudiante: "+estudiante+"\n");

        }

    }


}
