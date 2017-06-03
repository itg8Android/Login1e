package com.example.vaibhav.login1e.assessor;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.assessor.model.AssessorRegModel;
import com.example.vaibhav.login1e.assessor.mvp.AssessorMVP;
import com.example.vaibhav.login1e.assessor.mvp.AssessorPresenterImp;
import com.example.vaibhav.login1e.common.CommomMethod;
import com.example.vaibhav.login1e.common.DialogListFragmentListener;
import com.example.vaibhav.login1e.common.SharedPrefClass;
import com.example.vaibhav.login1e.dashboard.model.CitystateList;
import com.example.vaibhav.login1e.dashboard.model.StateList;
import com.example.vaibhav.login1e.exams.ListDataFragment;
import com.example.vaibhav.login1e.login.MainActivity;
import com.kbeanie.multipicker.api.FilePicker;
import com.kbeanie.multipicker.api.ImagePicker;
import com.kbeanie.multipicker.api.callbacks.FilePickerCallback;
import com.kbeanie.multipicker.api.callbacks.ImagePickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenFile;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.example.vaibhav.login1e.assessor.EnumType.FILE;
import static com.example.vaibhav.login1e.assessor.EnumType.IMAGE;

public class AddAssessor extends AppCompatActivity implements AssessorMVP.AssessorView, DialogListFragmentListener, View.OnClickListener, EasyPermissions.PermissionCallbacks {

    private static final String NO_INTERNET_CONNECTION = "No internet connection";
    private static final String WRONG = "Something went wrong";
    private static final String TAG = AddAssessor.class.getSimpleName();
    private static final String STATE_LIST = "Search state from list";
    private static final String CITY_LIST = "Search city from list";
    private static final String SELECT_DATE = "Please select date of birth";
    private static final int PICK_IMAGE = 101;
    private static final int RC_PERMISSION_STORAGE = 102;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtPan)
    EditText edtPan;
    @BindView(R.id.edtAdhar)
    EditText edtAdhar;
    @BindView(R.id.txtDob)
    TextView txtDob;
    @BindView(R.id.rdo_male)
    RadioButton rdoMale;
    @BindView(R.id.rdo_female)
    RadioButton rdoFemale;
    @BindView(R.id.edit)
    TextView edit;
    @BindView(R.id.edtQualification)
    EditText edtQualification;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtMobileNumber)
    EditText edtMobileNumber;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.state)
    EditText state;
    @BindView(R.id.city)
    EditText city;
    @BindView(R.id.edtAddress)
    EditText edtAddress;
    @BindView(R.id.pincode)
    EditText pincode;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    AssessorRegModel model;

    AssessorMVP.AssessorPresenter presenter;
    @BindView(R.id.edtExperience)
    EditText edtExperience;
    @BindView(R.id.captureImage)
    ImageView captureImage;
    @BindView(R.id.btn_capture_image)
    ImageButton btnCaptureImage;
    @BindView(R.id.btn_resume)
    Button btnResume;
    @BindView(R.id.txt_file_name)
    TextView txtFileName;
    //    private boolean mobileValidate = true;
//    private boolean emailValidate = true;
//    private boolean pincodeValidate = true;
    private StateList selectedState;
    private CitystateList selectedCity;
    //    private int mYear;
//    private int mMonth;
//    private int mDay;
    public String date;
    private EnumType type;
    private ImagePicker imagePicker;
    private String photopath;
    private String resume;
    private FilePicker filePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assessor);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToDb();
            }
        });
        presenter = new AssessorPresenterImp(this);
        presenter.prepareSpinner();
        txtDob.setOnClickListener(this);
        btnResume.setOnClickListener(this);
        btnCaptureImage.setOnClickListener(this);
    }

    private void saveToDb() {
//        if (date == null) {
//            txtDob.setError(SELECT_DATE);
//            return;
//        }
        if (presenter.onValidate(edtAddress, edtAdhar, edtEmail, edtMobileNumber, edtName, edtPan, edtQualification)
                && presenter.onEmailValidate(edtEmail) &&
                presenter.onMobileNumbervalidate(edtMobileNumber) && checkPhoto() && checkResume()) {
            model = new AssessorRegModel();
            model.setName(edtName.getText().toString());
            model.setGender(getGenderFromRdo());
            model.setEmail(edtEmail.getText().toString());
            model.setMobileNumber(edtMobileNumber.getText().toString());
            model.setPass(password.getText().toString());
            model.setState(selectedState.getIds());
            model.setCity(selectedCity.getIds());
            //model.setPan(edtPan.getText().toString());
            //model.setDob(txtDob.getText().toString());
            //model.setAdahar(edtAdhar.getText().toString());
            //model.setQualification(edtQualification.getText().toString());
            //model.setAddress(edtAddress.getText().toString());
            //model.setPincode(pincode.getText().toString());
            //model.setExperience(edtExperience.getText().toString());
            presenter.onStoreToDB(model, getBaseContext(), new File(photopath), new File(resume));
        }
    }

    private boolean checkResume() {
        return resume != null;
    }

    private boolean checkPhoto() {
        return photopath != null;
    }

    @Override
    public void onValidationFail(EditText editText) {
        editText.setError("Field is empty");
    }

    @Override
    public void onMobileNUmberInvalid(EditText editText) {
        editText.setError("Please enter valid mobile number");
    }


    @Override
    public void onPasswordValidateFail(EditText editText) {
        editText.setError("Password should contain number and text");
    }

    @Override
    public void onPincodeNotValid(EditText editText) {
        editText.setError("Please enter valid pincode");
    }

    @Override
    public void onSuccessfulRegister(String id) {
        SharedPrefClass.getInstance(this).savePref(CommomMethod.USERID, id);
        sendToLogin();
    }

    private void sendToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onUnSuccessfulCall(String error) {
        Log.d(TAG, "error" + error);
        showSnackbar(WRONG);
    }

    @Override
    public void onNoInternetConnection() {
        showSnackbar(NO_INTERNET_CONNECTION);
    }

    private void showSnackbar(String s) {
        Snackbar.make(toolbar, s, Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToDb();
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.onDistroy();
        super.onDestroy();
    }

    @Override
    public void prepareModelClass() {

//        model.setC
    }

    @Override
    public void onStatelistAvailable(final List<StateList> stateLists) {
        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogFragment(stateLists, STATE_LIST);
            }
        });
    }

    @Override
    public void onCityListAvailable(final List<CitystateList> citystateLists) {
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogFragment(citystateLists, CITY_LIST);
            }
        });
    }

    private void showDialogFragment(Object citystateLists, String title) {
        ListDataFragment.getInstance(citystateLists, title).show(getSupportFragmentManager(), "SECTOR");

    }

    public String getGenderFromRdo() {
        if (rdoFemale.isChecked())
            return "Female";

        return "Male";
    }

    @Override
    public void getSelectedItem(Object mSelectedata) {
        if (mSelectedata instanceof StateList) {
            selectedState = ((StateList) mSelectedata);
            state.setText(selectedState.getState());
            presenter.initCityByStateId(selectedState.getIds());
        } else if (mSelectedata instanceof CitystateList) {
            selectedCity = ((CitystateList) mSelectedata);
            city.setText(selectedCity.getCity());
        }
    }

    @Override
    public void onClick(View view) {
//        if(view.getId()==R.id.txtDob) {
//
//        }else
        if (view.getId() == R.id.btn_capture_image) {
            type = IMAGE;
            checkPermissionForFile();
        } else if (view.getId() == R.id.btn_resume) {
            type = EnumType.FILE;
            checkPermissionForFile();
        }
    }


    @AfterPermissionGranted(RC_PERMISSION_STORAGE)
    private void checkPermissionForFile() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            getFileFromMobile();
        } else {
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_storage), RC_PERMISSION_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void getFileFromMobile() {
//        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
//        getIntent.setType("image/*");
//
//        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        pickIntent.setType("image/*");
//
//        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
//        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
//
//        startActivityForResult(chooserIntent, PICK_IMAGE);
        if (type == IMAGE) {
            imagePicker = new ImagePicker(AddAssessor.this);
            imagePicker.shouldGenerateThumbnails(false);
            imagePicker.setImagePickerCallback(new ImagePickerCallback() {
                                                   @Override
                                                   public void onImagesChosen(List<ChosenImage> images) {
                                                       // Display images
                                                       if (images != null && images.size() > 0) {
                                                           Log.d(TAG, "imagepath " + images.get(0).getOriginalPath());
                                                           setImg(images.get(0).getOriginalPath());
                                                       }
                                                   }

                                                   @Override
                                                   public void onError(String message) {
                                                       // Do error handling
                                                       Log.d(TAG, "Emage: " + message);
                                                   }
                                               }
            );
            imagePicker.pickImage();
        } else if (type == FILE) {
            filePicker = new FilePicker(this);
            filePicker.setMimeType("application/pdf");
            filePicker.setFilePickerCallback(new FilePickerCallback() {
                @Override
                public void onFilesChosen(List<ChosenFile> list) {
                    if (list != null && list.size() > 0) {
                        resume=list.get(0).getOriginalPath();
                        txtFileName.setText(list.get(0).getDisplayName());
                    }
                }

                @Override
                public void onError(String s) {

                }
            });
            filePicker.pickFile();
        }
    }

    private void setImg(String originalPath) {
        photopath = originalPath;
        Glide.with(this).load(new File(originalPath)).into(captureImage);
    }


    private void captureImage() {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            // Do anything with file
            Log.d(TAG, "filepath: " + filePath);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (type == IMAGE) {
            captureImage();
        } else if (type == EnumType.FILE) {
            getFileFromMobile();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
