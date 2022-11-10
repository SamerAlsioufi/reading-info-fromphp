package com.example.testing31;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.testing31.Adapter.ProvinsiAdapter;
import com.example.testing31.Model.Provinsi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Provinsi> provinsiList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_prov);
        provinsiList = new ArrayList<>();
        showList();

    }
    private void showList(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://web01.usn.no/~240179/android/cars.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray array= obj.getJSONArray("samer");
                            for (int i=0; i< array.length();i++){
                                JSONObject provObj =array.getJSONObject(i);
                                Provinsi p = new Provinsi(provObj.getString("companyID"),provObj.getString("companyName"));
                                provinsiList.add(p);
                            }
                            ProvinsiAdapter adapter =new ProvinsiAdapter(provinsiList,getApplicationContext());
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

        };
        Handler.getInstance(getApplicationContext()).addToRequestQue(stringRequest);
    }
}