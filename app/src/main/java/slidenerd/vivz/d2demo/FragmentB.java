package slidenerd.vivz.d2demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import slidenerd.vivz.d2demo.extras.Keys;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentB extends Fragment implements View.OnClickListener {
    private SharedPreferences mPreferences;
    private TextView mTextStored;
    private Button mBtnRefresh;

    public FragmentB() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mTextStored = (TextView) view.findViewById(R.id.text_stored);
        mBtnRefresh = (Button) view.findViewById(R.id.btn_refresh);
        mBtnRefresh.setOnClickListener(this);
        loadStoredDataIntoTextView();
    }

    @Override
    public void onClick(View v) {
        loadStoredDataIntoTextView();
    }

    private void loadStoredDataIntoTextView() {
        String storedText = mPreferences.getString(Keys.PREF_INPUT, "Nothing found yet");
        mTextStored.setText(storedText);
    }
}
