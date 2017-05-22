package com.santam.nanosofttest;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class PersonDetail  extends    android.app.Fragment {
    private static final String TAG = "Person Detail";
    public static View root;
    TextView mMame, mId, mAge, mDob;
    SqLiteDBHelper mDBHelper;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_person_detail, container, false);

        mMame = (TextView) root.findViewById(R.id.viewId);
        mId = (TextView) root.findViewById(R.id.viewName);
        mAge = (TextView) root.findViewById(R.id.viewAge);
        mDob = (TextView) root.findViewById(R.id.viewDOb);
        mDBHelper = new SqLiteDBHelper(root.getContext());
        Bundle args = getArguments();
        String id = args.getString("id");
        String Name = args.getString("name");
        Toast.makeText(root.getContext(),id+"/"+Name,Toast.LENGTH_LONG).show();
        fillData(id,Name);

        return root;
    }



    private void fillData(String id, String name) {

        Log.d(TAG, "viewData: Displaying Persons...");
        String finalName="", finalAge="", finalId="", finalDob="";
        Cursor data = mDBHelper.viewDataByID(id,name);

        while(data.moveToNext()){
            finalName = "<html><b>Name: </b>"+ data.getString(1)+"</html>";
            finalAge = "<html><b>Age: </b>"+ data.getString(2)+"</html>";
            finalId = "<html><b>ID: </b>"+ data.getString(0)+"</html>";
            finalDob = "<html><b>Name: </b>"+ data.getString(3)+"</html>";

        }
        mMame.setText(Html.fromHtml(finalName));
        mAge.setText(Html.fromHtml(finalAge));
        mId.setText(Html.fromHtml(finalId));
        mDob.setText(Html.fromHtml(finalDob));

    }
}
