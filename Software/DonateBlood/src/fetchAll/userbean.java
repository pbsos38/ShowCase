package fetchAll;

public class userbean {
	String dname,bgroup,mobile,address,city,dob,count,gender;

	public userbean(String dname, String bgroup, String mobile, String address, String city, String dob, String count,
			String gender) {
		super();
		this.dname = dname;
		this.bgroup = bgroup;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.dob = dob;
		this.count = count;
		this.gender = gender;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getBgroup() {
		return bgroup;
	}

	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
