package com.example.plmntnsv.workoutapplication.Utils;

import android.view.View;

import com.example.plmntnsv.workoutapplication.R;
import com.example.plmntnsv.workoutapplication.Utils.contracts.ModalWindowLogic;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

/**
 * Created by Plmn Tnsv on 09-Oct-17.
 */

public class ModalWindow implements ModalWindowLogic {
    private NiftyDialogBuilder dialogBuilder;

    public ModalWindow(View view, String title){
        dialogBuilder = NiftyDialogBuilder.getInstance(view.getContext());
        this.setup(view, title);
    }

    @Override
    public void setup(View view, String title) {
        dialogBuilder
                .withTitle(title)
                .withTitleColor("#FF000000")
                .withDividerColor("#FF5DADE2")
                .withDialogColor("#FFE8E8E8")
                .withEffect(Effectstype.Slidetop)
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
