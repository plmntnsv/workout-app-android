package com.example.plmntnsv.workoutapplication.utils;

import android.view.View;

import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.utils.contracts.ModalWindowLogic;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public class ModalWindow implements ModalWindowLogic {
    private NiftyDialogBuilder dialogBuilder;

    public ModalWindow(View view){
        dialogBuilder = NiftyDialogBuilder.getInstance(view.getContext());
        this.setup(view);
    }

    @Override
    public void setup(View view) {
        dialogBuilder
                .withTitle("Loading...")
                .withTitleColor(R.color.modalMessageColor)
                .withDividerColor(R.color.modalMessageColor)
                .withDialogColor("#FF5DADE2")
                .isCancelableOnTouchOutside(false)
                .setCustomView(R.layout.modal_loading, view.getContext());
    }

    @Override
    public void show() {
        dialogBuilder.show();
    }

    @Override
    public void hide() {
        dialogBuilder.hide();
    }
}
