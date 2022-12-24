package com.example.iitpatna;

import static com.example.iitpatna.R.color.iitpmain;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class AdminNoticeFragments extends Fragment {
FloatingActionButton addnoticefloatingbtn;
RecyclerView noticerecyclerview;
ArrayList<NoticeModel> noticelist;
AddNoticeAdapter adapter;
    FirebaseDatabase database;
    FirebaseStorage storage;
    ImageView noticeimage;
    CardView selectnoticeimage;
    TextView noticetitle;
    TextView noticedescription;
    TextView pdfname;
    ImageView pdfuploadbtn;
    TextView txtbviewuploadimage;
    AppCompatButton noticeuploadbtn;
    LinearLayout pdflayout;
    String nameofpdf;
    ActivityResultLauncher<String> launcher;
    Uri noticeimageresulturi;
    Uri noticepdfresulturi;
    ProgressDialog progressDialog, pdfornoticelist;


    





    public AdminNoticeFragments() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View =inflater.inflate(R.layout.fragment_admin_notice_fragments, container, false);
        addnoticefloatingbtn = View.findViewById(R.id.addnoticefloatingbtn);
        noticerecyclerview = View.findViewById(R.id.noticerecyclerview);
        noticerecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

//*******************Floating button add notice ******************************
        addnoticefloatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.add_notice_layout);
                noticeimage = dialog.findViewById(R.id.addnoticeimage);
                noticetitle = dialog.findViewById(R.id.addnoticetitle);
                noticedescription = dialog.findViewById(R.id.addnoticedescription);
                pdfname = dialog.findViewById(R.id.pdfname);
                pdfuploadbtn = dialog.findViewById(R.id.pdfuploadbtn);
                noticeuploadbtn = dialog.findViewById(R.id.uploadnoticebtn);
                txtbviewuploadimage = dialog.findViewById(R.id.txtviewuploadimage);
                selectnoticeimage = dialog.findViewById(R.id.selectnoticeimage);
                pdflayout = dialog.findViewById(R.id.pdflyout);
                dialog.show();
                //*******************Selecting image*************************
                selectnoticeimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        opengallery();
                    }
                });
                //***********************Selecting Image************************

//                //********************** selecting pdf************************
               pdflayout.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(android.view.View view) {
                       selectfile();

                   }
               });
    // ***********************Notice Upload process*******************************
                noticeuploadbtn.setOnClickListener(new View.OnClickListener() {
                    String title, description, date, time, image, pdf;
                    @Override
                    public void onClick(android.view.View view) {
                        if(noticetitle.getText().toString().isEmpty()){
                            noticetitle.setError("Empty");
                            noticetitle.requestFocus();

                        }
                       else if(noticedescription.getText().toString().isEmpty()){
                            noticedescription.setError("Empty");
                            noticedescription.requestFocus();

                        }
                       else if(noticeimageresulturi==null){
                            txtbviewuploadimage.setError("Empty");
                            txtbviewuploadimage.requestFocus();

                        }
                       else if(noticepdfresulturi==null){
                           pdfname.setText("please select pdf");
                           pdfname.setError("select pdf");
                           pdfname.requestFocus();
                        }
                        else{
                           title = noticetitle.getText().toString();
                           description = noticedescription.getText().toString();
                           image = noticeimageresulturi.toString();

                            Calendar calfordate = Calendar.getInstance();
                            SimpleDateFormat curentdate = new SimpleDateFormat("dd-MM-yy");
                            date = curentdate.format(calfordate.getTime());
                            Calendar calfortime = Calendar.getInstance();
                            SimpleDateFormat curenttime = new SimpleDateFormat("hh:mm");
                            time = curenttime.format(calfortime.getTime());
                            progressDialog = new ProgressDialog(getActivity());
                            progressDialog.setMessage("Adding Notice");
                            progressDialog.show();
                            StorageReference storageReference= storage.getReference().child("Notice");
                            storageReference.child(title).child("pdf").putFile(noticepdfresulturi).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    storageReference.child("pdf").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            pdf= uri.toString();
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Image Upload Failed", Toast.LENGTH_SHORT).show();

                                }                            });

                            storageReference.child(title).child("notice Image").putFile(noticeimageresulturi).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    storageReference.child(title).child("notice Image").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            NoticeModel noticemodel = new NoticeModel(title, description, uri.toString(), title+".pdf", date,time);
                                            database.getReference().child("Notice").child(title).setValue(noticemodel).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Toast.makeText(getContext(), "Notice Added", Toast.LENGTH_SHORT).show();
                                                    progressDialog.dismiss();
                                                    dialog.dismiss();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(getContext(), "Datbase upload failed", Toast.LENGTH_SHORT).show();
                                                    progressDialog.dismiss();
                                                    dialog.dismiss();
                                                }
                                            });

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Image Upload failed", Toast.LENGTH_SHORT).show();


                                }
                            });




                        }

                    }
                });
                // ***********************Notice Upload process*******************************


                
            }



            private void opengallery() {
                launcher.launch("image/*");

            }


        });
        // **************************Floating action button*****************************************
        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                noticeimage.setImageURI(result);
                noticeimageresulturi = result;


            }
        });


    //*******************Recycler View********************************
        pdfornoticelist = new ProgressDialog(getActivity());
        pdfornoticelist.setMessage("Loading...");
        pdfornoticelist.show();

        database.getReference().child("Notice").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                noticelist = new ArrayList<>();
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    NoticeModel data = datasnapshot.getValue(NoticeModel.class);
                    noticelist.add(data);

                }
                adapter = new AddNoticeAdapter(noticelist, getContext());
                noticerecyclerview.setAdapter(adapter);
                pdfornoticelist.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });









        return View;
    }

    private void selectfile() {
        Intent ipdf = new Intent();
        ipdf.setType("application/pdf");
        ipdf.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(ipdf, "SELECT PDF FILE"), 1);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 ){
            noticepdfresulturi = data.getData();
            pdfname.setText("pdf Selected");
            pdfname.setBackgroundColor(getResources().getColor(R.color.green));


        }
    }


}