package com.example.plmntnsv.workoutapplication.Home;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.plmntnsv.workoutapplication.Login.LoginActivity;
import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Tabs.TabsActivity;
import com.example.plmntnsv.workoutapplication.utils.ModalWindow;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment implements HomeContracts.View {
    private Drawer mDrawer;
    private Drawable mImage;
    private AccountHeader mHeaderResult;
    private HomeContracts.Presenter mPresenter;
    private ModalWindow mModalWindow;
    private String mCurrentUserEmail;

    public DrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drawer_toolbar, container, false);
        mImage = getActivity().getResources().getDrawable(R.drawable.dark_drawer_header);

        String wait =  getResources().getString(R.string.please_wait);
        mModalWindow = new ModalWindow(root, wait);

        return root;
    }

    public void onStart(){
        super.onStart();
        mCurrentUserEmail = this.getCurrentUserEmail();
        this.setupHeader();
        this.setupDrawer();
        mPresenter.subscribe(this);
    }

    protected void setupDrawer() {
        Toolbar toolbar = this.getView().findViewById(R.id.drawer_toolbar);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_my_plans);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_logout);

        mDrawer = new DrawerBuilder()
                .withActivity(this.getActivity())
                .withAccountHeader(mHeaderResult)
                .withToolbar(toolbar)

                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 1){
                            mModalWindow.show();
                            navigateToMyWorkouts();
                        }
                        if (drawerItem.getIdentifier() == 2){
                            mModalWindow.show();
                            logoutCurrentUser();
                        }
                        return true;
                    }
                })
                .build();
    }

    private void navigateToMyWorkouts() {
        Toast.makeText(getContext(), "Logout successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), TabsActivity.class);
        startActivity(intent);
    }

    protected void setupHeader(){
        mHeaderResult = new AccountHeaderBuilder()
                .withActivity(getActivity())
                .withHeaderBackground(mImage)
                .addProfiles(
                        new ProfileDrawerItem().withEmail(mCurrentUserEmail)//.withName("asd").withIcon(getResources().getDrawable())
                )
                .build();
    }

    @Override
    public void onResume() {
        mModalWindow.hide();
        mDrawer.closeDrawer();
        mPresenter.subscribe(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mModalWindow.hide();
        mDrawer.closeDrawer();
        mPresenter.unsubscribe();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mModalWindow.hide();
        mPresenter = null;
        super.onDestroy();
    }

    public static DrawerFragment newInstance() {
        DrawerFragment fragment = new DrawerFragment();
        return fragment;
    }

    @Override
    public void setPresenter(HomeContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public String getCurrentUserEmail() {
        return mPresenter.getCurrentUser();
    }

    @Override
    public void navigateToLogin() {
        mModalWindow.hide();
        Toast.makeText(getContext(), "Logout successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void logoutCurrentUser() {
        mPresenter.logoutUser();
    }
}
