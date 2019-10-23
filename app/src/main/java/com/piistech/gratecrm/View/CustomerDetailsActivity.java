package com.piistech.gratecrm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.piistech.gratecrm.Model.Customer;
import com.piistech.gratecrm.Model.Repair;
import com.piistech.gratecrm.R;
import com.piistech.gratecrm.Utils.Adapter.CustomerAdapter;
import com.piistech.gratecrm.Utils.Adapter.RepairAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerDetailsActivity extends AppCompatActivity {

    @BindView(R.id.customer_details_repair_list)
    RecyclerView mList;
    @BindView(R.id.customer_details_back)
    ImageView mBack;

    private ArrayList<Repair> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        ButterKnife.bind(this);

        getData();
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(new RepairAdapter(arrayList,this));

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getData() {
        arrayList = new ArrayList<Repair>(){
            {
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
                add(new Repair("0", "Mar 1, 2019", "5", "24", "$1,200"));
            }
        };
    }
}
