package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.*;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.model.request.EnrollmentApplicationRequest;
import com.thanhdong.tuyensinh.repository.*;
import com.thanhdong.tuyensinh.service.EnrollmentApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class EnrollmentApplicationServiceImpl implements EnrollmentApplicationService {

    @Autowired
    private EnrollmentApplicationRepository enrollmentApplicationRepository;
    @Autowired
    private IeltsInfoRepository ieltsInfoRepository;
    @Autowired
    private SubjectScoreRepository subjectScoreRepository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private AcademicResultsRepository academicResultsRepository;
    @Autowired
    private SpecializedSubjectRepository specializedSubjectRepository;
    @Autowired
    private HighSchoolEachRepository highSchoolEachRepository;
    @Autowired
    private HighSchoolInfoRepository highSchoolInfoRepository;
    @Autowired
    private LearningProcessRepository learningProcessRepository;
    @Autowired
    private CitizenIdentificationRepository citizenIdentificationRepository;
    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private RegistrationPreferencesRepository registrationPreferencesRepository;


    @Override
    public void createEnrollmentApplication(EnrollmentApplicationRequest request) {
        try {
            EnrollmentApplication enrollmentApplication = new EnrollmentApplication();

            // create object

            CitizenIdentification citizenIdentification = new CitizenIdentification();
            HighSchoolInfo highSchoolInfo = new HighSchoolInfo();
            LearningProcess learningProcess = new LearningProcess();
            AcademicResults academicResults = new AcademicResults();
            SpecializedSubject specializedSubject = new SpecializedSubject();
            HighSchoolEach highSchoolEach10 = new HighSchoolEach();
            HighSchoolEach highSchoolEach11 = new HighSchoolEach();
            HighSchoolEach highSchoolEach12 = new HighSchoolEach();
            Result result10 = new Result();
            Result result11 = new Result();
            Result result12 = new Result();
            SubjectScore math10 = new SubjectScore();
            SubjectScore physics10 = new SubjectScore();
            SubjectScore biology10 = new SubjectScore();
            SubjectScore chemistry10 = new SubjectScore();
            SubjectScore literature10 = new SubjectScore();
            SubjectScore history10 = new SubjectScore();
            SubjectScore geography10 = new SubjectScore();
            SubjectScore foreignlanguage10 = new SubjectScore();
            SubjectScore civic_education10 = new SubjectScore();
            SubjectScore math11 = new SubjectScore();
            SubjectScore physics11 = new SubjectScore();
            SubjectScore biology11 = new SubjectScore();
            SubjectScore chemistry11 = new SubjectScore();
            SubjectScore literature11 = new SubjectScore();
            SubjectScore history11 = new SubjectScore();
            SubjectScore geography11 = new SubjectScore();
            SubjectScore foreignlanguage11 = new SubjectScore();
            SubjectScore civic_education11 = new SubjectScore();
            SubjectScore math12 = new SubjectScore();
            SubjectScore physics12 = new SubjectScore();
            SubjectScore biology12 = new SubjectScore();
            SubjectScore chemistry12 = new SubjectScore();
            SubjectScore literature12 = new SubjectScore();
            SubjectScore history12 = new SubjectScore();
            SubjectScore geography12 = new SubjectScore();
            SubjectScore foreignlanguage12 = new SubjectScore();
            SubjectScore civic_education12 = new SubjectScore();
            Qualification qualification = new Qualification();

            //save
            enrollmentApplication.setQualificationId(qualificationRepository.save(request.getQualification()).getIdQualification());

            enrollmentApplication.setFullName(request.getFullName());
            enrollmentApplication.setDateOfBirth(Date.valueOf(request.getDateOfBirth()));
            enrollmentApplication.setPlaceOfBirth(request.getPlaceOfBirth());
            enrollmentApplication.setGender(request.getGender());
            enrollmentApplication.setEmail(request.getEmail());
            enrollmentApplication.setPhone(request.getPhone());
            enrollmentApplication.setAddress(request.getAddress());

            citizenIdentification.setNumberCitizenIdentification(request.getNumberCitizenIdentification());
            citizenIdentification.setDateOfIssue(Date.valueOf(request.getDateOfIssue()));
            citizenIdentification.setPlaceOfIssue(request.getPlaceOfIssue());
            citizenIdentification.setPlaceOfOrigin(request.getPlaceOfOrigin());
            citizenIdentification.setPlaceOfPrecidence(request.getPlaceOfPrecidence());
            citizenIdentification.setFrontOfCard(request.getFrontOfCard());
            citizenIdentification.setBackOfCard(request.getBackOfCard());

            enrollmentApplication.setCitizenIdentificationId(citizenIdentificationRepository.save(citizenIdentification).getIdCitizenIdentification());

            learningProcess.setYearHighSchoolInfo(request.getYearHighSchoolInfo());

            if (request.getIeltsInfo() != null) {
                IeltsInfo ieltsInfo = new IeltsInfo();
                ieltsInfo = ieltsInfoRepository.save(request.getIeltsInfo());
                academicResults.setIeltsInfoId(ieltsInfo.getIdIeltsInfo());
            }

            if (request.getSpecializedSubject() != null) {
                learningProcess.setSpecializedSubjectId(specializedSubjectRepository.save(request.getSpecializedSubject()).getIdSpecializedSubject());
            }

            highSchoolEach10.setNameHighSchool(request.getSchool1());
            highSchoolEach10.setDistrictIdDistrict(request.getDistrictIdSchool1());
            highSchoolInfo.setHighSchool1Id(highSchoolEachRepository.save(highSchoolEach10).getIdHighSchool());
            highSchoolEach11.setNameHighSchool(request.getSchool2());
            highSchoolEach11.setDistrictIdDistrict(request.getDistrictIdSchool2());
            highSchoolInfo.setHighSchool2Id(highSchoolEachRepository.save(highSchoolEach11).getIdHighSchool());
            highSchoolEach12.setNameHighSchool(request.getSchool3());
            highSchoolEach12.setDistrictIdDistrict(request.getDistrictIdSchool3());
            highSchoolInfo.setHighSchool3Id(highSchoolEachRepository.save(highSchoolEach12).getIdHighSchool());
            highSchoolInfo.setPriorityPopulationId(request.getPriorityPopulationId());

            learningProcess.setHighSchoolInfoId(highSchoolInfoRepository.save(highSchoolInfo).getIdHighSchoolInfo());

            if (request.getSpecializedClass() != null) {
                highSchoolInfo.setSpecializedClassId(request.getSpecializedClass().getIdSpecializedClass());
            }

            result10.setGradeTranscriptPicture(request.getGradeStransciptPictureClass10());

            math10.setFirstSemesterScore(request.getMathSemester101());
            math10.setSecondSemesterScore(request.getMathSemester102());
            result10.setMathId(subjectScoreRepository.save(math10).getIdSubjectScore());

            physics10.setFirstSemesterScore(request.getPhysicSemester101());
            physics10.setSecondSemesterScore(request.getPhysicSemester102());
            result10.setPhysicsId(subjectScoreRepository.save(physics10).getIdSubjectScore());

            chemistry10.setFirstSemesterScore(request.getChemistrySemester101());
            chemistry10.setSecondSemesterScore(request.getChemistrySemester102());
            result10.setChemistryId(subjectScoreRepository.save(chemistry10).getIdSubjectScore());

            biology10.setFirstSemesterScore(request.getBiologySemester101());
            biology10.setSecondSemesterScore(request.getBiologySemester102());
            result10.setBiologyId(subjectScoreRepository.save(biology10).getIdSubjectScore());

            literature10.setFirstSemesterScore(request.getHistorySemester101());
            literature10.setSecondSemesterScore(request.getHistorySemester102());
            result10.setLiteratureId(subjectScoreRepository.save(literature10).getIdSubjectScore());

            history10.setFirstSemesterScore(request.getHistorySemester101());
            history10.setSecondSemesterScore(request.getHistorySemester102());
            result10.setHistoryId(subjectScoreRepository.save(history10).getIdSubjectScore());

            geography10.setFirstSemesterScore(request.getGeographySemester101());
            geography10.setSecondSemesterScore(request.getGeographySemester102());
            result10.setGeographyId(subjectScoreRepository.save(geography10).getIdSubjectScore());

            foreignlanguage10.setFirstSemesterScore(request.getForeignLanguageSemester101());
            foreignlanguage10.setSecondSemesterScore(request.getForeignLanguageSemester102());
            result10.setForeignLanguageId(subjectScoreRepository.save(foreignlanguage10).getIdSubjectScore());

            civic_education10.setFirstSemesterScore(request.getCivicEducationSemester101());
            civic_education10.setSecondSemesterScore(request.getCivicEducationSemester102());
            result10.setCivicEducationId(subjectScoreRepository.save(civic_education10).getIdSubjectScore());

            result11.setGradeTranscriptPicture(request.getGradeStransciptPictureClass11());
            math11.setFirstSemesterScore(request.getMathSemester111());
            math11.setSecondSemesterScore(request.getMathSemester112());
            result11.setMathId(subjectScoreRepository.save(math11).getIdSubjectScore());

            physics11.setFirstSemesterScore(request.getPhysicSemester111());
            physics11.setSecondSemesterScore(request.getPhysicSemester112());
            result11.setPhysicsId(subjectScoreRepository.save(physics11).getIdSubjectScore());

            chemistry11.setFirstSemesterScore(request.getChemistrySemester111());
            chemistry11.setSecondSemesterScore(request.getChemistrySemester112());
            result11.setChemistryId(subjectScoreRepository.save(chemistry11).getIdSubjectScore());

            biology11.setFirstSemesterScore(request.getBiologySemester111());
            biology11.setSecondSemesterScore(request.getBiologySemester112());
            result11.setBiologyId(subjectScoreRepository.save(biology11).getIdSubjectScore());

            literature11.setFirstSemesterScore(request.getHistorySemester111());
            literature11.setSecondSemesterScore(request.getHistorySemester112());
            result11.setLiteratureId(subjectScoreRepository.save(literature11).getIdSubjectScore());

            history11.setFirstSemesterScore(request.getHistorySemester111());
            history11.setSecondSemesterScore(request.getHistorySemester112());
            result11.setHistoryId(subjectScoreRepository.save(history11).getIdSubjectScore());

            geography11.setFirstSemesterScore(request.getGeographySemester111());
            geography11.setSecondSemesterScore(request.getGeographySemester112());
            result11.setGeographyId(subjectScoreRepository.save(geography11).getIdSubjectScore());

            foreignlanguage11.setFirstSemesterScore(request.getForeignLanguageSemester111());
            foreignlanguage11.setSecondSemesterScore(request.getForeignLanguageSemester112());
            result11.setForeignLanguageId(subjectScoreRepository.save(foreignlanguage11).getIdSubjectScore());

            civic_education11.setFirstSemesterScore(request.getCivicEducationSemester111());
            civic_education11.setSecondSemesterScore(request.getCivicEducationSemester112());
            result11.setCivicEducationId(subjectScoreRepository.save(civic_education11).getIdSubjectScore());

            result12.setGradeTranscriptPicture(request.getGradeStransciptPictureClass12());
            math12.setFirstSemesterScore(request.getMathSemester121());
            result12.setMathId(subjectScoreRepository.save(math12).getIdSubjectScore());

            physics12.setFirstSemesterScore(request.getPhysicSemester121());
            result12.setPhysicsId(subjectScoreRepository.save(physics12).getIdSubjectScore());

            chemistry12.setFirstSemesterScore(request.getChemistrySemester121());
            result12.setChemistryId(subjectScoreRepository.save(chemistry12).getIdSubjectScore());

            biology12.setFirstSemesterScore(request.getBiologySemester121());
            result12.setBiologyId(subjectScoreRepository.save(biology12).getIdSubjectScore());

            literature12.setFirstSemesterScore(request.getLiteratureSemester121());
            result12.setLiteratureId(subjectScoreRepository.save(literature12).getIdSubjectScore());

            geography12.setFirstSemesterScore(request.getGeographySemester121());
            result12.setGeographyId(subjectScoreRepository.save(geography12).getIdSubjectScore());

            history12.setFirstSemesterScore(request.getHistorySemester121());
            result12.setHistoryId(subjectScoreRepository.save(history12).getIdSubjectScore());

            foreignlanguage12.setFirstSemesterScore(request.getForeignLanguageSemester121());
            result12.setForeignLanguageId(subjectScoreRepository.save(foreignlanguage12).getIdSubjectScore());

            civic_education12.setFirstSemesterScore(request.getCivicEducationSemester121());
            result12.setCivicEducationId(subjectScoreRepository.save(civic_education12).getIdSubjectScore());

            academicResults.setResult10ThGrade(resultRepository.save(result10).getIdResult());
            academicResults.setResult11ThGrade(resultRepository.save(result11).getIdResult());
            academicResults.setResult12ThGrade(resultRepository.save(result12).getIdResult());

            learningProcess.setAcademicResultsId(academicResultsRepository.save(academicResults).getIdAcademicResults());

            enrollmentApplication.setLearningProcessId(learningProcessRepository.save(learningProcess).getIdLearningProcess());
            enrollmentApplication.setEnrollmentApplicationStatusId(1);
            enrollmentApplication.setProfileId(1);


            int eid = enrollmentApplicationRepository.save(enrollmentApplication).getIdEnrollmentApplication();
            //assignment
            for (RegistrationPreferences r : request.getRegistrationPreferencesList()) {
                RegistrationPreferences p = new RegistrationPreferences();
                p.setPriorityLevel(r.getPriorityLevel());
                p.setRecruitmentId(r.getRecruitmentId());
                p.setEnrollmentApplicationId(eid);
                p.setRegistrationPreferencesStatusId(1);

                registrationPreferencesRepository.save(p);

            }

        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public EnrollmentApplication updateEnrollmentApplication(int id, EnrollmentApplicationRequest request) {
        try {
            EnrollmentApplication enrollmentApplication = enrollmentApplicationRepository.findById(id).get();
            // Update enrollment application data
            enrollmentApplication.setFullName(request.getFullName());
            enrollmentApplication.setDateOfBirth(Date.valueOf(request.getDateOfBirth()));
            enrollmentApplication.setPlaceOfBirth(request.getPlaceOfBirth());
            enrollmentApplication.setGender(request.getGender());
            enrollmentApplication.setEmail(request.getEmail());
            enrollmentApplication.setPhone(request.getPhone());
            enrollmentApplication.setAddress(request.getAddress());

            // Update CitizenIdentification
            CitizenIdentification citizenIdentification = new CitizenIdentification();
            citizenIdentification.setIdCitizenIdentification(enrollmentApplication.getCitizenIdentificationId());
            citizenIdentification.setNumberCitizenIdentification(request.getNumberCitizenIdentification());
            citizenIdentification.setDateOfIssue(Date.valueOf(request.getDateOfIssue()));
            citizenIdentification.setPlaceOfIssue(request.getPlaceOfIssue());
            citizenIdentification.setPlaceOfOrigin(request.getPlaceOfOrigin());
            citizenIdentification.setPlaceOfPrecidence(request.getPlaceOfPrecidence());
            citizenIdentification.setFrontOfCard(request.getFrontOfCard());
            citizenIdentification.setBackOfCard(request.getBackOfCard());

            citizenIdentificationRepository.save(citizenIdentification);

            //Update learning process
            LearningProcess learningProcess = learningProcessRepository.findById(enrollmentApplication.getLearningProcessId()).get();
            learningProcess.setIdLearningProcess(enrollmentApplication.getLearningProcessId());
            learningProcess.setYearHighSchoolInfo(request.getYearHighSchoolInfo());
            learningProcessRepository.save(learningProcess);

            //Update specialized subject
            SpecializedSubject specializedSubject = specializedSubjectRepository.findById(learningProcess.getSpecializedSubjectId()).get();
            specializedSubject.setIdSpecializedSubject(learningProcess.getSpecializedSubjectId());
            specializedSubject.setCertificate(request.getSpecializedSubject().getCertificate());
            specializedSubject.setNameSpecializedSubject(request.getSpecializedSubject().getNameSpecializedSubject());
            specializedSubjectRepository.save(specializedSubject);

            //Check academic result
            AcademicResults academicResults = academicResultsRepository.findById(learningProcess.getAcademicResultsId()).get();
            academicResults.setIdAcademicResults(learningProcess.getAcademicResultsId());

            //Update ielts info
            IeltsInfo ieltsInfo = ieltsInfoRepository.findById(academicResults.getIeltsInfoId()).get();
            ieltsInfo.setIdIeltsInfo(academicResults.getIeltsInfoId());
            ieltsInfo.setScore(request.getIeltsInfo().getScore());
            ieltsInfo.setCertificate(request.getIeltsInfo().getCertificate());
            ieltsInfoRepository.save(ieltsInfo);

            //Check High Shool Info
            HighSchoolInfo highSchoolInfo = highSchoolInfoRepository.findById(learningProcess.getHighSchoolInfoId()).get();
            highSchoolInfo.setIdHighSchoolInfo(learningProcess.getHighSchoolInfoId());

            //Update School 10
            HighSchoolEach highSchoolEach10 = highSchoolEachRepository.findById(highSchoolInfo.getHighSchool1Id()).get();
            highSchoolEach10.setIdHighSchool(highSchoolInfo.getHighSchool1Id());
            highSchoolEach10.setNameHighSchool(request.getSchool1());
            highSchoolEachRepository.save(highSchoolEach10);

            //Update School 11
            HighSchoolEach highSchoolEach11 = highSchoolEachRepository.findById(highSchoolInfo.getHighSchool2Id()).get();
            highSchoolEach11.setIdHighSchool(highSchoolInfo.getHighSchool2Id());
            highSchoolEach11.setNameHighSchool(request.getSchool2());
            highSchoolEachRepository.save(highSchoolEach11);

            //Update School 12
            HighSchoolEach highSchoolEach12 = highSchoolEachRepository.findById(highSchoolInfo.getHighSchool3Id()).get();
            highSchoolEach12.setIdHighSchool(highSchoolInfo.getHighSchool3Id());
            highSchoolEach12.setNameHighSchool(request.getSchool3());
            highSchoolEachRepository.save(highSchoolEach12);

            //Update result 10
            Result result10 = resultRepository.findById(academicResults.getResult10ThGrade()).get();
            result10.setIdResult(academicResults.getResult10ThGrade());
            result10.setGradeTranscriptPicture(request.getGradeStransciptPictureClass10());
            resultRepository.save(result10);

            //Update result 11
            Result result11 = resultRepository.findById(academicResults.getResult11ThGrade()).get();
            result11.setIdResult(academicResults.getResult11ThGrade());
            result11.setGradeTranscriptPicture(request.getGradeStransciptPictureClass11());
            resultRepository.save(result11);

            //Update result 12
            Result result12 = resultRepository.findById(academicResults.getResult12ThGrade()).get();
            result12.setIdResult(academicResults.getResult12ThGrade());
            result12.setGradeTranscriptPicture(request.getGradeStransciptPictureClass12());
            resultRepository.save(result12);

            //Score class 10
            //Math
            SubjectScore M10 = subjectScoreRepository.findById(result10.getMathId()).get();
            M10.setIdSubjectScore(result10.getMathId());
            M10.setFirstSemesterScore(request.getMathSemester101());
            M10.setSecondSemesterScore(request.getMathSemester102());
            subjectScoreRepository.save(M10);

            //Physics
            SubjectScore P10 = subjectScoreRepository.findById(result10.getPhysicsId()).get();
            P10.setIdSubjectScore(result10.getPhysicsId());
            P10.setFirstSemesterScore(request.getPhysicSemester101());
            P10.setSecondSemesterScore(request.getPhysicSemester102());
            subjectScoreRepository.save(P10);

            //Chemistry
            SubjectScore C10 = subjectScoreRepository.findById(result10.getChemistryId()).get();
            C10.setIdSubjectScore(result10.getChemistryId());
            C10.setFirstSemesterScore(request.getChemistrySemester101());
            C10.setSecondSemesterScore(request.getChemistrySemester102());
            subjectScoreRepository.save(C10);

            //Biology
            SubjectScore biology10 = subjectScoreRepository.findById(result10.getBiologyId()).get();
            biology10.setIdSubjectScore(result10.getBiologyId());
            biology10.setFirstSemesterScore(request.getBiologySemester101());
            biology10.setSecondSemesterScore(request.getBiologySemester102());
            subjectScoreRepository.save(biology10);

            //Literature
            SubjectScore literature10 = subjectScoreRepository.findById(result10.getLiteratureId()).get();
            literature10.setIdSubjectScore(result10.getLiteratureId());
            literature10.setFirstSemesterScore(request.getLiteratureSemester101());
            literature10.setSecondSemesterScore(request.getLiteratureSemester102());
            subjectScoreRepository.save(literature10);

            //History
            SubjectScore history10 = subjectScoreRepository.findById(result10.getHistoryId()).get();
            history10.setIdSubjectScore(result10.getHistoryId());
            history10.setFirstSemesterScore(request.getHistorySemester101());
            history10.setSecondSemesterScore(request.getHistorySemester102());
            subjectScoreRepository.save(history10);

            //Geography
            SubjectScore geography10 = subjectScoreRepository.findById(result10.getGeographyId()).get();
            geography10.setIdSubjectScore(result10.getGeographyId());
            geography10.setFirstSemesterScore(request.getGeographySemester101());
            geography10.setSecondSemesterScore(request.getGeographySemester102());
            subjectScoreRepository.save(geography10);

            //Foreign Language
            SubjectScore foreignLanguage10 = subjectScoreRepository.findById(result10.getForeignLanguageId()).get();
            foreignLanguage10.setIdSubjectScore(result10.getForeignLanguageId());
            foreignLanguage10.setFirstSemesterScore(request.getForeignLanguageSemester101());
            foreignLanguage10.setSecondSemesterScore(request.getForeignLanguageSemester102());
            subjectScoreRepository.save(foreignLanguage10);

            //Civic Education
            SubjectScore civicEducation10 = subjectScoreRepository.findById(result10.getCivicEducationId()).get();
            civicEducation10.setIdSubjectScore(result10.getCivicEducationId());
            civicEducation10.setFirstSemesterScore(request.getCivicEducationSemester101());
            civicEducation10.setSecondSemesterScore(request.getCivicEducationSemester102());
            subjectScoreRepository.save(civicEducation10);

            //Score class 11
            //Math
            SubjectScore math11 = subjectScoreRepository.findById(result11.getMathId()).get();
            math11.setIdSubjectScore(result11.getMathId());
            math11.setFirstSemesterScore(request.getMathSemester111());
            math11.setSecondSemesterScore(request.getMathSemester112());
            subjectScoreRepository.save(math11);

            //Physics
            SubjectScore physics11 = subjectScoreRepository.findById(result11.getPhysicsId()).get();
            physics11.setIdSubjectScore(result11.getPhysicsId());
            physics11.setFirstSemesterScore(request.getPhysicSemester111());
            physics11.setSecondSemesterScore(request.getPhysicSemester112());
            subjectScoreRepository.save(physics11);

            //Chemistry
            SubjectScore chemistry11 = subjectScoreRepository.findById(result11.getChemistryId()).get();
            chemistry11.setIdSubjectScore(result11.getChemistryId());
            chemistry11.setFirstSemesterScore(request.getChemistrySemester111());
            chemistry11.setSecondSemesterScore(request.getChemistrySemester112());
            subjectScoreRepository.save(chemistry11);

            //Biology
            SubjectScore biology11 = subjectScoreRepository.findById(result11.getBiologyId()).get();
            biology11.setIdSubjectScore(result11.getBiologyId());
            biology11.setFirstSemesterScore(request.getBiologySemester111());
            biology11.setSecondSemesterScore(request.getBiologySemester112());
            subjectScoreRepository.save(biology11);

            //Literature
            SubjectScore literature11 = subjectScoreRepository.findById(result11.getLiteratureId()).get();
            literature11.setIdSubjectScore(result11.getLiteratureId());
            literature11.setFirstSemesterScore(request.getLiteratureSemester111());
            literature11.setSecondSemesterScore(request.getLiteratureSemester112());
            subjectScoreRepository.save(literature11);

            //History
            SubjectScore history11 = subjectScoreRepository.findById(result11.getHistoryId()).get();
            history11.setIdSubjectScore(result11.getHistoryId());
            history11.setFirstSemesterScore(request.getHistorySemester111());
            history11.setSecondSemesterScore(request.getHistorySemester112());
            subjectScoreRepository.save(history11);

            //Geography
            SubjectScore geography11 = subjectScoreRepository.findById(result11.getGeographyId()).get();
            geography11.setIdSubjectScore(result11.getGeographyId());
            geography11.setFirstSemesterScore(request.getGeographySemester111());
            geography11.setSecondSemesterScore(request.getGeographySemester112());
            subjectScoreRepository.save(geography11);

            //Foreign Language
            SubjectScore foreignLanguage11 = subjectScoreRepository.findById(result11.getForeignLanguageId()).get();
            foreignLanguage11.setIdSubjectScore(result11.getForeignLanguageId());
            foreignLanguage11.setFirstSemesterScore(request.getForeignLanguageSemester111());
            foreignLanguage11.setSecondSemesterScore(request.getForeignLanguageSemester112());
            subjectScoreRepository.save(foreignLanguage11);

            //Civic Education
            SubjectScore civicEducation11 = subjectScoreRepository.findById(result11.getCivicEducationId()).get();
            civicEducation11.setIdSubjectScore(result11.getCivicEducationId());
            civicEducation11.setFirstSemesterScore(request.getCivicEducationSemester111());
            civicEducation11.setSecondSemesterScore(request.getCivicEducationSemester112());
            subjectScoreRepository.save(civicEducation11);

            //Score class 12
            //Math
            SubjectScore math12 = subjectScoreRepository.findById(result12.getMathId()).get();
            math12.setIdSubjectScore(result12.getMathId());
            math12.setFirstSemesterScore(request.getMathSemester121());
            subjectScoreRepository.save(math12);

            //Physics
            SubjectScore physics12 = subjectScoreRepository.findById(result12.getPhysicsId()).get();
            physics12.setIdSubjectScore(result12.getPhysicsId());
            physics12.setFirstSemesterScore(request.getPhysicSemester121());
            subjectScoreRepository.save(physics12);

            //Chemistry
            SubjectScore chemistry12 = subjectScoreRepository.findById(result12.getChemistryId()).get();
            chemistry12.setIdSubjectScore(result12.getChemistryId());
            chemistry12.setFirstSemesterScore(request.getChemistrySemester121());
            subjectScoreRepository.save(chemistry12);

            //Biology
            SubjectScore biology12 = subjectScoreRepository.findById(result12.getBiologyId()).get();
            biology12.setIdSubjectScore(result12.getBiologyId());
            biology12.setFirstSemesterScore(request.getBiologySemester121());
            subjectScoreRepository.save(biology12);

            //Literature
            SubjectScore literature12 = subjectScoreRepository.findById(result12.getLiteratureId()).get();
            literature12.setIdSubjectScore(result12.getLiteratureId());
            literature12.setFirstSemesterScore(request.getLiteratureSemester121());
            subjectScoreRepository.save(literature12);

            //History
            SubjectScore history12 = subjectScoreRepository.findById(result12.getHistoryId()).get();
            history12.setIdSubjectScore(result12.getHistoryId());
            history12.setFirstSemesterScore(request.getHistorySemester121());
            subjectScoreRepository.save(history12);

            //Geography
            SubjectScore geography12 = subjectScoreRepository.findById(result12.getGeographyId()).get();
            geography12.setIdSubjectScore(result12.getGeographyId());
            geography12.setFirstSemesterScore(request.getGeographySemester121());
            subjectScoreRepository.save(geography12);

            //Foreign Language
            SubjectScore foreignLanguage12 = subjectScoreRepository.findById(result12.getForeignLanguageId()).get();
            foreignLanguage12.setIdSubjectScore(result12.getForeignLanguageId());
            foreignLanguage12.setFirstSemesterScore(request.getForeignLanguageSemester121());
            subjectScoreRepository.save(foreignLanguage12);

            //Civic Education
            SubjectScore civicEducation12 = subjectScoreRepository.findById(result12.getCivicEducationId()).get();
            civicEducation12.setIdSubjectScore(result12.getCivicEducationId());
            civicEducation12.setFirstSemesterScore(request.getCivicEducationSemester121());
            subjectScoreRepository.save(civicEducation12);

            enrollmentApplicationRepository.save(enrollmentApplication);
            return enrollmentApplication;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void save(EnrollmentApplication enrollmentApplication) {
        try {
            enrollmentApplicationRepository.save(enrollmentApplication);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete enrollment application.");
    }

    @Override
    public List<EnrollmentApplication> findAll() {
        try {
            return enrollmentApplicationRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public EnrollmentApplication findOne(int id) {
        return enrollmentApplicationRepository.findById(id).orElseThrow(() -> new ErrorHandler("Can not find enrollment application."));
    }

    @Override
    public EnrollmentApplication approval(int enrollmentApplicationId, int enrollmentApplicationStatusId) {
        boolean exists = enrollmentApplicationRepository.existsById(enrollmentApplicationId);
        if (!exists) {
            throw new ErrorHandler("Cannot find Enrollment Application by id");
        } else {
            int count = enrollmentApplicationRepository.approval(
                    enrollmentApplicationId,
                    enrollmentApplicationStatusId);
            if (count != 1) {
                throw new ErrorHandler("Approval failed");
            } else {
                EnrollmentApplication enrollmentApplication = enrollmentApplicationRepository.getDetail(enrollmentApplicationId);
                return enrollmentApplication;
            }
        }

    }
}
