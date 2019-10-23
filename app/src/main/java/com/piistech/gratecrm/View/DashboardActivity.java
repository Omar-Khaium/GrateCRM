package com.piistech.gratecrm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.dashboard_list)
    RecyclerView mList;

    private ArrayList<Customer> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        getData();
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new CustomerAdapter(arrayList,this));
    }

    private void getData() {
        arrayList = new ArrayList<Customer>(){
            {
                add(new Customer("0", "Customer 1", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("1", "Customer 2", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("2", "Customer 3", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("3", "Customer 4", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("4", "Customer 5", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("5", "Customer 6", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("6", "Customer 7", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("7", "Customer 8", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("8", "Customer 9", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
                add(new Customer("9", "Customer 10", "01XXXXXXXXX", "example@mail.com", "Address Line 1\nAddress Line 2\nProvince", R.drawable.ic_ui_face));
            }
        };
    }
}
