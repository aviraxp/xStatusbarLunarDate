package de.xiaoxia.xstatusbarlunardate;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class Setting extends PreferenceActivity implements OnSharedPreferenceChangeListener{

    ListPreference lp;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        //�ҵ����ã�����������޸�Ϊ��ǰ����option_name
        lp = (ListPreference)findPreference("minor");
        lp.setSummary(lp.getEntry());

        lp = (ListPreference)findPreference("lang");
        lp.setSummary(lp.getEntry());
        
        lp = (ListPreference)findPreference("year");
        lp.setSummary(lp.getEntry());
        
        //����sharedPreferences�仯
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    	//���÷����仯ʱ������summaryΪoption_name
        if(key.equals("minor")){
            lp.setSummary(lp.getEntry());
        }
        if(key.equals("lang")){
            lp.setSummary(lp.getEntry());
        }
        if(key.equals("year")){
            lp.setSummary(lp.getEntry());
        }
        return;
    }
}