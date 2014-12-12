package com.example.vf996;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CategoryFragment extends Fragment {
	private TextView textView21, textView31, textView41;
	private Button button13, button23, button33;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_category, container, false);
		
		textView21 = (TextView)rootView.findViewById(R.id.textView21);
		textView31 = (TextView)rootView.findViewById(R.id.textView31);
		textView41 = (TextView)rootView.findViewById(R.id.textView41);
		String fontPath = "fonts/WalletIcons-Regular.otf";
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);

        textView21.setTypeface(tf);
        textView31.setTypeface(tf);
        textView41.setTypeface(tf);
		return rootView;
	}
}
