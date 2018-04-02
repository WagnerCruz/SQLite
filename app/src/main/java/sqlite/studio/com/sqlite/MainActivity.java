package sqlite.studio.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase banco = openOrCreateDatabase("app",MODE_PRIVATE, null);
            banco.execSQL("CREATE TABLE IF NOT EXISTS DadosUsuario(nome VARCHAR, idade INT(3))");
//            banco.execSQL("INSERT INTO DadosUsuario (nome, idade) VALUES('Wagner', 39)");
//            banco.execSQL("INSERT INTO DadosUsuario (nome, idade) VALUES('Ana', 40)");
//            banco.execSQL("INSERT INTO DadosUsuario (nome, idade) VALUES('Davi', 3)");

            Cursor cursor = banco.rawQuery("SELECT nome, idade FROM DadosUsuario ", null);

            int indicecolunanome = cursor.getColumnIndex("nome");
            int indicecolunaidade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){


                Log.i("RESULTADO - nome: " , cursor.getString(indicecolunanome));
                Log.i("RESULTADO - idade: " , cursor.getString(indicecolunaidade));
                cursor.moveToNext();

                int contador = 0;
                contador = contador + 1;
                Toast.makeText(MainActivity.this,"Contador: " + contador,Toast.LENGTH_LONG).show();


            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
