package drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ads.todayoffers.MainActivity;
import com.ads.todayoffers.PrimaryAdapter;
import com.ads.todayoffers.PrimaryDetailsFragment;
import com.ads.todayoffers.R;
import com.ads.todayoffers.SuperInterface;

import java.util.ArrayList;

/**
 * Created by thrmyr on 10/9/15.
 */
public class DiagnosticFragment extends Fragment {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int[] prgmImages = {R.drawable.dia_chennai, R.drawable.dia_elbit, R.drawable.dia_jagruthi, R.drawable.dia_one, R.drawable.dia_vijaya, R.drawable.dia_vijaya_new};
    public static String[] prgmNameList = {"Complete Health Package", "Take Kidney Test to Avoid...", "Free Eye Campain in Vasan Eye Care", "Consult your Dentist Now", "Body scan with ECG and MRI ", "Check Your details"};
    private SuperInterface mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.primary_layout, container, false);

        lv = (ListView) v.findViewById(R.id.listViewPrimary);

        lv.setAdapter(new PrimaryAdapter(getActivity(), prgmNameList, prgmImages));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Intent intentDetails = new Intent)

                Fragment fragment = new PrimaryDetailsFragment();

                MainActivity.deatailsBundle.putString("detailsname", prgmNameList[position]);
                MainActivity.deatailsBundle.putInt("detailsimage", prgmImages[position]);
                fragment.setArguments(MainActivity.deatailsBundle);
                Log.e("", "onItemclick bundle" + MainActivity.deatailsBundle);
            }
        });


        return v;
    }
}
