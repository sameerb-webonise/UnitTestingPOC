package com.example.sameer.unittestcasepoc;

import android.test.ActivityInstrumentationTestCase;

import com.jayway.android.robotium.solo.Solo;

/**
 * Created by webonise on 1/3/18.
 */

public class FormFillingActivityTest extends ActivityInstrumentationTestCase<FormFillingActivity> {

    private Solo solo;

    public FormFillingActivityTest(){
        super("com.example.sameer.unittestcasepoc", FormFillingActivity.class);
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
        solo.getButton(R.id.button);
        solo.clickOnButton(R.id.button);
    }
}
