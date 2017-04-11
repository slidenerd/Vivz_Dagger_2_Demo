package slidenerd.vivz.d2demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import slidenerd.vivz.d2demo.extras.Keys;

/**
 * A placeholder fragment containing a simple view.
 */

/**
 * What object do you want?
 * Where do you want that object?
 * How will you provide or construct that object?
 */
public class FragmentA extends Fragment implements View.OnClickListener {
    @Inject
    SharedPreferences mPreferences;
    private EditText mInputText;
    private Button mBtnStore;

    public FragmentA() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mInputText = (EditText) view.findViewById(R.id.input_text);
        mBtnStore = (Button) view.findViewById(R.id.btn_store);
        mBtnStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        storeTextToPreferences();
    }

    private void storeTextToPreferences() {
        String text = mInputText.getText().toString().trim();
        if (text != null && !text.isEmpty()) {
            mPreferences.edit().putString(Keys.PREF_INPUT, text).apply();
        }
    }
}
