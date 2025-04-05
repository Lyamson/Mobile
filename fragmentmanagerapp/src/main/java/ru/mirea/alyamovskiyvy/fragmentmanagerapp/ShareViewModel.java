package ru.mirea.alyamovskiyvy.fragmentmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareViewModel extends ViewModel {
    private HashMap<String, String> countriesInfo = new HashMap<>();
    private final MutableLiveData<String> selectedItem = new MutableLiveData<>();
    public void setSelectedItem(String item) {
        selectedItem.setValue(item);
    }
    public LiveData<String> getSelectedItem() {
        return selectedItem;
    }
    public void addCountryWithInfo(String country, String info) {
        countriesInfo.put(country, info);
    }
    public String getCountryInfo(String country) {
        return countriesInfo.getOrDefault(country, "No info");
    }
    public List<String> getCountries() {
        return new ArrayList<>(countriesInfo.keySet());
    }
}
