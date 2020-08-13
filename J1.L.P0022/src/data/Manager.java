/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import uyen.ulti.InputTool;
import uyen.ulti.Validation;

/**
 *
 * @author SE140355
 */
public class Manager {

    ArrayList<Candidate> candidateList = new ArrayList<>();

    private int searchCandidateByID(String id) {
        if (candidateList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < candidateList.size(); i++) {
            if (candidateList.get(i).getCandidateId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isMailExist(String mail) {
        if (candidateList.isEmpty()) {
            return false;
        }

        for (Candidate candidate : candidateList) {
            if (candidate.getEmail().equalsIgnoreCase(mail)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPhoneExist(String phone) {
        if (candidateList.isEmpty()) {
            return false;
        }

        for (Candidate candidate : candidateList) {
            if (candidate.getPhone().equalsIgnoreCase(phone)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList searchCandidateObjectByNameAndType(String searchName, int searchType) {
        if (candidateList.isEmpty()) {
            return null;
        }
        ArrayList<Candidate> foundList = new ArrayList<>();
        for (Candidate c : candidateList) {
            if ((c.getFirstName().contains(searchName)
                    || c.getLastName().contains(searchName))
                    && c.getCandidateType() == searchType) {
                foundList.add(c);
            }
        }
        return foundList;
    }

    public void addExperience() {
        String candidateId, firstName, lastName, address, phone, email, proSkill;
        int birthDate, expInYear;
        int candidateType = 0;  //0 for experience
        int pos;

        while (true) {
            do {
                candidateId = InputTool.getID("ID: ", "Error!");
                pos = searchCandidateByID(candidateId);
                if (pos >= 0) {
                    System.out.println("This ID is already exist.");
                }
            } while (pos != -1);

            firstName = InputTool.getString("First Name: ", "Error!");
            lastName = InputTool.getString("Last Name: ", "Error!");
            address = InputTool.getString("Address: ", "Error!");

            do {
                phone = InputTool.getString("Phone: ", "Error!");
                if (!Validation.checkPhone(phone)) {
                    System.out.println("Please enter at least 10 number.");
                }

                if (isPhoneExist(phone)) {
                    System.out.println("This phone number is already exist!");
                }
            } while (!Validation.checkPhone(phone) || isPhoneExist(phone));

            do {
                email = InputTool.getString("Email: ", "Error!");
                if (!Validation.checkEmail(email)) {
                    System.out.println("Wrong format!");
                }
                if (isMailExist(email)) {
                    System.out.println("This email is already exist!");
                }
            } while (!Validation.checkEmail(email) || isMailExist(email));

            do {
                birthDate = InputTool.getAnInteger("Birth Year: ", "Error!");
                if (!Validation.checkBirthDate(birthDate)) {
                    System.out.println("Input from 1900 to current year.");
                }
            } while (!Validation.checkBirthDate(birthDate));

            proSkill = InputTool.getString("Professional Skill: ", "Error!");

            do {
                expInYear = InputTool.getAnInteger("Year of Experience: ", "Error!");
                if (!Validation.checkExperience(expInYear, birthDate)) {
                    System.out.println("Input from 0 to 100 and must be lower than your age");
                }
            } while (!Validation.checkExperience(expInYear, birthDate));

            candidateList.add(new ExperienceCandidate(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType, expInYear, proSkill));

            if (!Validation.checkYN("Do you want to add more experience candidate? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    public void addFresher() {
        String candidateId, firstName, lastName, address, phone, email, graduationRank, university;
        int birthDate, graduationDate;
        int candidateType = 1;  //1 for fresher
        int pos;
        while (true) {
            do {
                candidateId = InputTool.getID("ID: ", "Error!");
                pos = searchCandidateByID(candidateId);
                if (pos >= 0) {
                    System.out.println("This ID is already exist.");
                }
            } while (pos != -1);

            firstName = InputTool.getString("First Name: ", "Error!");
            lastName = InputTool.getString("Last Name: ", "Error!");
            address = InputTool.getString("Address: ", "Error!");

            do {
                phone = InputTool.getString("Phone: ", "Error!");
                if (!Validation.checkPhone(phone)) {
                    System.out.println("Please enter at least 10 number.");
                }

                if (isPhoneExist(phone)) {
                    System.out.println("This phone number is already exist!");
                }
            } while (!Validation.checkPhone(phone) || isPhoneExist(phone));

            do {
                email = InputTool.getString("Email: ", "Error!");
                if (!Validation.checkEmail(email)) {
                    System.out.println("Wrong format!");
                }
                if (isMailExist(email)) {
                    System.out.println("This email is already exist!");
                }
            } while (!Validation.checkEmail(email) || isMailExist(email));

            do {
                birthDate = InputTool.getAnInteger("Birth Year: ", "Error!");
                if (!Validation.checkBirthDate(birthDate)) {
                    System.out.println("Input from 1900 to current year.");
                }
            } while (!Validation.checkBirthDate(birthDate));

            university = InputTool.getString("University: ", "Error!");

            do {
                graduationDate = InputTool.getAnInteger("Graduation Date: ", "Error!");
                if (!Validation.checkGraduationDate(graduationDate, birthDate)) {
                    System.out.println("It must be between your birth date and current year.");
                }
            } while (!Validation.checkGraduationDate(graduationDate, birthDate));

            do {
                graduationRank = InputTool.getString("Graduation Rank: ", "Error!");
                if (!Validation.checkGraduationRank(graduationRank)) {
                    System.out.println("Only input: Excellent, Good, Fair, Poor");
                }
            } while (!Validation.checkGraduationRank(graduationRank));

            candidateList.add(new FresherCandidate(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType, graduationDate, graduationRank, university));
            if (!Validation.checkYN("Do you want to add more fresher candidate? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    public void addInternship() {
        String candidateId, firstName, lastName, address, phone, email, university, majors, semester;
        int birthDate;
        int candidateType = 2;  //2 for Internship
        int pos;
        while (true) {
            do {
                candidateId = InputTool.getID("ID: ", "Error!");
                pos = searchCandidateByID(candidateId);
                if (pos >= 0) {
                    System.out.println("This ID is already exist.");
                }
            } while (pos != -1);

            firstName = InputTool.getString("First Name: ", "Error!");
            lastName = InputTool.getString("Last Name: ", "Error!");
            address = InputTool.getString("Address: ", "Error!");

            do {
                phone = InputTool.getString("Phone: ", "Error!");
                if (!Validation.checkPhone(phone)) {
                    System.out.println("Please enter at least 10 number.");
                }

                if (isPhoneExist(phone)) {
                    System.out.println("This phone number is already exist!");
                }
            } while (!Validation.checkPhone(phone) || isPhoneExist(phone));

            do {
                email = InputTool.getString("Email: ", "Error!");
                if (!Validation.checkEmail(email)) {
                    System.out.println("Wrong format!");
                }
                if (isMailExist(email)) {
                    System.out.println("This email is already exist!");
                }
            } while (!Validation.checkEmail(email) || isMailExist(email));

            do {
                birthDate = InputTool.getAnInteger("Birth Year: ", "Error!");
                if (!Validation.checkBirthDate(birthDate)) {
                    System.out.println("Input from 1900 to current year.");
                }
            } while (!Validation.checkBirthDate(birthDate));

            university = InputTool.getString("University: ", "Error!");
            majors = InputTool.getString("Majors: ", "Error!");
            semester = InputTool.getString("Semester: ", "Error!");

            candidateList.add(new InternCandidate(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType, majors, semester, university));
            if (!Validation.checkYN("Do you want to add more internship candidate? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    private void printCandidateName(ArrayList<Candidate> list) {
        Comparator nameBalance = new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
            }
        };

        Collections.sort(list, nameBalance);
        System.out.println("=========EXPERIENCE CANDIDATES=========");
        for (Candidate c : list) {
            if (c instanceof ExperienceCandidate) {
                System.out.println(c.getFirstName() + " "
                        + c.getLastName());
            }
        }

        System.out.println("=========FRESHER CANDIDATES=========");
        for (Candidate c : list) {
            if (c instanceof FresherCandidate) {
                System.out.println(c.getFirstName() + " "
                        + c.getLastName());
            }
        }

        System.out.println("=========INTERN CANDIDATES=========");
        for (Candidate c : list) {
            if (c instanceof InternCandidate) {
                System.out.println(c.getFirstName() + " "
                        + c.getLastName());
            }
        }
    }

    public void searchCandidate() {
        printCandidateName(candidateList);
        String searchName;
        int searchType;
        while (true) {
            searchName = InputTool.getString("Search name (first or last name): ", "Error!");
            do {
                searchType = InputTool.getAnInteger("Candidate type: ", "Error!");
                if (searchType < 0 || searchType > 2) {
                    System.out.println("Candidate type must be from 0 to 2");
                }
            } while (searchType < 0 || searchType > 2);

            ArrayList<Candidate> foundList = searchCandidateObjectByNameAndType(searchName, searchType);

            if (foundList == null) {
                System.out.println("Cannot find this candidate.");
            } else {
                System.out.println("The candidates found:");
                for (Candidate c : foundList) {
                    c.showProfile();
                }
            }
            if (!Validation.checkYN("Do you want to search more student? (Y/N): ", "Error!")) {
                break;
            }
        }
    }

    public void printAllCandidates() {
        Collections.sort(candidateList);
        System.out.println("CANDIDATE LIST:");
        for (Candidate c : candidateList) {
            c.showProfile();
        }
    }
}
