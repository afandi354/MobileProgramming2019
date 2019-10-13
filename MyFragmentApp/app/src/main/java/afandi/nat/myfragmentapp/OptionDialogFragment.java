package afandi.nat.myfragmentapp;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{

    Button btnChoose, btnClose;
    RadioGroup rgOptions;
    RadioButton rbNS, rbIR, rbAT, rbAF;
    OnOptionDialogListener optionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = view.findViewById(R.id.rg_options);
        rbNS = view.findViewById(R.id.rb_ns);
        rbIR = view.findViewById(R.id.rb_ir);
        rbAT = view.findViewById(R.id.rb_at);
        rbAF = view.findViewById(R.id.rb_af);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if(checkRadioButtonId != -1){
                    String dosen = null;
                    switch(checkRadioButtonId){
                        case R.id.rb_ns:
                            dosen = rbNS.getText().toString().trim();
                            break;
                        case R.id.rb_ir:
                            dosen = rbIR.getText().toString().trim();
                            break;
                        case R.id.rb_at:
                            dosen = rbAT.getText().toString().trim();
                            break;
                        case R.id.rb_af:
                            dosen = rbAF.getText().toString().trim();
                            break;
                    }

                    if(optionDialogListener != null){
                        optionDialogListener.onOptionChosen(dosen);
                    }
                    getDialog().dismiss();
                }
                break;
        }

    }

    public interface OnOptionDialogListener{
        void onOptionChosen(String text);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if(fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        this.optionDialogListener = null;
    }
}
