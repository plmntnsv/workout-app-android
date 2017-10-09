package com.example.plmntnsv.workoutapplication.utils;

import com.example.plmntnsv.workoutapplication.utils.contracts.ModalWindowLogic;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public class ModalWindow implements ModalWindowLogic {
    private NiftyDialogBuilder dialogBuilder;

    @Override
    public void setup() {
        dialogBuilder
                .withTitle("Loading...")
                .withTitleColor("#FFFFFF")
                .withDividerColor("#11000000")
                .withMessage("This is a modal Dialog.")
                .withMessageColor("#FFFFFFFF")
                .withDialogColor("#FFE74C3C")
                .isCancelableOnTouchOutside(false)  ;
                //.setCustomView(R.layout.custom_view,v.getContext());
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
