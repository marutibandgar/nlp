package com.bean;

public class Userbean {
   private int id,que_id,ans_id,like,dislike,lang_id;
   private String name,password,email,mobile,education,designation,userStatus,gender,dob,question,answer,type;
   public String getAnswer() {
	return answer;
}
public int getLang_id() {
	return lang_id;
}
public void setLang_id(int lang_id) {
	this.lang_id = lang_id;
}
public int getQue_id() {
	return que_id;
}
public void setQue_id(int que_id) {
	this.que_id = que_id;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int getAns_id() {
	return ans_id;
}
public int getLike() {
	return like;
}
public void setLike(int like) {
	this.like = like;
}
public int getDislike() {
	return dislike;
}
public void setDislike(int dislike) {
	this.dislike = dislike;
}
public void setAns_id(int ans_id) {
	this.ans_id = ans_id;
}
public String getUserStatus() {
	return userStatus;
}
public String getGender() {
	return gender;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public void setUserStatus(String userStatus) {
	this.userStatus = userStatus;
}
public int getId(){
		  return id;
	  }
	  public void setId(int id){
		  this.id=id;
	  }
	  public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getName(){
		  return name;
	  }
	  public void setName(String name){
		   this.name=name;
	  }
	  public String getPassword(){
		  return password;
	  }
	  public void setPassword(String password){
		  this.password=password;
	  }
	  public String getEmail(){
		  return email;
	  }
	  public void setEmail(String email){
		  this.email=email;
	  }
	  public String getMobile(){
		  return mobile;
	  }
	  public void setMobile(String mobile){
		  this.mobile=mobile;
	  }
	  

}
