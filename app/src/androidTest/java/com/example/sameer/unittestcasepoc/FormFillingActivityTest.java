package com.example.sameer.unittestcasepoc;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;

/**
 * Created by webonise on 1/3/18.
 */

public class FormFillingActivityTest extends ActivityInstrumentationTestCase2<FormFillingActivity> {

    private Solo solo;

    public FormFillingActivityTest(){
        super(FormFillingActivity.class);
    }

    public FormFillingActivityTest(String pkg, Class<FormFillingActivity> formFillingActivityClass) {
        super(pkg, formFillingActivityClass);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testActivityDisplay() throws Exception {
        solo.assertCurrentActivity("FormFillingActivity  displayed successfully", FormFillingActivity.class);
        solo.getView(R.id.fragmentContainer);
    }

    public void testViewLoaded() throws Exception {
        solo.waitForFragmentById(R.id.fragmentContainer);
        solo.getView(R.id.etFirstName);
        solo.getView(R.id.etMiddleName);
        solo.getView(R.id.etLastName);
        solo.getView(R.id.etDOB);
        solo.getView(R.id.button).callOnClick();
        //solo.clickOnButton(R.id.button);
    }

    public void testValidateData() throws Exception {
        FormFillingFragment formFillingFragment = (FormFillingFragment) solo.getCurrentActivity().getFragmentManager().findFragmentByTag("FormFillingActivity");
        formFillingFragment.validateData("dasd","asd","sadas","sdf");
    }

    public void testWithValisData() throws Exception {
        solo.enterText(((EditText) solo.getView(R.id.etFirstName)), "abc");
        solo.enterText(((EditText) solo.getView(R.id.etMiddleName)), "def");
        solo.enterText(((EditText) solo.getView(R.id.etLastName)), "ghi");
        solo.enterText(((EditText) solo.getView(R.id.etDOB)), "02/01/1988");
        solo.getView(R.id.button).callOnClick();
        //formFillingFragment.validateData("dasd","asd","sadas","sdf");
    }
}
