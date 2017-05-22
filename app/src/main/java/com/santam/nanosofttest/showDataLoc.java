package com.santam.nanosofttest;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class showDataLoc extends   android.app.Fragment {

    public static View root;
    private static final String TAG = "ShowPerson";

    SqLiteDBHelper mDBHelper;

    private ListView mListView;

//    FragmentManager fn = new PersonData().getFragmentManager();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_show_data, container, false);

//        // Inflate the layout for this fragment
//        listview = (ListView) root.findViewById(R.id.list_View);
//        Item_List = new ArrayList<HashMap<String, String>>();
//        ReadDataFromDB();
        mListView = (ListView) root.findViewById(R.id.listView);
        mDBHelper = new SqLiteDBHelper(root.getContext());

        viewData();
        return root;
    }
    private void viewData() {
        Log.d(TAG, "viewData: Displaying Persons...");

        Cursor data = mDBHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){

            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(root.getContext(), android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDBHelper.getItemID(name);
                String ID = "";
                while(data.moveToNext()){
                    ID = data.getString(0);
                }
                if(!ID.equals("")){
                    Log.d(TAG, "onItemClick: The ID is: " + ID);

                    toastMessage(ID);
                    PersonDetailLoc personDetail= new PersonDetailLoc();
                    Bundle args = new Bundle();
                    args.putString("id", ID);

                    personDetail.setArguments(args);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.contentFrame1, personDetail)
                            .addToBackStack(null)
                            .commit();

                }
                else{
                    toastMessage("No ID associated with that name");
                }
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(root.getContext(),message, Toast.LENGTH_SHORT).show();
    }
}