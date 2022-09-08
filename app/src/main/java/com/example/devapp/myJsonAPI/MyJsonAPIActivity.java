package com.example.devapp.myJsonAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.devapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyJsonAPIActivity extends AppCompatActivity {
    private TextView tv_advice_today, tv_advice_by_id, tv_advice_search;
    private Button btn_get_advice, btn_advice_by_id, btn_advice_search;
    private EditText et_advice_id, et_advice_search;
    private String url;
    private int adviceId;
    private String adviceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_json_apiactivity);

        url = "https://api.adviceslip.com/advice/";
        castViews();
        setListeners();
    }

    private void castViews() {
        // inputs
        et_advice_id = findViewById(R.id.et_advice_id);
        et_advice_search = findViewById(R.id.et_advice_search);
        // btns
        btn_get_advice = findViewById(R.id.btn_get_advice);
        btn_advice_by_id = findViewById(R.id.btn_advice_by_id);
        btn_advice_search = findViewById(R.id.btn_advice_search);
        // results
        tv_advice_today = findViewById(R.id.tv_advice_today);
        tv_advice_by_id = findViewById(R.id.tv_advice_by_id);
        tv_advice_search = findViewById(R.id.tv_advice_search);
    }

    private void setListeners() {
        // btn get random advice of the day
        btn_get_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jsonParseEmployees();
                jsonParseRandomAdvice();
            }
        });

        // btn get advice by id
        btn_advice_by_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_advice_id.getText().toString().equals("")) {
                    jsonParseAdviceById();
                } else {
                    et_advice_id.setError("Please input the advice id");
                    et_advice_id.requestFocus();
                }
            }
        });

        // btn get searched word
        btn_advice_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_advice_search.getText().toString().equals("")) {
                    jsonParseSearchWord();
                } else {
                    et_advice_search.setError("Please input a word to search...");
                    et_advice_search.requestFocus();
                }
            }
        });
    }

    private void jsonParseRandomAdvice() {
        JsonObjectRequest requestRandomAdvice = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject slipData = response.getJSONObject("slip");
                            adviceId = slipData.getInt("id");
                            adviceText = slipData.getString("advice");
                            tv_advice_today.setText("id : "+ adviceId + "\nadvice : " + adviceText);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyJsonAPIActivity.this, "Error occured = " + error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("API:", error.getMessage());
            }
        });
        MySingleton.getInstance(MyJsonAPIActivity.this).addToRequestQueue(requestRandomAdvice);
    }

    private void jsonParseAdviceById() {
        JsonObjectRequest requestAdviceById = new JsonObjectRequest(Request.Method.GET, url + et_advice_id.getText().toString(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject slipData = response.getJSONObject("slip");
                            adviceText = slipData.getString("advice");
                            tv_advice_by_id.setText(adviceText);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyJsonAPIActivity.this, "Error occured.", Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(MyJsonAPIActivity.this).addToRequestQueue(requestAdviceById);
    }

    private void jsonParseSearchWord() {
        JsonObjectRequest requestSearchWord = new JsonObjectRequest(Request.Method.GET, url + "search/" + et_advice_search.getText().toString(), null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray slips = response.getJSONArray("slips");
                        int slipsCount = Integer.parseInt(response.getString("total_results"));
                        int i;
                        ArrayList<String> searchList = new ArrayList<>();
                        for (i = 0; i < slips.length(); i++) {
                            JSONObject searchData = slips.getJSONObject(i);
                            searchList.add(searchData.getString("advice"));
                        }
                        tv_advice_search.setText("results : " + slipsCount + "\n" + searchList.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MyJsonAPIActivity.this, "Searching error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        MySingleton.getInstance(MyJsonAPIActivity.this).addToRequestQueue(requestSearchWord);
    }

}