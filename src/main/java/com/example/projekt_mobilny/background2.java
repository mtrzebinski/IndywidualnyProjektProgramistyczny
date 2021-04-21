package com.example.projekt_mobilny;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class background2 extends AsyncTask<String, Void, String> {
    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public background2(Context context)
    {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("INFO");
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.setButton(dialog.BUTTON_NEGATIVE,"OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    protected String doInBackground(String ...voids)
    {
        String result = "";
        String nazwa = voids[0];
        String kategorie = voids[1];

        String connstr = "";
        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("pot","UTF-8")+"="+URLEncoder.encode(nazwa,"UTF-8")
                    +"&&"+URLEncoder.encode("kat","UTF-8")+"="+URLEncoder.encode(kategorie,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                result += line+"\n";
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }
        return result;
    }
}