package com.example.nepl2.navigationdrawerdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class NavigationDrawerFragment extends Fragment {

    TextView txt_admin_name;
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private NavigationDrawerCallbacks mCallbacks;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerListView;
    private View mFragmentContainerView;
    private int mCurrentSelectedPosition = 0;

    View rootView;

    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.drawer_drawer, container, false);
        mDrawerListView = (ExpandableListView) rootView.findViewById(R.id.list_slidermenu);
        txt_admin_name = (TextView) rootView.findViewById(R.id.txt_admin_name);
        mDrawerListView.setVisibility(View.VISIBLE);


        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);

            }
        });

        //Toast.makeText(getActivity(), ""+session.isLoggedIn(), Toast.LENGTH_SHORT).show();
        expandableListDetail = ExpandableListDataPump.getData();

        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());


        mDrawerListView.setAdapter(new ExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail));

        mDrawerListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int gupPosition) {


            }
        });


        mDrawerListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View view, int groupPosition, long id) {
                boolean retVal = true;
                if (groupPosition == ExpandableListAdapter.ITEMRatriyaSangathan) {


                    mDrawerLayout.closeDrawer(mFragmentContainerView);

                    retVal = false;
                } else if (groupPosition == ExpandableListAdapter.ITEMRajyaSangathan) {


                    mDrawerLayout.closeDrawer(mFragmentContainerView);


                      retVal = false;
                } else if (groupPosition == ExpandableListAdapter.ITEMShaherMahaSangathan) {
                    mDrawerLayout.closeDrawer(mFragmentContainerView);

                    retVal = false;
                }  else if (groupPosition == ExpandableListAdapter.ITEMShaherMahaSangathanLoksabha) {
                    mDrawerLayout.closeDrawer(mFragmentContainerView);

                    retVal = false;
                }   else if (groupPosition == ExpandableListAdapter.ITEMShaherMahaSangathanVidhansabha) {
                       retVal = false;
                } else if (groupPosition == ExpandableListAdapter.ITEMDirecotry) {

                     mDrawerLayout.closeDrawer(mFragmentContainerView);
                     retVal = false;

                }  else if (groupPosition == ExpandableListAdapter.ITEMSearchMembers) {
                    retVal = false;

                }else if (groupPosition == ExpandableListAdapter.ITEMReport) {
                     mDrawerLayout.closeDrawer(mFragmentContainerView);
                }
                else if (groupPosition == ExpandableListAdapter.ITEMOther) {

                    retVal = false;
                }
               /* else if (groupPosition == ExpandableListAdapter.ITEMContactUs) {
                    //Toast.makeText(getContext(),"hiii",Toast.LENGTH_LONG).show();
                    mDrawerLayout.closeDrawer(mFragmentContainerView);
                         retVal = false;
                }
                else if (groupPosition == ExpandableListAdapter.ITEMShareThisApp) {
                    //Toast.makeText(getContext(),"hiii",Toast.LENGTH_LONG).show();
                    mDrawerLayout.closeDrawer(mFragmentContainerView);

                    retVal = false;
                }*/
                return retVal;


            }
        });

        mDrawerListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                if (groupPosition == ExpandableListAdapter.ITEMSearchMembers) {
                    // call activity here
                    if (childPosition == ExpandableListAdapter.SUBITEMReport1) {

                        mDrawerLayout.closeDrawer(mFragmentContainerView);

                        // call activity here

                    } else if (childPosition == ExpandableListAdapter.SUBITEMReport2) {
                        mDrawerLayout.closeDrawer(mFragmentContainerView);



                             }


                } else if (groupPosition == ExpandableListAdapter.ITEMShaherMahaSangathanWard) {
                    // call activity here
                  /*  if (childPosition == ExpandableListAdapter.SUBITEMFounder) {

                    } else if (childPosition == ExpandableListAdapter.SUBITEMIdeologue) {

                    }else if (childPosition == ExpandableListAdapter.SUBITEMTimeLine) {

                    }*/
                }
                return true;
            }
        });

        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);


        return rootView;
    }




    public boolean isDrawerOpen() {
        hideKeyboard(getActivity());
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);

    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActionBar().setIcon(R.drawable.ic_drawer);
                hideKeyboard(getActivity());
                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard(getActivity());

                if (!isAdded()) {
                    return;
                }


                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };


        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // If the drawer is open, show the global app actions in the action bar. See also
        // showGlobalContextActionBar, which controls the top-left area of the action bar.
        if (mDrawerLayout != null && isDrawerOpen()) {
//            inflater.inflate(R.menu.menu_main, menu);
            showGlobalContextActionBar();

        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     */
    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

    }

    private ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    public void test() {
        Toast.makeText(getContext(), "test Method Called", Toast.LENGTH_SHORT).show();
    }

    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position);
    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }

    @Override
    public void onResume() {
        super.onResume();
        //switch menu

                //Toast.makeText(getActivity(), ""+session.isLoggedIn(), Toast.LENGTH_SHORT).show();
                expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

    }

    @Override
    public void onPause() {
        super.onPause();

        mDrawerListView = (ExpandableListView) rootView.findViewById(R.id.list_slidermenu);
        txt_admin_name = (TextView) rootView.findViewById(R.id.txt_admin_name);
        // displaying user data
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);

            }
        });

        //switch menu
            expandableListDetail = ExpandableListDataPump.getData();

        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());


        mDrawerListView.setAdapter(new ExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail));

        mDrawerListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition)
            {
            }
        });
    }
    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}