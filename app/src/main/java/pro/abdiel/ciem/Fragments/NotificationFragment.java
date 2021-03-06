package pro.abdiel.ciem.Fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import pro.abdiel.ciem.Adapters.ItemAdapter;
import pro.abdiel.ciem.R;
import pro.abdiel.ciem.models.NotificationsModel;

public class NotificationFragment extends Fragment {
    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private List<NotificationsModel> itemList;
    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView=view.findViewById(R.id.recyclerNotification);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //FIREBASE
        db = FirebaseFirestore.getInstance();
        consulta();

        return view;
    }

    //EVENT LISTENER TO DATA IN REAL TIME
    public void consulta(){

        db.collection("Messages")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {

                        if (e != null) {

                            return;
                        }
                        itemList=new ArrayList<>();
                        for (DocumentSnapshot doc : snapshots) {
                            //GET DOCUMENT ID

                            if (doc.get("asunto") != null) {
                                String uuid = doc.getString("uuid");
                                Logger.d(uuid);

                                itemList.add(new NotificationsModel(R.drawable.messaging, uuid,doc.getString("asunto"), doc.getString("mensaje")));
                            }
                        }
                        recyclerView.setAdapter(new ItemAdapter(itemList,getContext()));

                    }
                });
    }

}