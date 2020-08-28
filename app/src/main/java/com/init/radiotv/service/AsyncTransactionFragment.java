package com.init.radiotv.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.init.radiotv.utils.Constants;

/**
 * Só pra dar aquele efeito de transição de fragmento massa.
 */
public class AsyncTransactionFragment extends AsyncTask<String,Integer,Integer> {


    private ProgressDialog progressDialog;


    public AsyncTransactionFragment(ProgressDialog progressDialog){
        this.progressDialog=progressDialog;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        Integer loop=0;
        for(Integer i = 0 ; i < 8000000 ; i ++){

            loop+=1;
        }
        return loop;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressDialog.setMessage(Constants.MESSAGE_LOAD_TRANSACTION);
        this.progressDialog.show();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer != null){
            this.progressDialog.dismiss();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}
