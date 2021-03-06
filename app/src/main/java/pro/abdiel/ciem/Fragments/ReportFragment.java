package pro.abdiel.ciem.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import pro.abdiel.ciem.Adapters.CredentialAdapter;
import pro.abdiel.ciem.R;
import pro.abdiel.ciem.models.ReadCredentialsModel;


public class ReportFragment extends Fragment {

    RecyclerView recyclerView;
    List<ReadCredentialsModel> itemList;

    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_report, container, false);
        recyclerView=view.findViewById(R.id.recyclerReport);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initData();
        recyclerView.setAdapter(new CredentialAdapter(initDataCredentials(),getContext()));
        return view;
    }

    private List<ReadCredentialsModel> initDataCredentials() {

        itemList=new ArrayList<ReadCredentialsModel>();
        itemList.add(new ReadCredentialsModel("Elsa Gutierrez","MEXON","24 - ENE- 2022","13:33","093892",R.drawable.alejandra));
        itemList.add(new ReadCredentialsModel("Veronica Galindo","MEXON","24 - ENE- 2022","13:36","093833",R.drawable.veronica));
        itemList.add(new ReadCredentialsModel("Miriam Rosas","MEXON","24 - ENE- 2022","13:34","093643",R.drawable.miriam));
        itemList.add(new ReadCredentialsModel("Jair Hernadez","MEXON","24 - ENE- 2022","13:40","093375",R.drawable.jair));
        itemList.add(new ReadCredentialsModel("Angeles Rivera","MEXON","24 - ENE- 2022","13:20","093888",R.drawable.angeles));
        itemList.add(new ReadCredentialsModel("Sofia Sanchez","MEXON","24 - ENE- 2022","13:22","0938456",R.drawable.sofia));
        itemList.add(new ReadCredentialsModel("Roberto Martinez","MEXON","24 - ENE- 2022","13:25","097056",R.drawable.roberto));



        return itemList;
    }
}