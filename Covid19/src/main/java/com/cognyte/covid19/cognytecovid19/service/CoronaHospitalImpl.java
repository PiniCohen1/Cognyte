package com.cognyte.covid19.cognytecovid19.service;


import com.cognyte.covid19.cognytecovid19.model.CoronaDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoronaHospitalImpl implements CoronaHospital {

    @Autowired
    private List<CoronaDoctor> doctors;

    private int currentDoc = 0;

    @Override
    public void treat() {

        doctors.get(currentDoc).treatCurrentMutation();

        // Execute logic for specific type of object

//        if(doctors.get(currentDoc) instanceof CoronaDoctorC) {
//            System.out.println("This one is from instanceof:" +
//                    ((CoronaDoctorC)doctors.get(currentDoc)).getTreatMessage());
//        }
    }

    @Override
    public void changeToNextMutation() {
        System.out.println("Change To Next Mutation");
        currentDoc++;
        if (currentDoc == doctors.size()) {
            currentDoc = 0;
        }
    }

}
