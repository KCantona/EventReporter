package com.hao.eventreporter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelectListener {
    private EventFragment mListFragment;
    private CommentFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Show different fragments based on screen size.
//        if (findViewById(R.id.fragment_container) != null) {
//            Fragment fragment = isTablet() ? new  CommentFragment() : new EventFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//        }

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        //add list view
        mListFragment = new EventFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.event_container, mListFragment).commit();


        //add Gridview
        if (isTablet()) {
            mGridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.comment_container, mGridFragment).commit();

        }
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }


//xml boolean value depends on screen size

//        // Get ListView object from xml.
//        ListView eventListView = (ListView) findViewById(R.id.event_list);
//
//        // Initialize an adapter.
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
////                this,
////                R.layout.event_item,
////                R.id.event_name,
////                getEventNames());
//
//        EventAdapter adapter = new EventAdapter(this);
//
//        // Assign adapter to ListView.
//        eventListView.setAdapter(adapter);


//    /**
//     * A dummy function to get fake event names.
//     *
//     * @return an array of fake event names.
//     */
//    private String[] getEventNames() {
//        String[] names = {
//                "Event1", "Event2", "Event3",
//                "Event4", "Event5", "Event6",
//                "Event7", "Event8", "Event9",
//                "Event10", "Event11", "Event12"};
//        return names;
//    }
@Override
protected void onStart() {
    super.onStart();
    Log.e("Life cycle test", "We are at onStart()");
}

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //important
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
//        if(isChangingConfigurations()) {
//            fragmentManager.beginTransaction().remove(fragment).commit();
//        }
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

    @Override
    public void onItemSelected(int position){
        mGridFragment.onItemSelected(position);
    }

}
