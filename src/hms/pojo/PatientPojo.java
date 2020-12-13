/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.pojo;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class PatientPojo
{ 

    @Override
    public String toString() {
        return "PatientPojo{" + "p_id=" + p_id + ", f_Name=" + f_Name + ", s_Name=" + s_Name + ", Opd=" + Opd + ", gender=" + gender + ", m_Status=" + m_Status + ", address=" + address + ", city=" + city + ", mNo=" + mNo + ", doctor_id=" + doctor_id + ", age=" + age + ", d=" + d + '}';
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getS_Name() {
        return s_Name;
    }

    public void setS_Name(String s_Name) {
        this.s_Name = s_Name;
    }

    public String getOpd() {
        return Opd;
    }

    public void setOpd(String Opd) {
        this.Opd = Opd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getM_Status() {
        return m_Status;
    }

    public void setM_Status(String m_Status) {
        this.m_Status = m_Status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getmNo() {
        return mNo;
    }

    public void setmNo(String mNo) {
        this.mNo = mNo;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public PatientPojo(String p_id, String f_Name, String s_Name, String Opd, String gender, String m_Status, String address, String city, String mNo, String doctor_id, int age, Date d) {
        this.p_id = p_id;
        this.f_Name = f_Name;
        this.s_Name = s_Name;
        this.Opd = Opd;
        this.gender = gender;
        this.m_Status = m_Status;
        this.address = address;
        this.city = city;
        this.mNo = mNo;
        this.doctor_id = doctor_id;
        this.age = age;
        this.d = d;
    }
    public PatientPojo()
            
    {
        
    }

    
    private String p_id,f_Name,s_Name,Opd,gender,m_Status,address,city,mNo,doctor_id;
    private int age;
    private Date d;
    
}
