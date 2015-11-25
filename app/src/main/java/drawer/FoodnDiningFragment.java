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
public class FoodnDiningFragment extends Fragment {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int[] prgmImages = {R.drawable.food, R.drawable.food_four, R.drawable.food_kfc, R.drawable.food_one, R.drawable.food_pizza, R.drawable.food_pizza_ofc, R.drawable.food_six, R.drawable.food_three, R.drawable.food_two,};
    public static String[] prgmNameList = {"30% Off on Toatal Bill", "Buffet Lunch at 399/-", "KFC Coupons: 50% OFF on Fiery Grilled Bucket on Online Orders Only", "Buy a Large Pizza & Get a Medium FREE AND Buy a Medium Pizza & Get a Regular FREE at US Pizza.", "Pub Lunch for Rs.150 (AI) at Tap Quench Bar, Banjara Hills, Hyderabad.", "Get Free 1+1 on Indian Spirits & 2+1 on Indian Scotch with Complimentary Veg Snacks @ Ebony Hotel", "Happy Hours Offer at Spoil The Lounge, Hyderabad - Any Beverage or Snack at Rs.89.", "Save 10% on Kitty Parties at Ebony, Banjara Hills, Hyderabad.", "Test Purpose"};
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