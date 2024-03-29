package info.emperinter.AndroidStudy.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import info.emperinter.AndroidStudy.R;

public class BFragment extends Fragment {

    private TextView mTvTitle;
    private Button Mret;
    private AFragment aFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);  //设置布局文件
//        return super.onCreateView(inflater, container, savedInstanceState);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);

        Mret = (Button) view.findViewById(R.id.ret);

        Mret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aFragment == null){
                    aFragment = new AFragment();
                }

                //按返回键上一个状态保持原样！Tag:"a"在ContainerActivity中设置;
                Fragment fragment = getFragmentManager().findFragmentByTag("b");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,aFragment).addToBackStack(null).commitAllowingStateLoss();
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,aFragment).addToBackStack(null).commitAllowingStateLoss();
                }

            }
        });

    }
}
