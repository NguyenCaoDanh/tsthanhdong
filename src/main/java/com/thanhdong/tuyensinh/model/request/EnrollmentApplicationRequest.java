package com.thanhdong.tuyensinh.model.request;

import com.thanhdong.tuyensinh.entity.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class EnrollmentApplicationRequest {

    //enrollment application
    private String fullName;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String address;
//
    //citizen ìdentification
    private int numberCitizenIdentification;
    private LocalDate dateOfIssue;
    private String placeOfIssue;
    private String placeOfOrigin;
    private String placeOfPrecidence;
    private String frontOfCard;
    private String backOfCard;
    //learning process
    private int yearHighSchoolInfo;
    //ielts info
    private IeltsInfo ieltsInfo;
    //specialized  subject
    private SpecializedSubject specializedSubject;
    //school each
    private String school1;
    private int districtIdSchool1;
    private String school2;
    private int districtIdSchool2;
    private String school3;
    private int districtIdSchool3;
    //priority population
    private int priorityPopulationId;
    //specialized class (check not null)
    private SpecializedClass specializedClass;

    //Score class 10
    private String gradeStransciptPictureClass10;
    private BigDecimal mathSemester101;
    private BigDecimal mathSemester102;
    private BigDecimal physicSemester101;
    private BigDecimal physicSemester102;
    private BigDecimal chemistrySemester101;
    private BigDecimal chemistrySemester102;
    private BigDecimal biologySemester101;
    private BigDecimal biologySemester102;
    private BigDecimal historySemester101;
    private BigDecimal historySemester102;
    private BigDecimal geographySemester101;
    private BigDecimal geographySemester102;
    private BigDecimal foreignLanguageSemester101;
    private BigDecimal foreignLanguageSemester102;
    private BigDecimal civicEducationSemester101;
    private BigDecimal civicEducationSemester102;
    private BigDecimal literatureSemester101;
    private BigDecimal literatureSemester102;
    //Score Class 11
    private String gradeStransciptPictureClass11;
    private BigDecimal mathSemester111;
    private BigDecimal mathSemester112;
    private BigDecimal physicSemester111;
    private BigDecimal physicSemester112;
    private BigDecimal chemistrySemester111;
    private BigDecimal chemistrySemester112;
    private BigDecimal biologySemester111;
    private BigDecimal biologySemester112;
    private BigDecimal historySemester111;
    private BigDecimal historySemester112;
    private BigDecimal geographySemester111;
    private BigDecimal geographySemester112;
    private BigDecimal foreignLanguageSemester111;
    private BigDecimal foreignLanguageSemester112;
    private BigDecimal civicEducationSemester111;
    private BigDecimal civicEducationSemester112;
    private BigDecimal literatureSemester111;
    private BigDecimal literatureSemester112;
    //Score Class 12
    private String gradeStransciptPictureClass12;
    private BigDecimal mathSemester121;
    private BigDecimal physicSemester121;
    private BigDecimal chemistrySemester121;
    private BigDecimal biologySemester121;
    private BigDecimal historySemester121;
    private BigDecimal geographySemester121;
    private BigDecimal foreignLanguageSemester121;
    private BigDecimal civicEducationSemester121;
    private BigDecimal literatureSemester121;

    private Qualification qualification;

    //create list registration
    private List<RegistrationPreferences> registrationPreferencesList;


}
